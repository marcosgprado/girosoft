/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.persistence.entities;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author marcos
 */

public class DadosGiroscopio {




private static final long serialVersionUID = 1L;
private int id;
private double velocAngDisco;
private double velocAngPrecessaoMedida;
private int numeroCaptura;







    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public double getVelocAngDisco() {
        return velocAngDisco;
    }

    public int getNumeroCaptura() {
        return numeroCaptura;
    }

    public double getVelocAngPrecessaoMedida() {
        return velocAngPrecessaoMedida;
    }

    public void setVelocAngDisco(double velocAngDisco) {
        this.velocAngDisco = velocAngDisco;
    }

    public void setNumeroCaptura(int numeroCaptura) {
        this.numeroCaptura = numeroCaptura;
    }

    public void setVelocAngPrecessaoMedida(double velocAngPrecessaoMedida) {
        this.velocAngPrecessaoMedida = velocAngPrecessaoMedida;
    }




}



