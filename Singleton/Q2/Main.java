public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        for (int i = 0; i < 9; i++) {
            Triple triple = Triple.getInstance(i % 3);
            System.out.println(i + ":" + triple);
        }
        System.out.println("End.");
    }
}
/* 
public class Main {
  public static void main(String[] args) {
    Triple obj1 = Triple.getInstance(1);
    Triple obj2 = Triple.getInstance(2);
    Triple obj3 = Triple.getInstance(3);
    Triple obj4 = Triple.getInstance(4);
  }
}
*/
