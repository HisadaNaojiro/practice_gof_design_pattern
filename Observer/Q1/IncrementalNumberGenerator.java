public class IncrementalNumberGenerator extends NumberGenerator {
  // ↓ 不要
  //private int start;
  private int number;
  private int end;
  private int increment;

  /* ↓ 修正
    public IncrementalNumberGenerator(int start, int end, int increment) {
    this.start = start;
  */
  public IncrementalNumberGenerator(int number, int end, int increment) {
    this.number = number;
    this.end = end;
    this.increment = increment;
  }

  public int getNumber() {
    return number;
  }

  public void execute() {
    while (number < end) {
        notifyObservers();
        number += increment;
    }
  }
  /*  ↑ こうする
    public void execute() {
      for (int i = start; i < end; i += increment){
        number = i;
        notifyObservers();
      }
    }
  */
}
