import java.util.Scanner;

public class Simulador_tv {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] tvs = new int[5][3];
        int opcaotv;

        for (int i = 0; i < tvs.length; i++) {
            tvs[i][1] = 1;
        }

        do {
            System.out.println(" ==Qual TV vai controlar?== ");

            System.out
                    .println("1-TV 1\n" + "2-TV 2\n" + "3-TV 3\n" + "4-TV 4\n" + "5-TV 5\n" + "0-Encerrar o programa");
            System.out.print(": ");
            opcaotv = input.nextInt();

            if (opcaotv >= 1 && opcaotv <= 5) {
                controle(opcaotv, tvs);
            } else if (opcaotv != 0) {
                System.out.println("\nOpção indisponível! Tente novamente.\n");
            }
        } while (opcaotv != 0);

        input.close();
    }

    public static void statusgeral(int ntv, int[][] tvs) {
        System.out.println("\n===== TV " + ntv + " =====");

        if (tvs[ntv - 1][0] == 1) {
            System.out.println("Status: ligada");
        } else {
            System.out.println("Status: desligada");
        }
        
        System.out.println("Canal: " + tvs[ntv - 1][1]);
        System.out.println("Volume: " + tvs[ntv - 1][2]);
    }

    public static void controle(int ntv, int[][] tvs) {

        int opcao;
        do {
            statusgeral(ntv, tvs);

            System.out
                    .println("\n ==Controle== \n" + "1-Ligar/Desligar\n" + "2-Alterar canal\n" + "3-Aumentar o volume\n"
                            + "4-Diminuir o volume\n" + "0- Escolha outra TV");
            System.out.print(": ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    tvs[ntv - 1][0] = ligar(ntv, tvs);
                    break;
                case 2:
                    if (tvs[ntv - 1][0] == 1) {
                        System.out.println("\nCanais disponiveis: 1, 3, 5, 7 e 11");
                        System.out.print("Digite o numero do canal escolhido: ");
                        int c = input.nextInt();

                        if (alterar_canal(c) == 1) {
                            tvs[ntv - 1][1] = c;
                        } else {
                            System.out.println("\nEscolha um canal válido!");
                        }
                    } else {
                        System.out.println("\nLigue a TV primeiro!");
                    }
                    break;
                case 3:
                    if (tvs[ntv - 1][0] == 1) {
                        if (aumentar_volume(tvs[ntv - 1][2]) == 1) {
                            System.out.println("\nVolume máximo atingido.");
                        } else {
                            tvs[ntv - 1][2]++;
                        }
                    } else {
                        System.out.println("\nLigue a TV primeiro!\n");
                    }
                    break;
                case 4:
                    if (tvs[ntv - 1][0] == 1) {
                        if (diminuir_volume(tvs[ntv - 1][2]) == 1) {
                            System.out.println("\nVolume mínimo atingido.");
                        } else {
                            tvs[ntv - 1][2]--;
                        }
                    } else {
                        System.out.println("\nLigue a TV primeiro!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção indisponível! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static int ligar(int ntv, int[][] tvs) {
        if (tvs[ntv - 1][0] == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int alterar_canal(int c) {
        if (c == 1 || c == 3 || c == 5 || c == 7 || c == 11) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int aumentar_volume(int n) {
        if (n >= 100) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int diminuir_volume(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}