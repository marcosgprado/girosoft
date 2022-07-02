/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uesb.giroscopio.bussiness.services;

import br.uesb.giroscopio.persistence.entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
@Service(value = "usuarioService")
public class UsuarioService implements Serializable {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public UsuarioService() {
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional(readOnly = true)
    public Usuario getUsuarioFromLogin(String login) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Usuario.class);
        detachedCriteria.add(Restrictions.eq("login", login));
        Usuario usuario = null;
        List<Usuario> result = this.hibernateTemplate.findByCriteria(detachedCriteria);
        if (result.size() > 0) {
            usuario = result.get(0);
        }
        return usuario;
    }

    @Transactional
    public void save(Usuario usuario) {
        this.hibernateTemplate.save(usuario);
    }
}
