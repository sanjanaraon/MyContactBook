package com.mycontactbook.repository;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

public class MongoTemplate {

    MongoDbFactory mongoDbFactory;
//    public MongoTemplate(MongoDbFactory mongoDbFactory) {
//        this.mongoDbFactory=mongoDbFactory;
//    }
//
//    public @Bean
//    MongoDbFactory mongoDbFactory() throws UnknownHostException {
//            return new SimpleMongoDbFactory(new MongoClient(),"contactBook");
//    }
//
//    public @Bean
//    MongoTemplate mongoTemplate() throws UnknownHostException {
//        System.out.println("got mongoTemplate");
//        return new MongoTemplate(mongoDbFactory());
//    }
}
