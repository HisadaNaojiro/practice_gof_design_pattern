import game.Memento;
import game.Gamer;
// ↓ 追加
import java.io.*;

public class Main {

  // ↓ 追加
  public static final String SAVEFILENAME = "game.dat";       

  public static void main(String[] args) {
    Gamer gamer = new Gamer(100);
    Memento memento = loadMemento();
    /* ↑ こうする
      Memento memento = gamer.createMemento();
    */

    // ↓ 追加 
    if (memento != null) {
        System.out.println("前回保存した結果からスタートします。");
        gamer.restoreMemento(memento);
    } else {
        System.out.println("新規にスタートします。");
        memento = gamer.createMemento();
    }
    for (int i = 0; i < 100; i++) {
      System.out.println("====" + i);
      System.out.println("現状: " + gamer);

      gamer.bet();

      System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

      if (gamer.getMoney() > memento.getMoney()) {
        System.out.println("    (だいぶ増えてきたので、現在の状態を保存しておこう)");
        memento = gamer.createMemento();
        saveMemento(memento);
      } else if (gamer.getMoney() < memento.getMoney()) {
        System.out.println("    (だいぶ減ったので、以前の状態に復帰しよう)");
        gamer.restoreMemento(memento);
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println("");
    }
  }

  //↓ 追加
  public static void saveMemento(Memento memento) {   
      try {
          ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SAVEFILENAME));
          out.writeObject(memento);
          out.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  //↓ 追加
  public static Memento loadMemento() {               
      Memento memento = null;
      try {
          ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME));
          memento = (Memento)in.readObject();
          in.close();
      } catch (FileNotFoundException e) {
          System.out.println(e.toString());
      } catch (IOException e) {
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
      return memento;
  }
}
