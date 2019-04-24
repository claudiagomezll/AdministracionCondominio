import java.awt.*;
import javax.swing.*;
import java.awt.color.*;
import javax.swing.border.TitledBorder;

/**
 * Write a description of class JFAdministracion here.
 * 
 * @author (Claudia Gomez) 
 * @version (a version number or a date)
 */
public class JFAdministracion extends JFrame
{
    
   private JPanel p1,p2,p3;
         
    
    public JFAdministracion(){
    
        setTitle("Administración Condominio Savanitas");
        setVisible(true);
        setSize(350,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//para que se cierre al salir
        setResizable(false);//no se puede cambiar de tamaño la ventana
        setLayout(new BorderLayout());
        
        //Creamos el panel p1:"Datos de la propiedad" y sus propiedades
        p1=new JPanel();
        p1.setLayout(new GridLayout(5,2,5,5));
        p1.setPreferredSize(new Dimension (350,200));
        p1.setBackground(Color.orange);
        p1.setBorder( new TitledBorder( "Datos de la propiedad" ) );
        
        // Se crea el segundo panel p2: "descuentos"
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setPreferredSize(new Dimension (3500,100));
        p2.setBackground(Color.pink);
        p2.setBorder( new TitledBorder( "Aplicacion de descuentos" ) );
        
        
        // Se crea el tercer panel p3:"Calculos y resultados" y sus propiedades
        p3=new JPanel();
        p3.setLayout(new GridLayout(2,2,5,5));
        p3.setPreferredSize(new Dimension (350,100));
        p3.setBackground(Color.yellow);
        p3.setBorder( new TitledBorder( "Calculos y Resultados" ) );
        
        //añadimos paneles v1
        /*getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(p2, BorderLayout.CENTER);
        getContentPane().add(p3, BorderLayout.SOUTH);
        pack()*/
        
        //Se añaden los paneles al formulario "Administración Condominio Savanitas""
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        //Se crean los elementos graficos del panel p1: "Datos de la Propiedad"
        JLabel lblNombre =new JLabel("Nombre");
        JLabel lblPropietario =new JLabel("Propietario");
        JLabel lblArea =new JLabel("Area (m2)");
        JLabel lblHabitantes =new JLabel("Numero de habitantes");
        JTextArea txtNombre=  new JTextArea("");
        JTextArea txtPropietario=  new JTextArea("");
        JTextArea txtArea=  new JTextArea("");
        JTextArea txtHabitantes=  new JTextArea("");
        JButton btnBuscar = new JButton("Buscar");
        
        //Añadimos los elementos graficos al panel p1: "Datos de la Propiedad"
        
        p1.add(lblNombre);
        p1.add(txtNombre);
        p1.add(lblPropietario);
        p1.add(txtPropietario);
        p1.add(lblArea);
        p1.add(txtArea);
        p1.add(lblHabitantes);
        p1.add(txtHabitantes);
        p1.add(btnBuscar);
        
        //Se crean los elementos graficos del panel p2: "Descuentos"
        
        Checkbox checkProntop= new Checkbox("Pronto Pago", false);
        Checkbox checkPlataforma= new Checkbox("Pago por plataforma", false);
                
        //Se añaden los elementos gráficos del panel p2: "Descuentos"
        p2.add(checkProntop);
        p2.add(checkPlataforma);
        
        //Se crean los elementos graficos del panel p3: "Calculos y Resultados"
        JLabel lblPagar=new JLabel("Valor a pagar:");
        JTextArea txtPagar=new JTextArea("");
        JButton btnCalcular = new JButton("Calcular");
        JButton btnLimpiar = new JButton("Limpiar");
        
        //Se añaden los elementos graficos al panel p3: "Calculos y Resultados"
        p3.add(lblPagar);
        p3.add(txtPagar);
        p3.add(btnCalcular);
        p3.add(btnLimpiar);
        
}



}
