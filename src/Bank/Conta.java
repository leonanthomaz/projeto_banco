package Bank;

public class Conta {

    private static final int  MAX_LENGTH = 12;

    private String ag;
    private String cc;
    private String nome;
    private double balance;
    private Log logger;

    public Conta(String ag, String cc, String nome){
        this.ag = ag;
        this.cc = cc;
        setNome(nome);
        logger = new Log();
    }

    public void setNome(String nome){
        if(nome.length() > MAX_LENGTH){
            this.nome = nome.substring(0, MAX_LENGTH);
        }else{
            this.nome = nome;
        }
        System.out.println(this.nome);
    }

    public void depositar(double valor){
        balance += valor;
        logger.out("DEPOSITO - R$" + valor + " Sua conta agora é de: R$" + balance );
    }

    public boolean sacar(double valor){
        if(balance < valor){
            logger.out("SAQUE - R$" + valor + " Seu saldo atual é de: R$" + balance );
            return false;
        }else{
            balance -= valor;
            logger.out("SAQUE - R$" + valor + " Sua conta agora é de: R$" + balance );
            return true;
        }
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString(){
        String resultado = "A conta do cliente: " + this.nome + ", agência " + this.ag + ", conta " + this.cc + " possui R$" + balance;
        return resultado;
    }
}
