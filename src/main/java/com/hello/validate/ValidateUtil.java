package com.hello.validate;

import com.alibaba.fastjson.JSON;
import com.hello.annotation.CheckParams;

import javax.jnlp.IntegrationService;
import java.lang.reflect.Field;
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
            if (paramMap.containsKey(validateKey)) {
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
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            CheckParams checkParams = field.getAnnotation(CheckParams.class);
            if (null != checkParams) {
                String columnName = checkParams.columnName();
                Boolean notNull = checkParams.notNull();
                int[] rightLength = checkParams.length();
                Object value = field.get(t);
                if (notNull && value == null) {
                    throw new RuntimeException(columnName + "不能为空!");
                }
                if (value != null && legalLength(value, rightLength)) {
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
        if (value instanceof Integer) {
            String newVal = String.valueOf(value);
            int valueLength = newVal.length();
            return valueLength <= rightLength[1] && valueLength >= rightLength[0];
        }
        return false;
    }

    /**
     * 第三种方式：可以对调用的方法做动态代理，然后将入参与注解元数据比较
     * 做参数校验
     */

}
