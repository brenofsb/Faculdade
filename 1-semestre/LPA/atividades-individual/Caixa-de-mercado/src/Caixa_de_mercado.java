import java.util.Scanner;

public class Caixa_de_mercado
{
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int i = 1, codProduto;
		double vProduto, vCompra = 0;

		do {
			System.out.print("Digite o código do " + i + "° produto ou 0 para encerrar: ");
			codProduto = input.nextInt();

			switch (codProduto) {
			case 1, 2, 3, 4:
				System.out.println("Seu produto é um alimento perecível.");
				break;
			case 5, 6:
				System.out.println("Seu produto é um tipo de vestuário.");
				break;
			case 7:
				System.out.println("Seu produto é um item de higiene pessoal.");
				break;
			case 0:
				break;
			default:
				System.out.println("Código inválido, portanto não tem categoria.");
				break;
			}
			
			if (codProduto == 0) {
			    break;
			}
			
			if (codProduto <= 4 && codProduto > 0) {
			    System.out.println("Valor adicionado");
				vProduto = 8.75;
				vCompra += vProduto;
			}

			if (codProduto <= 6 && codProduto > 4) {
				System.out.println("Valor adicionado");
				vProduto = 69.90;
				vCompra += vProduto;
			}

			if (codProduto == 7) {
				System.out.println("Valor adicionado");
				vProduto = 4.90;
				vCompra += vProduto;
			}
			
			i++;                    

		} while (codProduto != 0);

		System.out.println("O valor total da compra ficou por: R$ " + vCompra);

	}
}
