import java.util.Iterator;
import java.util.ArrayList;

public class MultiStringDisplay extends Display {
  private ArrayList<String> display = new ArrayList<String>();
  // ↓ 追加
  private int columns = 0;

  public void add(String string) {
    display.add(string);
    // 追加
    updateColumn(string);
  }

  public int getColumns() {
    return columns;
    /* ↑ こうする
      int columns = 0;
      Iterator it = display.iterator();
      while (it.hasNext()) {
        String string = (String)it.next();
        columns += string.getBytes().length;
      }
      return columns;
    */
  }

  public int getRows() {
    return display.size();
  }

  public String getRowText(int row) {
    return display.get(row);
  }

  // ↓ 追加
  private void updateColumn(String msg) {
    if (msg.getBytes().length > columns) {
      columns = msg.getBytes().length;
    }
    for (int row = 0; row < display.size(); row++) {
      int fills = columns - ((String)display.get(row)).getBytes().length;
      if (fills > 0) {
        display.set(row, display.get(row) + spaces(fills));
      }
    }
  }

  // ↓ 追加
  private String spaces(int count) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < count; i++) {
      buf.append(' ');
    }
    return buf.toString();
  }
}
