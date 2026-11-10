import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SmartTv sala = new SmartTv("sala");
        SmartTv quarto = new SmartTv("quarto");
        TV varanda = new TV("varanda");

        int opcao;

        do {
            System.out.print("==== MENU PRINCIPAL ====\n" +
                    "1- Sala\n" +
                    "2- Quarto\n" +
                    "3- Varanda\n" +
                    "0- Sair\n\n" +
                    "Escolha a TV que deseja usar: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    menuSmart(input, sala);
                    break;
                case 2:
                    menuSmart(input, quarto);
                    break;
                case 3:
                    menuTV(input, varanda);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public static void menuTV(Scanner input, TV tv) {
        int opcao;

        do {
            System.out.println("Nome da TV: " + tv.cNome());
            System.out.println("Status: " + (tv.cLigada() ? "Ligada" : "Desligada"));
            System.out.println("Canal atual: " + tv.cCanal());
            System.out.println("Volume atual: " + tv.cVolume());

            System.out.print("\n==== MENU TV ====\n" +
                    "1- Ligar/Desligar\n" +
                    "2- Alterar Canal\n" +
                    "3- Aumentar Volume\n" +
                    "4- Diminuir Volume\n" +
                    "0- Voltar\n\n" +
                    ": ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    tv.power();
                    break;
                case 2:
                    if (!tv.cLigada()) {
                        System.out.println("Ligue a TV primeiro");
                    } else {
                        System.out.print("Digite o canal desejado: ");
                        int canal = input.nextInt();
                        tv.altCanal(canal);
                    }
                    break;
                case 3:
                    tv.aumentarVol();
                    break;
                case 4:
                    tv.diminuirVol();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println();
        } while (opcao != 0);

        input.close();
    }

    public static void menuSmart(Scanner input, SmartTv tv) {
        int opcao;

        do {
            System.out.println("Nome da TV: " + tv.cNome());
            System.out.println("Status: " + (tv.cLigada() ? "Ligada" : "Desligada"));
            System.out.println("Canal atual: " + tv.cCanal());
            System.out.println("Volume atual: " + tv.cVolume());
            System.out.println("Modo atual: " + (tv.cModo() == 1 ? "TV" : "STREAMING"));
            System.out.println("Conectado: " + (tv.cConectado() ? "Sim" : "Não"));

            System.out.print("\n==== MENU SMART TV ====\n" +
                    "1- Ligar/Desligar\n" +
                    "2- Alterar Canal\n" +
                    "3- Aumentar Volume\n" +
                    "4- Diminuir Volume\n" +
                    "5- Conectar\n" +
                    "6- Desconectar\n" +
                    "7- Alterar Modo\n" +
                    "8- Alterar Login/Senha\n" +
                    "0- Voltar\n\n" +
                    "Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    tv.power();
                    break;
                case 2:
                    if (!tv.cLigada()) {
                        System.out.println("A TV está desligada.");
                    } else {
                        System.out.print("Digite o canal desejado: ");
                        int canal = input.nextInt();
                        tv.altCanal(canal);
                    }
                    break;
                case 3:
                    tv.aumentarVol();
                    break;
                case 4:
                    tv.diminuirVol();
                    break;
                case 5:
                    if (!tv.cLigada()) {
                        System.out.println("A TV está desligada.");
                    } else {
                        System.out.print("Digite o login: ");
                        String login = input.next();
                        System.out.print("Digite a senha: ");
                        String senha = input.next();
                        tv.conect(login, senha);
                    }
                    break;
                case 6:
                    tv.desconect();
                    break;
                case 7:
                    if (!tv.cLigada()) {
                        System.out.println("A TV está desligada.");
                    } else {
                        System.out.print("Digite o modo desejado (1 para TV, 2 para Streaming): ");
                        int modo = input.nextInt();
                        tv.altModo(modo);
                    }
                    break;
                case 8:
                    if (!tv.cLigada()) {
                        System.out.println("A TV está desligada.");
                    } else if (!tv.cConectado()) {
                        System.out.println("A TV não está conectada");
                    } else {
                        System.out.print("Digite o novo login: ");
                        String login = input.next();
                        System.out.print("Digite a nova senha: ");
                        String senha = input.next();
                        tv.altLogin(login);
                        tv.altSenha(senha);
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println();
        } while (opcao != 0);
    }
}