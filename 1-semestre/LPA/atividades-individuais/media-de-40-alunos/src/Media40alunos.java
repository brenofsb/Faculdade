import java.util.Scanner;

public class Media40alunos {
	public static void main(String[] args) {

		double nota1, nota2, nota3, media, somaMedias = 0, mediaGeral;
		int aprovado = 0, qntA = 40;

		Scanner input = new Scanner(System.in);


		for (int i = 0; i < qntA; i ++) {
			System.out.println("Aluno " + (i + 1));

			System.out.print("Digite a 1° nota: ");
			nota1 = input.nextDouble();

			System.out.print("Digite a 2° nota: ");
			nota2 = input.nextDouble();

			System.out.print("Digite a 3° nota: ");
			nota3 = input.nextDouble();

			media = (nota1 + nota2 + nota3) / 3;

			somaMedias += media;
			System.out.println("Média final: " + media);


			if (media >= 6) {
				System.out.println("Situação: Aprovado\n");
				aprovado++;
			} else if (media  <= 4) {
				System.out.println("Situação: Recuperação\n");
			} else {
				System.out.println("Situação: Reprovado\n");
			}
		}

		mediaGeral = somaMedias / qntA;

		System.out.println("Foram aprovados: " + aprovado);
		System.out.println("Média geral: " + mediaGeral);

		input.close();
	}
}