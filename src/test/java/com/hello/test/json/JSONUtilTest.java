package com.hello.test.json;

import com.hello.json.JSONUtil;
import com.hello.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUtilTest {

    @Test public void testModelToJson() {
        // 将person转换为json串
        Person person = new Person(123456, "hlcuic");
        System.out.println(JSONUtil.toJson(person));

        // 将Map转换为json串
        Map<String, String> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        System.out.println(JSONUtil.toJson(map));

        // 将List转换为json串
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        System.out.println(JSONUtil.toJson(list));
    }

}
