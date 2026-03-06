package com.example.springboot2_essentials.mapper;

import com.example.springboot2_essentials.domain.Anime;
import com.example.springboot2_essentials.requests.AnimePostRequestBody;
import com.example.springboot2_essentials.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimeMapper {
    Anime toAnime(AnimePostRequestBody animePostRequestBody);
    Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
