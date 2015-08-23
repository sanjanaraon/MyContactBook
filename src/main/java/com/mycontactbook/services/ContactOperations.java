package com.mycontactbook.services;

import com.mongodb.MongoClient;
import com.mycontactbook.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;
import java.util.List;

public class ContactOperations {
    static String DataBase = "contactBook";
    MongoOperations mongoOperations;
    MongoClient mongo;

    public MongoOperations getMongoConnection() {
        try {
            mongo = new MongoClient("localhost", 27017);
            mongoOperations = new MongoTemplate(mongo, DataBase);
            return mongoOperations;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        //db.contactBook.contacts.find().pretty()
        MongoOperations mongoConnection = getMongoConnection();
        List<Contact> contacts = mongoConnection.findAll(Contact.class,"contacts");
        return contacts;
    }

    public void addContact(Contact contact) {
        MongoOperations mongoConnection = getMongoConnection();
        mongoConnection.insert(contact,"contacts");
    }

}
