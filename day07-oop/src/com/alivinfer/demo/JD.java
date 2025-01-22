package com.alivinfer.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 家电基类
 * @date 2025/1/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JD implements Switch{
    /**
     * 家电名称
     */
    private String name;
    /**
     * 家电开关状态
     */
    private boolean status;

    @Override
    public void press() {
        status = !status;
    }
}
