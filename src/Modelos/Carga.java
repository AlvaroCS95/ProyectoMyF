package Modelos;

import java.util.ArrayList;


public class Carga {
    String IdCamion;

    ArrayList <DetalleCarga> laListaDeCarga;

    public Carga( String IdCamion) {
       
        this.IdCamion = IdCamion;
      
         laListaDeCarga=new ArrayList();
    }

    

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
}