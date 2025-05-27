package com.application.film;

import com.application.film.dto.FilmWithActorResponseDto;
import com.presentation.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FilmController {

  private final FilmService filmService;

  @GetMapping("/filmWithActors")
  public FilmWithActorResponseDto filmWithActors(@RequestParam Long page, @RequestParam Long size) {
    return filmService.findFilmWithActor(page, size);
  }
}
