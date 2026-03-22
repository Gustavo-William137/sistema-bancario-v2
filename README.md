Nome:Gustavo william dos santos   
Disciplina:Projeto de programação
Matrícula:2639157
Professor:AMAURY NOGUEIRA NETO

EXPLICAÇÃO DA ARQUITETURA

Por que Conta é abstrata?
A classe `Conta` foi definida como abstrata (Abstração) porque ela representa apenas um conceito genérico no sistema. No mundo real, um cliente não abre uma "Conta" genérica, ele abre tipos específicos de conta (Corrente ou Poupança). Torná-la abstrata impede que ela seja instanciada diretamente, mas permite a reutilização de toda a lógica de saldo e operações básicas para as classes filhas através da Herança.

Por que Tributavel é interface?
A `Tributavel` é uma interface porque ela define um "comportamento" (a capacidade de pagar tributos) que pode ser assinado por diferentes classes que não necessariamente têm uma relação de herança direta. Por exemplo, uma `ContaCorrente` é tributável, mas amanhã o banco pode criar um `SeguroDeVida` que também seja. A interface garante que qualquer classe que a implemente terá o método `calcularTributo()`.

Como ocorre o polimorfismo no cálculo de imposto?
O polimorfismo ocorre no método `registrar(Tributavel t)` da classe `CalculadoraDeImposto`. Este método não precisa saber se está recebendo uma `ContaCorrente` ou qualquer outra classe; ele apenas exige que o objeto recebido cumpra o contrato da interface `Tributavel`. Assim, em tempo de execução, o Java sabe exatamente de qual objeto chamar o método `calcularTributo()`, permitindo tratar diferentes objetos de forma padronizada.

EXECUÇÃO DO SISTEMA
1. Abra o terminal e navegue até a pasta onde os arquivos `.java` estão salvos.
2. Compile todos os arquivos executando o comando: `javac *.java`
3. Execute a classe principal com o comando: `java Main`

EXEMPLO DE EXECUÇÃO
===== BANCO JAVA AVANCADO =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
7 - Calcular tributos (Contas Correntes)
8 - Autenticar Gerente
0 - Sair
Escolha uma opcao: 8

Digite a senha do gerente: 1234
Acesso liberado! Bem-vindo, Gerente.
