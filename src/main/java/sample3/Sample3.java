package sample3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sample3 {

  public static void main(String[] args) {
    try {
      Files.list(Paths.get("."))
        .filter(Files::isDirectory)
        .flatMap(t -> {
          try {
            return Files.list(t);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        })
        .forEach(System.out::println);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
