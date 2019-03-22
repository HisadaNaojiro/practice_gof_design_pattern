package idcard;
import framework.*;
import java.util.*;

public class IDCardFactory extends Factory { 
  // ↓不要
  private ArrayList<String> owners = new ArrayList<String>();
  // ↓追加
  private HashMap<Integer, String> database = new HashMap<Integer, String>();
  // ↓追加
  private int serial = 100;

  protected synchronized Product createProduct(String owner) {
      return new IDCard(owner, serial++);
  }
  /* ↑こうする
    protected Product createProduct(String owner) {
      return new IDCard(owner);
    }
  */

  protected void registerProduct(Product product) {
      IDCard card = (IDCard)product;
      database.put(Integer.valueOf(card.getSerial()), card.getOwner());
  }
  /* ↑こうする
    protected void registerProduct(Product product) {
      owners.add(((IDCard)product).getOwner());
    }
  */

  // ↓追加
  public HashMap getDatabase() {
      return database;
  }

  /* ↓不要
    public List getOwners() {
      return owners;
    }
  */
}
