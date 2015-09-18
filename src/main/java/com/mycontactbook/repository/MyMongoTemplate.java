package com.mycontactbook.repository;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;

import java.net.UnknownHostException;

public class MyMongoTemplate {
    static MongoOperations mongoOperations;
    static MongoClient mongo;
    static String DataBase = "contactBook";

    public static MongoOperations getMongoConnection() {
        try {
            mongo = new MongoClient("localhost", 27017);
            mongoOperations = new org.springframework.data.mongodb.core.MongoTemplate(mongo, DataBase);
            return mongoOperations;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
