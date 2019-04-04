import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
  private Mediator mediator;

  public ColleagueButton(String caption) {
    super(caption);
  }

  public void setMediator(Mediator mediator) { //Mediatorを保持
    this.mediator = mediator;
  }

  public void setColleagueEnabled(boolean enabled) { //Mediatorから指示される
    setEnabled(enabled);
  }
}
