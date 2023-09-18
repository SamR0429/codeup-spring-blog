package edu.codeup.codeupspringblog.controllers;


import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
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
    public String postId(@PathVariable Long id) {
        return String.format("this post id is %s", id);
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
