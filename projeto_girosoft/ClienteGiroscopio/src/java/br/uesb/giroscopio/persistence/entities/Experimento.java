/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.persistence.entities;

/**
 *
 * @author marcos
 */



import java.util.ArrayList;
import java.util.Collection;



public class Experimento {


   private Collection<DadosGiroscopio> listaDadosGiroscopio;

   public Experimento(){
    //this.listaDadosGiroscopio = new ArrayList<DadosGiroscopio>();
   }

         public Collection<DadosGiroscopio> getListaDadosGiroscopio() {
        return listaDadosGiroscopio;
    }

    public void setListaDadosGiroscopio(Collection<DadosGiroscopio> listaDadosGiroscopio) {
        this.listaDadosGiroscopio = listaDadosGiroscopio;
    }

}
