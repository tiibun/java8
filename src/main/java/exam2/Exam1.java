package exam2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Exam1 {

  public static void main(String[] args) {
    // TODO listの合計点を出力してください
    List<BigDecimal> list = Arrays.asList(
        new BigDecimal("15.766"),
        new BigDecimal("14.900"),
        new BigDecimal("14.733"),
        new BigDecimal("15.566"),
        new BigDecimal("15.600"),
        new BigDecimal("15.800"));

    // BigDecimal
    BigDecimal sum = list.stream()
        .reduce(new BigDecimal(0), BigDecimal::add);

    System.out.println("BigDecimal : " + sum);


    // double版
    double sumDouble = list.stream()
        .mapToDouble(BigDecimal::doubleValue)
        .sum();

    System.out.println("double : " + sumDouble);

  }

}
