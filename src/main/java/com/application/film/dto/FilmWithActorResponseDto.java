package com.application.film.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilmWithActorResponseDto {

  private final PageResponseDto pageInfo;
  private final List<FilmWithActor> data;

  @Getter
  public static class FilmWithActor {
    private final String filmName;
    private final String actorFullName;

    public FilmWithActor(FilmWithActorDto filmWithActorDto) {
      this.filmName = filmWithActorDto.getFilmName();
      this.actorFullName = filmWithActorDto.getActorFullName();
    }
  }
}
