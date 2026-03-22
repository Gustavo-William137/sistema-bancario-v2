public abstract class Conta {
    private int numero;
    private String titular;
    protected double saldo;

    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
        System.out.println("Deposito realizado.");
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            System.out.println("Saque realizado.");
        } else {
            System.out.println("Erro: Saldo insuficiente!"); 
        }
    }

    public void transferir(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            destino.saldo = destino.saldo + valor; 
            System.out.println("Transferencia realizada com sucesso.");
        } else {
            System.out.println("Erro: Nao tem saldo para transferir.");
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void mostrarDados() {
        System.out.println("Numero: " + this.numero + " | Titular: " + this.titular + " | Saldo: " + this.saldo);
    }
}