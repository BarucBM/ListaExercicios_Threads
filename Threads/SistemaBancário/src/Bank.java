import java.util.HashMap;
import java.util.Map;


public class Bank {
    static Map<Integer, Account> accounts = new HashMap<>();


    public synchronized static void withdraw(Integer id, double value){
        Account customer = searchAccount(id);

        if (customer == null){
            System.out.println("This account does not exist!");
        }else{
            customer.withdraw(value);
        }
    }

    public synchronized static void deposit(Integer id, double value){
        Account customer = searchAccount(id);

        if (customer == null){
            System.out.println("This account does not exist!");
        }else{
            customer.deposit(value);
        }
    }
    public synchronized static double balance (Integer id){
        return searchAccount(id).getBalance();
    }

    private static Account searchAccount(Integer id){
        return accounts.entrySet().stream()
                .filter(v -> v.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    public synchronized static Integer newCustomer (Account customer) {
        Integer idNew = customer.gerarId();
        accounts.put(idNew, customer);
        return idNew;
    }
}
