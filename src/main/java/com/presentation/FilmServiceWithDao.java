package com.presentation;

import java.util.List;
import org.jooq.Configuration;
import org.jooq.generated.tables.daos.FilmDao;
import org.jooq.generated.tables.pojos.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceWithDao {

  private final FilmDao filmDao;

  public FilmServiceWithDao(Configuration configuration) {
    this.filmDao = new FilmDao(configuration);
  }

  public Film findById(Long id) {
    return filmDao.findById(id);
  }

  public List<Film> filmLength(Short from, Short to) {
    return filmDao.fetchRangeOfLength(from, to);
  }
}
