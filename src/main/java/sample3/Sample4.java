package sample3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Sample4 {

  public static void main(String[] args) {
    List<String> list 
      = Arrays.asList("Apple", "Microsoft", "Adobe", "Alphabet");

    Optional<String> str = list.parallelStream()
      .filter(s -> s.startsWith("A"))
      .findAny();

    System.out.println(str.orElse("Nothing."));
  }
}
