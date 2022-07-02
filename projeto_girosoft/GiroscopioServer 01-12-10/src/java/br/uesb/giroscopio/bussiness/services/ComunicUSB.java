/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.bussiness.services;

/**
 *
 * @author Administrador
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import org.springframework.stereotype.Service;

@Service("comunicUSB")
public class ComunicUSB implements SerialPortEventListener {


        SerialPort USBPort;

	private static final String PORT_NAME[] = {"/dev/ttyUSB0"};

        /* Fluxo de dados de entrada para a porta */
	private InputStream input;

        /** Fluxo de dados de saida para a porta */
	private OutputStream output;

        /** Intervalo de tempo em milisegundo de bloqueio da porta antes de abri-la */
	private static final int TIME_OUT = 2000;

        /** velocidade padrao de transmisao de dados */
	private static final int DATA_RATE = 9600;

        /*String de dados de entrada */
        private String strIn = null;

        /*String de dados de saida */
        private String strOut = null;

        /*Caracter de dados de saida */
        private char charOut;

public ComunicUSB(){
  // initialize();
}

/* gets e sets: */


    public char getCharOut() {
        return charOut;
    }
    public String getStrIn() {
        return strIn;
    }

    public String getStrOut() {
        return strOut;
    }


    public SerialPort getUSBPort() {
        return USBPort;
    }

    public InputStream getInput() {
        return input;
    }

    public OutputStream getOutput() {
        return output;
    }


    public void setCharOut(char charOut) {
        this.charOut = charOut;
    }

     public void setStrIn(String StrIn) {
        this.strIn = StrIn;
    }

    public void setStrOut(String StrOut) {
        this.strOut = StrOut;
    }

    public void setUSBPort(SerialPort USBPort) {
        this.USBPort = USBPort;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public void setOutput(OutputStream output) {
        this.output = output;
    }








        /* Funcao de inicializacao da comunicacao*/
	public void initialize() {

		CommPortIdentifier Idport = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();


		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAME) {
				if (currPortId.getName().equals(portName)) {
					Idport = currPortId;
					break;
				}
			}
		}

		if (Idport == null) {
			System.out.println("Could not find COM port.");//tratar erro
			return;
		}

		try {
			this.setUSBPort((SerialPort) Idport.open(this.getClass().getName(), TIME_OUT));

			// set port parameters
			this.getUSBPort().setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,	SerialPort.PARITY_NONE);

			// open the streams
			this.setInput(this.getUSBPort().getInputStream());
			this.setOutput(this.getUSBPort().getOutputStream());

			// add event listeners
			this.getUSBPort().addEventListener(this);
			this.getUSBPort().notifyOnDataAvailable(true);

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}


	public synchronized void close() {
		if (USBPort != null) {
			USBPort.removeEventListener();
			USBPort.close();
		}
	}


        //Envia a String "0" para confirmar conexao
        public void sincronizar(){

        try {
                int t = 0;
                this.setStrOut("0");
                while(t<6){
		enviaString();
                t++;
                }
         } catch (Exception e) {
            System.out.println("Houve um erro durante o sincronismo. ");//tratar erro
            System.out.println("STATUS: " + e );

         }
	}


        public void enviaString(){

        try {
             byte dataOut = Byte.valueOf(strOut);
	     this.getOutput().write(dataOut);
             Thread.sleep(100);
             this.getOutput().flush();
          } catch (Exception e) {
             System.out.println("Houve um erro durante o envio. ");//trtar erro
             System.out.println("STATUS: " + e );

          }
	}

	public void enviaChar(){

        try {
             System.out.println(charOut); // debug

	     this.getOutput().write(charOut);
             
             System.out.println(charOut); // debug

             Thread.sleep(100);
             this.getOutput().flush();
          } catch (Exception e) {
             System.out.println("Houve um erro durante o envio. char ");//trtar erro
             System.out.println("STATUS: " + e );

          }
	}



	public void executarExperimento(){

                this.setStrOut("x");
		enviaString();
	}

	/* Captura dados enviados provindos da porta USB */
	public synchronized void serialEvent(SerialPortEvent event) {

		if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {

				int size = input.available();
				byte data[] = new byte[size];
				input.read(data, 0, size);

                                setStrIn( new String(data));
                                //setStrIn(String.valueOf(data));
                                System.out.println(strIn);
                                //System.out.println(size);
                                //System.out.println(Integer.parseInt(strIn));

			} catch (Exception e) {

				System.err.println(e.toString());
			}
		}

	}



/*

public static void main(String[] args)  {
try{
		ComunicUSB usb = new ComunicUSB();

		System.out.println("Started");
                usb.setCharOut('t');
                usb.enviaChar();
                usb.enviaChar();
                usb.enviaChar();
                usb.enviaChar();

            System.out.println("Started0");
}catch (Exception e) {
				System.err.println(e.toString());}
	}
*/

}


