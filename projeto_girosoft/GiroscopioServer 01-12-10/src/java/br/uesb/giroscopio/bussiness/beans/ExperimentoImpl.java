/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.beans;

import org.springframework.stereotype.Service;
import java.util.Collection;
/**
 *
 * @author Administrador
 */
@Service("experimentoImpl")
public class ExperimentoImpl implements Experimento {


    private Collection <DadosGiroscopioImpl> listaDadosGiroscopio;



    public void setListaDadosGiroscopio(Collection<DadosGiroscopioImpl> listaDadosGiroscopio) {
        this.listaDadosGiroscopio = listaDadosGiroscopio;
    }

    public Collection<DadosGiroscopioImpl> getListaDadosGiroscopio() {
        return this.listaDadosGiroscopio;
    }


}
