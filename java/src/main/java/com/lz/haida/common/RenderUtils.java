package com.lz.haida.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据输出工具类
 */
public class RenderUtils {

    private static final Logger logger = LoggerFactory.getLogger(RenderUtils.class);

    /**
     * 操作成功
     *
     * @param object 成功后返回的数据体
     * @return
     */
    public static Map<String,Object> renderSuccess(Object object) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",true);
        map.put("message", "");
        map.put("data", object);
        return map;
    }

    /**
     * 操作失败
     *
     * @param message 失败信息
     * @return
     */
    public static Map<String,Object> renderError(String message){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",false);
        map.put("message",message);
        return map;
    }

}
