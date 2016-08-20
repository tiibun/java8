package sample1;

import java.util.Arrays;
import java.util.List;

public class Java8Sample {

  public static void main(String[] args) {
    List<String> list 
      = Arrays.asList("Apple", "Microsoft", "Adobe", "Alphabet");

    int total = list.stream()
      .filter(s -> s.startsWith("A"))
      .mapToInt(String::length)
      .sum();
    System.out.println(total);
  }
}
