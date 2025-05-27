package com.application.film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageResponseDto {

  private final Long page;
  private final Long size;
}
