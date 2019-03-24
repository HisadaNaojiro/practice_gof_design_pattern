import java.util.Random;

public class RandomDisplay extends CountDisplay {
/* ↑こうする
  public class RandomDisplay extends Display {
*/

  // ↓追加
  private Random random = new Random();

  public RandomDisplay(DisplayImpl impl) {
    super(impl);
  }

  public void randomDisplay(int times) {
      multiDisplay(random.nextInt(times));
  }
  /* ↑こうする
    public final void randomDisplay(int times) {
      open();
      int randomTimes = (int)(Math.random() * times);
      for (int i = 0; i < randomTimes ; i++) {
        print();
      }
      close();
    }
  */
}


