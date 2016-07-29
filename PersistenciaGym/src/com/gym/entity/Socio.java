package com.gym.entity;
// Generated 28/07/2016 05:53:40 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Socio generated by hbm2java
 */
@Entity
@Table(name="socio"
    ,catalog="gym"
)
public class Socio  implements java.io.Serializable {


     private Integer id;
     private String cedula;
     private String nombres;
     private String email;
     private String apellidos;
     private String direccion;
     private String ciudad;
     private String telefono;
     private String celular;
     private String sexo;
     private Date fechanacimiento;
     private Date fechainicio;
     private Date fechafinal;
     private String profesion;
     private String observaciones;
     private byte[] foto;
     private Integer idplan;

    public Socio() {
    }

    public Socio(String cedula, String nombres, String email, String apellidos, String direccion, String ciudad, String telefono, String celular, String sexo, Date fechanacimiento, Date fechainicio, Date fechafinal, String profesion, String observaciones, byte[] foto, Integer idplan) {
       this.cedula = cedula;
       this.nombres = nombres;
       this.email = email;
       this.apellidos = apellidos;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.telefono = telefono;
       this.celular = celular;
       this.sexo = sexo;
       this.fechanacimiento = fechanacimiento;
       this.fechainicio = fechainicio;
       this.fechafinal = fechafinal;
       this.profesion = profesion;
       this.observaciones = observaciones;
       this.foto = foto;
       this.idplan = idplan;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="cedula", length=20)
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    
    @Column(name="nombres", length=100)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="email", length=60)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="apellidos", length=100)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Column(name="direccion", length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="ciudad", length=60)
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    @Column(name="telefono", length=20)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="celular", length=20)
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    @Column(name="sexo", length=12)
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechanacimiento", length=10)
    public Date getFechanacimiento() {
        return this.fechanacimiento;
    }
    
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechainicio", length=10)
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechafinal", length=10)
    public Date getFechafinal() {
        return this.fechafinal;
    }
    
    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    
    @Column(name="profesion", length=100)
    public String getProfesion() {
        return this.profesion;
    }
    
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    
    @Column(name="observaciones", length=65535)
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    @Column(name="foto")
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    
    @Column(name="idplan")
    public Integer getIdplan() {
        return this.idplan;
    }
    
    public void setIdplan(Integer idplan) {
        this.idplan = idplan;
    }




}

