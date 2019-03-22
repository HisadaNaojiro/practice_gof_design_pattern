package idcard;
import framework.*;

public class IDCard extends Product {
  private String owner;
  // ↓追加
  private int serial;


  IDCard(String owner, int serial) {
  /*↑こうする
  IDCard(String owner) {
  */

    System.out.println(owner + "(" + serial + ")" + "のカードを作ります");
    /*↑こうする
      System.out.println(owner + "のカードを作ります");
    */
    this.owner = owner;
    // ↓追加
    this.serial = serial;
  }

  public void use() {
    System.out.println(owner + "(" + serial + ")" + "のカードを使います");
    /*↑こうする
      System.out.println(owner + "のカードを使います ");
    */
  }

  public String getOwner() {
    return owner;
  }

  public int getSerial() {
    return serial;
  }
}
