import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Cadastro do cliente
        System.out.println("=== Bem-vindo à PC Mania ===");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        // Array para armazenar os computadores da compra
        Computador[] pcsComprados = new Computador[10];
        int contador = 0;

        int opcao;
        do {
            System.out.println("\nEscolha a promoção desejada:");
            System.out.println("1 - Apple (R$184)");
            System.out.println("2 - Samsung (R$1418)");
            System.out.println("3 - Dell (R$5862)");
            System.out.println("0 - Finalizar compra");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            Computador pc = null;

            switch (opcao) {
                case 1:
                    pc = new Computador(
                            "Apple",
                            184,
                            new SistemaOperacional("macOS Sequoia", 64),
                            3
                    );
                    pc.addHardware(new HardwareBasico("Pentium Core i3", 2200));
                    pc.addHardware(new HardwareBasico("Memória RAM", 8));
                    pc.addHardware(new HardwareBasico("HD", 500));
                    pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
                    break;

                case 2:
                    pc = new Computador(
                            "Samsung",
                            1418,
                            new SistemaOperacional("Windows 8", 64),
                            3
                    );
                    pc.addHardware(new HardwareBasico("Pentium Core i5", 3370));
                    pc.addHardware(new HardwareBasico("Memória RAM", 16));
                    pc.addHardware(new HardwareBasico("HD", 1000));
                    pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
                    break;

                case 3:
                    pc = new Computador(
                            "Dell",
                            5862,
                            new SistemaOperacional("Windows 10", 64),
                            3
                    );
                    pc.addHardware(new HardwareBasico("Pentium Core i7", 4500));
                    pc.addHardware(new HardwareBasico("Memória RAM", 32));
                    pc.addHardware(new HardwareBasico("HD", 2000));
                    pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                    break;

                case 0:
                    System.out.println("Finalizando compra...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

            if (pc != null) {
                pcsComprados[contador] = pc;
                contador++;
            }

        } while (opcao != 0);

        // Mostrar informações do cliente e da compra
        System.out.println("\n===== RESUMO DA COMPRA =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        float total = 0;
        for (int i = 0; i < contador; i++) {
            pcsComprados[i].mostraPCConfigs();
            total += pcsComprados[i].getPreco();
        }

        System.out.println("TOTAL DA COMPRA: R$ " + total);

        ProcessarPedido.processar(pcsComprados, contador);

        sc.close();
    }
}
