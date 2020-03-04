package com.hello.pagehelper;

import java.util.Collections;
import java.util.List;

public class PageHelperUtil {

    /**
     * 适合内存分页，但是效率不高
     */
    public static <E> List<E> getSubList(List<E> dataList, int pageNum, int pageSize) {
        int totalDataSize = dataList.size();
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = startIndex + pageSize;
        if (startIndex >= totalDataSize) {
            return Collections.emptyList();
        }
        if (endIndex > totalDataSize) {
            endIndex = totalDataSize;
        }
        return dataList.subList(startIndex, endIndex);
    }

}
