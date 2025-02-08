package com.alivinfer.demoTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Fer
 * @version 1.0
 * @description 电影业务处理
 * @date 2025/2/7
 */

public class MovieService {
    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            // 3、准备操作界面:GUI界面/cmd命令做。
            System.out.println("====电影信息操作系统===");
            System.out.println("1、上架");
            System.out.println("2、下架某个电影");
            System.out.println("3、查询某个电影");
            System.out.println("4、封杀某个明星");
            System.out.println("5、退出");
            System.out.println("6、展示全部电影");
            System.out.println("7、修改某个电影");
            System.out.println("请您输入操作命令：");
            String command = sc.next();
            switch (command) {
                case "1":
                    // 上架
                    addMovie();
                    break;
                case "2":
                    // 下架
                    deleteMovie();
                    break;
                case "3":
                    // 查询某个电影
                    queryMovie();
                    break;
                case "4":
                    // 封杀某个明星
                    deleteStar();
                    break;
                case "5":
                    System.out.println("退出成功！");
                    return;
                case "6":
                    // 展示全部电影
                    queryAllMovies();
                    break;
                case "7":
                    // 修改
                    modifyMovies();
                    break;
                default:
                    System.out.println("没有此命令，请重新输入！");
            }
        }
    }

    /**
     * 查询所有电影
     */
    private void queryAllMovies() {
        System.out.println("===========展示全部电影============");
        for (Movie m : movies) {
            System.out.println(m.getName() + "  " + m.getActor() + "  " + m.getPrice() + "  " + m.getScore());
        }
    }

    /**
     * 上架电影
     */
    private void addMovie() {
        System.out.println("==========上架电影============");
        // 1、创建电影对象，封装这部电影信息。
        Movie movie = new Movie();

        // 2、给电影对象注入数据。
        System.out.println("请您输入电影名称：");
        movie.setName(sc.next());
        System.out.println("请您输入主演：");
        movie.setActor(sc.next());
        System.out.println("请您输入电影价格：");
        movie.setPrice(sc.nextDouble());
        System.out.println("请您输入电影评分：");
        movie.setScore(sc.nextDouble());

        // 3、把电影对象添加到集合中。
        movies.add(movie);
        System.out.println("==========上架成功============");
    }

    /**
     * 下架电影
     */
    private void deleteMovie() {
        System.out.println("===========下架电影============");
        // 1、输入电影名称
        System.out.println("请您输入电影名称：");
        String movieName = sc.next();
        // 2、查询是否有此电影
        Movie movie = queryMovieByName(movieName);
        if (movie != null) {
            movies.remove(movie);
        } else {
            System.out.println("没有找到该电影，请重新输入！");
        }
    }

    /**
     * 查询电影
     */
    private void queryMovie() {
        System.out.println("===========查询电影============");
        System.out.println("请您输入电影名称：");
        String name = sc.next();
        // 根据电影名称查询电影对象返回，展示这个对象数据。
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            System.out.println(movie.getName() + "  " + movie.getActor() + "  " + movie.getPrice() + "  " + movie.getScore());
        } else {
            System.out.println("没有找到这个电影！");
        }
    }

    /**
     * 根据电影名称查询电影
     * @param name 电影名称
     * @return 电影对象
     */
    private Movie queryMovieByName(String name) {
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                // 找到这个电影对象
                return m;
            }
        }
        // 没有找到这个电影对象
        return null;
    }

    /**
     * 封杀某个明星
     */
    private void deleteStar() {
        System.out.println("===========封杀明星============");
        System.out.println("请您输入要封杀的明星：");
        String star = sc.next();

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(star)) {
                movies.remove(movie);
                // 更新下标
                i--;
            }
        }
        System.out.println("封杀成功！");
        // 展示全部电影。
        queryAllMovies();
    }

    /**
     * 根据电影名称修改信息
     */
    private void modifyMovies() {
        System.out.println("===========封杀明星============");
        System.out.println("请您输入要修改的电影：");
        String movieName = sc.next();
        Movie movie = queryMovieByName(movieName);
        if (movie != null) {
            System.out.println("该电影信息如下：");
            System.out.println(movie.getName() + "  " + movie.getActor() + "  " + movie.getPrice() + "  " + movie.getScore());
            System.out.println("1、主演");
            System.out.println("2、票价");
            System.out.println("3、评分");
            System.out.println("请选择你想修改的内容：");
            String str = sc.next();
            if ("1".equals(str)) {
                System.out.println("输入想修改的主演名称：");
                String actorName = sc.next();
                movie.setActor(actorName);
            } else if ("2".equals(str)) {
                System.out.println("输入想修改的票价名称：");
                double price = sc.nextDouble();
                movie.setPrice(price);
            } else if ("3".equals(str)) {
                System.out.println("输入想修改的评分名称：");
                double score = sc.nextDouble();
                movie.setPrice(score);
            }
        } else {
            System.out.println("修改的电影不存在！");
        }

    }
}
