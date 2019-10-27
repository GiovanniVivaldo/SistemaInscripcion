/**
 *
 * @author GiovanniV17
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ProcesoInscripcion {
        ArrayList<Object> Lista = new ArrayList<Object>();
    
    String Nombe1,Grupo,Id;
    private String ruta_txt = "Listas.txt";
    Inscripcion mat;
    
    public ProcesoInscripcion() 
    {
    }

    public ProcesoInscripcion(ArrayList<Object> Lista)
    {
        this.Lista = Lista;
    }
    
    public void agregarRegistro(Inscripcion E)
    {
        this.Lista.add(E);
    }
    
    public void modificarRegistro(int i, Inscripcion E)
    {
        this.Lista.set(i, E);
    }
    
    public void eliminarRegistro(int i)
    {
        this.Lista.remove(i);
    }
    
    public Inscripcion obtenerRegistro(int i)
    {
        return (Inscripcion)Lista.get(i);
    }
    
    public int cantidadRegistro()
    {
        return this.Lista.size();
    }
    
    public int buscaCodigo(int codigo)
    {
        for(int i = 0; i < cantidadRegistro(); i++)
        {
            if(codigo == obtenerRegistro(i).getBoleta())return i;
        }
        return -1;
    }
    
    public String leerGrupo()
    {
        try
        {
            String Nombre = Grupo.trim().replace(" ", "_");
            return Nombre;
        }
        catch(Exception ex)
        {
            return null;
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
                mat = new Inscripcion();
                mat.setBoleta(Integer.parseInt(st.nextToken()));
                mat.setNombre(st.nextToken());
                mat.setGrupo(st.nextToken());
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
        JOptionPane.showMessageDialog(null, "Registrado Correctamente");
        FileWriter fw;
        PrintWriter pw;
        try
        {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);
            
            for(int i = 0; i < cantidadRegistro(); i++)
            {
                mat = obtenerRegistro(i);
                pw.println(String.valueOf(mat.getBoleta()+","+mat.getNombre()+","+mat.getGrupo()));
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
            else if(leerGrupo()== null)
                System.out.println("No Se Ingreso La Edad");
            else
            {
                mat = new Inscripcion(leerId(),leerMateria(),leerGrupo());
                
                if(buscaCodigo(mat.getBoleta())!= -1)
                    
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
            else if(leerGrupo()== null)
                System.out.println("No Se Ingreso La Edad");
            else
            {
                mat = new Inscripcion(leerId(),leerMateria(),leerGrupo());
                int codigo = buscaCodigo(leerId());
                
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
            if(leerId()== -666)
                System.out.println("No Se Ingreso La Matricula");
            
            else
            {
                int codigo = buscaCodigo(leerId());
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
