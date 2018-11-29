package com.wripz.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:yangqiao
 * @description:
 * @Date:2018/11/28
 */
@Data
@Component
@ConfigurationProperties(prefix = "mongodb")
public class MongoDBProperties {



    /**
     * 地址
     */
    private String host;

    /**
     * 端口
     */
    private int port;

    /**
     * 数据库名
     */
    private String database;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}