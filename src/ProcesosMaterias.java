
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
public class ProcesosMaterias 
{
    ArrayList<Object> Materias = new ArrayList<Object>();
    
    String Nombe1,Grupo,Id;
    private String ruta_txt = "Materias.txt";
    Materias mat;
    
    public ProcesosMaterias() 
    {
    }

    public ProcesosMaterias(ArrayList<Object> Materias)
    {
        this.Materias = Materias;
    }
    
    public void agregarRegistro(Materias E)
    {
        this.Materias.add(E);
    }
    
    public void modificarRegistro(int i, Materias E)
    {
        this.Materias.set(i, E);
    }
    
    public void eliminarRegistro(int i)
    {
        this.Materias.remove(i);
    }
    
    public Materias obtenerRegistro(int i)
    {
        return (Materias)Materias.get(i);
    }
    
    public int cantidadRegistro()
    {
        return this.Materias.size();
    }
    
    public int buscaCodigo(int codigo)
    {
        for(int i = 0; i < cantidadRegistro(); i++)
        {
            if(codigo == obtenerRegistro(i).getGrupo())return i;
        }
        return -1;
    }
    
    public int leerGrupo()
    {
        try
        {
            int Boleta = Integer.parseInt(Grupo.trim());
            System.out.println(Boleta);
            return Boleta;
        }
        catch(Exception ex)
        {
            return -666;
        }
    }

    public String leerMateria()
    {
        try
        {
            String Nombre = Nombe1.trim().replace(" ", "_");
            return Nombre;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
             
    public int leerId()
    {
        try
        {
            int Boleta = Integer.parseInt(Id.trim());
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
                mat = new Materias();
                mat.setId(Integer.parseInt(st.nextToken()));
                mat.setNombre(st.nextToken());
                mat.setGrupo(Integer.parseInt(st.nextToken()));
                agregarRegistro(mat);
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
                mat = obtenerRegistro(i);
                pw.println(String.valueOf(mat.getId()+","+mat.getNombre()+","+mat.getGrupo()));
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
            if(leerId() == -666)
                System.out.println("No Se Ingreso La Matricula");
            else if(leerMateria()== null)
                System.out.println("No Se Ingreso El Nombre");
            else if(leerGrupo()== -666)
                System.out.println("No Se Ingreso La Edad");
            else
            {
                mat = new Materias(leerId(),leerMateria(),leerGrupo());
                
                if(buscaCodigo(mat.getGrupo())!= -1)
                    
                    JOptionPane.showMessageDialog(null, "El Grupo Ya Existe");
                else
                    agregarRegistro(mat);
                
                grabar_txt();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
           
    public void modificarRegistro()
    {
        try{
            if(leerId() == -666)
                System.out.println("No Se Ingreso La Matricula");
            else if(leerMateria()== null)
                System.out.println("No Se Ingreso El Nombre");
            else if(leerGrupo()== -666)
                System.out.println("No Se Ingreso La Edad");
            else
            {
                mat = new Materias(leerId(),leerMateria(),leerGrupo());
                int codigo = buscaCodigo(leerGrupo());
                
                if
                    (codigo == -1)agregarRegistro(mat);
                else 
                    modificarRegistro(codigo, mat);
                
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
            if(leerGrupo() == -666)
                System.out.println("No Se Ingreso La Matricula");
            
            else
            {
                int codigo = buscaCodigo(leerGrupo());
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
