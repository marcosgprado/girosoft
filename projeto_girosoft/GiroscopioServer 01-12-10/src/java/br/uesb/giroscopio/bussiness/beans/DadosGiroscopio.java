/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.beans;

/**
 *
 * @author Administrador
 */
public interface DadosGiroscopio {


    public double getVelocAngDisco();

    public double getVelocAngPrecessaoCalc();

    public double getVelocAngPrecessaoMedida();


    
    public void setVelocAngDisco(double velocAngDisco);


    public void setVelocAngPrecessaoCalc(double velocAngPrecessaoCalc);

    public void setVelocAngPrecessaoMedida(double velocAngPrecessaoMedida);




}
