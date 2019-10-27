/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GiovanniV17
 */

public class Estudiantes 
{
    int Boleta;
    String Nombe,Edad,Genero,Carrera,Contraseña;

    public Estudiantes() 
    {}

    public Estudiantes(int Boleta, String Nombe, String Edad, String Genero, String Carrera, String Contraseña) 
    {
        this.Boleta = Boleta;
        this.Nombe = Nombe;
        this.Edad = Edad;
        this.Genero = Genero;
        this.Carrera = Carrera;
        this.Contraseña = Contraseña;
    }

    public int getBoleta() 
    {
        return Boleta;
    }

    public void setBoleta(int Boleta) 
    {
        this.Boleta = Boleta;
    }

    public String getNombe() 
    {
        return Nombe;
    }

    public void setNombe(String Nombe) 
    {
        this.Nombe = Nombe;
    }

    public String getEdad() 
    {
        return Edad;
    }

    public void setEdad(String Edad) 
    {
        this.Edad = Edad;
    }

    public String getGenero() 
    {
        return Genero;
    }

    public void setGenero(String Genero) 
    {
        this.Genero = Genero;
    }

    public String getCarrera() 
    {
        return Carrera;
    }

    public void setCarrera(String Carrera) 
    {
        this.Carrera = Carrera;
    }

    public String getContraseña() 
    {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) 
    {
        this.Contraseña = Contraseña;
    }
    
}
