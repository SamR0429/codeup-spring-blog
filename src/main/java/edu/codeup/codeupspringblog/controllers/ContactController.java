package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
public class ContactController {

    //constructor dependency injection
    private ContactRepository contactsDao;
    public ContactController(ContactRepository contactsDao){
        this.contactsDao = contactsDao;
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> returnContacts(){
        //WE WOULD NOT DO THIS, (ask to be told why again, dependency injection
//        ContactRepository cr = new ContactRepository();

        return contactsDao.findAll();
    }

    @GetMapping("/contacts/view")
    public String returnContactsView(Model model){
        model.addAttribute("contacts", contactsDao.findAll());
        return "contacts/index";
    }
}
