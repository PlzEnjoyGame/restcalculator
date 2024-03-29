package idi.ntnu.restcalculator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class User {
    @Id
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
