
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GiovanniV17
 */
public class ProfesoresProceosos 
{
    ArrayList<Object> Profesor = new ArrayList<Object>();
    String Boleta1,Nombe1,Edad1,Genero1;
    private String ruta_txt = "Profesores.txt";
    Profesores prof;

    public ProfesoresProceosos() 
    {
    }

    public ProfesoresProceosos(ArrayList<Object> Profesor)
    {
        this.Profesor = Profesor;
    }
    
    public void agregarRegistro(Profesores E)
    {
        this.Profesor.add(E);
    }
    
    public void modificarRegistro(int i, Profesores E)
    {
        this.Profesor.set(i, E);
    }
    
    public void eliminarRegistro(int i)
    {
        this.Profesor.remove(i);
    }
    
    public Profesores obtenerRegistro(int i)
    {
        return (Profesores)Profesor.get(i);
    }
    
    public int cantidadRegistro()
    {
        return this.Profesor.size();
    }
    
    public int buscaCodigo(int codigo)
    {
        for(int i = 0; i < cantidadRegistro(); i++)
        {
            if(codigo == obtenerRegistro(i).getMatricula())return i;
        }
        return -1;
    }
    
    public String leerNombre()
    {
        try
        {
            String nombre = Nombe1.trim().replace(" ", "_");
            return nombre;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public String leerEdad()
    {
        try
        {
            String Edad = Edad1.trim().replace(" ", "_");
            return Edad;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public String leerGenero()
    {
        try
        {
            String Genero =  Genero1.trim().replace(" ", "_");
            return Genero;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
             
    public int leerMatricula()
    {
        try
        {
            int Boleta = Integer.parseInt(Boleta1.trim());
            System.out.println(Boleta);
            return Boleta;
        }
        catch(Exception ex)
        {
            return -666;
        }
    }
    
    public void cargar_txt()
    {
        File ruta = new File(ruta_txt);
        try
        {    
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);
            String linea = null;
            
            while((linea = bu.readLine())!=null)
            {
                StringTokenizer st = new StringTokenizer(linea, ",");
                prof = new Profesores();
                prof.setMatricula(Integer.parseInt(st.nextToken()));
                prof.setNombre(st.nextToken());
                prof.setEdad(st.nextToken());
                prof.setGenero(st.nextToken());

                agregarRegistro(prof);
            }
            bu.close();
        }
        catch(Exception ex)
        {
            System.out.println("No Se Encontro");
        }
    }
    
    public void grabar_txt()
    {
        JOptionPane.showMessageDialog(null, "Profesor Agregado Correctamente");
        FileWriter fw;
        PrintWriter pw;
        try
        {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);
            
            for(int i = 0; i < cantidadRegistro(); i++)
            {
                prof = obtenerRegistro(i);
                pw.println(String.valueOf(prof.getMatricula()+","+prof.getNombre()+","+prof.getEdad()+","+prof.getGenero()));
            }
            pw.close();
            
        }
        
        catch(Exception ex)
        {

            System.out.println("Error Al grabar");
        }
    }
    
    public void ingresarRegistro()
    {
        try
        {
            if(leerMatricula() == -666)
                System.out.println("No Se Ingreso La Matricula");
            else if(leerNombre() == null)
                System.out.println("No Se Ingreso El Nombre");
            else if(leerEdad() == null)
                System.out.println("No Se Ingreso La Edad");
            else if(leerGenero() == null)
                System.out.println("No Se Ingreso El Genero");
            else
            {
                prof = new Profesores(leerMatricula(),leerNombre(),leerEdad(),leerGenero());
                
                if(buscaCodigo(prof.getMatricula())!= -1)
                    
                    JOptionPane.showMessageDialog(null, "El Profesor Ya Existe");
                else
                    agregarRegistro(prof);
                
                grabar_txt();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
           
    public void modificarRegistro1()
    {
        try{
            if(leerMatricula() == -666)
                System.out.println("No Se Ingreso La Matricula");
            else if(leerNombre() == null)
                System.out.println("No Se Ingreso El Nombre");
            else if(leerEdad() == null)
                System.out.println("No Se Ingreso La Edad");
            else if(leerGenero() == null)
                System.out.println("No Se Ingreso El Genero");

            else
            {
                int codigo = buscaCodigo(leerMatricula());
                prof = new Profesores(leerMatricula(),leerNombre(),leerEdad(),leerGenero());
                
                if
                    (codigo == -1)agregarRegistro(prof);
                else 
                    modificarRegistro(codigo, prof);
                
                grabar_txt();
            }
        }
        catch(Exception ex)
        {
            System.out.println("No Se Pudo Actualizar");
        }
    }
    
    public void eliminarRegistro()
    {
        try{
            if(leerMatricula() == -666)
                System.out.println("No Se Ingreso La Matricula");
            
            else
            {
                int codigo = buscaCodigo(leerMatricula());
                if(codigo == -1) 
                    System.out.println("La Matricula No Existe");
                
                else
                {
                    int s = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Quiere Eliminar Este Profesor","Si/No",0);
                    if(s == 0)
                    {
                        eliminarRegistro(codigo);
                        grabar_txt();
                    }
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error En Eliminar");
        }
    }

}
