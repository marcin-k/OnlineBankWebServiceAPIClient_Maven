package onlinebankwebserviceapiclient;
import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.model.Customer;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class POSTRequests {

//-------------------Creates a new Customer-------------------------------------	
    public String newCustomer(Customer c) {
        String input = "{\"name\": \""+c.getName()+"\",\"address\": \""
                        +c.getAddress()+"\",\"email\": \""+c.getEmail()+"\","
                        + "\"login\": \""+c.getLogin()+"\",\"password\": \""
                        +c.getPassword()+"\"}";            
        String url = "http://localhost:49000/api/customers";
        
        return performPOSTRequest(url, input);
    }
//-------------------Creates a new Account-------------------------------------	
    public String newAccount(String login) {
        String input = "{\"customerId\": \""+login+"\"}";  
        String url = "http://localhost:49000/api/accounts/new";
        
        return performPOSTRequest(url, input);
    }
//-------------------Creates a debit Transaction-------------------------------------	
    public String newDebitTransaction(Transaction t) {
        String input = "{\"description\": \""+t.getDescription()+"\",\""
                + "accountNumber\": \""+t.getAccountNumber()+"\",\"amount\": "
                + "\""+t.getAmount()+"\"}";
        String url = "http://localhost:49000/api/transactions/debit";
        
        return performPOSTRequest(url, input);
    }  
//-------------------Creates a debit Transaction-------------------------------------	
    public String newCreditTransaction(Transaction t) {
        String input = "{\"description\": \""+t.getDescription()+"\",\""
                + "accountNumber\": \""+t.getAccountNumber()+"\",\"amount\": "
                + "\""+t.getAmount()+"\"}";
        String url = "http://localhost:49000/api/transactions/credit";
        
        return performPOSTRequest(url, input);
    } 
//----------------Method used for POST requests----------------------------------
    public String performPOSTRequest(String urlString, String input){
        String output = "";  
	  try {

		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

                output = br.readLine();

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
         System.out.println(output);
         return output;
    }
}