public class Account {

    private double balance;
    static Integer idBase = 100;

    public Account() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    private  void setBalance(double balance1) {
        balance = balance1;
    }

    public  void withdraw(double value){
        if((getBalance() - value) > 0){
            setBalance(getBalance() - value);
            //System.out.println("Current balance: " + getBalance());
        }else{
            //System.out.println("Insufficient funds!");
        }
    }

    public  void deposit(double value){
        setBalance(getBalance()+value);
        //System.out.println("Current balance: " + getBalance());
    }
    public Integer gerarId(){
        return idBase++;
    }

}
