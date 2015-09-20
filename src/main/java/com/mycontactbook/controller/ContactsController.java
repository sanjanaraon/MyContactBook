package com.mycontactbook.controller;

import com.mycontactbook.domain.Contact;
import com.mycontactbook.repository.MyMongoTemplate;
import com.mycontactbook.services.ContactOperations;
import com.sun.deploy.net.HttpResponse;
import com.sun.tools.javac.util.Convert;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class ContactsController {
    ContactOperations contactOperations = new ContactOperations(MyMongoTemplate.getMongoConnection());

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        List<Contact> allContacts = contactOperations.getAllContacts();
        modelMap.addAttribute("contacts", allContacts);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "addNewContact")
    public String addNewContact() {
        return "addNewContact";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addContact(HttpServletRequest request, ModelMap modelMap) {
        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("mobileNumber"));
        String street1 = request.getParameter("street1");
        String street2 = request.getParameter("stree2");
        String city = request.getParameter("city");
        String emailId = request.getParameter("emailId");
        Contact contact = new Contact(name, number, street1, street2, city, emailId);
        contactOperations.addContact(contact);
        modelMap.addAttribute("message", "Contact Added Successfully");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public String updateContact(HttpServletRequest request, ModelMap modelMap) {

        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("mobileNumber"));
        String street1 = request.getParameter("street1");
        String street2 = request.getParameter("street2");
        String city = request.getParameter("city");
        String emailId = request.getParameter("emailId");
        Contact contact = new Contact(name, number, street1, street2, city, emailId);
        try {
            contactOperations.updateContact(contact);
        } catch (UnknownHostException e) {
            System.out.printf("Failed to update");
        }
        modelMap.addAttribute("message", "contact updated successfully");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "getContact")
    public String getContact(HttpServletRequest request, ModelMap modelMap) {

        String emailId = request.getParameter("emailId");
        Contact contact = contactOperations.getContact(emailId);
        modelMap.addAttribute("contact", contact);
        return "editContact";

    }

    @RequestMapping(method = RequestMethod.GET, value = "delete")
    public String deleteContact(HttpServletRequest request,ModelMap modelMap) {
        String emailId=request.getParameter("emailId");
        contactOperations.deleteContact(emailId);
        return "index";
//        homePage(new ModelMap("message","contact deleted"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserDetail")
    public String getUserDetailForm(HttpServletRequest request,ModelMap modelMap){
        String emailId = request.getParameter("emailId");
        Contact contact = contactOperations.getContact(emailId);
        modelMap.addAttribute("contact", contact);
        return "userDetail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "getContactByNameOrNumber")
    public String getContactByNameOrNumber(HttpServletRequest request, ModelMap modelMap){
        String searchContact = request.getParameter("searchContact");
        List<Contact> contacts=contactOperations.searchContact(searchContact);
        modelMap.addAttribute("contacts",contacts);
        modelMap.addAttribute("message","search results");
        return "searchResult";
    }
}