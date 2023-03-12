package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user_db")
public class User {
    public User() {
    }

    public User(String name, String surName, byte age, String email) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 1, max = 50, message = "Surname should be between 1 and 50 characters")
    private String surName;

    @Column(name = "age", nullable = false)
    @Min(value = 1, message = "Age should be greater than 0")
    @Max(value = 120, message = "Age should be less than 120")
    private byte age;

    @Column(name = "email", nullable = false, length = 100)
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public int getId() {
        return id;
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
