package edu.codeup.codeupspringblog.controllers;


import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postsDao;

    private UserRepository userDao;

    public PostController(PostRepository postsDao, UserRepository userDao) {
        this.postsDao = postsDao;
        this.userDao = userDao;
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

    @GetMapping("/posts/create")
    public String postForm() {
        //when you are returning, you never want to have "/xxxxx/xxxx" cause the first / will give you and infinite redirect with the website when deployed
        return "posts/create";
    }

    //this was for when we didnt have the form and the html made up yet, the bottom is the newer version after the creation of the html and form

//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String postFormCreate() {
//        return ("heres the post create post repose");
//    }

    @PostMapping("/posts/create")
    public String postFormCreate(@RequestParam ("title") String title, @RequestParam ("body") String body) {
        Post newPost = new Post(
                title, body
        );
        postsDao.save(newPost);
        return "redirect:/posts";
    }

}
