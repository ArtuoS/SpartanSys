package SpartanSys;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Testes {

	public static void main(String[] args) {

		Scanner inputSelecionar = new Scanner(System.in);

		System.out.print("[1] - Cadastrar \n" + "[2] - Consultar Cadastro\n -> ");
		byte selecionarOpcao = inputSelecionar.nextByte();

		switch (selecionarOpcao) {
		case 1:
			Scanner inputCadastro = new Scanner(System.in);

			double desconto = 0.0;
			double valorTotal = 0.0;
			final String hotelNome = "Quality Hotel";

			// NOME, CPF, RG, TELEFONE, FORMA DE PAGAMENTO

			System.out.print("Insira seu nome completo: ");
			String nomeCompleto = inputCadastro.nextLine();

			System.out.print("Insira seu CPF: ");
			String CPF = inputCadastro.nextLine();

			System.out.print("Insira seu RG: ");
			String RG = inputCadastro.nextLine();

			System.out.print("Insira seu telefone: ");
			String telefone = inputCadastro.nextLine();

			System.out.print("Insira a forma de pagamento" + "\n [0] = Cart�o de Cr�dito" + "\n [1] = Cart�o de D�bito"
					+ "\n [3] = Dinheiro" + "\n [4] = Bitcoin\n -> ");
			byte pagamento = inputCadastro.nextByte();

			while (pagamento != 0 && pagamento != 1 && pagamento != 2 && pagamento != 3 && pagamento != 4) {
				System.out.print("Insira a forma de pagamento" + "\n [0] = Cart�o de Cr�dito"
						+ "\n [1] = Cart�o de D�bito" + "\n [3] = Dinheiro" + "\n [4] = Bitcoin\n -> ");
				pagamento = inputCadastro.nextByte();
			}

			// PAGAMENTOS EM DINHEIRO E EM BITCOIN

			switch (pagamento) {
			case 3:
				desconto = 0.1;
				valorTotal = (double) (valorTotal - (valorTotal * desconto));
				break;
			case 4:
				desconto = 0.15;
				valorTotal = (double) (valorTotal - (valorTotal * desconto));
				break;
			}

			// QUARTOS DISPONIVEIS

			int quartoEconomico = 4; // diaria R$40
			int diariaEconomico = 40;
			int quartoExecutivo = 2; // diaria R$100
			int diariaExecutivo = 100;
			int suiteMaster = 1; // diaria R$350
			int diariaSuiteMaster = 350;
			final int quartosTotais = quartoEconomico + quartoExecutivo + suiteMaster;

			boolean isQuartoDisponivel = false;

			if (quartosTotais > 0) {
				isQuartoDisponivel = true;
				if (isQuartoDisponivel) {
					System.out.println(
							"Temos " + quartosTotais + " quartos dispon�veis: \n" + "N�mero de Quartos Econ�micos = [ "
									+ quartoEconomico + " ]\n" + "N�mero de Quartos Executivos = [ " + quartoExecutivo
									+ " ]\n" + "N�mero de Su�tes Master = [ " + suiteMaster + " ]");

					System.out.println("Em qual quarto o(a) Sr(a)." + nomeCompleto + " gostaria de se hospedar:\n");
					System.out.print("Para selecionar o 'Quarto Econ�mico', digite [ 1 ]\n"
							+ "Para selecionar o 'Quarto Executivo', digite [ 2 ]\n"
							+ "Para selecionar a 'Su�te Master', digite [ 3 ]\n -> ");
					byte quartoDesejado = inputCadastro.nextByte();

					switch (quartoDesejado) {
					case 1:
						System.out.println("Quarto Econ�mico selecionado!");
						System.out.println("A di�ria do Quarto Econ�mico � de: R$" + diariaEconomico
								+ ", voc� ir� ficar hospedado em nosso hotel por X dias e pagar� "); // JODA TIME

						break;
					case 2:
						System.out.println("Quarto Executivo selecionado!");
						System.out.println("A di�ria do Quarto Executivo � de: R$" + diariaExecutivo
								+ ", voc� ir� ficar hospedado em nosso hotel por X dias e pagar� "); // JODA TIME
						break;
					case 3:
						System.out.println("Su�te Master selecionada!");
						System.out.println("A di�ria da Su�te Master � de: R$" + diariaSuiteMaster
								+ ", voc� ir� ficar hospedado em nosso hotel por X dias e pagar� "); // JODA TIME
						break;
					}

				}
			} else {
				System.out.println("Sr(a)." + nomeCompleto + ", sinto lhe informar que a " + hotelNome
						+ " est� sem quartos dispon�veis.");
				while (!isQuartoDisponivel) {
					break;
				}
			}

			inputCadastro.close();
			break;

		case 2:
			System.out.println("A SER IMPLEMENTADO");
			break;
		}
	}

}
