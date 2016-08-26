package sample8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Sample1 {


  public static void main(String[] args) {
    Sample1 sample1 = new Sample1();
    sample1.exec();
  }

  // 3つの引数を加算する
  int sumsum(int x, int y, int z) {
	  return x + y + x;
  }
  
  public void exec() {
	// ①
	int A = sumsum(5, 10, 15);
	// ②
	int B = sumsum(5, 20, 30);
	
	// ③sumsumを最初の引数だけ適用する関数を返す（カリー化）
	Function<Integer, BiFunction<Integer, Integer, Integer>> sum
	  = x -> (y, z) -> sumsum(x, y, z);
	
	// ④③を使って一部の引数を適用する関数を返す。
	BiFunction<Integer, Integer, Integer> sum5 = sum.apply(5);
	
	// ⑤④を使って
	int C = sum5.apply(10, 15);
	
	// ⑥④を使って
	int D = sum5.apply(20, 30);
  }
}
