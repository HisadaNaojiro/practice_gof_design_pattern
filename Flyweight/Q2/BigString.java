public class BigString {

  private BigChar[] bigchars;

  public BigString(String string) {
    sharedBigChar(string);
  }

  public BigString(String string, boolean shared) {
    if (shared) {
      sharedBigChar(string);
    } else {
      notSharedBigChar(string);
    }
  }

  private void sharedBigChar(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = factory.getBigChar(string.charAt(i));
    }
  }

  private void notSharedBigChar(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = new BigChar(string.charAt(i));
    }
  }

  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i].print();
    }
  }
}
