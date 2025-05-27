package com.domain.film;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.application.film.dto.FilmDto;
import com.application.film.dto.FilmWithActorDto;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.jooq.generated.tables.pojos.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmRepositoryTest {

  @Autowired private FilmRepository filmRepository;

  @Test
  public void findById() {
    Film foundFilm = filmRepository.findById(1L);
    assertNotNull(foundFilm);
  }

  @Test
  public void findByIdDto() {
    FilmDto foundFilm = filmRepository.findByIdDto(1L);
    assertThat(foundFilm).hasNoNullFieldsOrProperties();
  }

  @Test
  public void findFilmWithActor() {
    List<FilmWithActorDto> filmWithActorPageOne = filmRepository.findFilmWithActor(1L, 5L);
    List<FilmWithActorDto> filmWithActorPageTwo = filmRepository.findFilmWithActor(2L, 5L);

    Assertions.assertThat(filmWithActorPageOne).hasSize(5);
    Assertions.assertThat(filmWithActorPageTwo).hasSize(5);
  }
}
