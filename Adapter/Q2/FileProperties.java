import java.io.*;
import java.util.*;
/* ↑こうする
  import java.util.Properties;
*/

public class FileProperties extends Properties implements FileIO {
/* ↑こうする
  public class FileProperties implements FileIO {
*/

/* ↓いらない
  private Properties properties;
*/

/* ↓いらない
  public FileProperties () {
    this.properties = new Properties();
  }
*/

  public void readFromFile(String filename) throws IOException {
      load(new FileInputStream(filename));
  }
/* ↑こうする
  public void readFromFile(String filename) {
    try {
      InputStream inputStream = new FileInputStream(new File(filename));
      properties.load(inputStream);
      inputStream.close();
    } catch  (IOException e) {
       System.out.println(e.getMessage());
    }
  }
*/

  public void writeToFile(String filename) throws IOException {
      store(new FileOutputStream(filename), "written by FileProperties");
  }
/* ↑こうする
  public void writeToFile(String filename) {
    try {
      FileOutputStream outputStream = new FileOutputStream(new File(filename));
      properties.store(outputStream, "written by FileProperties");
      outputStream.close();
    } catch  (IOException e) {
       System.out.println(e.getMessage());
    }
  }
*/

  public void setValue(String key, String value) {
      setProperty(key, value);
  }
/* ↑こうする
  public void setValue(String key, String value) {
    properties.setProperty(key, value);
  }
*/

  public String getValue(String key) {
      return getProperty(key, "");
  }
/* ↑こうする
  public String getValue(String key) {
    return properties.getProperty(key);
  }
*/
}
