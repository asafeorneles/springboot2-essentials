package com.example.springboot2_essentials.controller;

import com.example.springboot2_essentials.domain.Anime;
import com.example.springboot2_essentials.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "anime")
@RequiredArgsConstructor
public class AnimeController {

    private final DataUtil dataUtil;

    //    localhost:8080/anime/list
    //    @RequestMapping(method = RequestMethod.GET, path = "list") Antes se usava essa configuração, agora fica mais fácil com o @GetMapping...
    @GetMapping(path = "list")
    public List<Anime> list(){
        log.info(dataUtil.formatterDateTimeDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Hunter x Hunter"), new Anime("Berserk"));
    }

    @GetMapping(path = "list2")
    public List<Anime> list2(){
        log.info(dataUtil.formatterDateTimeDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Hunter x Hunter"), new Anime("Berserk"), new Anime("One Piece"));
    }

}
