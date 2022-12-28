package com.example.crudUsers.model;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
//@MappedSuperclass
@Table(name="usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User { //implements Serializable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String name;

    @Column
    protected LocalDate birth;

    @Column
    protected String addres;

    @Column(unique = true)
    protected String phone;

    @Column(unique = true)
    protected String email;

    @Column(unique = true)
    protected String cpf;


    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

}
