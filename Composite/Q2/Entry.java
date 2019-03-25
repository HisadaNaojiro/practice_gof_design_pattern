import java.util.Iterator;
import java.util.ArrayList;

public abstract class Entry {
  // ↓ 追加
  protected Entry parent; 
  public abstract String getName();
  public abstract int getSize();
  protected ArrayList<Entry> directory = new ArrayList<Entry>();

  public Entry add(Entry entry) throws FileTreatmentException {
    throw new FileTreatmentException();
  }

  public void printList() {
    printList("");
  }

  protected abstract void printList(String prefix);

  public String toString() {
    return getName() + "(" + getSize() + ")";
  }

  /* ↓ いじらない
    public void printList(String prefix) {
      System.out.println(prefix + "/" + this);
      Iterator it = directory.iterator();
      while (it.hasNext()) {
        Entry entry = (Entry)it.next();
        entry.printList(prefix + "/" + getName());
      }
    }
  */

  // ↓ 追加
  public String getFullName() {                       
      StringBuffer fullname = new StringBuffer();
      Entry entry = this;
      do {
          fullname.insert(0, "/" + entry.getName());
          entry = entry.parent;
      } while (entry != null);
      return fullname.toString();
  }
}
