package edu.codeup.codeupspringblog.controllers;


import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import edu.codeup.codeupspringblog.services.EmailService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postsDao;

    private UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository userDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping("/posts")
    // model is the way we package up stuff from the back end and send it to the front
    public String returnPosts(Model model) {
//        return postsDao.findAll();
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

//    @GetMapping("/posts")
//    @ResponseBody
//    public String post() {
//        return "index page!";
//    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(Model model, @PathVariable Long id) {
//        return String.format("this post id is %s", id);
        if(postsDao.existsById(id)) {
            Post post = postsDao.findById(id).get();
            model.addAttribute("post", post);
            return "post/show";
        }
        return "redirect:/posts";
    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String postForm(@PathVariable String create) {
//        return create ;
//    }




    //this was for when we didnt have the form and the html made up yet, the bottom is the newer version after the creation of the html and form

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String postForm() {
//        return ("heres the post create get repose");
//    }

//    @GetMapping("/posts/create")
//    public String postForm() {
//        //when you are returning, you never want to have "/xxxxx/xxxx" cause the first / will give you and infinite redirect with the website when deployed
//        return "posts/create";
//    }

    //this was for when we didnt have the form and the html made up yet, the bottom is the newer version after the creation of the html and form

//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String postFormCreate() {
//        return ("heres the post create post repose");
//    }

//    @PostMapping("/posts/create")
//    public String postFormCreate(@RequestParam ("title") String title, @RequestParam ("body") String body) {
//
//        User hardCodedUser = userDao.findById(2L).get();
//
//        Post newPost = new Post(title, body, hardCodedUser);
//        postsDao.save(newPost);
//        return "redirect:/posts";
//    }

//    @PostMapping("/posts/create")
//    public String postFormCreate(@ModelAttribute Post post) {
//
//        User hardCodedUser = userDao.findById(2L).get();
//
//        Post newPost = new Post(
//                post.getTitle(),
//                post.getBody(),
//                hardCodedUser
//        );
//        postsDao.save(newPost);
//        return "redirect:/posts";
//    }


//    we added this during billies lecture


//    @GetMapping("/posts/{id}/edit")
//    public String editPost(@PathVariable long id, Model model){
//        Post postToEdit = postsDao.findById(id).get();
//        model.addAttribute("post", postToEdit);
//        return "post/edit";
//    }
//
//    @PostMapping("/posts/{id}/edit")
//    public String insertEdit(@ModelAttribute Post post, @PathVariable long id){
//        Post postToEdit = postsDao.findById(id).get();
//        postToEdit.setTitle(post.getTitle());
//        postToEdit.setBody(post.getBody());
//        postsDao.save(postToEdit);
//        return  "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String showCreatePostView(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        // Hard Coded user SaintSteve
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User hardCodedUser = userDao.findById(2L).get();
        Post postToCreate = new Post(
                post.getTitle(),
                post.getBody(),
                hardCodedUser
        );
        postsDao.save(postToCreate);
        emailService.prepareAndSend(postToCreate, "new post", "you have created a new post");
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        Post postToEdit = postsDao.findById(id).get();
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String insertEdit(@ModelAttribute Post post, @PathVariable long id){
        Post postToEdit = postsDao.findById(id).get();
        postToEdit.setTitle(post.getTitle());
        postToEdit.setBody(post.getBody());
        postsDao.save(postToEdit);
        return "redirect:/posts/"+id;
    }

}
