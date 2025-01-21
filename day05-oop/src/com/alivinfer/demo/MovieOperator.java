package com.alivinfer.demo;

import java.util.Scanner;

/**
 * @author Fer
 * @version 1.0
 * @description 电影操作类
 * @date 2025/1/20
 */

public class MovieOperator {
    private Movie[] movies;
    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    // 打印全部电影信息
    public void printAllMovies() {
        System.out.println("================全部电影信息如下===============");
        for (Movie m : movies) {
            System.out.println(m.toString());
        }
    }

    // 根据电影ID查询电影
    public void searchMovieById(int movieId) {
        System.out.println("要查询的电影id：" + movieId);
        // 遍历每个电影对象
        for (Movie m : movies) {
            // 拿到当前遍历到的电影对象
            // 判断当前电影对象的id是否是我们正在找的电影id，是则打印出该电影信息并立即结束方法
            if (m.getId() == movieId) {
                System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice() + "\t" + m.getActor() + "\t");
                return;
            }
        }
        System.out.println("没有找到该电影");
    }

}
