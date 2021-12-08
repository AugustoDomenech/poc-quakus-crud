package org.acme.service;

import org.acme.domain.Anime;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class AnimeService {

    public Anime findById(Long id) {
        return (Anime) Anime.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Anime not found."));
    }

    public Anime save(Anime anime) {
        anime.persist();
        return anime;
    }

    public Anime update(Long id, Anime anime) {
        Anime animeSaved = this.findById(id);

        animeSaved.name = anime.name;
        return animeSaved;
    }

    public void delete(Long id) {
        Anime animeById = this.findById(id);

        boolean deletedAnime = Anime.deleteById(animeById.id);

        if (!deletedAnime)
            throw new InternalServerErrorException("An internal error occurred while deleting the anime");

    }

}