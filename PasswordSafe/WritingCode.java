
/**
 * Write a description of class WritingCode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WritingCode
{
    public void exportData(){
        try{
            File f=new File("data.xml");
            FileWriter fw=new FileWriter(f);
            PrintWriter pw=new PrintWriter(fw);
            pw.println("<data>");
            pw.println("<vault>");
            for(int i=0;i<vault.size();i++){
                pw.println("<Password>");
                pw.println("<service>"+vault.get(i).getService()+"</service>");
                pw.println("<username>"+vault.get(i).getUsername()+"</service>");
                pw.println("<category>"+vault.get(i).getCategory()+"</category>");
                pw.println("<comments>"+vault.get(i).getComments()+"</comments>");
                String ps="<password>";
                char[] pa=vault.get(i).getPass();
                for(int j=0;j<pa.length;j++){
                    ps+=pa[j];
                }
                pw.println(ps+"</password>");
                pw.println("</Password>");
            }
            pw.println("</vault>");
            pw.println("</data>");
            pw.close();
            fw.close();
        }
        catch(Exception e){}
    }
}
