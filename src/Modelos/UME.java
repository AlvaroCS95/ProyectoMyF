/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author usuario
 */
public class UME {
    int codigo;
    String UME;

    public UME(int codigo, String UME) {
        this.codigo = codigo;
        this.UME = UME;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUME() {
        return UME;
    }

    public void setUME(String UME) {
        this.UME = UME;
    }
    
    
}
