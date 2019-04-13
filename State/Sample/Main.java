import java.util.Properties;

public class Main {
  public static void main(String[] args) {
    Properties prop = System.getProperties ();
    prop.put ("java.awt.headless", "true");
    SafeFrame frame = new SafeFrame("State Simple");
    while (true) {
      for (int hour = 0; hour < 24; hour++) {
        frame.setClock(hour); //時刻の設定
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
      }
    }
  }
}
