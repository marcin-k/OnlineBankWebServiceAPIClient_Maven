package onlinebankwebserviceapiclient;

import com.mycompany.onlinebankwebserviceapi.model.Customer;
import com.mycompany.onlinebankwebserviceapi.model.Transaction;

public class Runner {
    public static void main(String[] args) {
        
//        PostCustomer pc = new PostCustomer();
//        System.out.println(pc.postCustomer());
        GETRequestes cm = new GETRequestes();
        cm.getAllCustomers();
        cm.getCustomerByID("bob1");
        cm.getAllAccountsForCustomer("bob1");
        cm.getAccountsDetails(100000001);
        cm.getAllTransactions();
        cm.makeTransfer(100000002, 100000001, 200.20);
        cm.getAllAccounts();
        cm.getAllTransactions(100000001);
        cm.login("bob1", "test");
        cm.getSortCode();
        cm.getBalance("bob1");
       
        POSTRequests pr = new POSTRequests();
        pr.newCustomer(new Customer("marcin test","cork", "marcin@marcin.con", "myLogin", "random password"));
        pr.newAccount("bob1");
        cm.getBalance("bob1");
        
        pr.newCreditTransaction(new Transaction("test transaction1", 100000001, 121));
        pr.newDebitTransaction(new Transaction("test transaction1", 100000001, 121));
    }
}
