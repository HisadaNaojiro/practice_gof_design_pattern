public class Triple {
    private static Triple[] triple = new Triple[]{
        new Triple(0),
        new Triple(1),
        new Triple(2),
    };
    private int id;
    private Triple(int id) {                                 
        System.out.println("The instance " + id + " is created.");
        this.id = id;
    }
    public static Triple getInstance(int id) {
        return triple[id];
    }
    public String toString() {
        return "[Triple id=" + id + "]";
    }
}
/* ↑ こうする 
import java.util.*;
public class Triple {
  private static ArrayList<Triple> instances = new ArrayList<Triple>(); 
  private static int maxsize = 3;

  private Triple() {
    System.out.println("インスタンスを生成しました");
  }

  public static Triple getInstance(int id) {
    if (instances.size() > maxsize) {
      System.out.println("インスタンスの生成は最大" + maxsize + "までです。");
      return instances.get(0);
    } else {
      instances.add(new Triple());
      return instances.get(id);
    }
  }
}
*/
