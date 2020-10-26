/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.proyectojic.resources;

import com.jose.proyectojic.ejb.HospitalFacade;
import com.jose.proyectojic.entity.Hospital;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose Luis
 */
@Path("hospital")
public class OperacionesHospital {
    @Inject
    HospitalFacade hospitalFacade;
    
    //obtener hospitales todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenerhospital")
    public List<Hospital> buscarhospital(@PathParam(value="id") String id)
    {   
       List<Hospital> cp=hospitalFacade.findAll();
       return cp;
    }
}
