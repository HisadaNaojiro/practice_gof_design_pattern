import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor {
  private String extension = "";
  private ArrayList<File> files = new ArrayList<File>();

  public FileFindVisitor(String extension) {
    this.extension = extension;
  } 

  public void visit(File file) {
    if (file.getName().indexOf(extension) != -1) {
      files.add(file);
    }
  }

  public void visit(Directory directory) {
    Iterator it = directory.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry)it.next();
      entry.accept(this);
    }
  }

  public Iterator getFoundFiles() {
    return files.iterator();
  }
}
