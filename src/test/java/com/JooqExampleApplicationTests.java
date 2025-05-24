package com;

import java.util.List;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Actor;
import org.jooq.generated.tables.records.ActorRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JooqExampleApplicationTests {

  @Autowired private DSLContext dsl;

  @Test
  public void selectAllActors() {
    List<ActorRecord> actors = dsl.selectFrom(Actor.ACTOR).fetchInto(ActorRecord.class);
    for (ActorRecord actor : actors) {
      System.out.println(actor.getFirstName() + "-" + actor.getLastName());
    }
  }

  @Test
  public void insertActor() {
    int execute =
        dsl.insertInto(Actor.ACTOR)
            .columns(Actor.ACTOR.FIRST_NAME, Actor.ACTOR.LAST_NAME)
            .values("AHN", "HJ")
            .execute();

    System.out.println(execute);
  }
}
