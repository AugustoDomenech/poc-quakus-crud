package org.acme.service;

import org.acme.domain.Anime;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class AnimeService {

    @Transactional
    public Anime save(Anime anime) {
        anime.persist();
        return anime;
    }

}