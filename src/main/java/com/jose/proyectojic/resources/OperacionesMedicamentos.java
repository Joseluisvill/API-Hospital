/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.proyectojic.resources;


import com.jose.proyectojic.ejb.MedicamentoFacade;
import com.jose.proyectojic.entity.Medicamentos;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose Luis
 */
@Path("medicamentos")
public class OperacionesMedicamentos {
    
    @Inject
    MedicamentoFacade medicamentoFacade;
    
    
    //crear medicamento
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crearmedicamento")
    public Response crearcomputadora(Medicamentos medicamento)
    {
        medicamentoFacade.create(medicamento);
        return Response
                .ok()
                .build();
    }
    //obtener medicamentos todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenermedicamentos")
    public List<Medicamentos> buscarmedicamentos()
    {   
       List<Medicamentos> cp=medicamentoFacade.findAll();
       return cp;
    }
    //obtener un solo medicamento
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenermedicamento/{id}")
    public Medicamentos buscarmedicamento(@PathParam(value="id") String id)
    {   
       Medicamentos cp=medicamentoFacade.un_medicamento(id);
       return cp;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actualizarmedicamento")
    public Medicamentos actualizarmedicamento(@PathParam(value="id") String id)
    {   
       Medicamentos cp=medicamentoFacade.find(id);
       return cp;
    }
}

