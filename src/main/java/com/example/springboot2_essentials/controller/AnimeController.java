package com.example.springboot2_essentials.controller;

import com.example.springboot2_essentials.domain.Anime;
import com.example.springboot2_essentials.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DataUtil dataUtil;

    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dataUtil.formatterDateTimeDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Hunter x Hunter"), new Anime("Berserk"));
    }

}

