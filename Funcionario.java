public class Funcionario implements Autenticavel {
    protected String nome;
    protected String senha;

    public Funcionario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    public boolean autenticar(String senhaDigitada) {
        if (this.senha.equals(senhaDigitada)) {
            return true;
        } else {
            return false;
        }
    }
}