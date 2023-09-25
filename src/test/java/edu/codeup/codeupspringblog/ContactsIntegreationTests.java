package edu.codeup.codeupspringblog;


import edu.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootTest(classes = EntSpring)
@AutoConfigureMockMvc
public class ContactsIntegreationTests {

    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;


    @Autowired
    private UserRepository userDao;


}
