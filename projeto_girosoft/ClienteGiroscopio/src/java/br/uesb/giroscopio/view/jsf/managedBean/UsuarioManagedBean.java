/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uesb.giroscopio.view.jsf.managedBean;

/**
 *
 * @author marcos
 */
import br.uesb.giroscopio.bussiness.services.UsuarioService;
import br.uesb.giroscopio.persistence.entities.Usuario;

public class UsuarioManagedBean {

    private UsuarioService usuarioService;
    private Usuario usuario;

    public UsuarioManagedBean() {
        usuario = new Usuario();
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {
        //tesar se usuario exixte
        this.usuarioService.save(this.usuario);
        return "usuarioSalvo";



        
//        System.out.println(this.usuario.getNome());
//        System.out.println("s1");//debug
//        Session session = HibernateSessionFactory.getInstancia();
//        Transaction tx = null;
//        System.out.println("s2");
//        try {
//            System.out.println("s3");
//            tx = session.beginTransaction();
//            session.save(this.usuario);
//            tx.commit();
//            System.out.println("s4");
//            return "usuarioSalvo";
//
//        } catch (HibernateException he) {
//            System.out.println("s5");
//            he.printStackTrace();
//            tx.rollback();
//            return null;
//        } finally {
//            session.close();
//            novoUsuario();
//        }
//
    }

    public void novoUsuario() {
        usuario = new Usuario();
    }

    /*
    public static void main (String []args){
    Usuario u = new Usuario();
    u.setAdministrador(false);
    u.setEmail("aaa");
    u.setInstituicao("UESB");
    u.setLogin("aa");
    u.setNome("luiz");
    u.setSenha("zzz");

    UsuarioManagedBean um = new UsuarioManagedBean();
    um.setUsuario(u);
    um.salvar();
    }
     */
}
