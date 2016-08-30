package exam2;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exam2 {
  enum Medal {
    GOLD, SILVER, BRONZE, NOTHING
  }

  static class Person {
    final int age;
    final String name;
    final Medal medal;

    Person(String name, int age, Medal medal) {
      this.name = name;
      this.age = age;
      this.medal = medal;
    }

    int getAge() {
      return age;
    }

    String getName() {
      return name;
    }

    Medal getMedal() {
      return medal;
    }

    public static Person nobody() {
      return new Person("", 0, Medal.NOTHING);
    }
  }

  public static void main(String[] args) {
    List<Person> list = Arrays.asList(new Person("ハギノ コウスケ", 21, Medal.GOLD), new Person("カネトウ リエ", 27, Medal.GOLD),
        new Person("ウチムラ コウヘイ", 27, Medal.GOLD), new Person("カトウ リョウヘイ", 22, Medal.GOLD),
        new Person("ヤマムロ コウジ", 27, Medal.GOLD), new Person("タナカ ユウスケ", 26, Medal.GOLD),
        new Person("シライ ケンゾウ", 19, Medal.GOLD), new Person("トウサカ エリ", 22, Medal.GOLD),
        new Person("イチョウ カオリ", 32, Medal.GOLD), new Person("カワイ リサコ", 21, Medal.GOLD),
        new Person("ドショウ サラ", 21, Medal.GOLD), new Person("オオノ ショウヘイ", 24, Medal.GOLD),
        new Person("ベイカー マシュウ", 21, Medal.GOLD), new Person("タチモト ハルカ", 26, Medal.GOLD),
        new Person("タカハシ アヤカ", 26, Medal.GOLD), new Person("マツトモ ミサキ", 24, Medal.GOLD),
        new Person("ヤマガタ リョウタ", 24, Medal.SILVER), new Person("イイヅカ ショウタ", 25, Medal.SILVER),
        new Person("キリュウ ヨシヒデ", 20, Medal.SILVER), new Person("ケンブリッジ アスカ", 23, Medal.SILVER),
        new Person("サカイ マサト", 21, Medal.SILVER), new Person("ヒグチ レイ", 20, Medal.SILVER),
        new Person("オオタ シノブ", 22, Medal.SILVER), new Person("ヨシダ サオリ", 33, Medal.SILVER),
        new Person("ミズタニ ジュン", 27, Medal.SILVER), new Person("ニワ コウキ", 21, Medal.SILVER),
        new Person("ヨシムラ マハル", 23, Medal.SILVER), new Person("ハラサワ ヒサヨシ", 24, Medal.SILVER),
        new Person("アライ ヒロオキ", 28, Medal.BRONZE), new Person("セト ダイヤ", 22, Medal.BRONZE),
        new Person("エハラ ナイト", 23, Medal.BRONZE), new Person("コボリ ユウキ", 22, Medal.BRONZE),
        new Person("マツダ タケシ", 32, Medal.BRONZE), new Person("ホシ ナツミ", 25, Medal.BRONZE),
        new Person("イヌイ ユキコ", 25, Medal.BRONZE), new Person("ミツイ リサコ", 22, Medal.BRONZE),
        new Person("ヨシダ クルミ", 24, Medal.BRONZE), new Person("ハコヤマ アイカ", 25, Medal.BRONZE),
        new Person("ナカムラ マイ", 27, Medal.BRONZE), new Person("マルモ ケイ", 24, Medal.BRONZE),
        new Person("ナカマキ カナミ", 24, Medal.BRONZE), new Person("オマタ カノ", 20, Medal.BRONZE),
        new Person("ハヤシ アイコ", 22, Medal.BRONZE), new Person("ニシコリ ケイ", 26, Medal.BRONZE),
        new Person("ミヤケ ヒロミ", 30, Medal.BRONZE), new Person("フクハラ アイ", 27, Medal.BRONZE),
        new Person("イシカワ カスミ", 23, Medal.BRONZE), new Person("イトウ ミマ", 15, Medal.BRONZE),
        new Person("タカトウ ナオヒサ", 23, Medal.BRONZE), new Person("エビヌマ マサシ", 26, Medal.BRONZE),
        new Person("ナガセ タカノリ", 22, Medal.BRONZE), new Person("ハガ リュウノスケ", 25, Medal.BRONZE),
        new Person("コンドウ アミ", 21, Medal.BRONZE), new Person("ナカムラ ミサト", 27, Medal.BRONZE),
        new Person("マツモト カオリ", 28, Medal.BRONZE), new Person("ヤマベ カナエ", 25, Medal.BRONZE),
        new Person("オクハラ ノゾミ", 21, Medal.BRONZE), new Person("ハネダ タクヤ", 29, Medal.BRONZE));

    // 1.メダル別の平均年齢を求めてください
    // TODO 1.メダル別の平均年齢を求めてください
    Map<Medal, Double> averageAge = list.stream()
      .collect(groupingBy(Person::getMedal, averagingInt(Person::getAge)));
    System.out.println(averageAge);

    // 2.メダル別の最高年齢の名前を出力してください
    // 一人出力バージョン
    Map<Medal, Optional<Person>> maxAge = list.stream()
        .collect(groupingBy(Person::getMedal, maxBy(comparingInt(Person::getAge))));
    maxAge.forEach((m, op) -> System.out.println(m + "=" + op.map(Person::getName).orElse("")));

    // 複数人いた場合の出力バージョン
    Map<Medal, Integer> maxAgeEachMedal = list.stream()
        .collect(groupingBy(Person::getMedal, mapping(Person::getAge, reducing(0, BinaryOperator.maxBy(Integer::compare)))));

    // メダル名を文字列の前に追加する関数
    Function<Medal, Function<String, String>> toStringBeforeMedalName = medal -> appended -> medal.name() + " : " + appended;

    // 最高齢の人の名前を出力する関数
    Function<Medal, String> toStringMaxAgeMedalist = medal -> toStringBeforeMedalName
        .apply(medal).apply(maxAgeMedalistEachMedal.getOrDefault(medal, Optional.empty()).orElse(Person.nobody()).getName());

    // メダリスト抽出関数
    Function<Map<Medal, Integer>, Function<Medal, Function<List<Person>, String>>> extractMaxAgeMedalistName = medalAgeMap -> medal -> persons -> persons.stream()
        .filter(has(medal).and(isSameAge(maxAgeEachMedal.getOrDefault(medal, 0))))
        .map(Person::getName)
        .collect(joining(","));

    Function<Medal, String> toStringMaxAgeMedalists = medal -> extractMaxAgeMedalistName.apply(maxAgeEachMedal).apply(medal)
        .andThen(toStringBeforeMedalName.apply(medal))
        .apply(list);

    Arrays.stream(Medal.values()).map(toStringMaxAgeMedalists).forEach(System.out::println);

  }

  private static Predicate<Person> has(Medal medal) {
    return e -> e.getMedal().equals(medal);
  }

  private static Predicate<Person> isSameAge(int age) {
    return e -> Objects.equals(e.getAge(), age);
  }

}
