
/**
 * Write a description of class Propiedad here.
 * 
 * @author (Claudia Yamile Gómez Llanez) 
 * @version (a version number or a date)
 */
public class Propiedad
{
    public String nombre;
    public String propietario;
    public Double area;
    public Integer habitantes;
    
    public Propiedad(String nombre,String propietario, Double area, 
    Integer habitantes ){
        this.nombre=nombre;
        this.propietario=propietario;
        this.area=area;
        this.habitantes=habitantes;        
        
    }
    
    public String getNombre(){
    return nombre;
    }
    
    public String getPropietario(){
    return propietario;
    }
    
    public Double getArea(){
    return area;
    }
    
    public Integer getHabitantes(){
    return habitantes;
    }
    
     public void setNombre(String nombre){
     this.nombre=nombre;
    }
    
    public void setPropietario(){
    this.propietario=propietario;
    }
    
    public void setArea(){
    this.area=area;
    }
    
    public void setHabitantes(){
    this.habitantes=habitantes;
    }
    
    public Double calcularPagoAdministración()
    {
        Double pago=null;
        if (area <= 120){
           pago=107000.00;
            if(area>=250 && area<=320){
                pago=222916.67;
                }else{ 
                 pago=285333.33;
                }
        }
        return pago;
    }
}
