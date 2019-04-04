import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends Frame implements ActionListener, Mediator {

  private ColleagueCheckbox checkGuest;
  private ColleagueCheckbox checkLogin;
  private ColleagueTextField textUser;
  private ColleagueTextField textPass;
  private ColleagueButton buttonOk;
  private ColleagueButton buttonCancel;

  public LoginFrame(String title) {
    super(title);
    setBackground(Color.lightGray);
    setLayout(new GridLayout(4,2));
    createColleagues();

    add(checkGuest);
    add(checkLogin);
    add(new Label("Useranme:"));
    add(textUser);
    add(new Label("Password:"));
    add(textPass);
    add(buttonOk);
    add(buttonCancel);

    colleagueChanged();

    pack();
    setVisible(true);
  }

  // Colleagueたちを生成
  public void createColleagues() {
    // 生成
    CheckboxGroup g = new CheckboxGroup();
    checkGuest = new ColleagueCheckbox("Guest", g, true);
    checkLogin = new ColleagueCheckbox("Login", g, false);
    textUser = new ColleagueTextField("", 10);
    textPass = new ColleagueTextField("", 10);
    textPass.setEchoChar('*');
    buttonOk = new ColleagueButton("OK");
    buttonCancel = new ColleagueButton("Cancel");

    // Mediatorセット
    checkGuest.setMediator(this);
    checkLogin.setMediator(this);
    textUser.setMediator(this);
    textPass.setMediator(this);
    buttonOk.setMediator(this);
    buttonCancel.setMediator(this);

    // Listenerセット
    checkGuest.addItemListener(checkGuest);
    checkLogin.addItemListener(checkLogin);
    textUser.addTextListener(textUser);
    textPass.addTextListener(textPass);
    buttonOk.addActionListener(this);
    buttonCancel.addActionListener(this);
  }

  // Colleagueからの通知で各Colleagueの有効/無効を判定
  public void colleagueChanged() {

   if (checkGuest.getState()) { //Guestモード
     textUser.setColleagueEnabled(false);
     textPass.setColleagueEnabled(false);
     buttonOk.setColleagueEnabled(false);
   } else { //Loginモード
     textUser.setColleagueEnabled(false);
     userpassChanged();
   }
  }

  // textUserまたはtextPassの変更があった
  // 各Colleagueの有効/無効を判定
  private void userpassChanged() {
    if (textUser.getText().length() > 0) {
     textPass.setColleagueEnabled(true);
     if (textPass.getText().length() > 0) {
       buttonOk.setColleagueEnabled(true);
     } else {
       buttonOk.setColleagueEnabled(false);
     }
    } else {
     textPass.setColleagueEnabled(true);
     buttonOk.setColleagueEnabled(false);
    }
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    System.exit(0);
  }
}
