import java.io.*;

public class HtmlBuilder extends Builder {
  private String filename;
  private PrintWriter writer;
  
  protected void buildTitle(String title) {
  /* ↑ メソッド名の修正
    public void makeTitle(String title) {
  */
    filename = title + ".html";
    try {
      writer = new PrintWriter(new FileWriter(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }

    writer.println("<html><head><title>" + title + "</title></head><body>");
    writer.println("<h1>" + title + "</h1>");
  }

  protected void buildString(String str) {
  /* ↑ メソッド名の修正
    public void makeString(String str) {
  */
    writer.println("<p>" + str + "</p>");
  }

  protected void buildItems(String[] items) {
  /* ↑ メソッド名の修正
    public void makeItems(String[] items) {
  */
    writer.println("<ul>");

    for (int i = 0; i < items.length; i++) {
      writer.println("<li>" + items[i] + "</li>");
    }
    writer.println("</ul>");
  }

  protected void buildDone() {
  /* ↑ メソッド名の修正
    public void close() {
  */
    writer.println("</body></html>");
    writer.close();
  }

  public String getResult() {
    return filename; 
  }
}

