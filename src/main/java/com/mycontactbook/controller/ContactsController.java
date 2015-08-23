package com.mycontactbook.controller;

import com.mycontactbook.domain.Contact;
import com.mycontactbook.services.ContactOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ContactsController {
    ContactOperations contactOperations=new ContactOperations();
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "contacts/all")
    public List<Contact> getAllContacts(){
        return contactOperations.getAllContacts();
    }

    @RequestMapping(method = RequestMethod.GET,value = "addNewContact")
    public String addNewContact(){
        return "addNewContact";
    }

    @RequestMapping(method = RequestMethod.POST,value = "contacts/add")
    public String addContact(@RequestBody Contact contact, ModelMap modelMap){
        contactOperations.addContact(contact);
        modelMap.addAttribute("message", "Contact Added Successfully");
        return "index";
    }

}