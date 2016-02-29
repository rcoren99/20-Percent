import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Safe implements ActionListener
{
    private ArrayList<Password> safe=new ArrayList<Password>();
    private JFrame frame;

    private JPanel contentPaneLogin;
    private JPanel passwordPane;
    private JPanel buttonPaneLogin;
    private JButton loginButton;
    private JButton signupButton;
    private JPasswordField mainPass;
    private JLabel loginLabel;
    private static String LOGIN = "login";
    private static String SIGNUP = "signup";

    private JPanel contentPaneSU;
    private JPanel tfPane;
    private JPanel buttonPaneSU;
    private JPanel namePaneSU;
    private JPanel passPaneSU;
    private JPanel confPassPaneSU;
    private JLabel nameLabelSU;
    private JLabel passLabelSU;
    private JLabel confPassLabelSU;
    private JTextField nameFieldSU;
    private JPasswordField passFieldSU;
    private JPasswordField confPassFieldSU;
    private JButton createAcctButton;
    private JButton cancelSignupButton;
    private static String CREATEACCT = "create";
    private static String CANCELSU = "cancel";

    private JLabel label;
    public Safe(int x){
        frame=new JFrame("Password Vault");

        setScreen(x);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void loginScreenGUI(){
        loginLabel=new JLabel("Enter Password:");
        loginLabel.setLabelFor(mainPass);

        mainPass=new JPasswordField(15);
        mainPass.setActionCommand(LOGIN);
        mainPass.addActionListener(this);

        loginButton=new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setActionCommand(LOGIN);
        loginButton.addActionListener(this);

        signupButton=new JButton("Sign Up");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.setActionCommand(SIGNUP);
        signupButton.addActionListener(this);

        passwordPane=new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordPane.setOpaque(true);
        passwordPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordPane.add(loginLabel);
        passwordPane.add(mainPass);

        buttonPaneLogin=new JPanel();
        buttonPaneLogin.setLayout(new BoxLayout(buttonPaneLogin,BoxLayout.LINE_AXIS));

        buttonPaneLogin.add(loginButton);
        buttonPaneLogin.add(signupButton);

        contentPaneLogin=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        contentPaneLogin.add(passwordPane,c);
        GridBagConstraints b=new GridBagConstraints();
        b.gridx=1;
        b.gridy=1;
        contentPaneLogin.add(buttonPaneLogin,b);

        frame.setContentPane(contentPaneLogin);
    }

    private void signupScreenGUI(){
        nameFieldSU=new JTextField(15);
        nameLabelSU=new JLabel("Name:");
        nameLabelSU.setLabelFor(nameFieldSU);
        namePaneSU=new JPanel();
        namePaneSU.setLayout(new BoxLayout(namePaneSU,BoxLayout.LINE_AXIS));
        namePaneSU.setOpaque(true);
        namePaneSU.add(nameLabelSU);
        namePaneSU.add(nameFieldSU);

        passFieldSU=new JPasswordField(15);
        passLabelSU=new JLabel("Password:");
        passLabelSU.setLabelFor(passFieldSU);
        passPaneSU=new JPanel();
        passPaneSU.setLayout(new BoxLayout(passPaneSU,BoxLayout.LINE_AXIS));
        passPaneSU.setOpaque(true);
        passPaneSU.add(passLabelSU);
        passPaneSU.add(passFieldSU);

        confPassFieldSU=new JPasswordField(15);
        confPassLabelSU=new JLabel("Confirm password:");
        confPassLabelSU.setLabelFor(confPassFieldSU);
        confPassPaneSU=new JPanel();
        confPassPaneSU.setLayout(new BoxLayout(confPassPaneSU,BoxLayout.LINE_AXIS));
        confPassPaneSU.setOpaque(true);
        confPassPaneSU.add(confPassLabelSU);
        confPassPaneSU.add(confPassFieldSU);

        tfPane=new JPanel();
        tfPane.setLayout(new BoxLayout(tfPane,BoxLayout.PAGE_AXIS));
        tfPane.add(namePaneSU);
        tfPane.add(passPaneSU);
        tfPane.add(confPassPaneSU);

        createAcctButton=new JButton("Create Account");
        createAcctButton.setActionCommand(CREATEACCT);
        createAcctButton.addActionListener(this);
        cancelSignupButton=new JButton("Cancel");
        cancelSignupButton.setActionCommand(CANCELSU);
        cancelSignupButton.addActionListener(this);

        buttonPaneSU=new JPanel();
        buttonPaneSU.setLayout(new BoxLayout(buttonPaneSU,BoxLayout.LINE_AXIS));
        buttonPaneSU.add(createAcctButton);
        buttonPaneSU.add(cancelSignupButton);

        contentPaneSU=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        contentPaneSU.add(tfPane,c);
        GridBagConstraints b=new GridBagConstraints();
        b.gridx=1;
        b.gridy=1;
        contentPaneSU.add(buttonPaneSU,b);

        frame.setContentPane(contentPaneSU);
    }

    public void mainScreenGUI(){
        label=new JLabel("Main screen will go here.");
        frame.getContentPane().add(label);
    }

    private void setScreen(int x){
        switch(x){
            case 1:
            loginScreenGUI();
            break;
            case 2:
            signupScreenGUI();
            break;
            case 3:
            mainScreenGUI();
            break;
        }
    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect=true;
        char[] correctPassword={'h','e','l','p'};
        if (input.length!=correctPassword.length) {
            isCorrect=false;
        } else {
            isCorrect=Arrays.equals(input,correctPassword);
        }
        return isCorrect;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();

        if (LOGIN.equals(cmd)) {
            char[] input=mainPass.getPassword();
            if (isPasswordCorrect(input)) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new Safe(3);
                        }
                    });
            } else {
                JOptionPane.showMessageDialog(frame,"Invalid password","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(SIGNUP.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Safe(2);
                    }
                });
        }
        else if(CREATEACCT.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Safe(3);
                    }
                });
        }
        else if(CANCELSU.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Safe(1);
                    }
                });
        }
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Safe(1);
                }
            });
    }

    public void addItem(String serv,String user,String cate,String pass,String comm){
        safe.add(new Password(serv,user,cate,pass,comm));
    }

    public void delItem(int x){
        safe.remove(x);
    }

}
