import java.io.*;

public class TextDisplayImpl extends DisplayImpl {
    private String filename;
    private BufferedReader reader;
    private final int MAX_READAHEAD_LIMIT = 4096;

    public TextDisplayImpl(String filename) {
        this.filename = filename;
    }

    public void rawOpen() {
        try {
            reader = new BufferedReader(new FileReader(filename));
            reader.mark(MAX_READAHEAD_LIMIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=-=-=-=-=-= " + filename + " =-=-=-=-=-=");
    }

    public void rawPrint() {
        try {
            String line;
            reader.reset();
            while ((line = reader.readLine()) != null) {
                System.out.println("> " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rawClose() {
        System.out.println("=-=-=-=-=-= ");
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* ↑ こうする
  import java.io.BufferedReader;
  import java.io.FileReader;
  import java.io.IOException;

  public class TextDisplayImpl extends DisplayImpl {

    private String filename;
    private StringBuilder builder = new StringBuilder();
    private BufferedReader reader;

    public TextDisplayImpl(String filename) {
      this.filename = filename;
    }

    public void rawOpen() {
      try { 
        reader = new BufferedReader(new FileReader(this.filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void rawPrint() {
      try { 
        String string = reader.readLine();
        while (string != null){
          builder.append(string + System.getProperty("line.separator"));
          string = reader.readLine();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(builder.toString());
    }

    public void rawClose() {
      try { 
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
*/
