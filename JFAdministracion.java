import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.border.TitledBorder;
import java.io.*;
import java.util.*;;


/**
 * Write a description of class JFAdministracion here.
 * 
 * @author (Claudia Gomez) 
 * @version (a version number or a date)
 */
public class JFAdministracion extends JFrame implements ActionListener
{
    
   private JPanel p1,p2,p3;
   private JTextArea txtNombre, txtPropietario,txtArea, txtHabitantes, txtPagar;
   JButton btnCalcular, btnLimpiar;
   private Servicio servicio;
         
    
    public JFAdministracion() {
    
        servicio = new Servicio();

            try{
                servicio.leeDeFicheroB("propiedades");
            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(ClassNotFoundException e1){
            }
         
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
        
              
        //Se añaden los paneles al formulario "Administración Condominio Savanitas""
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        //Se crean los elementos graficos del panel p1: "Datos de la Propiedad"
        JLabel lblNombre =new JLabel("Nombre");
        JLabel lblPropietario =new JLabel("Propietario");
        JLabel lblArea =new JLabel("Area (m2)");
        JLabel lblHabitantes =new JLabel("Numero de habitantes");
        txtNombre=  new JTextArea("");
        txtPropietario=  new JTextArea("");
        txtArea=  new JTextArea("");
        txtHabitantes=  new JTextArea("");
        JButton btnGuardar= new JButton("Guardar");
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
        p1.add(btnGuardar);
        p1.add(btnBuscar);
        
        //Se crean los elementos graficos del panel p2: "Descuentos"
        
        Checkbox checkProntop= new Checkbox("Pronto Pago", false);
        Checkbox checkPlataforma= new Checkbox("Pago por plataforma", false);
                
        //Se añaden los elementos gráficos del panel p2: "Descuentos"
        p2.add(checkProntop);
        p2.add(checkPlataforma);
        
        //Se crean los elementos graficos del panel p3: "Calculos y Resultados"
        JLabel lblPagar=new JLabel("Valor a pagar:");
        txtPagar=new JTextArea("");
        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");
        
        //Se añaden los elementos graficos al panel p3: "Calculos y Resultados"
        p3.add(lblPagar);
        p3.add(txtPagar);
        p3.add(btnCalcular);
        p3.add(btnLimpiar);
        
       //se añaden los escuchadores
     
       btnCalcular.addActionListener(this);
       btnLimpiar.addActionListener(this);
       btnGuardar.addActionListener(this);
       btnBuscar.addActionListener(this);
        
        
}

    public void actionPerformed(ActionEvent evento){
        
        String comando = evento.getActionCommand();
        System.out.println(comando);
         if (comando.equals("Calcular")){
             
            Propiedad p = new Propiedad(txtNombre.getText(),txtPropietario.getText(),Double.parseDouble(txtArea.getText()), Integer.parseInt(txtHabitantes.getText()));
            Double pago=0.0;
            if (Double.parseDouble(txtArea.getText())<=120){
                pago=107000.00;            
              
            }else if (Double.parseDouble(txtArea.getText())<=250 ){ 
                pago=155000.00;
            
            }else if (Double.parseDouble(txtArea.getText())<=320){
                pago=222916.67;}
                else { 
                pago=285333.33;}
                
               txtPagar.setText(pago.toString());
            System.out.println("El pago de condominio es:"+pago); 
            
        
        }else if (comando.equals("Limpiar")){
            txtNombre.setText("");
            txtPropietario.setText("");
            txtArea.setText("");
            txtHabitantes.setText("");
            
        }
        else if (comando.equals("Guardar")){
            Propiedad p = new Propiedad(txtNombre.getText(),txtPropietario.getText(),Double.parseDouble(txtArea.getText()), Integer.parseInt(txtHabitantes.getText()));
            this.servicio.agregar(p);
            try{
                servicio.salvaAFicheroB("propiedades");
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            
            
    }else if (comando.equals("Buscar")){
            Propiedad p = servicio.buscarv(txtNombre.getText());
            if (p!= null) {
                txtPropietario.setText(p.getPropietario());
                txtArea.setText(p.getArea().toString());
                txtHabitantes.setText(p.getHabitantes().toString());
            }
            
        }
}
}
    
    
    






