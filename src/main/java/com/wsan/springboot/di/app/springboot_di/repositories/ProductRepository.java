package com.wsan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.wsan.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

   List<Product> data;

   //constructor
   public ProductRepository(){
      this.data = Arrays.asList(
      new Product(1L,"Memoria corsair 32", 300L),
      new Product(2L, "Cpu Ryzen 9", 850L),
      new Product(3L, "Teclado mecanico", 180L),
      new Product(4L, "Motherboard Asus", 850L));
   }
   //estos son metodos
   //metodo para buscar todos
   public List<Product> findAll(){
      return data;
   }
   //metodo para buscar por ID
   public Product findById(Long id){
      return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
   }
}
