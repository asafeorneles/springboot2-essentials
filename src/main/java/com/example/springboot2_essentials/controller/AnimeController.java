package com.example.springboot2_essentials.controller;

import com.example.springboot2_essentials.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "anime")
public class AnimeController {

    //    localhost:8080/anime/list
    //    @RequestMapping(method = RequestMethod.GET, path = "list") Antes se usava essa configuração, agora fica mais fácil com o @GetMapping...
    @GetMapping(path = "list")
    public List<Anime> list(){
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
    }

}
