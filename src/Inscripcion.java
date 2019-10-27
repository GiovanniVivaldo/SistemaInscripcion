/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GiovanniV17
 */
public class Inscripcion 
{
    int Boleta;
    String Nombre,grupo;

    public Inscripcion() {
    }

    public Inscripcion(int Boleta, String Nombre, String grupo) {
        this.Boleta = Boleta;
        this.Nombre = Nombre;
        this.grupo = grupo;
    }

    public int getBoleta() {
        return Boleta;
    }

    public void setBoleta(int Boleta) {
        this.Boleta = Boleta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
}
