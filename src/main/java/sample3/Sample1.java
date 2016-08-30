package sample3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample1 {

  public static void main(String[] args) {
    List<String> list 
      = Arrays.asList("Apple", "Microsoft", "Adobe", "Alphabet");

    List<String> subList = list.stream()
      .filter(s -> s.startsWith("A"))
      .collect(Collectors.toList());

    // 配列への変換
    String[] subArray = list.stream()
      .filter(s -> s.startsWith("A"))
      .toArray(String[]::new);
    
    System.out.println(subList);
    System.out.println(Arrays.asList(subArray));
  }
}
