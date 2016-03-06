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
    private static char[] mainPassword={};

    private JFrame frame=new JFrame("Password Vault");
    private static String LOGINSCREEN="Login screen card";
    private static String SIGNUPSCREEN="Signup screen card";
    private static String MAINSCREEN="Main screen card";
    private static String APSCREEN="Add password screen card";
    private static String DNESCREEN="Screen does not exist card";
    private JPanel contentPane=new JPanel(new CardLayout());

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

    private JLabel labelMain;
    private JButton addPassButton;
    private static String ADDPASSMAIN = "add password";
    private JPanel contentPaneMain;

    private JPanel contentPaneAP;
    private JTextField serviceField;
    private JTextField categoryField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confPassField;
    private JTextArea commentsField;
    private static String CREATEPASS="create password";
    private static String CANCEL="cancel create pass";
    //private JPanel tfPaneAP;
    //private JPanel buttonPaneAP;

    private JLabel label;
    private JPanel contentPaneDNE;
    public Safe(){
        loginScreenGUI();
        signupScreenGUI();
        mainScreenGUI();
        addPasswordScreenGUI();
        screenDNEGUI();

        contentPane.add(contentPaneLogin,LOGINSCREEN);
        contentPane.add(contentPaneSU,SIGNUPSCREEN);
        contentPane.add(contentPaneMain,MAINSCREEN);
        contentPane.add(contentPaneAP,APSCREEN);
        contentPane.add(contentPaneDNE,DNESCREEN);

        frame.setContentPane(contentPane);
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
    }

    public void mainScreenGUI(){
        labelMain=new JLabel("Main screen will go here.");
        addPassButton=new JButton("Add Password");
        addPassButton.setActionCommand(ADDPASSMAIN);
        addPassButton.addActionListener(this);
        contentPaneMain=new JPanel();
        contentPaneMain.add(labelMain);
        contentPaneMain.add(addPassButton);
    }

    public void addPasswordScreenGUI(){
        serviceField=new JTextField(15);
        JLabel serviceLabel=new JLabel("Service:");
        serviceLabel.setLabelFor(serviceField);
        JPanel servicePane=new JPanel();
        servicePane.add(serviceLabel);
        servicePane.add(serviceField);
        servicePane.setOpaque(true);

        categoryField=new JTextField(15);
        JLabel categoryLabel=new JLabel("Category:");
        categoryLabel.setLabelFor(categoryField);
        JPanel categoryPane=new JPanel();
        categoryPane.add(categoryLabel);
        categoryPane.add(categoryField);
        categoryPane.setOpaque(true);

        usernameField=new JTextField(15);
        JLabel usernameLabel=new JLabel("Username:");
        usernameLabel.setLabelFor(usernameField);
        JPanel usernamePane=new JPanel();
        usernamePane.add(usernameLabel);
        usernamePane.add(usernameField);
        usernamePane.setOpaque(true);

        passwordField=new JPasswordField(15);
        JLabel passwordLabel=new JLabel("Password:");
        passwordLabel.setLabelFor(passwordField);
        JPanel passwordPane=new JPanel();
        passwordPane.add(passwordLabel);
        passwordPane.add(passwordField);
        passwordPane.setOpaque(true);

        confPassField=new JPasswordField(15);
        JLabel confPassLabel=new JLabel("Confirm Password:");
        confPassLabel.setLabelFor(confPassField);
        JPanel confPassPane=new JPanel();
        confPassPane.add(confPassLabel);
        confPassPane.add(confPassField);
        confPassPane.setOpaque(true);

        commentsField=new JTextArea(7,15);
        JScrollPane cfScrollPane=new JScrollPane(commentsField);
        commentsField.setEditable(true);
        commentsField.setLineWrap(true);
        cfScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cfScrollPane.setPreferredSize(new Dimension(250,125));

        JLabel commentsLabel=new JLabel("Comments:");
        commentsLabel.setLabelFor(commentsField);
        JPanel commentsPane=new JPanel();
        commentsPane.add(commentsLabel);
        commentsLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        commentsPane.add(cfScrollPane);
        commentsPane.setOpaque(true);

        JPanel tfPaneAP=new JPanel();
        tfPaneAP.setLayout(new BoxLayout(tfPaneAP,BoxLayout.PAGE_AXIS));
        tfPaneAP.add(servicePane);
        tfPaneAP.add(categoryPane);
        tfPaneAP.add(usernamePane);
        tfPaneAP.add(passwordPane);
        tfPaneAP.add(confPassPane);
        tfPaneAP.add(commentsPane);

        JButton createPassButton=new JButton("Create Password");
        createPassButton.setActionCommand(CREATEPASS);
        createPassButton.addActionListener(this);

        JButton cancelButton=new JButton("Cancel");
        cancelButton.setActionCommand(CANCEL);
        cancelButton.addActionListener(this);

        JPanel buttonPaneAP=new JPanel();
        buttonPaneAP.add(createPassButton);
        buttonPaneAP.add(cancelButton);

        contentPaneAP=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        contentPaneAP.add(tfPaneAP,c);
        GridBagConstraints b=new GridBagConstraints();
        b.gridx=1;
        b.gridy=1;
        contentPaneAP.add(buttonPaneAP,b);
    }

    public void screenDNEGUI(){
        label=new JLabel("Screen does not exist");
        contentPaneDNE=new JPanel();
        contentPaneDNE.add(label);
    }

    private void setScreen(int x){
        CardLayout cl = (CardLayout)(contentPane.getLayout());
        switch(x){
            case 1:
            cl.show(contentPane,LOGINSCREEN);
            break;
            case 2:
            cl.show(contentPane,SIGNUPSCREEN);
            break;
            case 3:
            cl.show(contentPane,MAINSCREEN);
            break;
            case 4:
            cl.show(contentPane,APSCREEN);
            break;
            default:
            cl.show(contentPane,DNESCREEN);
        }
    }

    private static boolean isPasswordCorrect(char[] input,char[] correctPassword) {
        boolean isCorrect=true;
        if(input.length!=correctPassword.length){
            isCorrect=false;
        }
        else{
            isCorrect=Arrays.equals(input,correctPassword);
        }
        return isCorrect;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();

        if (LOGIN.equals(cmd)) {
            char[] input=mainPass.getPassword();
            if(isPasswordCorrect(input,mainPassword)) {
                if(mainPassword.length==0)JOptionPane.showMessageDialog(frame,"Invalid password","Error Message",JOptionPane.ERROR_MESSAGE);
                else{
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                setScreen(3);
                            }
                        });
                }	
            } 
            else JOptionPane.showMessageDialog(frame,"Invalid password","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        else if(SIGNUP.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(2);
                    }
                });
        }
        else if(CREATEACCT.equals(cmd)){
            if(isPasswordCorrect(confPassFieldSU.getPassword(),passFieldSU.getPassword())==true){
                mainPassword=passFieldSU.getPassword();
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            setScreen(3);
                        }
                    });
            }
            else JOptionPane.showMessageDialog(frame,"Passwords do not match","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        else if(CANCELSU.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(1);
                    }
                });
        }
        else if(ADDPASSMAIN.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(4);
                    }
                });
        }
        else if(CREATEPASS.equals(cmd)){
            addItem(serviceField.getText(),categoryField.getText(),usernameField.getText(),passwordField.getPassword(),commentsField.getText());

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
        else if(CANCEL.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Safe();
                }
            });
    }

    public void addItem(String serv,String user,String cate,char[] pass,String comm){
        safe.add(new Password(serv,user,cate,pass,comm));
    }

    public void delItem(int x){
        safe.remove(x);
    }

}
