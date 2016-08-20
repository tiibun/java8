package sample1;

import java.util.Arrays;
import java.util.List;

public class Java7Sample {

  public static void main(String[] args) {
    List<String> list 
      = Arrays.asList("Apple", "Microsoft", "Adobe", "Alphabet");

    int total = 0;
    for (String s : list) {
      if (s.startsWith("A")) {
        total += s.length();
      }
    }
    System.out.println(total);
  }
}
