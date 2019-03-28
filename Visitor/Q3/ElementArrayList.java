import java.util.Iterator;
import java.util.ArrayList;

class ElementArrayList extends ArrayList implements Element {
  public void accept(Visitor v) {
    Iterator it = iterator();
    while (it.hasNext()) {
      Element e = (Element)it.next();
      e.accept(v);
    }
  }
}

/* ↑ こうする
public class ElementArrayList implements Element {
  private ArrayList<Entry> entries = new ArrayList<Entry>();

  public void add(Entry entry) {
    entries.add(entry);
  }

  public void accept(Visitor v) {
    Iterator it = entries.iterator();
    while (it.hasNext()) {
      //Entry entry = (Entry)it.next();
      if (it.next() instanceof File) {
        File entry = (File)it.next();
        v.visit(entry);
      } else {
        Directory entry = (Directory)it.next();
        v.visit(entry);
      }
    }
  }
}
*/
