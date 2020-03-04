package com.hello.test.validate;

import com.alibaba.fastjson.JSON;
import com.hello.model.Person;
import com.hello.service.impl.DoSomethingServiceImpl;
import com.hello.service.IdoSomething;
import com.hello.service.ProxyInterceptorService;
import com.hello.validate.ValidateUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidateUtilTest {

    /**
     * 参数为json串时
     */
    @Test public void testValidateForString() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("identityId", "123456");
        String request = JSON.toJSONString(paramMap);
        ValidateUtil.validate(request);
    }

    /**
     * 在model上添加注解元数据，根据注解数据
     * 判断参数的值
     *
     * @throws Exception
     */
    @Test public void testValidateForModel() throws Exception {
        Person person = new Person();
        person.setIdentityId(1234567);
        person.setName("hello");
        ValidateUtil.validate(person);
    }

    /**
     * 模拟拦截需要校验的方法，生成动态代理，
     * 校验参数
     */
    @Test public void testValidateForProxy() {
        IdoSomething target = new DoSomethingServiceImpl();
        ProxyInterceptorService service = new ProxyInterceptorService(target);
        IdoSomething proxy = service.getProxy();
        Person person = new Person();
        person.setIdentityId(123456);
        person.setName("hello");
        proxy.doSomething(person);
    }
}
