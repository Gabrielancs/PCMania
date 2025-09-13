package model;
public class Computador {
    private String marca;
    private float preco;
    private SistemaOperacional sistema;
    private HardwareBasico[] hardwares;
    private int qtdHardwares;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, SistemaOperacional sistema, int limiteHardwares, HardwareBasico[] hardwares) {
        this.marca = marca;
        this.preco = preco;
        this.sistema = sistema;
        this.hardwares = hardwares;
        this.qtdHardwares = hardwares.length;
        this.memoriaUSB = null; // inicialmente sem USB
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);
        System.out.println();

        System.out.println("---- Sistema Operacional ----");
        System.out.println("Nome: " + sistema.getNome() + " | Tipo: " + sistema.getTipo() + " bits");
        System.out.println();

        System.out.println("---- Hardwares ----");
        for (int i = 0; i < qtdHardwares; i++) {
            System.out.println(hardwares[i].getNome() + " - " + hardwares[i].getCapacidade());
        }
        System.out.println();

        if (memoriaUSB != null) {
            System.out.println("---- Memória USB ----");
            System.out.println(memoriaUSB.getNome() + " - " + memoriaUSB.getCapacidade() + "Gb");
        } else {
            System.out.println("Sem dispositivo USB incluso.");
        }
    }

    // Getters
    public float getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }

    public SistemaOperacional getSistema() {
        return sistema;
    }

    public HardwareBasico[] getHardwares() {
        return hardwares;
    }

    public MemoriaUSB getMemoriaUSB() {
        return memoriaUSB;
    }
}