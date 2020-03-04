package com.hello.service;

import com.hello.validate.ValidateUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInterceptorService implements InvocationHandler {

    private Object target;

    public ProxyInterceptorService(Object target) {
        this.target = target;
    }

    /**
     * 模拟对IdoSomething接口做代理，拦截类方法成员，
     * 做参数校验
     *
     * @return
     */
    public IdoSomething getProxy() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (IdoSomething)Proxy.newProxyInstance(classLoader, new Class[] {IdoSomething.class}, this);
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() != Object.class) {
            ValidateUtil.validate(method, args);
        }
        return method.invoke(target, args);
    }
}
