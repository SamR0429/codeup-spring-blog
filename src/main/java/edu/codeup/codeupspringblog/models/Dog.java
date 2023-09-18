package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity

@Table(name = "dogs")

public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @Column(columnDefinition = "tinyint(3) UNSIGNED")
    private int age;

    @Column(columnDefinition = "varchar(200)")
    private String name;

    @Column(columnDefinition = "char(2) DEFAULT 'XX'")
    private String resideState;

    public Dog() {
    }

    public Dog(Long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
