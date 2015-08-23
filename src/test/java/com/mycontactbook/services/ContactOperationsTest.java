package com.mycontactbook.services;


import com.mycontactbook.domain.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactOperationsTest {

    @Mock
    MongoOperations mongoOperationsMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    ContactOperations contactOperations=new ContactOperations();

    @Test
    public void shouldReturnEmptyMapWhenThereAreNoContacts() throws Exception {
        List<Contact> allContacts = contactOperations.getAllContacts();
        assertEquals(0,allContacts.size());
    }

    @Test
    public void shouldAddAContact() throws Exception {
        Contact contact=new Contact("abcd",1234567890,"#6901","koramangala","bangalore","abcd1@mail.com");
        contactOperations.addContact(contact);
        List<Contact> allContacts = contactOperations.getAllContacts();
        for(Contact contact1:allContacts){
            System.out.printf(contact1.getEmailId()+" "+contact1.getName());
        }
        assertEquals(1, allContacts.size());

    }

    @After
    public void tearDown() throws Exception {
        mongoOperationsMock.dropCollection("contacts");
    }
}