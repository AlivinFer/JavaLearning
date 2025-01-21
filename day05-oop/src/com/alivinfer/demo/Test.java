package com.alivinfer.demo;

/**
 * @author Fer
 * @version 1.0
 * @description 测试类
 * @date 2025/1/21
 */

public class Test {
    public static void main(String[] args) {
        MovieOperator movieOperator = new MovieOperator(new Movie[]{
                new Movie(0, "《夏洛特烦恼》", 9.2, "沈腾"),
                new Movie(1, "《阿甘正传》", 9.6, "罗伯托·贝尼尼"),
                new Movie(2, "《教父》", 9.2, "弗兰克·德拉邦特"),
                new Movie(3, "《肖申克的救赎》", 9.5, "弗兰克·德拉邦特"),
                new Movie(4, "《阿甘正传》", 9.6, "罗伯托·贝尼尼"),
        });

        movieOperator.printAllMovies();
        movieOperator.searchMovieById(1);
    }
}
