/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.proyectojic.ejb;

import com.jose.proyectojic.entity.Medicamentos;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Luis
 */
@Stateless
public class MedicamentoFacade extends AbstractFacade<Medicamentos>{
    
    @Inject
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    public MedicamentoFacade()
    {
        super(Medicamentos.class);
    }
    public Medicamentos un_medicamento(String cadena)
    {
        Medicamentos cs= new Medicamentos();
        try
        {
            cs= (Medicamentos) em.createNativeQuery("SELECT * FROM medicamentos WHERE id= '"+cadena+"'",Medicamentos.class).getSingleResult();
        }catch(Exception e)
        {
            throw e;
        }
        return cs;
    }
}
