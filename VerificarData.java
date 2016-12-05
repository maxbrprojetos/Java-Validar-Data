import java.util.Scanner;

public class VerificarData {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Data data = new Data();
		System.out.println("Sistema de Verificação de Dada.");
		System.out.println("Digite o dia:");
		System.out.print("R:");
		data.dia = teclado.nextInt();

		System.out.println("Digite o mês: ");
		System.out.print("R:");
		data.mes = teclado.nextInt();

		System.out.println("Digite o ano:");
		System.out.print("R:");
		data.ano = teclado.nextInt();

		if (data.validarData() == true) {
			System.out.println("Data: " + data.formatada());

		} else {
			System.out.println("Data invalida");
		}

	}

}
