package com.wsan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.wsan.springboot.di.app.springboot_di.models.Product;

@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

   private List<Product> data;

   //constructor
   public ProductRepositoryImpl(){
      this.data = Arrays.asList(
      new Product(1L,"Memoria corsair 32", 300L),
      new Product(2L, "Cpu Ryzen 9", 850L),
      new Product(3L, "Teclado mecanico", 180L),
      new Product(4L, "Motherboard Asus", 850L));
   }
   //estos son metodos
   //metodo para buscar todos, implementado desde la interfaz ProductRepository
   @Override
   public List<Product> findAll(){
      return data;
   }
   //metodo para buscar por ID, implementado desde la interfaz ProductRepository
   @Override
   public Product findById(Long id){
      return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
   }
}
