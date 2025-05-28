package com.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmServiceWithDaoTest {

  @Autowired FilmServiceWithDao filmService;

  @Test
  void findByIdTest() {
    filmService.findById(20L);
  }

  @Test
  void filmLength() {
    filmService.filmLength((short) 10, (short) 80);
  }
}
