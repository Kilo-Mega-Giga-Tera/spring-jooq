package com.presentation;

import org.jooq.Configuration;
import org.jooq.generated.tables.daos.FilmDao;
import org.jooq.generated.tables.pojos.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImplementDao extends FilmDao {

  public FilmServiceImplementDao(Configuration configuration) {
    super(configuration);
  }

  @Override
  public Film findById(Long id) {
    return super.findById(id);
  }
}
