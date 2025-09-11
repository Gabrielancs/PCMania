public class Computador {
    private String marca;
    private float preco;
    private SistemaOperacional sistema;
    private HardwareBasico[] hardwares;
    private int qtdHardwares;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, SistemaOperacional sistema, int limiteHardwares) {
        this.marca = marca;
        this.preco = preco;
        this.sistema = sistema;
        this.hardwares = new HardwareBasico[limiteHardwares];
        this.qtdHardwares = 0;
        this.memoriaUSB = null; // inicialmente sem USB
    }

    public boolean addHardware(HardwareBasico hw) {
        if (qtdHardwares < hardwares.length) {
            hardwares[qtdHardwares] = hw;
            qtdHardwares++;
            return true;
        } else {
            System.out.println("Não é possível adicionar mais hardware a este computador.");
            return false;
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);

        System.out.println("---- Sistema Operacional ----");
        System.out.println("Nome: " + sistema.getNome() + " | Tipo: " + sistema.getTipo() + " bits");

        System.out.println("---- Hardwares ----");
        for (int i = 0; i < qtdHardwares; i++) {
            System.out.println(hardwares[i].getNome() + " - " + hardwares[i].getCapacidade());
        }

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