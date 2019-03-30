/* ↓ 不要
import java.util.Iterator;
import java.util.ArrayList;
*/

public abstract class Support {
  private String name;
  // ↓ 不要
  //private ArrayList<Support> nextList = new ArrayList<Support>();
  private Support next;

  public Support(String name) {
    this.name = name;
  }

  public Support setNext(Support next) {
    this.next = next;
    return next;
    /* ↑ 不要
      nextList.add(next);
      return this;
    */
  }

  public final void support(Trouble trouble) {
    for (Support obj = this; true; obj = obj.next) {
      if (obj.resolve(trouble)) {
        obj.done(trouble);
        break;
      } else if (obj.next == null) {
        obj.fail(trouble);
        break;
      }
    }

    /* ↑ こうする
      Iterator it = nextList.iterator();
      while (it.hasNext()) {
        Support next = (Support)it.next();
        if (next.resolve(trouble)) {
          next.done(trouble);
          return;
        }
      }
      fail(trouble);
    */
  }

  public String toString() {
    return "[" + name + "]";
  }

  protected abstract boolean resolve(Trouble toString);
  protected void done(Trouble trouble) {
    System.out.println(trouble + " is resolved by" + this + ".");
  }

  protected void fail(Trouble trouble) {
    System.out.println(trouble + "cannot be resolved.");
  }
}
