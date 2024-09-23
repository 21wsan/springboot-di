package com.wsan.springboot.di.app.springboot_di.models;

public class Product implements Cloneable{

    //estos son atributos
    private Long id;
    private String name;
    private Long price;
    
    //constructor vacío
    public Product(){}

    //constructor con parametros
    public Product(Long id, String name, Long price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getters and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getPrice(){
        return price;
    }

    public void setPrice(Long price){
        this.price = price;
    }
    //fin getters and setters...

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, "name", price);
        }
    }
}
