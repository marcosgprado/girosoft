package br.uesb.giroscopio.bussiness.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import javax.annotation.Resource;

import br.uesb.giroscopio.bussiness.beans.DadosGiroscopioImpl;
import br.uesb.giroscopio.bussiness.beans.ExperimentoImpl;

import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author marcos
 */

@Service("executaExperimentoImpl")
public class ExecutaExperimentoImpl implements ExecutaExperimento, Serializable{

    @Resource(name="comunicUSB")
    private ComunicUSB comuniUSB;

    @Resource(name="experimentoImpl")
    private ExperimentoImpl experimentoImpl;

    @Resource(name="dadosGiroscopioImpl")
    private DadosGiroscopioImpl dadosGiroscopioImpl;


    private String dadoIn;
    private String strIn;
    private char charOut;


  public ExecutaExperimentoImpl(){

  this.comuniUSB = new ComunicUSB();

  }

    public DadosGiroscopioImpl getDadosGiroscopioImpl() {
        return dadosGiroscopioImpl;
    }

    public void setDadosGiroscopioImpl(DadosGiroscopioImpl dadosGiroscopioImpl) {
        this.dadosGiroscopioImpl = dadosGiroscopioImpl;
    }




    public ExperimentoImpl getExperimentoImpl() {
        return experimentoImpl;
    }

    public void setExperimentoImpl(ExperimentoImpl experimentoImpl) {
        this.experimentoImpl = experimentoImpl;
    }


   
   


    public char getCharOut() {
        return charOut;
    }

    public ComunicUSB getComuniUSB() {
        return comuniUSB;
    }

    public String getDadoIn() {
        return dadoIn;
    }

    public String getStrIn() {
        return strIn;
    }

    



    public void setCharOut(char charOut) {
        this.charOut = charOut;
    }

    public void setComuniUSB(ComunicUSB comuniUSB) {
        this.comuniUSB = comuniUSB;
    }

    public void setDadoIn(String dadoIn) {
        this.dadoIn = dadoIn;
    }

    public void setStrIn(String strIn) {
        this.strIn = strIn;
    }

   





    public void executar() {


    try {
    this.comuniUSB.initialize();

    this.comuniUSB.setCharOut('E');
    this.comuniUSB.enviaChar();

    Thread.sleep(5000);

    extraiValorEnt();

    Thread.sleep(5000);

    extraiValorEnt();

    Thread.sleep(5000);

    extraiValorEnt();



    } catch (InterruptedException ex) {
            Logger.getLogger(ExecutaExperimentoImpl.class.getName()).log(Level.SEVERE, null, ex);
      }

    }


    public void extraiValorEnt(){

        String str = this.comuniUSB.getStrIn();

        if (str.charAt(0) == '@'){

            double t = Double.parseDouble(str.substring(1, str.length()));



            //calcular velocidade ##########################################################

            this.dadosGiroscopioImpl.setVelocAngDisco(t);
        }

        if (str.charAt(0) == '#'){

            double t = Double.parseDouble(str.substring(1, str.length()));

            //calcular velocidade ########################################################333

            this.dadosGiroscopioImpl.setVelocAngPrecessaoMedida(t);
            
        }
       else{
           //teste de transmissão de dodos
              double t = Double.parseDouble(str);
              this.dadosGiroscopioImpl.setVelocAngPrecessaoMedida(t);
              this.dadosGiroscopioImpl.setVelocAngDisco(t);
              this.dadosGiroscopioImpl.setVelocAngPrecessaoCalc(t);

        }//fim do else

    }

    public void adicionarDados(){ //adciona os dados do giroscopio na lista de dados do objeto experimento

      Collection<DadosGiroscopioImpl> dbGiro = new ArrayList<DadosGiroscopioImpl>();
         if(this.experimentoImpl.getListaDadosGiroscopio() != null){
            dbGiro = this.experimentoImpl.getListaDadosGiroscopio();
            dbGiro.add(this.dadosGiroscopioImpl);
            this.experimentoImpl.setListaDadosGiroscopio(dbGiro);
            this.dadosGiroscopioImpl = new DadosGiroscopioImpl();

         }else{
             dbGiro.add(this.dadosGiroscopioImpl);
             this.experimentoImpl.setListaDadosGiroscopio(dbGiro);
             this.dadosGiroscopioImpl = new DadosGiroscopioImpl();
          }

    }

public void testeSend(){

       //this.comuniUSB.initialize();
       this.comuniUSB.setCharOut('T');
       this.comuniUSB.enviaChar();

}
/*

public static void main (String args[]){
    try {



ExecutaExperimentoImpl exe = new ExecutaExperimentoImpl();


//exe.comuniUSB.initialize();
exe.comuniUSB.sincronizar();



exe.testeSend();

Thread.sleep(100);

exe.setDadoIn(exe.comuniUSB.getStrIn());

System.out.println(exe.comuniUSB.getStrIn());

exe.comuniUSB.close();

} catch (Exception e) {
				System.err.println(e.toString());
    }
}*/
}
