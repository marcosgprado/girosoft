/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.beans;

/**
 *
 * @author Administrador
 */
public class DadosGiroscopio {

private double velocAngDisco;
private double velocAngPrecessaoMedida;
private double velocAngPrecessaoCalc;

//private String velocAngDiscoStr;
//private String velocAngPrecessaoMedidaStr;
//private String velocAngPrecessaoCalcStr;


 





    public double getVelocAngDisco() {
        return velocAngDisco;
    }

    public double getVelocAngPrecessaoCalc() {
        return velocAngPrecessaoCalc;
    }

    public double getVelocAngPrecessaoMedida() {
        return velocAngPrecessaoMedida;
    }

    public void setVelocAngDisco(double velocAngDisco) {
        this.velocAngDisco = velocAngDisco;
    }

    public void setVelocAngPrecessaoCalc(double velocAngPrecessaoCalc) {
        this.velocAngPrecessaoCalc = velocAngPrecessaoCalc;
    }

    public void setVelocAngPrecessaoMedida(double velocAngPrecessaoMedida) {
        this.velocAngPrecessaoMedida = velocAngPrecessaoMedida;
    }




}
