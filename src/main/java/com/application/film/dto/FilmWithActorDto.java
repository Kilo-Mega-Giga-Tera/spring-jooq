package com.application.film.dto;

import lombok.Getter;
import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.generated.tables.pojos.FilmActor;

@Getter
@SuppressWarnings("unused")
public class FilmWithActorDto {

  private Film film;
  private Actor actor;
  private FilmActor filmActor;

  public String getFilmName() {
    return film.getDescription();
  }

  public String getActorFullName() {
    return actor.getFirstName() + " " + actor.getLastName();
  }
}
