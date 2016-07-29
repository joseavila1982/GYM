/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.gymcore.backingbean;

import com.gym.entity.Socio;
import com.gym.persistence.dao.SocioDao;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JOSE
 */
@ManagedBean(name = "socioBean")
@RequestScoped
public class SocioBean implements Serializable {

        
    private String cedula;
    private String nombres;
    private String email;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String celular;
    private String sexo;
    private Date fecnacimiento;
    private Date fechainicio;
    private Date fechafinal;
    private String profesion;
    private String observaciones;
    private byte[] foto;

    /**
     * Creates a new instance of SocioBean
     */
    public SocioBean() {
    }

    public void guardarSocio(){
        
       try {
       Socio socio = new Socio();
       socio.setCedula(cedula);
       socio.setNombres(nombres);
       socio.setEmail(email);
       socio.setDireccion(direccion);
       socio.setCiudad(ciudad);
       socio.setTelefono(telefono);
       socio.setCelular(celular);
       socio.setSexo(sexo);
       socio.setFechanacimiento(fecnacimiento);
       socio.setFechainicio(fechainicio);
       socio.setFechafinal(fechafinal);
       socio.setProfesion(profesion);
       socio.setObservaciones(observaciones);
       socio.setFoto(getFoto());
       
       
       SocioDao socioDao = new SocioDao();
       socioDao.crear(socio);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Socio Guardado Exitosamente."));
 
       List<Socio> soc;
       soc = socioDao.buscarTodos();
       
       if(soc.size() > 0){
           for(int i=0; i<soc.size();i++){
           System.out.println(".::Datos del Socio::."); 
           System.out.println("Cedula: " + soc.get(i).getCedula());
           System.out.println("Nombres: " + soc.get(i).getNombres());
           System.out.println("Apellidos: " + soc.get(i).getApellidos());
           }
       }
        } catch (Exception ex) {
            Logger.getLogger(SocioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fecnacimiento
     */
    public Date getFecnacimiento() {
        return fecnacimiento;
    }

    /**
     * @param fecnacimiento the fecnacimiento to set
     */
    public void setFecnacimiento(Date fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    /**
     * @return the fechainicio
     */
    public Date getFechainicio() {
        return fechainicio;
    }

    /**
     * @param fechainicio the fechainicio to set
     */
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * @return the fechafinal
     */
    public Date getFechafinal() {
        return fechafinal;
    }

    /**
     * @param fechafinal the fechafinal to set
     */
    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

   
    
    
}
