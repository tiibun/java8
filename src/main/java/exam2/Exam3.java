package exam2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exam3 {
  
  public static void main(String[] args) {
    // TODO src/main/resources/exam3.txtの内容のタブ区切りの国名の数を求めてください
    try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/exam3.txt"))) {
      long count = lines.flatMap(line -> Stream.of(line.split("\t")))
          //.peek(System.out::println) // 国名出力
          .count();
      System.out.println(count);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
