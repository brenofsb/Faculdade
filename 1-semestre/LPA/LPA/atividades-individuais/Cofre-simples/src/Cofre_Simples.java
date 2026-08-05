import java.util.Scanner;

public class Cofre_Simples
{
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int senha = 0;

		System.out.println("Qual e a senha do cofre");
		int senhareal = input.nextInt();

		while (senha != senhareal) {
            System.out.println("Digite a senha do cofre");
            senha = input.nextInt();
    
			if (senha != senhareal) {
				System.out.println("Senha incorreta, tente novamente!");
			}
		}

		if (senha == senhareal) {
			System.out.println("Acesso concedido!");
		}

	}
}
