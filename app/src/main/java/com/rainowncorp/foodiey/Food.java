package com.rainowncorp.foodiey;

public class Food {
    private String Description;
    private String Name;
    private int Price;


    public Food(){}

    public Food(String desc,String name,int price){
        this.Description = desc;
        this.Name = name;
        this.Price = price;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
