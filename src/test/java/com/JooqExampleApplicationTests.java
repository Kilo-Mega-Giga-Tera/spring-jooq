package com;

import static org.jooq.generated.tables.JActor.*;

import org.jooq.DSLContext;
import org.jooq.generated.tables.records.ActorRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JooqExampleApplicationTests {

  @Autowired private DSLContext dsl;

  @Test
  public void selectAllActors() {
    dsl.selectFrom(ACTOR).fetchInto(ActorRecord.class);
  }

  @Test
  public void insertActor() {
    int execute =
        dsl.insertInto(ACTOR)
            .columns(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
            .values("JA", "VA")
            .execute();

    System.out.println(execute);
  }

  @Test
  public void selectTenActors() {
    dsl.selectFrom(ACTOR).limit(10).fetchInto(ActorRecord.class);
  }
}
