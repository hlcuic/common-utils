package com.hello.test.json;

import com.alibaba.fastjson.JSON;
import com.hello.json.JSONUtil;
import com.hello.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUtilTest {

    /**
     * Model对象与JSON之间转换
     */
    @Test public void testModelToJson() {
        // 将person转换为json串
        Person person = new Person(123456, "hlcuic");
        String jsonString = JSONUtil.toJson(person);
        System.out.println("jsonString:" + jsonString);

        // 在将json串转换为person对象
        Person person2 = JSON.parseObject(jsonString, Person.class);
        System.out.println("person2:" + person2);
    }

    /**
     * Map集合与JSON之间转换
     */
    @Test public void testMapToJson() {
        // 将Map转换为json串
        Map<String, String> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        String jsonMap = JSONUtil.toJson(map);
        System.out.println("jsonMap:" + jsonMap);

        // 将json串转换为Map对象
        Map<String, String> map2 = JSON.parseObject(jsonMap, Map.class);
        System.out.println("map2:" + map2);

    }

    /**
     * List集合与JSON之间转换
     */
    @Test public void testListToJson() {
        // 将List转换为json串
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        String jsonList = JSONUtil.toJson(list);
        System.out.println("jsonList：" + jsonList);

        //将json串转换为List对象
        List list2 = JSON.parseObject(jsonList, List.class);
        System.out.println("list2:" + list2);
    }

}
