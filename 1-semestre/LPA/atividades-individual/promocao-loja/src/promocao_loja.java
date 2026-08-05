import java.util.Scanner;

public class promocao_loja {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String categoria;
		double vTotal = 300;

		System.out.println("Qual a sua categoria?");
		categoria = input.next().toUpperCase();

		switch (categoria) {
		case "VIP":
			vTotal *= 0.8;
			break;
		case "COMUM":
			vTotal *= 0.9;
		case "NOVO":
			vTotal *= 0.95;
		}

		System.out.println("O valor da compra ficou por: R$ " + vTotal);

		input.close();
	}
}
