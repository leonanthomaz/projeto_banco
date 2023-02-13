package Bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("001");

        while (true){
            System.out.println("O que deseja fazer? C = criar conta, E = sair");
            String op = scanner.nextLine();
            if(op.equals("C")){
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                Conta conta = santander.gerarConta(nome);
                santander.inserirConta(conta);

                operarConta(conta);
            }else if(op.equals("E")){
                System.out.println("Encerrado com sucesso!");
                break;
            }else {
                System.out.println("Opção não encontrada!");
                break;
            }
        }

        List<Conta> contasLista = santander.getContas();

        for(Conta cc : contasLista){
            System.out.println(cc);
        }

        santander.totalBalance();
    }

    static void operarConta(Conta conta){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("O que deseja fazer? D = saque, S = sacar, E = Sair");
            String op = scanner.nextLine();
            if(op.equals("D")){
                System.out.println("Qual valor deseja depositar?");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
            }else if(op.equals("S")){
                System.out.println("Qual valor deseja sacar?");
                double valor = scanner.nextDouble();
                if(!conta.sacar(valor)){
                    System.out.println("Erro: Saldo insuficiente!");
                }
            } else if (op.equals("E")) {
                break;
            }else {
                System.out.println("Opção inválida!");
            }
            scanner = new Scanner(System.in);
        }
    }
}
