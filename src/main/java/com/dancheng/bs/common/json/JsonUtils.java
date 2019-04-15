package com.dancheng.bs.common.json;

import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * 处理json工具类
 */
public class JsonUtils {
    public static ValueFilter isNullFilter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if(v==null)
                return "";
            return v;
        }
    };
}
