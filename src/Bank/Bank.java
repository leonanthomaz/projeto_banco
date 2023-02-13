package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String ag;
    private List<Conta> contas;

    private int ultimaConta = 1;

    public Bank(String ag){
        this.ag = ag;
        this.contas = new ArrayList<>();
    }

    public List<Conta> getContas(){
        return contas;
    }

    public void inserirConta(Conta conta){
        contas.add(conta);
    }

    public Conta gerarConta(String nome){
        Conta conta = new Conta("001", "" + ultimaConta, nome );
        ultimaConta++;
        return conta;
    }

    public void totalBalance(){
        double total = 0;
        for(Conta conta : contas){
            double b = conta.getBalance();
            total += b;
        }
        System.out.println("O balanço total do banco é: R$" + total);
    }

}
