package org.acme.controller;

import org.acme.domain.Anime;
import org.acme.service.AnimeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/anime")
public class AnimeController {

    @Inject
    AnimeService animeService;

    @GET
    @Produces(value = MediaType.TEXT_PLAIN)
    public String helloAnime() {
        return "Bem vindo a API de animes :)";
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path(value = "/{id}")
    public Anime findById(@PathParam("id") Long id) {
        return animeService.findById(id);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Transactional
    public Anime save(Anime anime) {
        return animeService.save(anime);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/{id}")
    @Transactional
    public Anime update(@PathParam("id") Long id, Anime anime){
        return animeService.update(id, anime);
    }

    @DELETE
    @Path(value = "/{id}")
    @Produces(value = MediaType.MEDIA_TYPE_WILDCARD)
    @Transactional
    public void delete(@PathParam(value = "id") Long id) {
        animeService.delete(id);
    }
}
