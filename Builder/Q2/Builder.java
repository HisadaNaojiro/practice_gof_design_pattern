public abstract class Builder {
    private boolean initialized = false;
    public void makeTitle(String title) {
        if (!initialized) {
            buildTitle(title);
            initialized = true;
        }
    }
    public void makeString(String str) {
        if (initialized) {
            buildString(str);
        }
    }
    public void makeItems(String[] items) {
        if (initialized) {
            buildItems(items);
        }
    }
    public void close() {
        if (initialized) {
            buildDone();
        }
    }
    protected abstract void buildTitle(String title);
    protected abstract void buildString(String str);
    protected abstract void buildItems(String[] items);
    protected abstract void buildDone();
}
/* ↑こうする
public abstract class Builder {
  public abstract void makeTitle(String title);
  public abstract void makeString(String str);
  public abstract void makeItems(String[] items);
  public abstract void close();
}
*/
