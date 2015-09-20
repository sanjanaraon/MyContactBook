package com.mycontactbook.services;


import com.mycontactbook.domain.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ContactOperationsTest {

    @Mock
    MongoOperations mongoOperationsMock;

    ContactOperations contactOperations;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        contactOperations = new ContactOperations(mongoOperationsMock);

    }


    List<Contact> contacts = new ArrayList<Contact>();

    //TODO:write proper test after ur done with functionality of the app.
    @Test
    public void shouldReturnEmptyMapWhenThereAreNoContacts() throws Exception {
        when(mongoOperationsMock.findAll(Contact.class, "contacts")).thenReturn(contacts);
        List<Contact> allContacts = contactOperations.getAllContacts();
        verify(mongoOperationsMock).findAll(Contact.class, "contacts");
        assertEquals(0, allContacts.size());
    }

    @Test
    public void shouldAddAContact() throws Exception {
        Contact contact = new Contact("abcd", 1234567890, "#6901", "koramangala", "bangalore", "abcd1@mail.com");
        contacts.add(contact);
        when(mongoOperationsMock.findAll(Contact.class, "contacts")).thenReturn(contacts);

        contactOperations.addContact(contact);
        List<Contact> allContacts = contactOperations.getAllContacts();
        verify(mongoOperationsMock).findAll(Contact.class, "contacts");
        verify(mongoOperationsMock).insert(contact, "contacts");
        assertEquals(1, allContacts.size());

    }

    @Test
    public void shouldGetAContactByEmailId() throws Exception {
        String emailId = "abcd1@mail.com";
        Contact contact = new Contact("abcd", 1234567890, "#6901", "koramangala", "bangalore", emailId);
        contacts.add(contact);
        when(mongoOperationsMock.find(Query.query(Criteria.where("_id").is(emailId)), Contact.class)).thenReturn(contacts);

        Contact allContacts = contactOperations.getContact(emailId);
        verify(mongoOperationsMock).find(Query.query(Criteria.where("_id").is(emailId)), Contact.class);
        assertEquals(contact, allContacts);

    }

    @Test
    public void shouldUpdateAContactDetailOtherThanEmailId() throws Exception {
        String emailId = "abcd1@mail.com";
        Contact newContact = new Contact("demo", 1987654320, "4th block", "jp nagar", "mysore", emailId);
        List<Contact> newContactList = new ArrayList<Contact>();
        newContactList.add(newContact);

        when(mongoOperationsMock.find(Query.query(Criteria.where("_id").is(emailId)), Contact.class)).thenReturn(newContactList);
        when(mongoOperationsMock.findAndModify(Query.query(Criteria.where("_id").is(emailId)), Update.update("name", newContact.getName()), Contact.class)).thenReturn(newContact);
        when(mongoOperationsMock.findAndModify(Query.query(Criteria.where("_id").is(emailId)), Update.update("mobileNumber", newContact.getMobileNumber()), Contact.class)).thenReturn(newContact);
        when(mongoOperationsMock.findAndModify(Query.query(Criteria.where("_id").is(emailId)),Update.update("street1",newContact.getStreet1()),Contact.class)).thenReturn(newContact);
        when(mongoOperationsMock.findAndModify(Query.query(Criteria.where("_id").is(emailId)), Update.update("street2", newContact.getStreet2()), Contact.class)).thenReturn(newContact);
        when(mongoOperationsMock.findAndModify(Query.query(Criteria.where("_id").is(emailId)), Update.update("city", newContact.getCity()), Contact.class)).thenReturn(newContact);

        Contact contact = contactOperations.updateContact(newContact);

        verify(mongoOperationsMock).find(Query.query(Criteria.where("_id").is(emailId)), Contact.class);
//        verify(mongoOperationsMock).findAndModify(Query.query(Criteria.where("_id").is(emailId)), Update.update("city", newContact.getCity()), Contact.class);
        assertEquals(newContact, contact);

    }

    @Test
    public void shouldDeleteAContactWithAGivenEmailId() throws Exception {

        String emailId = "abcd1@mail.com";
        Contact contact = new Contact("abcd", 1234567890, "#6901", "koramangala", "bangalore", emailId);
        contacts.add(contact);
        when(mongoOperationsMock.find(Query.query(Criteria.where("_id").is(emailId)), Contact.class)).thenReturn(contacts);
        contactOperations.deleteContact(emailId);
        assertEquals(1, contacts.size());
        verify(mongoOperationsMock).find(Query.query(Criteria.where("_id").is(emailId)), Contact.class);
        verify(mongoOperationsMock).remove(contact);
    }


    @Test
    public void shouldGetAConactByName() throws Exception {
        Contact contact = new Contact("abcd", 1234567890, "#6901", "koramangala", "bangalore", "abcd1@mail.com");
        contacts.add(contact);
        when(mongoOperationsMock.find(Query.query(Criteria.where("name").is("abcd")), Contact.class)).thenReturn(contacts);
        List<Contact> result = contactOperations.searchContact("abcd");
        verify(mongoOperationsMock).find(Query.query(Criteria.where("name").is("abcd")), Contact.class);
        assertEquals(contact, result.get(0));
    }

    @Test
    public void shouldGetAConactByMobileNumber() throws Exception {
        Contact contact = new Contact("abcd", 1234567890, "#6901", "koramangala", "bangalore", "abcd1@mail.com");
        contacts.add(contact);
        when(mongoOperationsMock.find(Query.query(Criteria.where("mobileNumber").is("1234567890")), Contact.class)).thenReturn(contacts);
        List<Contact> result = contactOperations.searchContact("1234567890");
        verify(mongoOperationsMock).find(Query.query(Criteria.where("mobileNumber").is("1234567890")), Contact.class);
        assertEquals(contact,result.get(0));
    }

    @After
    public void tearDown() throws Exception {
        mongoOperationsMock.dropCollection("contacts");
    }
}