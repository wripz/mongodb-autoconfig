package com.wripz.mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author:yangqiao
 * @description:mongodb
 * @Date:2018/11/28
 */

@Slf4j
@Configuration
@EnableConfigurationProperties({MongoDBProperties.class})
public class MongoDBConfiguration {

    @Autowired
    private MongoDBProperties mongoDBProperties;

    @Bean(name = {"mongoTemplate"})
    public MongoTemplate mongoTemplate() {

        return new MongoTemplate(this.getMongoClient(), mongoDBProperties.getDatabase());
    }

    public MongoClient getMongoClient() {

        ServerAddress serverAddress = new ServerAddress(mongoDBProperties.getHost(), mongoDBProperties.getPort());

        //用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createCredential(mongoDBProperties.getUsername(),
                mongoDBProperties.getDatabase(),
                mongoDBProperties.getPassword().toCharArray());

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(serverAddress, credential, MongoClientOptions.builder().connectTimeout(60000)
                .build());
        log.info("已连接到MongoDB，database：{}", mongoDBProperties.getDatabase());
        return mongoClient;
    }
}