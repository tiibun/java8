package sample8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sample1 {

  List<Path> findSorted(Predicate<Path> matcher, Comparator<Path> comparator) {
    try {
      return Files.walk(Paths.get(".")).filter(matcher).sorted(comparator)
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    Sample1 sample1 = new Sample1();
    sample1.exec();
    sample1.exec2();
  }

  void exec() {
    // ①拡張子が"java"で名前順にソート
    List<Path> javaNameSorted =
        findSorted(p -> p.toString().endsWith(".java"), Comparator.comparing(Path::getFileName));
    System.out.println(javaNameSorted);
    // ②拡張子が"java"でサイズ順にソート
    List<Path> javaSizeSorted = findSorted(p -> p.toString().endsWith(".java"),
        Comparator.comparing(p -> p.toFile().length()));
    System.out.println(javaSizeSorted);
  }

  // ③findSortedを最初の引数だけ適用する関数を返す（カリー化）
  Function<Comparator<Path>, List<Path>> curriedFindSorted(Predicate<Path> matcher) {
    return comparator -> findSorted(matcher, comparator);
  }

  void exec2() {
    // ④③を使って拡張子javaのみのファイルを取得して、Comparatorを引数にListを返す関数を返す。
    Function<Comparator<Path>, List<Path>> javaSorted =
        curriedFindSorted(p -> p.toString().endsWith(".java"));
    // ⑤④を使って名前順にソート
    List<Path> javaNameSorted = javaSorted.apply(Comparator.comparing(Path::getFileName));
    System.out.println(javaNameSorted);
    // ⑥④を使ってサイズ順にソート
    List<Path> javaSizeSorted = javaSorted.apply(Comparator.comparing(p -> p.toFile().length()));
    System.out.println(javaSizeSorted);
  }
}
