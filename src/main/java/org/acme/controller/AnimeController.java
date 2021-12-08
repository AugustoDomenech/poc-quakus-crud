package org.acme.controller;

import org.acme.domain.Anime;
import org.acme.service.AnimeService;
import org.jboss.logging.annotations.Pos;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
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

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Anime save(Anime anime) {
        return animeService.save(anime);
    }

}
