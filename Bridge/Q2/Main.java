public class Main {
  public static void main(String[] args) {
    Display d1 = new Display(new StringDisplayImpl("Hello Japan."));
    Display d2 = new CountDisplay(new StringDisplayImpl("Hello Japan."));
    CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello Universe."));
    Display d4 = new Display(new TextDisplayImpl("sample.txt"));
    d1.display();
    d2.display();
    d3.display();
    d3.multiDisplay(5);
    d4.display();
  }
}
