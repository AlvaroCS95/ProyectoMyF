package Modelos;

import java.util.ArrayList;
import java.util.Date;


public class Carga {
    String IdCamion;
    int IdCarga;
    String FechaCarga;

    ArrayList <DetalleCarga> laListaDeCarga;

    public Carga( String IdCamion) {
       
        this.IdCamion = IdCamion;
      
         laListaDeCarga=new ArrayList();
    }

    public Carga(){}

    public String getIdCamion() {
        return IdCamion;
    }

    public void setIdCamion(String IdCamion) {
        this.IdCamion = IdCamion;
    }

    public ArrayList<DetalleCarga> getLaListaDeCarga() {
        return laListaDeCarga;
    }

    public void setLaListaDeCarga(ArrayList<DetalleCarga> laListaDeCarga) {
        this.laListaDeCarga = laListaDeCarga;
    }

    public int getIdCarga() {
        return IdCarga;
    }

    public String getFechaCarga() {
        return FechaCarga;
    }

    public void setIdCarga(int IdCarga) {
        this.IdCarga = IdCarga;
    }

    public void setFechaCarga(String FechaCarga) {
        this.FechaCarga = FechaCarga;
    }
    
    
}