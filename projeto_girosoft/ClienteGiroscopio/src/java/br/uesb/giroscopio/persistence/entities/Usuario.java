/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.persistence.entities;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author marcos
 */

@Entity
@SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq")
@Table(name="usuario", uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String instituicao;
    private String nome;
    private String email;
    private String senha;
    private String login;
    private boolean administrador;


    public Usuario() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_id_seq")
    @Column(name = "id", nullable=false)
    public Integer getId() {
        return id;
    }

    @Column(name = "administrador", nullable = false)
    public boolean getAdministrador() {
        return administrador;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }


    @Column(name = "instituicao")
    public String getInstituicao() {
        return instituicao;
    }

    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha() {
        return senha;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }









}














