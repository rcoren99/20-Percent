import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class Safe implements ActionListener
{
    private static ArrayList<Password> vault=new ArrayList<Password>();
    private static char[] mainPassword={'s'};
    private Boolean tru=new Boolean(true);
    private Boolean fals=new Boolean(false);
    private int rowToEdit;

    private JFrame frame=new JFrame("Password Vault");
    private static String LOGINSCREEN="Login screen card";
    private static String SIGNUPSCREEN="Signup screen card";
    private static String MAINSCREEN="Main screen card";
    private static String APSCREEN="Add password screen card";
    private static String DNESCREEN="Screen does not exist card";
    private static String SETSCREEN="Settings screen card";
    private static String EDITSCREEN="Edit password screen card";
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
    private Object[][] allPass={{fals,"Google","janedoe123","jd123456","Email","Example"}};
    private JTable table;
    private JScrollPane scroll;
    private JButton addPassButton;
    private JLabel nameLabelMain;
    private static String ADDPASSMAIN = "add password";
    private static String LOGOUT="logout";
    private static String SETTINGS="settings";
    private static String EDITPASS="edit password";
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

    private static String DONE="finalize settings changes";
    private static String CANCELSET="cancel setting change";
    private static String CHANGENAME="change name";
    private static String CHANGEPASS="change password";
    private static String DELACCT="delete account";
    private JPanel contentPaneSet;

    private static String SAVE="save password changes";
    private static String CANCELEDIT="cancel password change";
    private static String DELETE="Delete password";
    private JPanel contentPaneEdit;
    private JTextField serviceFieldE;
    private JTextField categoryFieldE;
    private JTextField usernameFieldE;
    private JPasswordField passwordFieldE;
    private JTextArea commentsFieldE;
    private JPanel passwordPaneE;

    private String name="Rachel";
    public Safe(){
        loginScreenGUI();
        signupScreenGUI();
        mainScreenGUI();
        addPasswordScreenGUI();
        screenDNEGUI();
        settingsScreenGUI();
        editPassScreenGUI();

        contentPane.add(contentPaneLogin,LOGINSCREEN);
        contentPane.add(contentPaneSU,SIGNUPSCREEN);
        contentPane.add(contentPaneMain,MAINSCREEN);
        contentPane.add(contentPaneAP,APSCREEN);
        contentPane.add(contentPaneDNE,DNESCREEN);
        contentPane.add(contentPaneSet,SETSCREEN);
        contentPane.add(contentPaneEdit,EDITSCREEN);

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

    class MainTableModel extends AbstractTableModel{
        String[] colHeader={"Edit","Service","Username","Password","Category","Comments"};
        Object[][] passAry=allPass;
        public int getColumnCount(){
            return colHeader.length;
        }

        public int getRowCount(){
            return passAry.length;
        }

        public String getColumnName(int col){
            return colHeader[col];
        }

        public Object getValueAt(int row,int col){
            return passAry[row][col];
        }

        public Class getColumnClass(int c){
            return getValueAt(0,c).getClass();
        }

        public boolean isCellEditable(int row,int col){
            if (col<1)return true;
            else return false;
        }

        public void setValueAt(Object value,int row,int col){
            passAry[row][col]=value;
            fireTableCellUpdated(row,col);
        }
    }

    public void mainScreenGUI(){
        labelMain=new JLabel("Main screen will go here.");
        labelMain.setAlignmentX(Component.LEFT_ALIGNMENT);

        table=new JTable(new MainTableModel());
        //table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scroll=new JScrollPane(table);

        addPassButton=new JButton("Add Password");
        addPassButton.setActionCommand(ADDPASSMAIN);
        addPassButton.addActionListener(this);

        JButton editPassButton=new JButton("Edit Selected");
        editPassButton.setActionCommand(EDITPASS);
        editPassButton.addActionListener(this);

        JButton logoutButton=new JButton("Logout");
        logoutButton.setActionCommand(LOGOUT);
        logoutButton.addActionListener(this);

        JButton settingsButton=new JButton("Settings");
        settingsButton.setActionCommand(SETTINGS);
        settingsButton.addActionListener(this);

        nameLabelMain=new JLabel(name+"'s Vault");

        JPanel upperPane=new JPanel();
        upperPane.add(nameLabelMain);
        upperPane.add(logoutButton);
        upperPane.add(settingsButton);
        upperPane.add(addPassButton);
        upperPane.add(editPassButton);

        /*JLabel sortLabel=new JLabel("Sort by:");

        String[] sortVals={"Category","Username","Service"};
        JComboBox sortField=new JComboBox(sortVals);
        sortField.setSelectedIndex(1);
        sortField.addActionListener(this);
        sortLabel.setLabelFor(sortField);

        JPanel sortEditPane=new JPanel();
        sortEditPane.add(sortLabel);
        sortEditPane.add(sortField);
        sortEditPane.add(editPassButton);
        sortEditPane.setAlignmentX(Component.LEFT_ALIGNMENT);*/

        JPanel lowerPane=new JPanel();
        lowerPane.setLayout(new BoxLayout(lowerPane,BoxLayout.PAGE_AXIS));
        //lowerPane.add(sortEditPane);
        lowerPane.add(scroll);

        contentPaneMain=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        contentPaneMain.add(upperPane,c);
        GridBagConstraints b=new GridBagConstraints();
        b.gridx=1;
        b.gridy=1;
        contentPaneMain.add(lowerPane,b);
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
        tfPaneAP.add(usernamePane);
        tfPaneAP.add(passwordPane);
        tfPaneAP.add(confPassPane);
        tfPaneAP.add(categoryPane);
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

    public void settingsScreenGUI(){
        JButton changePassButton=new JButton("Change Password");
        changePassButton.setActionCommand(CHANGEPASS);
        changePassButton.addActionListener(this);

        JButton changeNameButton=new JButton("Change Name");
        changeNameButton.setActionCommand(CHANGENAME);
        changeNameButton.addActionListener(this);

        JButton delAcctButton=new JButton("Delete Account");
        delAcctButton.setActionCommand(DELACCT);
        delAcctButton.addActionListener(this);

        JButton doneButton=new JButton("Done");
        doneButton.setActionCommand(DONE);
        doneButton.addActionListener(this);

        JButton cancelButtonSet=new JButton("Cancel");
        cancelButtonSet.setActionCommand(CANCELSET);
        cancelButtonSet.addActionListener(this);

        JPanel setBP=new JPanel();
        setBP.add(doneButton);
        setBP.add(cancelButtonSet);

        JPanel buttonPaneSet=new JPanel();
        buttonPaneSet.setLayout(new BoxLayout(buttonPaneSet,BoxLayout.PAGE_AXIS));
        buttonPaneSet.add(changeNameButton);
        buttonPaneSet.add(changePassButton);
        buttonPaneSet.add(delAcctButton);
        buttonPaneSet.add(setBP);
        changeNameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changePassButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        delAcctButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBP.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPaneSet=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        contentPaneSet.add(buttonPaneSet,c);
    }

    public void editPassScreenGUI(){
        serviceFieldE=new JTextField(15);
        JLabel serviceLabelE=new JLabel("Service:");
        serviceLabelE.setLabelFor(serviceFieldE);
        JPanel servicePaneE=new JPanel();
        servicePaneE.add(serviceLabelE);
        servicePaneE.add(serviceFieldE);
        servicePaneE.setOpaque(true);

        categoryFieldE=new JTextField(15);
        JLabel categoryLabelE=new JLabel("Category:");
        categoryLabelE.setLabelFor(categoryFieldE);
        JPanel categoryPaneE=new JPanel();
        categoryPaneE.add(categoryLabelE);
        categoryPaneE.add(categoryFieldE);
        categoryPaneE.setOpaque(true);

        usernameFieldE=new JTextField(15);
        JLabel usernameLabelE=new JLabel("Username:");
        usernameLabelE.setLabelFor(usernameFieldE);
        JPanel usernamePaneE=new JPanel();
        usernamePaneE.add(usernameLabelE);
        usernamePaneE.add(usernameFieldE);
        usernamePaneE.setOpaque(true);

        passwordFieldE=new JPasswordField(15);
        JLabel passwordLabelE=new JLabel("Password:");
        passwordLabelE.setLabelFor(passwordFieldE);
        passwordPaneE=new JPanel();
        passwordPaneE.add(passwordLabelE);
        passwordPaneE.add(passwordFieldE);
        passwordPaneE.setOpaque(true);

        commentsFieldE=new JTextArea(7,15);
        JScrollPane cfScrollPaneE=new JScrollPane(commentsFieldE);
        commentsFieldE.setEditable(true);
        commentsFieldE.setLineWrap(true);
        cfScrollPaneE.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cfScrollPaneE.setPreferredSize(new Dimension(250,125));

        JLabel commentsLabelE=new JLabel("Comments:");
        commentsLabelE.setLabelFor(commentsFieldE);
        JPanel commentsPaneE=new JPanel();
        commentsPaneE.add(commentsLabelE);
        commentsLabelE.setAlignmentY(Component.TOP_ALIGNMENT);
        commentsPaneE.add(cfScrollPaneE);
        commentsPaneE.setOpaque(true);

        JButton delPassButton=new JButton("Delete Password");
        delPassButton.setActionCommand(DELETE);
        delPassButton.addActionListener(this);

        JPanel tfPaneE=new JPanel();
        tfPaneE.setLayout(new BoxLayout(tfPaneE,BoxLayout.PAGE_AXIS));
        tfPaneE.add(servicePaneE);
        tfPaneE.add(usernamePaneE);
        tfPaneE.add(passwordPaneE);
        tfPaneE.add(categoryPaneE);
        tfPaneE.add(commentsPaneE);
        tfPaneE.add(delPassButton);
        delPassButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton savePassButton=new JButton("Save");
        savePassButton.setActionCommand(SAVE);
        savePassButton.addActionListener(this);

        JButton cancelButtonE=new JButton("Cancel");
        cancelButtonE.setActionCommand(CANCELEDIT);
        cancelButtonE.addActionListener(this);

        JPanel buttonPaneE=new JPanel();
        buttonPaneE.add(savePassButton);
        buttonPaneE.add(cancelButtonE);

        contentPaneEdit=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        contentPaneEdit.add(tfPaneE,c);
        GridBagConstraints b=new GridBagConstraints();
        b.gridx=1;
        b.gridy=1;
        contentPaneEdit.add(buttonPaneE,b);
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
            case 5:
            cl.show(contentPane,SETSCREEN);
            break;
            case 6:
            cl.show(contentPane,EDITSCREEN);
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
            mainPass.setText("");
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
                name=nameFieldSU.getText();
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
            serviceField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            confPassField.setText("");
            categoryField.setText("");
            commentsField.setText("");
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(4);
                    }
                });
        }
        else if(CREATEPASS.equals(cmd)){
            addItem(serviceField.getText(),usernameField.getText(),changeToString(passwordField.getPassword()),passwordField.getPassword(),categoryField.getText(),commentsField.getText());

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
        else if(EDITPASS.equals(cmd)){
            int count=0;
            for(int r=0;r<allPass.length;r++){
                if(allPass[r][0].equals(tru)){
                    count++;
                    rowToEdit=r;
                }
            }
            if(count==1){
                serviceFieldE.setText((String)allPass[rowToEdit][1]);
                categoryFieldE.setText((String)allPass[rowToEdit][4]);
                usernameFieldE.setText((String)allPass[rowToEdit][2]);
                passwordPaneE.remove(1);
                passwordFieldE=new JPasswordField((String)allPass[rowToEdit][3],15);
                passwordPaneE.add(passwordFieldE,1);
                commentsFieldE.setText((String)allPass[rowToEdit][5]);
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            setScreen(6);
                        }
                    });
            }
            else JOptionPane.showMessageDialog(frame,"Please select one line to edit.","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        else if(SAVE.equals(cmd)){
            editItem(rowToEdit,serviceFieldE.getText(),usernameFieldE.getText(),changeToString(passwordFieldE.getPassword()),passwordFieldE.getPassword(),categoryFieldE.getText(),commentsFieldE.getText());
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
        else if(CANCELEDIT.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
        else if(DELETE.equals(cmd)){
            delItem(rowToEdit);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
        else if(LOGOUT.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(1);
                    }
                });
        }
        else if(SETTINGS.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(5);
                    }
                });
        }
        else if(DONE.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
        else if(CANCELSET.equals(cmd)){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setScreen(3);
                    }
                });
        }
        else if(CHANGENAME.equals(cmd)){
            String msg="Input your new name";
            String btn1="Change";
            String btn2="Cancel";
            Object[] buttons={btn1,btn2};
            String s=(String)JOptionPane.showInputDialog(frame,msg,"Name Changer",JOptionPane.INFORMATION_MESSAGE,null,null,"Input new name here");
            if(s!=null){
                name=s;
                nameLabelMain.setText(name+"'s Vault");
            }
        }
        else if(CHANGEPASS.equals(cmd)){
            JPasswordField field=new JPasswordField(15);
            String msg="Input your new password";
            Object[] array={msg,field};
            String btn1="Change";
            String btn2="Cancel";
            Object[] buttons={btn1,btn2};
            int opt=JOptionPane.showOptionDialog(frame,array,"Password Changer",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,buttons,buttons[0]);
            if(opt==JOptionPane.OK_OPTION){
                mainPassword=field.getPassword();
            }
        }
        else if(DELACCT.equals(cmd)){
            int opt=JOptionPane.showConfirmDialog(frame,"Would you like to delete your account?\nDoing so will delete all of your data permanently.","Confirm Delete Account",JOptionPane.YES_NO_OPTION);
            if(opt==JOptionPane.YES_OPTION){
                name="";
                mainPassword=null;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            setScreen(1);
                        }
                    });
            }
        }
    }

    public static void main(String[] args){
        vault.add(new Password("Google","janedoe123",new char[]{'j','d','1','2','3','4','5','6'},"Email","Example"));
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Safe();
                }
            });
    }

    public String changeToString(char[] ary){
        String s="";
        for(int i=0;i<ary.length;i++){
            s+=ary[i];
        }
        return s;
    }

    public void addItem(String serv,String user,String pass,char[] charPass,String cate,String comm){
        Object[][] temp=allPass;
        allPass=new Object[temp.length+1][6];
        if(allPass.length>=0){
            for(int row=0;row<temp.length;row++){
                for(int col=0;col<temp[0].length;col++){
                    allPass[row][col]=temp[row][col];
                }
            }
        }
        allPass[temp.length][0]=fals;
        allPass[temp.length][1]=serv;
        allPass[temp.length][2]=user;
        allPass[temp.length][3]=pass;
        allPass[temp.length][4]=cate;
        allPass[temp.length][5]=comm;
        table=new JTable(new MainTableModel());
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        scroll.setViewportView(table);
        vault.add(temp.length,new Password(serv,user,charPass,cate,comm));
    }

    public void delItem(int r){
        Object[][] temp=allPass;
        allPass=new Object[temp.length-1][temp[0].length];
        for(int row1=0;row1<r;row1++){
            for(int col1=0;col1<temp[0].length;col1++){
                allPass[row1][col1]=temp[row1][col1];
            }
        }
        for(int row2=r+1;row2<allPass.length;row2++){
            for(int col2=0;col2<temp[0].length;col2++){
                allPass[row2-1][col2]=temp[row2][col2];
            }
        }
        table=new JTable(new MainTableModel());
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        scroll.setViewportView(table);
        vault.remove(r);
    }

    public void editItem(int row,String serv,String user,String pass,char[] charPass,String cate,String comm){
        allPass[row][0]=fals;
        allPass[row][1]=serv;
        allPass[row][2]=user;
        allPass[row][3]=pass;
        allPass[row][4]=cate;
        allPass[row][5]=comm;
        table=new JTable(new MainTableModel());
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        scroll.setViewportView(table);
        vault.set(row,new Password(serv,user,charPass,cate,comm));
    }
}
