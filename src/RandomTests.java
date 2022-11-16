import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTests {
  static HashMap<Integer, String> map = new HashMap<Integer, String>();

  private static String generateRandomCorrectString() {
    return "" + ThreadLocalRandom.current().nextInt(1, 11) + " "
            + map.get(ThreadLocalRandom.current().nextInt(0, 4)) + " " + ThreadLocalRandom.current().nextInt(1, 11)
            + " " + map.get(ThreadLocalRandom.current().nextInt(0, 4)) + " "
            + ThreadLocalRandom.current().nextInt(1, 11);
  }

  public static void main(String[] args) {
    map.put(0, "+");
    map.put(1, "-");
    map.put(2, "*");
    map.put(3, "/");

    for (int i = 0; i < 10; i++) {
      String s = generateRandomCorrectString();
      System.out.println("Test " + (i + 1) + ": " + s);
      Calculator obj = new Calculator(s);
      obj.calculate();
      System.out.println("\n--------------------------------\n");
    }
  }
}
