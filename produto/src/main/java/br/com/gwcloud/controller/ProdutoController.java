package br.com.gwcloud.controller;

import br.com.gwcloud.model.Produto;
import br.com.gwcloud.service.ProdutoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/produto")
public class ProdutoController {

    @Inject
    ProdutoService produtoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> hello() {
        return produtoService.buscarTodos();
    }

    @POST
    @Transactional
    public Response cadastrar(Produto produto) {
        produtoService.cadastrar(produto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto buscarPorId(@PathParam("id") Long id) {
        return produtoService.buscarPorId(id);
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deletar(@PathParam("id") Long id) {
        produtoService.deletarPorId(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Produto atualizar(@PathParam("id") Long id, Produto produto) {
        return produtoService.atualizar(id, produto);
    }
}