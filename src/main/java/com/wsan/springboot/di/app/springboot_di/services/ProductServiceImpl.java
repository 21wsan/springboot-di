package com.wsan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.wsan.springboot.di.app.springboot_di.models.Product;
import com.wsan.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    /*esto en objeto de tipo ProductRepository
        private ProductRepositoryImpl repository = new ProductRepositoryImpl();
    */
    //@Autowired = se usa para inyectar una instancia(objeto)
    @Autowired
    private Environment environment;
    private ProductRepository repository;

    //esto es un constructor con un parametro, cuando hay un constructor no se requiere de inyectar con @Autowired en el parametro
    //"ProductRepositoryJson"
    public ProductServiceImpl(@Qualifier("ProductJson")ProductRepository repository){
        this.repository = repository;
    }
    
    //estos son metodos
    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            //Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }
    @Override
    public Product findById(Long id){
        return  repository.findById(id);
    }
    //metodos fin ...
}
