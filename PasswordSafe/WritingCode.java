import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
/**
 * Write a description of class WritingCode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WritingCode
{
    private static ArrayList<Password> vault=new ArrayList<Password>();
    /*
     * export method
     */
    public static void main(String[] args){
        vault.add(new Password("test","test",new char[]{'t','e','s','t'},"test","test"));
        try{
            File f=new File("data.xml");
            FileWriter fw=new FileWriter(f);
            PrintWriter pw=new PrintWriter(fw);
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            pw.println("<data>");
            System.out.println("<data>");
            pw.println("<vault>");
            System.out.println("<vault>");
            for(int i=0;i<vault.size();i++){
                pw.println("<Password id=\""+(i+1)+"\">");
                System.out.println("<Password id=\""+(i+1)+"\">");
                pw.println("<service>"+vault.get(i).getService()+"</service>");
                System.out.println("<service>"+vault.get(i).getService()+"</service>");
                pw.println("<username>"+vault.get(i).getUsername()+"</service>");
                System.out.println("<username>"+vault.get(i).getUsername()+"</service>");
                String ps="<password>";
                char[] pa=vault.get(i).getPass();
                for(int j=0;j<pa.length;j++){
                    ps+=pa[j];
                }
                pw.println(ps+"</password>");
                System.out.println(ps+"</password>");
                pw.println("<category>"+vault.get(i).getCategory()+"</category>");
                System.out.println("<category>"+vault.get(i).getCategory()+"</category>");
                pw.println("<comment>"+vault.get(i).getComments()+"</comment>");
                System.out.println("<comment>"+vault.get(i).getComments()+"</comment>");
                pw.println("</Password>");
                System.out.println("</Password>");
            }
            pw.println("</vault>");
            System.out.println("</vault>");
            pw.println("</data>");
            System.out.println("</data>");
            pw.close();
            fw.close();
        }
        catch(Exception e){}
    }
    public static void importData(){
        try{
            File f=new File("G:/CompSci/20-Percent/PasswordSafe/data.xml");
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
            Document doc=dBuilder.parse(f);
            doc.getDocumentElement().normalize();
            NodeList passList=doc.getElementsByTagName("Password");
            if(passList!=null){
                for(int i=0;i<passList.getLength();i++){
                    Node pass=passList.item(i);
                    if(pass.hasChildNodes()){
                        NodeList parList=pass.getChildNodes();
                        Password nuPass=new Password(parList.item(1).getTextContent(),
                                parList.item(3).getTextContent(),
                                parList.item(5).getTextContent().toCharArray(),
                                parList.item(7).getTextContent(),
                                parList.item(9).getTextContent());
                        vault.add(nuPass);
                    }
                }
                allPass=new Object[vault.size()][6];
                for(int row=0;row<vault.size();row++){
                    Password p=vault.get(row);
                    allPass[row][0]=fals;
                    allPass[row][1]=p.getService();
                    allPass[row][2]=p.getUsername();
                    allPass[row][3]=changeToString(p.getPass());
                    allPass[row][4]=p.getCategory();
                    allPass[row][5]=p.getComments();
                }
            }
        }
        catch(Exception e){}
    }
    
}
