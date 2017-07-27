import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.naming.directory.SearchResult;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("xxx");
		
		//String searchFilter = "CN="+Settings.DB_LOGIN;
		
		try {
		    LDAPConnection connection = new LDAPConnection(Settings.DB_HOST,
		                                    Settings.DB_USER_DN,
		                                    Settings.DB_LOGIN,
		                                    Settings.DB_PASSWORD);
		    
		    SearchResult result  =  connection.getUser("dev");
		    
		  
		    System.out.println("result : " + result);
		    System.out.println("result.getName() : " +result.getName());
		    System.out.println("result.getAttributes().get(name) : "  + result.getAttributes().get("name"));
		    System.out.println(result.getAttributes().get("displayname"));
		    System.out.println(result.getAttributes().get("givenname"));
		    System.out.println(result.getAttributes().get("samaccounttype").get(0));
		    
		    
		} catch (AuthenticationException e) {
		    System.err.println("LDAP -> Wrong Authentication");
		} catch (NamingException e) {
		    System.err.println("LDAP -> Couldn't connect: " + e.getMessage());
		    e.printStackTrace();
		}
      
    }

}
