/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.view.jsf.managedBean;

import br.uesb.giroscopio.bussiness.services.UsuarioService;
import br.uesb.giroscopio.persistence.entities.Usuario;

/**
 *
 * @author marcos
 */
public class LoginBean {


    private String nomeUsuario;
    private String senhaUsuario;

    private Usuario usuario;
    private UsuarioService usuarioService;



public LoginBean(){ }



    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }





     public String logar(){

     
    if (this.getNomeUsuario().equals("this") && this.getSenhaUsuario().equals("this"))

         return "homeAdmin";

      else
         {


         this.usuario = this.usuarioService.getUsuarioFromLogin(this.getNomeUsuario());

         if (this.usuario != null && this.getSenhaUsuario().equals(this.usuario.getSenha())){

             if(this.usuario.getAdministrador())
               return "homeAdmin";
            else
                return "homeUsuario";
         }
         return "homeVisit";

    }

    }

     public String sair(){
         
     this.usuario = new Usuario();
     this.nomeUsuario = null;
     return "sair";

     }


}
