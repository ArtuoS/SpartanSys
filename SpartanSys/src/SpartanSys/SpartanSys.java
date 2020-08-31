package SpartanSys;

import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SpartanSys {

	public static void main(String[] args) {

		Scanner inputSelecionar = new Scanner(System.in); // input para selecionar cadastrar ou consultar novo
															// cliente
		Scanner input = new Scanner(System.in); // input dos dias/mes/anos de entrada e saida

		Calendar data = Calendar.getInstance();

		int hora = data.get(Calendar.HOUR_OF_DAY);

		if (hora >= 6 && hora <= 12) {
			System.out.println("+---------------------+");
			System.out.println("|                     |");
			System.out.println("|       BOA DIA       |");
			System.out.println("|                     |");
			System.out.println("+---------------------+");
			System.out.println();
		} else if (hora > 12 && hora <= 18) {
			System.out.println("+---------------------+");
			System.out.println("|                     |");
			System.out.println("|      BOA TARDE      |");
			System.out.println("|                     |");
			System.out.println("+---------------------+");
			System.out.println();
		} else {
			System.out.println("+---------------------+");
			System.out.println("|                     |");
			System.out.println("|      BOA NOITE      |");
			System.out.println("|                     |");
			System.out.println("+---------------------+");
			System.out.println();
		}

		System.out.print("[1] - Cadastrar \n" + "[2] - Consultar Cadastro\n -> ");
		byte selecionarOpcao = inputSelecionar.nextByte();

		switch (selecionarOpcao) {
		case 1:
			Scanner inputCadastro = new Scanner(System.in);

			double desconto = 0.0;
			double valorTotal = 0.0;
			final String hotelNome = "Quality Hotel";

			// NOME, CPF, RG, FORMA DE PAGAMENTO

			System.out.print("Insira seu nome completo: ");
			String nomeCompleto = inputCadastro.nextLine();

			System.out.print("Insira seu CPF: ");
			String CPF = inputCadastro.nextLine();

			System.out.print("Insira seu RG: ");
			String RG = inputCadastro.nextLine();

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

					long diasHospedado;
					int inputDiaEntrada;
					int inputMesEntrada;
					int inputAnoEntrada;
					int inputDiaSaida;
					int inputMesSaida;
					int inputAnoSaida;
					LocalDate dataEntrada;
					LocalDate dataSaida;

					System.out.println("Quarto Econ�mico selecionado!");
					System.out.println("A di�ria do Quarto Econ�mico � de: R$" + diariaEconomico);

					System.out.println("....................\n");

					System.out.print("Dia da entrada: ");
					inputDiaEntrada = input.nextInt();

					System.out.print("M�s da entrada: ");
					inputMesEntrada = input.nextInt();

					System.out.print("Ano da entrada: ");
					inputAnoEntrada = input.nextInt();

					System.out.println();

					System.out.print("Dia da sa�da: ");
					inputDiaSaida = input.nextInt();

					System.out.print("M�s da sa�da: ");
					inputMesSaida = input.nextInt();

					System.out.print("Ano da sa�da: ");
					inputAnoSaida = input.nextInt();

					while (inputDiaEntrada <= 0 || inputDiaEntrada > 31 || inputMesEntrada <= 0 || inputMesEntrada > 12
							|| inputDiaSaida <= 0 // 31
							|| inputDiaSaida > 31 || inputMesSaida <= 0 || inputMesSaida > 12
							|| inputAnoEntrada > inputAnoSaida) {

						System.out.println("....................");

						System.out.println("Insira uma data v�lida!");

						System.out.print("Dia da entrada: ");
						inputDiaEntrada = input.nextInt();

						System.out.print("M�s da entrada: ");
						inputMesEntrada = input.nextInt();

						System.out.print("Ano da entrada: ");
						inputAnoEntrada = input.nextInt();

						System.out.println();

						System.out.print("Dia da sa�da: ");
						inputDiaSaida = input.nextInt();

						System.out.print("M�s da sa�da: ");
						inputMesSaida = input.nextInt();

						System.out.print("Ano da sa�da: ");
						inputAnoSaida = input.nextInt();

						System.out.println("....................");
					}

					dataEntrada = LocalDate.of(inputAnoEntrada, inputMesEntrada, inputDiaEntrada);
					dataSaida = LocalDate.of(inputAnoSaida, inputMesSaida, inputDiaSaida);

					diasHospedado = ChronoUnit.DAYS.between(dataEntrada, dataSaida);

					System.out.println();

					switch (quartoDesejado) {
					case 1:
						valorTotal = diasHospedado * diariaEconomico;
						break;
					case 2:
						valorTotal = diasHospedado * diariaExecutivo;
						break;
					case 3:
						valorTotal = diasHospedado * diariaSuiteMaster;
						break;
					}
					System.out.println("Voc� ficar� " + diasHospedado + " dias hospedado no " + hotelNome
							+ " e pagar� um total de R$" + valorTotal);
					System.out.println("\n....................");
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
