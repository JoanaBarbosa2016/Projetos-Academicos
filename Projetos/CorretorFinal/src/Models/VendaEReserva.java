/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author berna
 */
public class VendaEReserva{
    private int codBanco;
    private int codImovel;
    private int codComprador;
    private int codFiador;
    private int status;

    public int getCodBanco() {
        return codBanco;
    }

    public int getCodComprador() {
        return codComprador;
    }

    public int getCodFiador() {
        return codFiador;
    }

    public int getCodImovel() {
        return codImovel;
    }

    public int getStatus() {
        return status;
    }
    
    public void setCodBanco(int codBanco) {
        this.codBanco = codBanco;
    }

    public void setCodComprador(int codComprador) {
        this.codComprador = codComprador;
    }

    public void setCodFiador(int codFiador) {
        this.codFiador = codFiador;
    }

    public void setCodImovel(int codImovel) {
        this.codImovel = codImovel;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
