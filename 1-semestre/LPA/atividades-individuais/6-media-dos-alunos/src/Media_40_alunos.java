import java.util.Scanner;

public class Media40alunos {
	public static void main(String[] args) {

		double nota1, nota2, nota3, mediaFinal, somaMedias = 0, mediaGeral;
		int aprovado = 0;

		Scanner input = new Scanner(System.in);


		for (int i = 0; i <= 39; i ++) {
			System.out.println("Aluno " + (i + 1));

			System.out.println("Digite a 1° nota");
			nota1 = input.nextDouble();

			System.out.println("Digite a 2° nota");
			nota2 = input.nextDouble();

			System.out.println("Digite a 3° nota");
			nota3 = input.nextDouble();

			mediaFinal = (nota1 + nota2 + nota3) / 3;

			somaMedias += mediaFinal;
			System.out.println("Média final: " + mediaFinal);


			if (mediaFinal >= 6) {
				System.out.println("Situação: Aprovado");
				aprovado++;
			} else if (mediaFinal  <= 4) {
				System.out.println("Situação: Recuperação");
			} else {
				System.out.println("Situação: Reprovado");
			}

		}
	}
}
