package com.hello.validate;

import com.alibaba.fastjson.JSON;
import com.hello.annotation.CheckParamOnField;
import com.hello.annotation.CheckParamOnMethod;
import com.hello.annotation.CheckParamsOnMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 参数校验类
 */
public class ValidateUtil {

    private static Map<String, String> validateMap = new ConcurrentHashMap<>();

    static {
        validateMap.put("identityId", "编号");
        validateMap.put("name", "姓名");
    }

    public static void main(String[] args) {
        // 1:调试断点
        for(int i=0;i<1000;i++){
            System.out.println(i);
            System.out.println(i++);
        }

        // 2：调试drop to frame
        testDebug();

        // 3: 多线程调试
        new Thread(()->{
            System.out.println("hhh");
        }).start();

        new Thread(()->{
            System.out.println("hello world");
        }).start();

        System.out.println("end");
    }

    private static void testDebug(){
        System.out.println("hello world");
        System.out.println("hello world2");
    }

    /**
     * 第一种方式：直接在使用参数前调用静态方法校验
     * 如果request参数为json串/Map
     *
     * @param request
     */
    public static void validate(String request) {
        Map<String, String> paramMap = JSON.parseObject(request, Map.class);
        for (Map.Entry<String, String> validateEntry : validateMap.entrySet()) {
            String validateKey = validateEntry.getKey();
            // 只校验字段为null的
            if (!paramMap.containsKey(validateKey)) {
                String columnDesc = validateEntry.getValue();
                throw new RuntimeException(columnDesc + "不能为空!");
            }
        }
    }

    /**
     * 第二种方式：入参为对象时，直接在使用参数时调用静态方法校验
     */
    public static <T> void validate(T t) throws Exception {
        if (null == t) {
            throw new RuntimeException("参数不能为空!");
        }
        Class clazz = t.getClass();
        // getDeclaredFields() 获取本来声明的所有方法(包括private protected  public)，
        // 但是不包括父类中声明的方法
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            CheckParamOnField checkParams = field.getAnnotation(CheckParamOnField.class);
            if (null != checkParams) {
                String columnName = checkParams.columnName();
                Boolean notNull = checkParams.notNull();
                int[] rightLength = checkParams.length();
                field.setAccessible(true);
                Object value = field.get(t);
                if (notNull && value == null) {
                    throw new RuntimeException(columnName + "不能为空!");
                }
                if (value != null && !legalLength(value, rightLength)) {
                    throw new RuntimeException(columnName + "长度不在合法范围内!");
                }
            }
        }
    }

    /**
     * 校验值的长度是否合法
     *
     * @param value
     * @param rightLength
     * @return
     */
    private static boolean legalLength(Object value, int[] rightLength) {
        int valueLength = -1;
        if (value instanceof Integer) {
            String newVal = String.valueOf(value);
            valueLength = newVal.length();
        }
        if (value instanceof String) {
            valueLength = ((String)value).length();
        }
        return valueLength <= rightLength[1] && valueLength >= rightLength[0];
    }

    /**
     * 第三种方式：可以对调用的方法做动态代理，然后将入参与注解元数据比较
     * 做参数校验
     */
    public static void validate(Method method, Object[] args) throws NoSuchFieldException, IllegalAccessException {
        CheckParamsOnMethod checkParamsOnMethod = method.getDeclaredAnnotation(CheckParamsOnMethod.class);
        if (null == checkParamsOnMethod) {
            return;
        }
        Class clazz = args[0].getClass();
        CheckParamOnMethod[] checkParamOnMethods = checkParamsOnMethod.value();
        for (CheckParamOnMethod annotation : checkParamOnMethods) {
            // getDeclaredField()获取本类中声明的方法（包括private/protected/public）,不包括父类
            // getField()获取所有public修饰的方法，包括父类中声明的
            Field field = clazz.getDeclaredField(annotation.columnName());
            field.setAccessible(true);
            Object value = field.get(args[0]);
            if (annotation.notNull() && value == null) {
                throw new RuntimeException(annotation.columnDesc() + "不能为空!");
            }
            if (value != null && !legalLength(value, annotation.length())) {
                throw new RuntimeException(annotation.columnDesc() + "长度不在合法范围内!");
            }
        }

    }

}
