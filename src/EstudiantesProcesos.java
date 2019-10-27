import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author GiovanniV17
 */
public class EstudiantesProcesos 
{
    ArrayList<Object> Estudiante = new ArrayList<Object>();

    String Boleta1,Nombe1,Edad1,Genero1,Carrera1,Contraseña1;
    private String ruta_txt = "Estudiantes.txt";
    Estudiantes Alumnos;

    public EstudiantesProcesos() 
    {
    }

    public EstudiantesProcesos(ArrayList<Object> Estudiante)
    {
        this.Estudiante = Estudiante;
    }
    
    public void agregarRegistro(Estudiantes E)
    {
        this.Estudiante.add(E);
    }

    public void modificarRegistro(int i, Estudiantes E)
    {
        this.Estudiante.set(i, E);
    }
    
    public void eliminarRegistro(int i)
    {
        this.Estudiante.remove(i);
    }
    
    public Estudiantes obtenerRegistro(int i)
    {
        return (Estudiantes)Estudiante.get(i);
    }
    
    public int cantidadRegistro()
    {
        return this.Estudiante.size();
    }
    
    public int buscaCodigo(int codigo)
    {
        for(int i = 0; i < cantidadRegistro(); i++)
        {
            if(codigo == obtenerRegistro(i).getBoleta())return i;
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
    
    public String leerCarrera()
    {
        try
        {
            String Carrera =  Carrera1.trim().replace(" ", "_");
            return Carrera;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public String leerContraseña()
    {
        try
        {
            String Contraseña =  Contraseña1.trim().replace(" ", "_");
            return Contraseña;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
             
    public int leerBoleta()
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
                Alumnos = new Estudiantes();
                Alumnos.setBoleta(Integer.parseInt(st.nextToken()));
                Alumnos.setContraseña(st.nextToken());
                Alumnos.setNombe(st.nextToken());
                Alumnos.setEdad(st.nextToken());
                Alumnos.setGenero(st.nextToken());
                Alumnos.setCarrera(st.nextToken());
                agregarRegistro(Alumnos);
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
        JOptionPane.showMessageDialog(null, "Alumno Agregado Correctamente");
        FileWriter fw;
        PrintWriter pw;
        try
        {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);
            
            for(int i = 0; i < cantidadRegistro(); i++)
            {
                Alumnos = obtenerRegistro(i);
                pw.println(String.valueOf(Alumnos.getBoleta()+","+Alumnos.getNombe()+","+Alumnos.getEdad()+","+Alumnos.getGenero()+","+Alumnos.getCarrera()+","+Alumnos.getContraseña()));
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
            if(leerBoleta() == -666)
                System.out.println("No Se Ingreso La Boleta");
            else if(leerContraseña() == null)
                System.out.println("No Se Ingreso La Contraseña");
            else if(leerNombre() == null)
                System.out.println("No Se Ingreso El Nombre");
            else if(leerEdad() == null)
                System.out.println("No Se Ingreso La Edad");
            else if(leerGenero() == null)
                System.out.println("No Se Ingreso El Genero");
            else if(leerCarrera() == null)
                System.out.println("No Se Ingreso La Carrera");
            else
            {
                Alumnos = new Estudiantes(leerBoleta(),leerContraseña(),leerNombre(),leerEdad(),leerGenero() ,leerCarrera());
                
                if(buscaCodigo(Alumnos.getBoleta())!= -1)
                    
                    JOptionPane.showMessageDialog(null, "El Alumno Ya Existe");
                else
                    agregarRegistro(Alumnos);
                
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
            if(leerBoleta() == -666)
                System.out.println("No Se Ingreso La Boleta");
            else if(leerContraseña() == null)
                System.out.println("No Se Ingreso La Contraseña");
            else if(leerNombre() == null)
                System.out.println("No Se Ingreso El Nombre");
            else if(leerEdad() == null)
                System.out.println("No Se Ingreso La Edad");
            else if(leerGenero() == null)
                System.out.println("No Se Ingreso El Genero");
            else if(leerCarrera() == null)
                System.out.println("No Se Ingreso La Carrera");
            else
            {
                int codigo = buscaCodigo(leerBoleta());
                Alumnos = new Estudiantes(leerBoleta(),leerContraseña(),leerNombre(),leerEdad(),leerGenero() ,leerCarrera());
                
                if
                    (codigo == -1)agregarRegistro(Alumnos);
                else 
                    modificarRegistro(codigo, Alumnos);
                
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
            if(leerBoleta() == -666)
                System.out.println("No Se Ingreso La Boleta");
            
            else
            {
                int codigo = buscaCodigo(leerBoleta());
                if(codigo == -1) 
                    System.out.println("La Boleta No Existe");
                
                else
                {
                    int s = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Quiere Eliminar Este Estudiante","Si/No",0);
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
