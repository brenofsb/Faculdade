import java.util.Scanner;

public class SistemaCafe {

	public static void main(String[] args) {

		// Variaveis
		double precoPedido, totalPedidos = 0, valorPago, troco, ong, ongTotal = 0, mediaDoacao;
		int pagamento, opcao, pedido = 0, cookie, qnt;
		boolean venConcl, continua = true;
		String cliente;

		// Scanner
		Scanner input = new Scanner(System.in);

		// Inicio
		System.out.print("Digite seu nome: ");
		cliente = input.nextLine();

		while (continua == true) {
			precoPedido = 0;
			cookie = 0;

			System.out.println("\n===== NOVO PEDIDO =====");

			do {
				System.out.print(
						"Qual item do menu voce prefere:\n" +
								"1- Cafe expresso - R$ 6,00\n" +
								"2- Cappucino - R$ 9,00\n" +
								"3- Pao de queijo - R$ 5,00\n" +
								"4- Cookie - R$ 12,00\n" +
								"0- Finalizar pedido\n\n" +
								": ");
				opcao = input.nextInt();

				switch (opcao) {
					case 1:
						System.out.print("\nQuantos cafés expressos voce deseja? ");
						qnt = input.nextInt();

						if (qnt > 0) {
							precoPedido = precoPedido + (6 * qnt);
						} else {
							System.out.println("Quantidade invalida!");
						}
						break;
					case 2:
						System.out.print("\nQuantos cappucinos voce deseja? ");
						qnt = input.nextInt();

						if (qnt > 0) {
							precoPedido = precoPedido + (9 * qnt);
						} else {
							System.out.println("Quantidade invalida!");
						}
						break;
					case 3:
						System.out.print("\nQuantos paes de queijo voce deseja? ");
						qnt = input.nextInt();
						if (qnt > 0) {
							precoPedido = precoPedido + (5 * qnt);
						} else {
							System.out.println("Quantidade invalida!");
						}
						break;
					case 4:
						System.out.print("\nQuantos cookies voce deseja? ");
						qnt = input.nextInt();
						if (qnt > 0) {
							precoPedido = precoPedido + (12 * qnt);
							cookie = cookie + qnt;
						} else {
							System.out.println("Quantidade invalida!");
						}
						break;
					case 0:
						break;
					default:
						System.out.println("\nOpcao invalida, tente novamente.\n");
						break;
				}

			} while (opcao != 0);

			if (precoPedido == 0 && opcao == 0) {
				System.out.println("Pedido cancelado.");
				System.out.println("\nDeseja tentar novamente?\n" +
						"1- Sim\n" +
						"2- Nao");
				opcao = input.nextInt();

				if (opcao == 2) {
					continua = false;
				}
			} else {
				if (cookie > 3) {
					precoPedido -= ((cookie - 3) * 2);
				}

				if (precoPedido > 150) {
					precoPedido *= 0.9;
				} else if (precoPedido >= 50 && precoPedido <= 150) {
					precoPedido *= 0.95;
				}

				System.out.println("\nO preco ficou por: R$ " + precoPedido +
						"\nNome do cliente: " + cliente);

				System.out.print(
					"\nDeseja doar 2% para a ONG Zero Fome?\n" +
						"1- Sim\n" +
						"2- Nao\n\n" +
						": "
				);
				opcao = input.nextInt();

				if (opcao == 1) {
					ong = precoPedido * 0.02;
					precoPedido += ong;
					ongTotal += ong;
					System.out.printf("Doação de: R$ %.2f adicionada%n", ong);
				}

				System.out.print(
					"\n===== FORMA DE PAGAMENTO =====\n" +
						"1- Pix\n" +
						"2- Cartao\n" +
						"3- Dinheiro\n\n" +
						": "
				);
				pagamento = input.nextInt();
				venConcl = false;

				while (!venConcl) {
					switch (pagamento) {
						case 1:
						case 2:
							venConcl = true;
							break;
						case 3:
							System.out.printf("Valor do pedido: R$ %.2f%n", precoPedido);
							System.out.print("Valor entregue pelo cliente: R$ ");
							valorPago = input.nextDouble();

							if (valorPago >= precoPedido) {
								troco = valorPago - precoPedido;
								System.out.println("Troco do cliente: R$ " + troco);
								venConcl = true;
							} else {
								System.out.println("Dinheiro insuficiente! Falta R$ " + (precoPedido - valorPago) +
										"\nTente novamente ou use outra forma de pagamento.");
							}
							break;
						default:
							System.out.println("Forma de pagamento invalida!");
							pagamento = input.nextInt();
					}
				}

				System.out.println("Venda concluida! O valor final ficou por: R$ " + precoPedido);
				totalPedidos += precoPedido;

				System.out.println("\nDeseja fazer outro pedido?\n" +
						"1- Sim\n" +
						"2- Nao");
				opcao = input.nextInt();

				pedido++;

				if (opcao == 2) {
					continua = false;
				}
			}

		}

		System.out.println("\n===== RELATORIO FINAL =====\n" +
				"Total arrecadado: R$ " + totalPedidos +
				"\nQuantidade de pedidos: " + pedido);

		if (pedido > 0) {
			mediaDoacao = (ongTotal / pedido);
			System.out.println("Valor medio arrecadado por doacao: R$ " + mediaDoacao);
		} else {
			System.out.println("Nenhuma doacao realizada.");
		}

		input.close();

	}

}