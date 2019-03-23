public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      usage();
      System.exit(0);
    }

    if (args[0].equals("plain")) {
      TextBuilder textbuilder = new TextBuilder();
      Director director = new Director(textbuilder);
      director.construct();
      String result = textbuilder.getResult();
      System.out.println(result);
    } else if(args[0].equals("html")) {
      HtmlBuilder htmlbuilder = new HtmlBuilder();
      Director director = new Director(htmlbuilder);
      director.construct();
      String filename = htmlbuilder.getResult();
      System.out.println(filename + "が作成されました。");
    } else {
      usage();
      System.exit(0);
    }
  }

  public static void usage() {
    System.out.println("Usage: Java Main plain  ”プレーンテキストで文章作成");
    System.out.println("Usage: Java Main html   ”HTMLファイルで文章作成");
  }
}
