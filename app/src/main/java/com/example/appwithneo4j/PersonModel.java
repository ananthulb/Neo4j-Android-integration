package com.example.appwithneo4j;

public class PersonModel {

    private int id;
    private String name;


    public PersonModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonModel() {
    }


    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
