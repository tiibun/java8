package sample9;

import java.time.LocalDate;
import java.util.stream.Stream;

public class Sample1 {

  public static void main(String[] args) {
    Stream<LocalDate> dateStream = Stream.iterate(LocalDate.now(), d -> d.plusDays(1));
    // dateStream.forEach(System.out::println); // 永久ループ

    dateStream
        .filter(d -> d.isEqual(LocalDate.of(2020, 1, 1)) || d.isAfter(LocalDate.of(2020, 1, 1)))
        .filter(d -> d.isBefore(LocalDate.of(2021, 1, 1)))
        .forEach(System.out::println);
  }
}
