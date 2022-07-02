/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.beans;

import java.util.Collection;
/**
 *
 * @author Administrador
 */
public interface Experimento {




    public void setListaDadosGiroscopio(Collection<DadosGiroscopioImpl> listaDadosGiroscopio);

    public Collection<DadosGiroscopioImpl> getListaDadosGiroscopio();

}
