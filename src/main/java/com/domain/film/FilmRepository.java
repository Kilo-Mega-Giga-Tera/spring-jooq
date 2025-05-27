package com.domain.film;

import static org.jooq.generated.tables.JActor.ACTOR;
import static org.jooq.generated.tables.JFilm.*;
import static org.jooq.generated.tables.JFilmActor.FILM_ACTOR;

import java.util.List;

import com.application.film.dto.FilmDto;
import com.application.film.dto.FilmWithActorDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FilmRepository {

  private final DSLContext dsl;

  public Film findById(Long id) {
    return dsl.select(FILM.fields()).from(FILM).where(FILM.FILM_ID.eq(id)).fetchOneInto(Film.class);
  }

  public FilmDto findByIdDto(Long id) {
    return dsl.select(FILM.FILM_ID, FILM.TITLE, FILM.DESCRIPTION)
        .from(FILM)
        .where(FILM.FILM_ID.eq(id))
        .fetchOneInto(FilmDto.class);
  }

  public List<FilmWithActorDto> findFilmWithActor(Long page, Long size) {
    return dsl.select(
            DSL.row(FILM.fields()).as("FILM"),
            DSL.row(FILM_ACTOR.fields()).as("FILM_ACTOR"),
            DSL.row(ACTOR.fields()).as("ACTOR"))
        .from(FILM)
        .innerJoin(FILM_ACTOR)
        .on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
        .innerJoin(ACTOR)
        .on(FILM_ACTOR.ACTOR_ID.eq(ACTOR.ACTOR_ID))
        .offset((page - 1) * size)
        .limit(size)
        .fetchInto(FilmWithActorDto.class);
  }
}
