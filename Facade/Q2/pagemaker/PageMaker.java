package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Enumeration;

public class PageMaker {

  private PageMaker() {
  }

  public static void makeWelcomePage(String mailaddr, String filename) {
    try {
      Properties mailprop = Database.getProperties("maildata");
      String username = mailprop.getProperty(mailaddr);
      HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
      writer.title("Welcome to " + username + "'s page!");
      writer.paragraph(username + "のページへようこそ。");
      writer.paragraph("メールまっていますね。");
      writer.mailto(mailaddr, username);
      writer.close();
      System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void makeLinkPage(String filename) {
    try {
      Properties mailprop = Database.getProperties("maildata");
      HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
      Enumeration<String> enums =  (Enumeration<String>)mailprop.propertyNames();
      writer.title("Link page");
      while (enums.hasMoreElements()) {
        String mailaddr = enums.nextElement();
        String username = mailprop.getProperty(mailaddr, "(unknown)");
        // ↑ こうする
        //String username = mailprop.getProperty(mailaddr);
        writer.mailto(mailaddr, username);
      }
      writer.close();
      System.out.println(filename + " is created.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
