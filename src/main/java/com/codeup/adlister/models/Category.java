package com.codeup.adlister.models;

public class Category {
    private String name;
    private long Id;

    public Category (){}

    public Category(String name){
        this.name = name;
    }

    public Category(long id, String name){
        this.Id = id;
        this.name = name;
    }

    public String getCategory (){
        return this.name;
    }

    public long getCategoryId (){
        return this.Id;
    }


}
