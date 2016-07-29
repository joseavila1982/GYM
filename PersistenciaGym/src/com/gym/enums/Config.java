/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.enums;

/**
 *
 * @author JOSE
 */
public enum Config {
    
    CONF_HIBERNATE("/com/gym/cfg/hibernate.cfg.xml"),
    TIME_REVERSE("10"),
    FORMATO_FECHA("yyyy-MM-dd"),
    FORMATO_HORA("HH:mm:ss"),
    FORMATEO_FECHA_HORA("yyyy-MM-dd HH:mm:ss"),
    YEAR("1000000"),
    MONTH("100000"),
    DAY("10000"),
    HOURS("1000"),
    MINUTES("100"),
    SECONDS("10");
    private final String value;


    /**
     * Método para signar un valor al campo value
     * @param value Valor String
     */
    Config(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor del campo value
     * @return String con el valor del campo value
     */
    public String getConfig() {
        return value;
    }
}
