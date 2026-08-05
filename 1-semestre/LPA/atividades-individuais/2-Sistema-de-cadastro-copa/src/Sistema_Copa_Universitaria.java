 package Copa_universitaria;

import java.util.Scanner;

public class Sistema_Copa_Universitaria {

	// Scanner do sistema
	public static Scanner input = new Scanner(System.in);

	// Variaveis globais do sistema
	static final int quantSelecao = 5, quantJogador = 11;
	static boolean cadastradasS = false, cadastradosJ = false, pRegistradas = false, ativado = true;

	// Parte que o usuario vai acessar todas funcionalidades do sistema
	public static void main(String[] args) {
		String[] selecoes = new String[quantSelecao];
		String[][] jogadores = new String[quantSelecao][quantJogador];
		int[] pontos = new int[quantSelecao];
		int[][] golsJogadores = new int[quantSelecao][quantJogador];

		menuPrincipal(selecoes, jogadores, pontos, golsJogadores);

		System.out.println("\nFechando sistema...");
		input.close();
	}

	public static void menuPrincipal(String[] selecoes, String[][] jogadores, int[] pontos, int[][] golsJogadores) {

		int opcao;

		do {
			System.out.println("==== COPA UNIVERSITARIA - MENU ====");
			System.out.println("1 - Cadastrar selecoes\n" + "2 - Cadastrar jogadores\n"
					+ "3 - Buscar nomes das selecoes\n" + "4 - Buscar nomes dos jogadores\n"
					+ "5 - Registrar partidas\n" + "6 - Ver os resultados da competicao\n");
			System.out.print(": ");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				if (cadastradasS) {
					System.out.println("\nAs selecoes ja foram  cadastradas!\n");
				} else {
					cadastrarSelecoes(selecoes);
					cadastradasS = true;
				}
				break;
			case 2:
				if (!cadastradasS) {
					System.out.println("\nNao ha selecoes cadastradas!\n");
				} else if (cadastradosJ) {
					System.out.println("\nOs jogadores ja foram cadastrados!\n");
				} else {
					System.out.println("\n\n==== COPA UNIVERSITARIA - CADASTRO JOGADORES ====");

					for (int s = 0; s < quantSelecao; s++) {
						cadastrarJogadores(s, jogadores, selecoes);
					}

					cadastradosJ = true;
					System.out.println();
				}
				break;
			case 3:
				if (!cadastradasS) {
					System.out.println("\nNao ha selecoes cadastradas!\n");
				} else {
					buscaSelecao(selecoes);
				}
				break;
			case 4:
				if (!cadastradosJ) {
					System.out.println("\nNao ha jogadores cadastrados!\n");
				} else {
					buscaJogador(selecoes, jogadores);
				}
				break;

			case 5:
				if (!cadastradasS) {
					System.out.println("\nNao ha selecoes cadastradas!\n");
				} else if (!cadastradosJ) {
					System.out.println("\nNao ha jogadores cadastrados!\n");
				} else {
					registrarPartidas(selecoes, pontos, golsJogadores, jogadores);
					pRegistradas = true;

					System.out.println("\n");
				}
				break;
			case 6:
				if (!pRegistradas) {
					System.out.println("\nRegistre as partidas primeiro!\n");
				} else {
					menuResultados(selecoes, jogadores, pontos, golsJogadores);

					opcao = 0;
				}
				break;
			case 0:
				break;
			default:
				System.out.println("\nOpcao invalida! Tente novamente.\n");
			}

		} while (opcao != 0);

		System.out.println("\n");
	}

	// Cadastrar cada selecao na competicao
	public static void cadastrarSelecoes(String[] selecoes) {
		System.out.println("\n\n==== COPA UNIVERSITARIA - CADASTRO SELECOES ====");

		System.out.println("Digite o nome das selecoes que vao participar");
		for (int s = 0; s < quantSelecao; s++) {

			// Obriga o usuario a colocar um nome na selecao
			do {
				System.out.print((s + 1) + ": ");
				selecoes[s] = input.nextLine();

				if (selecoes[s].trim().isEmpty()) {
					System.out.println("\nDigite um nome para a selecao!\n");
				}
			} while (selecoes[s].trim().isEmpty());

		}
		System.out.println("\n");
	}

	// Cadastrar os jogadores de cada selecao
	public static void cadastrarJogadores(int numSelecao, String[][] jogadores, String[] selecoes) {
		System.out.println("  == " + selecoes[numSelecao] + " ==");
		for (int j = 0; j < quantJogador; j++) {

			// Obriga o usuario a dar um nome para o jogador
			do {
				System.out.print("Nome do jogador " + (j + 1) + ": ");
				jogadores[numSelecao][j] = input.nextLine();

				if (jogadores[numSelecao][j].trim().isEmpty()) {
					System.out.println("\nDigite um nome para o jogador primeiro!\n");
				}
			} while (jogadores[numSelecao][j].trim().isEmpty());

		}
		System.out.println();
	}

	// Registra tudo o que acontece nas partidas
	public static void registrarPartidas(String[] selecoes, int[] pontos, int[][] golsJogadores, String[][] jogadores) {

		System.out.println("\n\n==== COPA UNIVERSITARIA - REGISTRO DAS PARTIDAS ====\n");

		System.out.println("  == JOGOS DE IDA ==");
		for (int casa = 0; casa < quantSelecao; casa++) {
			for (int visitante = casa + 1; visitante < quantSelecao; visitante++) {
				registrarJogo(casa, visitante, selecoes, pontos, golsJogadores, jogadores);
			}
		}

		System.out.println("\n\n  == JOGOS DE VOLTA ==");
		for (int casa = 0; casa < quantSelecao; casa++) {
			for (int visitante = casa + 1; visitante < quantSelecao; visitante++) {
				registrarJogo(visitante, casa, selecoes, pontos, golsJogadores, jogadores);
			}
		}
	}

	public static void registrarJogo(int casa, int visitante, String[] selecoes, int[] pontos, int[][] golsJogadores,
			String[][] jogadores) {
		int golsCasa, golsVisitante;

		System.out.println("\n" + selecoes[casa] + " X " + selecoes[visitante]);

		do {
			System.out.print("Gols " + selecoes[casa] + ": ");
			golsCasa = input.nextInt();

			if (golsCasa < 0) {
				System.out.println("\nNao e permitido numeros negativos! Tente novamente.\n");
			}
		} while (golsCasa < 0);

		do {
			System.out.print("Gols " + selecoes[visitante] + ": ");
			golsVisitante = input.nextInt();

			if (golsVisitante < 0) {
				System.out.println("\nNao e permitido numeros negativos! Tente novamente.\n");
			}
		} while (golsVisitante < 0);

		registrarGols(casa, golsCasa, selecoes, jogadores, golsJogadores);

		registrarGols(visitante, golsVisitante, selecoes, jogadores, golsJogadores);

		if (golsCasa > golsVisitante) {
			pontos[casa] += 3;
			System.out.println("\n" + selecoes[casa] + " ganhou a partida (+3 pontos)");
		} else if (golsVisitante > golsCasa) {
			pontos[visitante] += 3;
			System.out.println("\n" + selecoes[visitante] + " ganhou a partida (+3 pontos)");
		} else {
			pontos[casa]++;
			pontos[visitante]++;
			System.out.println("\nEmpate (+1 ponto p/cada)");
		}
	}

	// Registra quem fez os gols das partidas
	public static void registrarGols(int selecao, int quantGols, String[] selecoes, String[][] jogadores,
			int[][] golsJogadores) {

		for (int gols = 0; gols < quantGols; gols++) {
			System.out.println("\nQuem fez o gol " + (gols + 1) + "  do(a) " + selecoes[selecao] + "?");

			System.out.println("0 - Gol contra");
			for (int jogador = 0; jogador < quantJogador; jogador++) {
				System.out.println((jogador + 1) + " - " + jogadores[selecao][jogador]);
			}

			int opcaojG;
			do {
				System.out.print(": ");
				opcaojG = input.nextInt();

			} while (opcaojG < 0 || opcaojG > quantJogador);

			if (opcaojG == 0) {
				continue;
			}

			opcaojG--;

			golsJogadores[selecao][opcaojG]++;
		}
	}

	public static void buscaSelecao(String[] selecoes) {

		int opcaoS;

		do {
			System.out.println("\n\n==== COPA UNIVERSITARIA - BUSCA SELECOES ====");
			System.out.println("1 - Buscar numero de inscricao\n2 - Buscar nome da selecao\n0 - Fechar busca\n");
			System.out.print(": ");
			opcaoS = input.nextInt();
			input.nextLine();

			switch (opcaoS) {
			case 1:
				System.out.print("\nDigite o nome da selecao: ");
				String nome = input.nextLine();

				int num = verNumInscricaoSelecao(nome, selecoes);

				if (num == -1) {
					System.out.println("\nSelecao nao encontrada");
				} else {
					System.out.println("\nNumero de inscricao do(a) " + nome + ": " + num);
				}

				break;
			case 2:
				System.out.print("\nDigite o numero de inscricao da selecao: ");
				num = input.nextInt();

				String selecao = verNomeSelecao(num, selecoes);

				if (selecao.equals("Invalido")) {
					System.out.println("\nNumero de inscricao invalido!");
				} else {
					System.out.println("\nNome da selecao: " + selecao);
				}
				break;
			case 0:
				break;
			default:
				System.out.println("\nOpcao invalida! Tente novamente.");
			}
		} while (opcaoS != 0);

		System.out.println("\n");
	}

	// Busca o numero de inscricao da selecao de acordo com o nome
	public static int verNumInscricaoSelecao(String nome, String[] selecoes) {
		for (int s = 0; s < quantSelecao; s++) {

			if (selecoes[s] != null && selecoes[s].equalsIgnoreCase(nome)) {
				return s + 1;
			}
		}

		return -1;
	}

	// Busca o nome da selecao de acordo com o numero de inscricao
	public static String verNomeSelecao(int num, String[] selecoes) {
		if (num < 1 || num > quantSelecao) {
			return "Invalido";
		}

		return selecoes[num - 1];
	}

	// Menu para as buscas relacionadas aos jogadores
	public static void buscaJogador(String[] selecoes, String[][] jogadores) {
		int opcaoJ;

		do {
			System.out.println("\n\n==== COPA UNIVERSITARIA - BUSCA JOGADORES ====");
			System.out.println("1 - Buscar numero de inscricao\n2 - Buscar nome do jogador\n0 - Cancelar busca\n");
			System.out.print(": ");
			opcaoJ = input.nextInt();
			input.nextLine();

			switch (opcaoJ) {
			case 1:
				System.out.print("\nDigite o nome da selecao: ");
				String nomeS = input.nextLine();

				int s = verNumInscricaoSelecao(nomeS, selecoes);

				if (s == -1) {
					System.out.println("\nSelecao nao encontrada!");
					break;
				}

				System.out.print("\nDigite o nome do jogador: ");
				String nomeJ = input.nextLine();

				int j = verNumInscricaoJogador(nomeS, nomeJ, selecoes, jogadores);

				if (j == -1) {
					System.out.println("\nJogador ou selecao nao encontrados!");
				} else {
					System.out.println("\nNumero da inscricao: " + j);
				}
				break;
			case 2:
				System.out.print("\nDigite o numero de inscricao da selecao: ");
				int numS = input.nextInt();

				System.out.print("\nDigite o numero de inscricao do jogador: ");
				int numJ = input.nextInt();

				String jogador = verNomeJogador(numS, numJ, jogadores);

				if (jogador.equals("Invalido")) {
					System.out.println("\nNumero de inscricao invalido!");
				} else {
					System.out.println("\nNome do jogador: " + jogador);
				}
				break;
			case 0:
				break;
			default:
				System.out.println("\nOpcao invalida! Tente novamente.");
			}
		} while (opcaoJ != 0);

		System.out.println("\n");
	}

	// Busca o numero de inscricao do jogador de acordo com o nome dele
	public static int verNumInscricaoJogador(String nomeS, String nomeJ, String[] selecoes, String[][] jogadores) {
		int s = verNumInscricaoSelecao(nomeS, selecoes);

		if (s == -1) {
			return -1;
		}

		for (int j = 0; j < quantJogador; j++) {
			if (jogadores[s - 1][j] != null && jogadores[s - 1][j].equalsIgnoreCase(nomeJ)) {
				return j + 1;
			}
		}

		return -1;
	}

	// Busca o nome do jogador de acordo com o numero de inscricao dele
	public static String verNomeJogador(int numS, int numJ, String[][] jogadores) {
		if (numS < 1 || numS > quantSelecao) {
			return "Invalido";
		}
		if (numJ < 1 || numJ > quantJogador) {
			return "Invalido";
		}
		if (jogadores[numS - 1][numJ - 1] == null) {
			return "Nao localizado";
		}

		return jogadores[numS - 1][numJ - 1];
	}

	// Menu dos resultados da competicao
	public static void menuResultados(String[] selecoes, String[][] jogadores, int[] pontos, int[][] golsJogadores) {

		int opcao;

		do {
			System.out.println("\n\n==== COPA UNIVERSITARIA - RESULTADOS ====");
			System.out.println("1 - Selecao campea\n" + "2 - Artilheiros da copa\n"
					+ "3 - % de jogadores com pelo menos 1 gol (por selecao)\n" + "4 - % de jogadores com mais de 5 gols\n"
					+ "5 - Desempenho das selecoes\n" + "6 - Desempenho dos jogadores\n"
					+ "7 - Voltar ao menu principal\n" + "\n8 - Ranking das selecoes (EXTRA)" + "\n0 - Fechar o sistema\n");
			System.out.print(": ");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				selecaoCampea(pontos, selecoes, golsJogadores);
				break;
			case 2:
				artilheirosCopa(selecoes, jogadores, golsJogadores);
				break;
			case 3:
				fezgol(selecoes, jogadores, golsJogadores);
				break;
			case 4:
				maisde5gols(selecoes, jogadores, golsJogadores);
				break;
			case 5:
				desempenhoS(selecoes, pontos, golsJogadores);
				break;
			case 6:
				desempenhoJ(selecoes, jogadores, golsJogadores);
				break;
			case 7:
				System.out.println("\n");
				menuPrincipal(selecoes, jogadores, pontos, golsJogadores);
				break;
			case 8:
				ranking(selecoes, pontos);
				break;
			case 0:
				ativado = false;
				break;
			default:
				System.out.println("\nOpcao invalida! Tente novamente.\n");
			}

		} while (opcao != 0);
	}

	// Mostra quem foi a selecao campea da competicao
	public static void selecaoCampea(int[] pontos, String[] selecoes, int[][] golsJogadores) {
		int campeao = 0;

		for (int s = 1; s < quantSelecao; s++) {
			if (pontos[s] > pontos[campeao]) {
				campeao = s;
			} else if (pontos[s] == pontos[campeao]) {
				int golsS = verGolsSelecao(selecoes[s], selecoes, golsJogadores);
				int golsCampeao = verGolsSelecao(selecoes[campeao], selecoes, golsJogadores);

				if (golsS > golsCampeao) {
					campeao = s;
				} else if (golsS == golsCampeao) {

				}
			}
		}

		System.out.println("\n==== CAMPEAO DA COPA ====");
		System.out.println("Selecao: " + selecoes[campeao]);
		System.out.println("Numero de inscricao: " + (campeao + 1));
		System.out.println("Numero de gols marcados: " + verGolsSelecao(selecoes[campeao], selecoes, golsJogadores));
		System.out.println("Pontos: " + pontos[campeao]);
	}

	// Calcula o total de gols dos jogadores de uma selecao
	public static int totalGolsS(int s, int[][] golsJogadores) {
		int gols = 0;

		for (int j = 0; j < quantJogador; j++) {
			gols += golsJogadores[s][j];
		}

		return gols;
	}

	// Mostra os jogadores que mais fizeram gol
	public static void artilheirosCopa(String[] selecoes, String[][] jogadores, int[][] golsJogadores) {
		int maisGols = 0;

		for (int s = 0; s < quantSelecao; s++) {
			for (int j = 0; j < quantJogador; j++) {
				int gols = verGolsJogador(selecoes[s], jogadores[s][j], selecoes, jogadores, golsJogadores);
				
				if (gols > maisGols) {
					maisGols = gols;
				}
			}
		}

		System.out.println("\n==== ARTILHEIRO(S) DA COPA ====");

		for (int s = 0; s < quantSelecao; s++) {
			for (int j = 0; j < quantJogador; j++) {
				int gols = verGolsJogador(selecoes[s], jogadores[s][j], selecoes, jogadores, golsJogadores);
				
				if (gols == maisGols) {
					int totalJogos = quantSelecao * (quantSelecao - 1);
					double media = (double) gols / totalJogos;

					System.out.println("\nJogador: " + jogadores[s][j] + "\nSelecao: " + selecoes[s]
							+ "\nQuantidade de gols: " + gols + "\nMedia de gols por partida: " + media);
				}
			}
		}
	}

	// Calcula o percentual dos jogares que fizeram gol
	public static void fezgol(String[] selecoes, String[][] jogadores, int[][] golsJogadores) {
		System.out.print("\nDigite o nome da selecao: ");
		String nomeS = input.nextLine();

		int s = verNumInscricaoSelecao(nomeS, selecoes);

		if (s == -1) {
			System.out.println("\nSelecao nao encontrada!\n");
			return;
		}

		int idx = s - 1;

		System.out.println("\n==== JOGADORES DE " + selecoes[idx].toUpperCase() + " COM PELO MENOS 1 GOL ====");

		int fezgol = 0;

		for (int j = 0; j < quantJogador; j++) {
			if (golsJogadores[idx][j] > 0) {
				fezgol++;

				System.out.println("Jogador: " + jogadores[idx][j]);
			}
		}

		double percentual = (fezgol * 100.0) / quantJogador;

		System.out.printf("\nPercentual que representa esses jogadores: %.2f%%\n", percentual);
	}

	// Calcula o percentutal dos jogares que fez mais que 5 gols
	public static void maisde5gols(String[] selecoes, String[][] jogadores, int[][] golsJogadores) {
		System.out.println("\n==== JOGADORES COM MAIS DE 5 GOLS ====");

		int maisque5 = 0;
		for (int s = 0; s < quantSelecao; s++) {
			for (int j = 0; j < quantJogador; j++) {
				if (golsJogadores[s][j] > 5) {
					maisque5++;

					System.out.println("Jogador: " + jogadores[s][j] + "\nSelecao: " + selecoes[s]
							+ "\nQuantidade gols: " + golsJogadores[s][j]);
				}
			}
		}

		int totalJ = quantSelecao * quantJogador;
		double percentual = (maisque5 * 100.0) / totalJ;

		System.out.printf("\nPercentual que representa esses jogadores: %.2f%%\n", percentual);
	}

	// Exibe o desempenho de todas as selecoes
	public static void desempenhoS(String[] selecoes, int[] pontos, int[][] golsJogadores) {
		System.out.println("\n==== DESEMPENHO DAS SELECOES ====");

		for (int s = 0; s < quantSelecao; s++) {
			int gols = verGolsSelecao(selecoes[s], selecoes, golsJogadores);
			int totalJogos = quantSelecao * (quantSelecao - 1);
			double media = (double) gols / totalJogos;

			System.out.println("Selecao: " + selecoes[s] + "\nQuantidade gols: " + gols
					+ "\nMedia de gols por partida: " + media + "\nPontos: " + pontos[s]);
		}
	}

	// Exibe o desempenho de todos os jogadores
	public static void desempenhoJ(String[] selecoes, String[][] jogadores, int[][] golsJogadores) {
		System.out.println("\n==== DESEMPENHO DOS JOGADORES ====");

		for (int s = 0; s < quantSelecao; s++) {
			System.out.println("  == " + selecoes[s] + " ==");

			for (int j = 0; j < quantJogador; j++) {
				int gols = verGolsJogador(selecoes[s], jogadores[s][j], selecoes, jogadores, golsJogadores);
				System.out.println(
						"Nome do jogador: " + jogadores[s][j] + "\n Quantidade de gols: " + gols);
			}
		}
	}
	
	public static void ranking(String [] selecoes, int [] pontos) {
		String [] rankN = new String[quantSelecao];
		int [] rankP = new int [quantSelecao];
		
		for (int s = 0; s < quantSelecao; s++) {
			rankN[s] = selecoes[s];
			rankP[s] = pontos[s];
		}
		
		for (int s = 0; s < quantSelecao; s++) {
			for (int j = 0; j < quantSelecao - 1 - s; j++) {
				if (rankP[j] < rankP[j + 1]) {
					int ponto = rankP[j];
					rankP[j] = rankP[j + 1];
					rankP[j + 1] = ponto;
					
					String nome = rankN[j];
					rankN[j] = rankN[j + 1];
					rankN[j + 1] = nome;
				}
			}
		}
		
		System.out.println("\n==== RANKING DAS SELECOES ====");
		for (int s = 0; s < quantSelecao; s++) {
			System.out.println((s + 1) + "º - " + rankN[s] + " | Pontos: " + rankP[s]);
		}
	}

	public static int verGolsSelecao(String nomeS, String[] selecoes, int[][] golsJogadores) {
		int s = verNumInscricaoSelecao(nomeS, selecoes);
		if (s == -1) {
			return -1;
		}

		return totalGolsS(s - 1, golsJogadores);
	}

	public static int verGolsJogador(String nomeS, String nomeJ, String[] selecoes, String[][] jogadores,
			int[][] golsJogadores) {
		int s = verNumInscricaoSelecao(nomeS, selecoes);
		if (s == -1) {
			return -1;
		}

		int j = verNumInscricaoJogador(nomeS, nomeJ, selecoes, jogadores);
		if (j == -1) {
			return -1;
		}

		return golsJogadores[s - 1][j - 1];
	}

}
