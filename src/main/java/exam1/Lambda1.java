package exam1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Lambda1 {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("Apple", "Microsoft", "Adobe", "Alphabet");

    int total = list.stream().filter(new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return s.startsWith("A");
      }
    }).mapToInt(new ToIntFunction<String>() {
      @Override
      public int applyAsInt(String value) {
        return value.length();
      }
    }).sum();
    System.out.println(total);

  }

}
