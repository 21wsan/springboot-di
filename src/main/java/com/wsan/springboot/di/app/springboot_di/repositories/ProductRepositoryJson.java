package com.wsan.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsan.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements ProductRepository{

    //estos son atributos
    private List<Product> list;

    //esto es un contructor vacío
    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//fin del constructor

    //estos son metodos sobre escritos de la interfaz ProductRepository
    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
    //fin de los metodos
}
