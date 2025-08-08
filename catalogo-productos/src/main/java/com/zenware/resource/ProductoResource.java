package com.zenware.resource;

import com.zenware.model.Producto;
import com.zenware.repository.ProductoRepo;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoResource {

    @Inject
    ProductoRepo repo;

    @GET
    public List<Producto> listar() {
        return repo.listar();
    }

    @POST
    public Response crear(@Valid Producto producto) {
        Producto creado = repo.guardar(producto);
        return Response.status(Response.Status.CREATED).entity(creado).build();
    }

    @GET
    @Path("/{id}")
    public Response obtener(@PathParam("id") Long id) {
        return repo.buscarPorId(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND)
                        .entity(Map.of("code", 404, "message", "No encontrado")))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        if (repo.eliminar(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Map.of("code", 404, "message", "No encontrado"))
                    .build();
        }
    }
}
