package com.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmServiceImplementDaoTest {

  @Autowired
  FilmServiceImplementDao filmService;

  @Test
  void findByIdTest() {
    filmService.findById(20L);
  }
}
