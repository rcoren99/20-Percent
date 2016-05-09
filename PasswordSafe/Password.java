
/**
 * Write a description of class Password here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Password
{
    private String service;
    private String username;
    private String category;
    private char[] password;
    private String comment;
    public Password(String service, String username, char[] password, String category, String comment){
        this.service=service;
        this.username=username;
        this.category=category;
        this.password=password;
        this.comment=comment;
    }

    public String addService(String x){
        service=x;
        return service;
    }
    
    public String addCategory(String x){
        category=x;
        return category;
    }
    
    public String addUsername(String x){
        username=x;
        return username;
    }
    
    public char[] addPassword(char[] x){
        password=x;
        return password;
    }
    
    public String addComments(String x){
        comment=x;
        return comment;
    }
    
    public void delService(){service="";}
    
    public void delCategory(){category="";}
    
    public void delUsername(){username="";}
    
    public String getService(){return service;}
    
    public String getCategory(){return category;}
    
    public String getUsername(){return username;}
    
    public char[] getPass(){return password;}
    
    public String getComments(){return comment;}
}