package sample6;

import java.util.stream.IntStream;

public class Sample1 {

  IntStream numbers = IntStream.of(100, 200, 300, 400, 500);
  
  public static void main(String[] args) {
    Sample1 sample1 = new Sample1();
    sample1.exec(100);
  }
  
  void exec(int x) {
    int y = 200;
    int z;
    int w = 300;
    
    IntStream stream = numbers.filter(i -> i > x)
      .filter(i -> i > y)
      //.filter(i -> i > z)   // zが初期化されていないためエラー
      //.filter(i -> i > w)   // wが実質finalでないためエラー
      ;
    z = 400;
    w = 500;    
    stream.forEach(System.out::println);  
  }
}
