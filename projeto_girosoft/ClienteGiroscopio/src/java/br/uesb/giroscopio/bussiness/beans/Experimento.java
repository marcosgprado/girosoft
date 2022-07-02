/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.beans;

import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Administrador
 */
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
