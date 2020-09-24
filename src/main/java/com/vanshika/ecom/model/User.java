package com.vanshika.ecom.model;

import com.vanshika.ecom.validation.ValidEmail;
import com.vanshika.ecom.validation.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotNull(message = "Enter your first name")
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull(message = "Enter your last name")
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull(message = "Enter your Gender")
    private String gender;

    @ValidEmail
    @NotNull(message = "Enter your email")
    private String username;

    @ValidPassword
    @NotNull(message = "Enter your password")
    private String password;
    private String confirmPassword;

    private boolean enabled;
    private String roles;


    public User(int id, String firstName, String lastName, String gender, String username, String password, String confirmPassword, boolean enabled, String roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.enabled = enabled;
        this.roles = roles;
    }

    public User(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

