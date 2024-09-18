package com.wsan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.wsan.springboot.di.app.springboot_di.models.Product;
import com.wsan.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    //esto en objeto de tipo ProductRepository
    private ProductRepository repository = new ProductRepository();

    //estos son metodos
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return  repository.findById(id);
    }
    //metodos fin ...
}
