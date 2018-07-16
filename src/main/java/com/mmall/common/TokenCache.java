package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oreo
 * on 2018/4/12
 */
public class TokenCache {
    public static final String TOKEN_PREFIX = "token_";
    public static Logger logger=LoggerFactory.getLogger(TokenCache.class);

    private static LoadingCache<String,String> localCache;

    static {
        localCache = CacheBuilder.newBuilder()
                .initialCapacity(1000)//初始化容量
                .maximumSize(10000)//缓存的最大容量
                .expireAfterAccess(12, TimeUnit.HOURS)//缓存有效期
                .build(new CacheLoader<String, String>() {
                    //默认的数据加载实现当调用get取值时，如果key没有对应的值，就执行这个方法
                    @Override
                    public String load(String s) {
                        return "null";
                    }
                });
    }


    public static void setKey(String key,String value){
        localCache.put(key,value);
    }

    public static String getKey(String key){
        String value;
        try {
            value=localCache.get(key);
            if ("null".equals(value)){
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            e.printStackTrace();
            logger.error("localCache get error");
        }
        return null;
    }

}
