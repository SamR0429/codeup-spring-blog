package edu.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity

@Table(name = "posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

//    @Column(columnDefinition = "varchar(100)")
    private String title;
//    @Column(columnDefinition = "varchar(250)")
    private String body;



    public Post(){

    }

    public Post(Long id,String title, String body) {
        this.id = id;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
