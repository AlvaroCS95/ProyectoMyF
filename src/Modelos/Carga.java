package Modelos;

import java.util.ArrayList;
import java.util.Date;


public class Carga {
    String IdCamion;
    int IdCarga,usuario,idRuta;
    String FechaCarga,FechaEjecucion;
    

    ArrayList <DetalleCarga> laListaDeCarga;

    public Carga( String IdCamion,int IdUsuario,String FechaE,int ruta) {
       
        this.IdCamion = IdCamion;
        this.usuario=IdUsuario;
        this.FechaEjecucion=FechaE;
        this.idRuta=ruta;
         laListaDeCarga=new ArrayList();
    }

    public Carga(){}

    public String getIdCamion() {
        return IdCamion;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
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

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    public String getFechaEjecucion() {
        return FechaEjecucion;
    }

    public void setFechaEjecucion(String FechaEjecucion) {
        this.FechaEjecucion = FechaEjecucion;
    }
    
    
}