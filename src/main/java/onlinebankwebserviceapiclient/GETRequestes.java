package onlinebankwebserviceapiclient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.onlinebankwebserviceapi.model.Account;
import com.mycompany.onlinebankwebserviceapi.model.Customer;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GETRequestes {
        //Library to convert json to objects
        Gson gson = new Gson();
//------------------Retruns arraylist of all custoemrs--------------------------
	public List<Customer> getAllCustomers(){
          String jsonString = performGETRequest("http://localhost:49000/"
                  + "api/customers/"); 
          
          List<Customer> list = gson.fromJson(jsonString, new TypeToken<List<Customer>>(){}.getType());
          return list;
	}
//------------------Retruns customer with a given ID----------------------------
        public Customer getCustomerByID(String id){
          String jsonString = performGETRequest("http://localhost:49000/"
                  + "api/customers/"+id); 
          
          // Convert JSON to Java Object
          Customer c = gson.fromJson(jsonString, Customer.class);
          return c;
	}
//----------Retruns all accounts for a customer with a given ID-----------------
        public List<Account> getAllAccountsForCustomer(String id){
          String jsonString = performGETRequest("http://localhost:49000/"
                  + "api/customers/"+id+"/accounts"); 
          
          List<Account> list = gson.fromJson(jsonString, new TypeToken<List<Account>>(){}.getType());
          return list;
	}
//--------Returns account details for account with account number---------------
        public Account getAccountsDetails(int accNumber){
          String jsonString = performGETRequest("http://localhost:49000/api"
                  + "/accounts//"+accNumber); 
          
          // Convert JSON to Java Object
          Account a = gson.fromJson(jsonString, Account.class);
          return a;
	}  
//-------Returns all transactions in the system for all accounts----------------
        public List<Transaction> getAllTransactions(){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "transactions/all"); 
          
          List<Transaction> list = gson.fromJson(jsonString, new TypeToken<List<Transaction>>(){}.getType());
          return list;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String makeTransfer(int accFrom, int accTo, double amount){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "transactions/transfer/"+accFrom+"/"+accTo
                  +"/"+amount+""); 
          
          return jsonString;
	}
//-------Returns all transactions in the system for all accounts----------------
        public List<Account> getAllAccounts(){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "accounts/all"); 
          
          List<Account> list = gson.fromJson(jsonString, new TypeToken<List<Account>>(){}.getType());
          return list;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public List<Transaction> getAllTransactions(int accNumber){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "customers/bob1/accounts/"+accNumber+"/transactions"); 
          
          List<Transaction> list = gson.fromJson(jsonString, new TypeToken<List<Transaction>>(){}.getType());
          return list;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String login(String login, String password){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "customers/"+login+"/"+password+""); 
          
          return jsonString;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String getSortCode(){
          String jsonString = performGETRequest("http://localhost:49000/api/"
                  + "accounts/sortcode"); 
          
          return jsonString;
	} 
//-------Returns all transactions in the system for all accounts----------------
        public String getBalance(String login){
          String jsonString = performGETRequest("http://localhost:49000/api/accounts"
                  + "/total/"+login+""); 
          
          return jsonString;
	}         
//----------------Method used for GET requests----------------------------------
    public String performGETRequest(String URL){
        String output="";  
	  try {
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) 
                        url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
                conn.getResponseCode();

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
                //all replies consist of one line only
		output = br.readLine();
		conn.disconnect();

	  } catch (MalformedURLException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
          return output;
    }
}