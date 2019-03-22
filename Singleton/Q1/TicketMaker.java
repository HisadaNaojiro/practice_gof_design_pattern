public class TicketMaker {
  private static TicketMaker singleton = new TicketMaker(); 
  private int ticket = 1000;

  private TicketMaker() {
    System.out.println("インスタンスを生成しました");
  }

  public synchronized int getNextTicketNumber() {                 
    return ticket++;
  }
  /* ↑こうする 
    public int getNextTicketNumber() {
      return ticket++;
    }
  */

  public static TicketMaker getInstance() {
    return singleton;
  }
}
