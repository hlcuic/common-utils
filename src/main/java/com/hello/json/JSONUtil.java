package com.hello.json;

import com.alibaba.fastjson.JSON;

/**
 * 类名：json转换类
 * 描述：将model/map/list与json互相转换
 * 直接使用fastjson包下的JSON工具类即可
 */
public class JSONUtil {

    /**
     * 将model/Map/List对象转换为json串
     * 利用fastJson库
     *
     * @return
     */
    public static <M> String toJson(M m) {
        return JSON.toJSONString(m);
    }

}
