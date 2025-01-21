package com.alivinfer.demo;

/**
 * @author Fer
 * @version 1.0
 * @description 电影类
 * @date 2025/1/20
 */

public class Movie {
    // 编号
    private int id;
    // 名称
    private String name;
    // 价格
    private double price;
    // 演员
    private String actor;

    public Movie() {
    }

    public Movie(int id, String name, double price, String actor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actor = actor;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", actor='" + actor + '\'' +
                '}';
    }
}

