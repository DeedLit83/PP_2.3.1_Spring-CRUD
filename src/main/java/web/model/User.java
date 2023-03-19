package web.model;

import javax.persistence.*;

@Entity
@Table(name = "user_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surName;

    @Column(name = "age", nullable = false)
    private byte age;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    public User() {
    }

    public User(String name, String surName, byte age, String email) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", suName='" + surName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
