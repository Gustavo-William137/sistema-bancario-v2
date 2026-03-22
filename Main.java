import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Banco meuBanco = new Banco();
    static Scanner teclado = new Scanner(System.in);
    static Gerente gerenteDoBanco = new Gerente("Will", "1234");

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== BANCO JAVA AVANCADO =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Consultar saldo");
            System.out.println("7 - Calcular tributos (Contas Correntes)");
            System.out.println("8 - Autenticar Gerente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = teclado.nextInt();

            if (opcao == 1) { criarConta(); } 
            else if (opcao == 2) { listarContas(); } 
            else if (opcao == 3) { depositar(); } 
            else if (opcao == 4) { sacar(); } 
            else if (opcao == 5) { transferir(); } 
            else if (opcao == 6) { consultarSaldo(); } 
            else if (opcao == 7) { calcularTributos(); } 
            else if (opcao == 8) { testarAutenticacao(); } 
            else if (opcao == 0) { System.out.println("Saindo..."); } 
            else { System.out.println("Opcao invalida!"); }
        }
    }

    public static void criarConta() {
        System.out.print("Digite o numero da conta: ");
        int num = teclado.nextInt();
        teclado.nextLine(); 
        
        System.out.print("Digite o nome do titular: ");
        String nome = teclado.nextLine();
        
        System.out.println("Tipo de conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupanca");
        System.out.print("Opcao: ");
        int tipo = teclado.nextInt();

        if (tipo == 1) {
            ContaCorrente cc = new ContaCorrente(num, nome);
            meuBanco.adicionar(cc);
            System.out.println("Conta corrente criada com sucesso.");
        } else if (tipo == 2) {
            ContaPoupanca cp = new ContaPoupanca(num, nome);
            meuBanco.adicionar(cp);
            System.out.println("Conta poupanca criada com sucesso.");
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    public static void listarContas() {
        ArrayList<Conta> lista = meuBanco.getLista();
        if (lista.size() == 0) {
            System.out.println("Nao tem contas cadastradas.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).mostrarDados();
            }
        }
    }

    public static void depositar() {
        System.out.print("Qual o numero da conta? ");
        int num = teclado.nextInt();
        Conta c = meuBanco.buscar(num);

        if (c != null) {
            System.out.print("Qual o valor para depositar? ");
            double valor = teclado.nextDouble();
            c.depositar(valor);
        } else {
            System.out.println("Essa conta nao existe.");
        }
    }

    public static void sacar() {
        System.out.print("Qual o numero da conta? ");
        int num = teclado.nextInt();
        Conta c = meuBanco.buscar(num);

        if (c != null) {
            System.out.print("Qual o valor do saque? ");
            double valor = teclado.nextDouble();
            c.sacar(valor);
        } else {
            System.out.println("Essa conta nao existe.");
        }
    }

    public static void transferir() {
        System.out.print("Numero da sua conta (origem): ");
        int numOrigem = teclado.nextInt();
        Conta origem = meuBanco.buscar(numOrigem);

        if (origem != null) {
            System.out.print("Numero da conta de destino: ");
            int numDestino = teclado.nextInt();
            Conta destino = meuBanco.buscar(numDestino);

            if (destino != null) {
                System.out.print("Qual valor quer transferir? ");
                double valor = teclado.nextDouble();
                origem.transferir(valor, destino);
            } else {
                System.out.println("Conta de destino nao encontrada.");
            }
        } else {
            System.out.println("Conta de origem nao encontrada.");
        }
    }

    public static void consultarSaldo() {
        System.out.print("Qual o numero da conta? ");
        int num = teclado.nextInt();
        Conta c = meuBanco.buscar(num);

        if (c != null) {
            System.out.println("O saldo atual eh: " + c.getSaldo());
        } else {
            System.out.println("Conta nao existe.");
        }
    }
    public static void calcularTributos() {
        CalculadoraDeImposto calc = new CalculadoraDeImposto();
        ArrayList<Conta> lista = meuBanco.getLista();

        for (int i = 0; i < lista.size(); i++) {
            Conta c = lista.get(i);
            
            if (c instanceof Tributavel) {
                Tributavel t = (Tributavel) c;
                calc.registrar(t);
            }
        }
        
        System.out.println("Total de tributos arrecadados: " + calc.getTotalImposto());
    }

    public static void testarAutenticacao() {
        teclado.nextLine(); 
        System.out.print("Digite a senha do gerente: ");
        String senhaDigitada = teclado.nextLine();

        if (gerenteDoBanco.autenticar(senhaDigitada)) {
            System.out.println("Acesso liberado! Bem-vindo, Gerente.");
        } else {
            System.out.println("Senha incorreta. Acesso negado.");
        }
    }
}