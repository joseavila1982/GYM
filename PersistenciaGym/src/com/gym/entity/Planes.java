package com.gym.entity;
// Generated 28/07/2016 05:53:40 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Planes generated by hbm2java
 */
@Entity
@Table(name="planes"
    ,catalog="gym"
)
public class Planes  implements java.io.Serializable {


     private Integer id;
     private String tipo;
     private String valor;

    public Planes() {
    }

    public Planes(String tipo, String valor) {
       this.tipo = tipo;
       this.valor = valor;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="tipo", length=60)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="valor", length=100)
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }




}

