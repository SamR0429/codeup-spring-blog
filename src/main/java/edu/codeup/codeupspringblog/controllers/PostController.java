package edu.codeup.codeupspringblog.controllers;


import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postsDao;
    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    @ResponseBody
    public List<Post> returnPosts(){
        return postsDao.findAll();
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

    @GetMapping("/posts/create")
    @ResponseBody
    public String postForm() {
        return ("heres the post create get repose");
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postFormCreate() {
        return ("heres the post create post repose");
    }

}
