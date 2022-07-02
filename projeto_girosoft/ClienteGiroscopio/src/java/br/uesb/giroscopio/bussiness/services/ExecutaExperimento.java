/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.services;

//import br.uesb.giroscopio.bussiness.beans.*;
import java.util.List;


/**
 *
 * @author Administrador
 */
public interface ExecutaExperimento {



    //public double getVelocAngPrecessaoCalc();

    //public double getVelocAngPrecessaoMedida();


    public char getCharOut();

    public String getDadoIn();

    public String getStrIn();

    public List<Double> dadosGiro();
     


    //public DadosGiroscopioImpl getDadosGiroscopio();

    //public void setDadosGiroscopio(DadosGiroscopioImpl dadosGiroscopio);

    //public ExperimentoImpl getExperimento();

    //public void setExperimento(ExperimentoImpl experimento);

    //public void adicionarDados();


    //public double getVelocAngDisco();

    //public void setVelocAngPrecessaoCalc(double velocAngPrecessaoCalc);

    //public void setVelocAngPrecessaoMedida(double velocAngPrecessaoMedida);



    public void setCharOut(char charOut);

    //public void setComuniUSB(ComunicUSB comuniUSB);

    public void setDadoIn(String dadoIn);
    public void setStrIn(String strIn);
    //public void setVelocAngDisco(double velocAngDisco);



    public void extraiValorEnt();
    public  boolean executar();
    public void testeSend();

}
