package com.alivinfer.demoTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 电影类
 * @date 2025/2/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    /**
     * 电影名称
     */
    private String name;

    /**
     * 电影评分
     */
    private double score;

    /**
     * 电影演员
     */
    private String actor;

    /**
     * 电影价格
     */
    private double price;
}
