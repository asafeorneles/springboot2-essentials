package com.example.springboot2_essentials.client;

import com.example.springboot2_essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        // GET

        //Retorna um ResponseEntity
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/1", Anime.class);
        log.info(entity);

        //Retorna um Object
        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/1", Anime.class);
        log.info(object);

        // É possível trabalhar com Arrays, porém, não é muito performático nem atual.
        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        log.info(Arrays.toString(animes));

        //@formatter:off
        ResponseEntity <List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        // @formatter:on
        log.info(exchange.getBody());

        // POST

//        Anime kingdom = Anime.builder().name("Kingdom").build();
//        Anime kingdomCreated = new RestTemplate().postForObject("http://localhost:8080/animes", kingdom, Anime.class);
//        log.info("Anime Created {}", kingdomCreated);

//        Anime samuraiChamploo = Anime.builder().name("Samurai Champloo").build();
//        ResponseEntity<Anime> samuraiChamplooCreated = new RestTemplate().postForEntity("http://localhost:8080/animes", samuraiChamploo, Anime.class);
//        log.info("Anime Created {}", samuraiChamplooCreated);

        Anime sakamotoDays = Anime.builder().name("Sakamoto Days").build();
        ResponseEntity<Anime> sakamotoDaysCreated = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.POST,
                new HttpEntity<>(sakamotoDays, createHttpHeader()),
                Anime.class);
        log.info("Anime Created {}", sakamotoDaysCreated);

        // PUT

        Anime animeToBeUpdate = sakamotoDaysCreated.getBody();
        animeToBeUpdate.setName("Sakamoto Days Updated");

        ResponseEntity<Void> sakamotoDaysUpdated = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdate, createHttpHeader()),
                Void.class);
        log.info("Anime Updated {}", sakamotoDaysUpdated);

        // DELETE

        ResponseEntity<Void> SakamotoDaysDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                animeToBeUpdate.getId());
        log.info(SakamotoDaysDeleted);

    }

    public static HttpHeaders createHttpHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // Caso precise de autenticação, posso passar o token via setBearerAuth():
        // httpHeaders.setBearerAuth();
        return httpHeaders;
    }
}
