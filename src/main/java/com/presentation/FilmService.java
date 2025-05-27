package com.presentation;

import com.application.film.dto.FilmWithActorDto;
import com.application.film.dto.FilmWithActorResponseDto;
import com.application.film.dto.FilmWithActorResponseDto.FilmWithActor;
import com.application.film.dto.PageResponseDto;
import com.domain.film.FilmRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

  private final FilmRepository filmRepository;

  public FilmWithActorResponseDto findFilmWithActor(Long page, Long size) {
    List<FilmWithActorDto> filmWithActor = filmRepository.findFilmWithActor(page, size);
    return new FilmWithActorResponseDto(
        new PageResponseDto(page, size), filmWithActor.stream().map(FilmWithActor::new).toList());
  }
}
