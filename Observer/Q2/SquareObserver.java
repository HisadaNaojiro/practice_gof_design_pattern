public class SquareObserver implements Observer {

  public void update(NumberGenerator generator) {
    System.out.println("SquareObserver: " + (generator.getNumber() * generator.getNumber()));
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
    }
  }

}
