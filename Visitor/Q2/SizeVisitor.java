import java.util.Iterator;

public class SizeVisitor extends Visitor {
  private int size = 0;

  // ↓追加
  public int getSize() {
    return size;
  }
  public void visit(File file) {
    // ↓追加
    size += file.getSize();
  }

  public void visit(Directory directory) {
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry)it.next();
      // ↓追加
      entry.accept(this);
      /* ↓不要
        size += entry.getSize();
       */
    }
  }

  /* ↓ 不要
    public int getSize() {
      return size;
    }
  */
}
