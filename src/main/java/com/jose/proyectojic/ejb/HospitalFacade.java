/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.proyectojic.ejb;

import com.jose.proyectojic.entity.Hospital;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Luis
 */
@Stateless
public class HospitalFacade extends AbstractFacade<Hospital>{
    
    @Inject
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    public HospitalFacade()
    {
        super(Hospital.class);
    }
}
