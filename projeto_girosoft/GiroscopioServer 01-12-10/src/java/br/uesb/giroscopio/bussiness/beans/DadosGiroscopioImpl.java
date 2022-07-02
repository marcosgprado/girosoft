/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.beans;

import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service("dadosGiroscopioImpl")
public class DadosGiroscopioImpl implements DadosGiroscopio {

    private double velocAngDisco;
    private double velocAngPrecessaoMedida;
    private double velocAngPrecessaoCalc;

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
