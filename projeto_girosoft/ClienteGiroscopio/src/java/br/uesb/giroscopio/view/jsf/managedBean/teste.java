/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.view.jsf.managedBean;

import br.uesb.giroscopio.persistence.entities.*;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author marcos
 */
public class teste {

    public static void main(String args[]){
    ExperimentoManagedBean ex = new ExperimentoManagedBean();

    Experimento exp = new Experimento();
    DadosGiroscopio d = new DadosGiroscopio();
    DadosGiroscopio e = new DadosGiroscopio();

    d.setNumeroCaptura(1);
    d.setVelocAngDisco(400);
    d.setVelocAngPrecessaoMedida(2);

    e.setNumeroCaptura(2);
    e.setVelocAngDisco(500);
    e.setVelocAngPrecessaoMedida(1.7);
    Collection<DadosGiroscopio> listDadogiroTmp = new ArrayList<DadosGiroscopio>();

    if(exp.getListaDadosGiroscopio() != null){

            listDadogiroTmp = exp.getListaDadosGiroscopio();
            listDadogiroTmp.add(e);
            exp.setListaDadosGiroscopio(listDadogiroTmp);

            }

            else{
            listDadogiroTmp.add(d);
            exp.setListaDadosGiroscopio(listDadogiroTmp);
            }
ex.setExperimento(exp);
}

}
