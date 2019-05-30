public class Main {
  private static BigString[] bsarray = new BigString[1000];
  public static void main(String[] args) {
    System.out.println("共有有り");
    testAllocation(true);
    System.out.println("共有無し");
    testAllocation(false);
  }

  public static void testAllocation(boolean shared) {
    for (int i = 0; i < bsarray.length; i++) {
      bsarray[i] = new BigString("1212123", shared);
    }
    showMemory();
  }

  public static void showMemory() {
    Runtime.getRuntime().gc();
    long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println("使用メモリ = " + used);
  }
}
