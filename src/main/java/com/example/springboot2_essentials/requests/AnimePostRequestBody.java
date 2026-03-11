package com.example.springboot2_essentials.requests;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

/*
NotNull apenas proíbe valores null, NotEmpty exige que coleções/strings não sejam nulas nem vazias (""),
e NotBlank (ideal para texto) garante que a String não seja nula, nem vazia, nem composta apenas por espaços em branco.
*/

public record AnimePostRequestBody(
    //  @NotBlank
        @NotNull(message = "The Anime can not be null")
        @NotEmpty(message = "The Anime can not be empty")
        String name,
        @URL(message = "The URL is not valid")
        String url

) {
}
