public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int qtdComputadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[5]; // começa pequeno e cresce se precisar
        this.qtdComputadores = 0;
    }

    public void adicionarComputador(Computador pc) {
        if (qtdComputadores == computadores.length) {
            // redimensiona o array dobrando o tamanho
            Computador[] novoArray = new Computador[computadores.length * 2];
            for (int i = 0; i < computadores.length; i++) {
                novoArray[i] = computadores[i];
            }
            computadores = novoArray;
        }
        computadores[qtdComputadores] = pc;
        qtdComputadores++;
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < qtdComputadores; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public void mostrarInfoCliente() {
        System.out.println("===== Dados do Cliente =====");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Quantidade de computadores comprados: " + qtdComputadores);
        System.out.println("Total da compra: R$ " + calculaTotalCompra());

        System.out.println("\n===== Computadores Comprados =====");
        for (int i = 0; i < qtdComputadores; i++) {
            computadores[i].mostraPCConfigs();
            System.out.println("-----------------------------");
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public int getQtdComputadores() {
        return qtdComputadores;
    }
}