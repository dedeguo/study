package top.chende.service;


import org.springframework.stereotype.Component;
import top.chende.api.ExternalFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("province/")
public class ExternalFacadeImpl implements ExternalFacade {

    /**
     * http://localhost:8080/v1/province/city/1
     * @param id
     * @return
     */
    @Path("city/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public String  hello(@PathParam("id") String id) {
        return "hello "+id;
    }
}