package oop.model;
// wzorzec JavaBeans
// 1. prywatne pola klasowe
// 2. metody dostępowe do pól klasowych gettery i settery

import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.time.LocalDateTime;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.TreeSet;

// klasa modelu -> klasa determinująca strukturę danych
public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    //płeć jest typem wyliczeniowym
    private Gender gender;
    //zbiór ról
    private Set<Role> roles = new TreeSet<>();
    private LocalDateTime registrationDateTime = LocalDateTime.now();
    private boolean status = true;
    private boolean removed = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}
