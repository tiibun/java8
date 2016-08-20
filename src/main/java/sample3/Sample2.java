package sample3;

import java.util.Arrays;
import java.util.List;

public class Sample2 {

  public static void main(String[] args) {
    List<String> list 
      = Arrays.asList("Apple", "Microsoft", "Adobe", "Alphabet");

    String str = list.stream()
      .map(s -> s.substring(1, 2))
      .reduce("", (a, b) -> a.concat(b));

    System.out.println(str);
  }
}
