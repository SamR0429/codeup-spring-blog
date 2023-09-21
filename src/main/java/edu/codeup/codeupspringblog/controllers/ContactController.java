package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {

    //constructor dependency injection
    private ContactRepository contactsDao;
//    private CountService countService;

//    public ContactController(ContactRepository contactsDao, CountService countService) {
//        this.contactsDao = contactsDao;
//        this.countService = countService;
//    }

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
