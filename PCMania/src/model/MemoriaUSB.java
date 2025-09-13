package model;
public class MemoriaUSB {
    private String nome;
    private int capacidade; // em GB

    public MemoriaUSB(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }
}