package com.example.crudeoperationbook.model;


import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="Books")
public class books implements UserDetails
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String Bookname;

    public String getBookname()
    {
        return Bookname;
    }

    public void setBookname(String bookname)
    {
        Bookname = bookname;
    }

    @Column
    private String author;

    @Column
    private int price;
    private  String email;
    private  String password;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="books", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id"))
    private Set<role> roles=new HashSet<>();


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities=this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return  authorities;

    }

    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}




