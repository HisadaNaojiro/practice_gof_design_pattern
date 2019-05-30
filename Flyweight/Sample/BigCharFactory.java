import java.util.HashMap;

public class BigCharFactory {
  // すでに作ったBigCharのインスタンスを管理
  private HashMap<String, BigChar>  pool = new HashMap<String, BigChar>();

  // Singletonパターン 
  private static BigCharFactory singleton = new BigCharFactory();

  private BigCharFactory() {
  }

  public static BigCharFactory getInstance() {
    return singleton;
  }

  // BigCharインスタんの生成(共有)
  public synchronized BigChar getBigChar(char charname) {
    BigChar bc = (BigChar)pool.get("" + charname);
    if (bc == null) {
      bc = new BigChar(charname);
      pool.put("" + charname, bc);
    }
    return bc;
  }
} 
