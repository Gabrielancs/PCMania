package controller;
import model.Computador;

public class ProcessarPedido {
    
    public void processar(Computador[] lista, int qtd) {
        System.out.println("Pedido enviado...");
        System.out.println("Quantidade de computadores no pedido: " + qtd);
        
        // Mostra informações dos computadores processados
        for (int i = 0; i < qtd; i++) {
            if (lista[i] != null) {
                System.out.println("------------------------------");
                System.out.println("Computador " + (i + 1) + ": " + lista[i].getMarca());
                lista[i].mostraPCConfigs();
                System.out.println("------------------------------");
            }
        }
    }
}