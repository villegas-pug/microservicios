package com.microservicios.test.controllers;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import com.microservicios.test.models.entities.Persona;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class TestController {

   public static void main(String[] args) {
      List<Persona> lstEntity = new ArrayList<Persona>();

      lstEntity.add(new Persona(1, "Cristopher", 30));
      lstEntity.add(new Persona(2, "Raul", 33));
      lstEntity.add(new Persona(3, "Roxana", 36));

      /* Stream<Integer> arrInt = Stream.of(1, 2, 3, 4, 1, 2, 1, 10); */

      IntStream entity = lstEntity.stream().mapToInt(per -> per.getAge());

      IntSummaryStatistics stats = entity.summaryStatistics();

      System.out.println(stats.getSum());
      System.out.println(stats.getMax());
      System.out.println(stats.getMin());
      System.out.println(stats.getAverage());
      System.out.println(stats.getCount());

      /*
       * boolean newArr = Stream.of(arr).peek(System.out::print).anyMatch(e -> e ==
       * 10);
       */
      /* int reduceInt = arrInt.reduce(0, Integer::sum); */

      /* entity.forEach(System.out::print); */
   }
}
