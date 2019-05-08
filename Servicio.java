import java.io.*;
import java.util.*;

public class Servicio implements Serializable
{
    List<Propiedad> propiedades;
          
    public Servicio()
    {
        propiedades = new ArrayList<Propiedad>();
    }
    
    public List<Propiedad> getPropiedades() { 
        
        return this.propiedades;
    }
    
    public void agregar(Propiedad prop) {
        this.propiedades.add(prop);
    }
    
    public Propiedad buscarv(String texto){
        for(int i = 0; i<this.propiedades.size(); i++) {
            Propiedad p = this.propiedades.get(i);
            if(p.getNombre().contentEquals(texto)){
                return p;
            }
        }
        return null;
    }
    
    public void salvaAFicheroB(String nomFich)
    throws IOException {
    
        ObjectOutputStream sal = null;
    
        try {
            
            FileOutputStream fout = new FileOutputStream(nomFich);
            sal = new ObjectOutputStream(fout);
            sal.writeObject(this);
            
        }finally {
    
            if (sal != null) {
    
                sal.close(); // cierra los streams
    
            }
        }
    }
    
    
    public void salvaAFicheroP(String nomFich) throws IOException {    
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nomFich);
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < this.propiedades.size(); i++) {
                Propiedad p = this.propiedades.get(i);
                pw.println(p.getNombre()+";"+p.getPropietario()+";"+p.getArea().toString()+";"+
                    p.getHabitantes().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
               if (null != fichero)
                  fichero.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
        }
    }
    
    
    public void leeDeFicheroB(String nomFich)
    throws IOException, ClassNotFoundException {
    
        ObjectInputStream ent = null;
        try {

            ent = new ObjectInputStream(
            new FileInputStream(nomFich));
            this.propiedades = ((Servicio)ent.readObject()).getPropiedades();
        
        } finally {
        
            if (ent != null) {
            
            ent.close(); // cierra los streams
            
            }
        
        }
    
    }
    
    
    public void leeDeFicheroP(String nomFich) throws FileNotFoundException, IOException{
        
        String cadena;
            FileReader f = new FileReader(nomFich);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                
                String[] props = cadena.split(";");
                Propiedad p = new Propiedad(props[0], props[1], Double.parseDouble(props[2]), 
                Integer.parseInt(props[3]));
                agregar(p);
                System.out.println(cadena);
            }
            b.close();
        
    }
    
    public void metodo() {
        
    }

    
    
}

