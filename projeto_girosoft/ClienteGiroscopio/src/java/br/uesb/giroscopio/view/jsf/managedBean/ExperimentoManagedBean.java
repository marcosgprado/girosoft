/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.view.jsf.managedBean;

import br.uesb.giroscopio.persistence.entities.DadosGiroscopio;
import br.uesb.giroscopio.persistence.entities.Experimento;
import br.uesb.giroscopio.bussiness.services.ExecutaExperimento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 *
 * @author marcos
 */
public class ExperimentoManagedBean implements Serializable{

    
    //private String velocAngDisco;
    //private String velocAngPrecessaoMedida;
    //private String velocAngPrecessaoCalc;

    private final static long serialVersionUID = 1L;
    private Experimento experimento;
    private DadosGiroscopio dadosGiroscopio;

    private ExecutaExperimento executaExperimento;

    private int numeroCaptura; // numero relativo a captura de dados de cada experimento




    public ExperimentoManagedBean(){
       this.experimento = new Experimento();
       this.numeroCaptura = 0;
    }




    public int getNumeroCaptura() {
        return numeroCaptura;
    }

    public void setNumeroCaptura(int numeroCaptura) {
        this.numeroCaptura = numeroCaptura;
    }


     public DadosGiroscopio getDadosGiroscopio(){
        return dadosGiroscopio;
    }

    public void setDadosGiroscopio(DadosGiroscopio dadosGiroscopio) {
        this.dadosGiroscopio = dadosGiroscopio;
    }


    public Experimento getExperimento() {
        return experimento;
    }

    public void setExperimento(Experimento experimento) {
        this.experimento = experimento;
    }

    public void setExecutaExperimento(ExecutaExperimento executaExperimento){

         this.executaExperimento = executaExperimento;
    }

    public ExecutaExperimento getExecutaExperimento() {
        return executaExperimento;
    }

  /*

    public String getVelocAngDisco() {
        return velocAngDisco;
    }

    public String getVelocAngPrecessaoCalc() {
        return velocAngPrecessaoCalc;
    }

    public String getVelocAngPrecessaoMedida() {
        return velocAngPrecessaoMedida;
    }

    
    public void setVelocAngDisco(String velocAngDisco) {
        this.velocAngDisco = velocAngDisco;
    }

    public void setVelocAngPrecessaoCalc(String velocAngPrecessaoCalc) {
        this.velocAngPrecessaoCalc = velocAngPrecessaoCalc;
    }

    public void setVelocAngPrecessaoMedida(String velocAngPrecessaoMedida) {
        this.velocAngPrecessaoMedida = velocAngPrecessaoMedida;
    }


   *
   *
   public void capturaVeloc(){

   this.setVelocAngDisco(this.executaExperimento.getDadoIn());
   System.out.println(this.getVelocAngDisco());

   }

    
    */
    
    public void executar(){
     if(this.executaExperimento.executar())
        this.novoDadoGiro();
     else {}

    }


   

    public void testeEnvio(){

    this.executaExperimento.testeSend();
    }


    public void novoDadoGiro(){ //captura dados gerados pelo experimento e armazena no objeto experimento

        this.numeroCaptura++;
        int nc = this.getNumeroCaptura();
        

        Iterator iterator = this.executaExperimento.dadosGiro().iterator();
        DadosGiroscopio dadosGiroscopioTemp = new DadosGiroscopio();
        Collection<DadosGiroscopio> listDadogiroTmp = new ArrayList<DadosGiroscopio>();

        dadosGiroscopioTemp.setNumeroCaptura(nc);

        int i = 0;
        while(iterator.hasNext())
        {
            Double dado = (Double)iterator.next(); //String dado = iterator.next().toString();
            
            
            switch(i)
            {
                case 0:
                    dadosGiroscopioTemp.setVelocAngDisco(dado);
                    i++;
                    break;
                case 1:
                    dadosGiroscopioTemp.setVelocAngPrecessaoMedida(dado);
                    i++;
                    break;
               /* case 2:
                    dadosGiroscopioTemp.setNumeroCaptura(nc);
                    i++;
                    break;*/
            }

            
        }

       // /*
        if(this.experimento.getListaDadosGiroscopio() != null){

            listDadogiroTmp = this.experimento.getListaDadosGiroscopio();
            listDadogiroTmp.add(dadosGiroscopioTemp);
            this.experimento.setListaDadosGiroscopio(listDadogiroTmp);

            }

            else{
            listDadogiroTmp.add(dadosGiroscopioTemp);
            this.experimento.setListaDadosGiroscopio(listDadogiroTmp);
            }


//*/
           //          System.out.println(this.experimento.getListaDadosGiroscopio().size());
   //         this.experimento.getListaDadosGiroscopio().add(dadosGiroscopioTemp);
    }


    public void sair(){

         this.experimento = new Experimento();
          
    }



}
