import java.util.Random;

public class CustomerThreads extends Thread{
    private Integer id;
    private String name;
    private int transacoes;

    public CustomerThreads(String name, int transacoes) {
        this.name = name;
        this. id = Bank.newCustomer(new Account());

        if (transacoes>0) this.transacoes = transacoes;
        else this.transacoes = 1;

    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();

        Bank.deposit(this.id, 1000);

        while (transacoes >0){
            if(random.nextInt(2) == 1) Bank.withdraw(this.id, random.nextInt(501));
            else Bank.deposit(this.id, random.nextInt(501));
            transacoes--;
        }
        System.out.println("A conta de " + name + " tem " + Bank.balance(this.id));
    }
}
