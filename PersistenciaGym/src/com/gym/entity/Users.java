package com.gym.entity;
// Generated 28/07/2016 05:53:40 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="gym"
)
public class Users  implements java.io.Serializable {


     private Integer id;
     private String nombres;
     private String email;
     private String username;
     private String password;

    public Users() {
    }

    public Users(String nombres, String email, String username, String password) {
       this.nombres = nombres;
       this.email = email;
       this.username = username;
       this.password = password;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombres", length=20)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="email", length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="username", length=30)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", length=60)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}

