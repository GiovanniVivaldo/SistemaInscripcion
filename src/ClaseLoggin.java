import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *Clase Loggin Tipo De Usuarios
 * 20/10/2019
 * author GiovanniV17
 */

public class ClaseLoggin 
{
    String Usuario;
    String Contraseña;
    boolean Validacion = false;
    
    public ClaseLoggin() 
    {}
    
    public void ValidacionEstudiante() throws IOException
    {
        BufferedReader Lector = new BufferedReader(new FileReader("Estudiantes.txt"));
        String Linea = Lector.readLine();
        
        while (Linea != null && Validacion == false)
        {
            String[] Dato = Linea.split(",");
            
            if (Dato[0].equals(Usuario) && Dato[1].equals(Contraseña))
                Validacion = true;
            
            else
                Linea = Lector.readLine();
        }
 
        if(Validacion)
        {
            System.out.println("Ingreso "+Usuario+" "+Contraseña);
            
            Menu_Alumnos Menu = new Menu_Alumnos();
            Menu.setVisible(Validacion);
            
        }
        else 
        {
            ValidacionAdministrador();
        }
    }
    
    public void ValidacionAdministrador() throws IOException
    {
        boolean  Validacion = false;
        BufferedReader Lector = new BufferedReader(new FileReader("Administradores.txt"));
        String Linea = Lector.readLine();
 
        while (Linea != null && Validacion == false)
        {
            String[] Dato = Linea.split(",");
            if (Dato[0].equals(Usuario) && Dato[1].equals(Contraseña))
                Validacion = true;
            else
                Linea = Lector.readLine();
        }
 
        if(Validacion)
        {
            //Abrimos Ventana admin
            System.out.println("Ingreso "+Usuario+" "+Contraseña);
            
            Menu_prof Menu = new Menu_prof();
            Menu.setVisible(Validacion);
        }
        else 
        {
            //Mensaje De Usuario y/o Contraseña No Encontrado
           JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña Incorrectos");
        }
    }
    
}
