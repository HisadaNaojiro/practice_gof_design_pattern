import java.util.Random;

public class WinningsStrategy implements Strategy {
  private Random random;
  private boolean won = false;
  private Hand prevHand;

  public WinningsStrategy(int seed) {
    random = new Random(seed);
  }

  public Hand nextHand() {
    if (!won) {
      prevHand = Hand.getHand(random.nextInt(3));
    }
    return prevHand;
  }

  public void study(boolean win) {
    won = win;
  }
}
