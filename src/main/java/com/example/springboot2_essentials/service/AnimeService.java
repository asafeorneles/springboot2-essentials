package com.example.springboot2_essentials.service;

import com.example.springboot2_essentials.domain.Anime;
import com.example.springboot2_essentials.mapper.AnimeMapper;
import com.example.springboot2_essentials.repository.AnimeRepository;
import com.example.springboot2_essentials.requests.AnimePostRequestBody;
import com.example.springboot2_essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    private final AnimeMapper animeMapper;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequest(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found."));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(animeMapper.toAnime(animePostRequestBody));
    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }

    // Eu uso esta abordagem:
//    public void replace(AnimePutRequestBody animePutRequestBody) {
//        Anime byId = findByIdOrThrowBadRequest(animePutRequestBody.id());
//        byId.setName(animePutRequestBody.name());
//        animeRepository.save(byId);
//    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime byId = findByIdOrThrowBadRequest(animePutRequestBody.id());
        Anime anime = animeMapper.toAnime(animePutRequestBody);
        anime.setId(byId.getId());
        animeRepository.save(anime);
    }
}
