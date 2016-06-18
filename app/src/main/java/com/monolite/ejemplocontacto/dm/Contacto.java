package com.monolite.ejemplocontacto.dm;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JoséAugusto on 14/06/2016.
 */

public class Contacto implements Serializable, Validable{

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public GregorianCalendar getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public boolean validarCorreo(){
        Pattern ptrn = Pattern.compile(this.REGEX_CORREO);
        Matcher matcher = ptrn.matcher(this.Correo);

        return matcher.matches();
    }



    private String Nombre;
    private GregorianCalendar FechaNacimiento;
    private String Telefono;
    private String Correo;
    private String Descripcion;

    private final String REGEX_CORREO = "\\A[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";


    @Override
    public boolean validar() {
        return false;
    }
}
