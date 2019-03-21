import java.util.ArrayList;

public class BookShelf implements Aggregate {
  private ArrayList<Book> books;
  /* ↑こうする
     private ArrayList<Book> books;
   */

  public BookShelf(int initialsize) {         
      this.books = new ArrayList<Book>(initialsize);   
  }                                           

  /* ↑こうする
    public BookShelf(int maxsize) {
      this.books = new ArrayList<Book>();
    }
  */

  public Book getBookAt(int index) {
      return (Book)books.get(index);          
  }

  /* ↑こうする
    public Book getBookAt(int index) {
      return this.books.get(index);
    }
  */

  public void appendBook(Book book) {
    books.add(book);
  }

  public int getLength() {
    return books.size();
  }

  public Iterator iterator() {
    return new BookShelfIterator(this);
  }
}


