import java.lang.reflect.Constructor;

public class PrinterProxy implements Printable  {
  private String name;
  private String className;
  private Printable real;
  
  public PrinterProxy(String className) {
    this.className = className;
  }

  public PrinterProxy(String className, String name) {
    this.className = className;
    this.name = name;
  }

  public synchronized void setPrinterName(String name) {
    if (real != null) {
      real.setPrinterName(name);
    }
    this.name = name;
  }

  public String getPrinterName() {
    return name;
  }

  public void print(String string) {
    realize();
    real.print(string);
  }

  private synchronized void realize() {
    if (real == null) {
      try {
        real= (Printable)Class.forName(className).getDeclaredConstructor().newInstance();
        real.setPrinterName(name);
      } catch (ClassNotFoundException e) {
        System.err.println("クラス" + className + "が見つかりません。");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
