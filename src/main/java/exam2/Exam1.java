package exam2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Exam1 {

  public static void main(String[] args) {
    // TODO list縺ｮ蜷郁ｨ育せ繧貞�ｺ蜉帙＠縺ｦ縺上□縺輔＞
    List<BigDecimal> list = Arrays.asList(
        new BigDecimal("15.766"),
        new BigDecimal("14.900"),
        new BigDecimal("14.733"),
        new BigDecimal("15.566"),
        new BigDecimal("15.600"),
        new BigDecimal("15.800"));

    BigDecimal total = list.stream()
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println(total);
  }

}
