package SpartanSys;

import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SpartanSys {

	public static void main(String[] args) {

		Scanner inputSelecionar = new Scanner(System.in); // input para selecionar cadastrar ou consultar novo cliente
		Scanner input = new Scanner(System.in); // input dos dias/mes/anos de entrada e saida
		Calendar data = Calendar.getInstance();

		int cadastrarNovamente = 0;
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

		System.out.print(" [1] - Cadastrar \n" + " [2] - Informa��es sobre o Hotel\n -> ");
		byte selecionarOpcao = inputSelecionar.nextByte();
		while (selecionarOpcao < 1 || selecionarOpcao > 2) {
			System.out.println("\nTENTE NOVAMENTE\n");
			System.out.print("[1] - Cadastrar \n" + "[2] - Informa�oes sobre o Hotel\n -> ");
			selecionarOpcao = inputSelecionar.nextByte();
		}
		switch (selecionarOpcao) {
		case 1:
			Scanner inputCadastro = new Scanner(System.in);

			// -------------------------------------
			String nomeCompleto;
			String CPF;
			String RG;
			int pagamento;

			// -------------------------------------

			// -------------------------------------
			long diasHospedado;
			int inputDiaEntrada;
			int inputMesEntrada;
			int inputAnoEntrada;
			int inputDiaSaida;
			int inputMesSaida;
			int inputAnoSaida;
			LocalDate dataEntrada;
			LocalDate dataSaida;
			// -------------------------------------

			// -------------------------------------
			int quartoEconomico = 12;
			int diariaEconomico = 40;
			int quartoExecutivo = 4;
			int diariaExecutivo = 100;
			int suiteMaster = 1;
			int diariaSuiteMaster = 350;
			final int quartosTotais = quartoEconomico + quartoExecutivo + suiteMaster;
			int quartoDesejado;
			String quarto = "Nenhum";
			boolean isQuartoDisponivel = false;
			// -------------------------------------

			// -------------------------------------
			String formaPagamento = " ";
			double desconto = 1.0;
			double valorTotal = 0.0;
			double cotacaoBTC = 0.00002;
			final String hotelNome = "Quality Hotel";
			// -------------------------------------

			// NOME, CPF, RG, FORMA DE PAGAMENTO

			while (cadastrarNovamente == 0) {

				System.out.print("\nInsira seu nome completo: ");
				nomeCompleto = inputCadastro.nextLine();

				System.out.print("Insira seu CPF: ");
				CPF = inputCadastro.nextLine();

				System.out.print("Insira seu RG: ");
				RG = inputCadastro.nextLine();

				System.out.print("\nInsira a forma de pagamento" + "\n [0] = Cart�o de Cr�dito"
						+ "\n [1] = Cart�o de D�bito" + "\n [2] = Dinheiro" + "\n [3] = Bitcoin\n -> ");
				pagamento = inputCadastro.nextInt();
				System.out.println();

				while (pagamento != 0 && pagamento != 1 && pagamento != 2 && pagamento != 3 && pagamento != 4) {
					System.out.print("\nInsira a forma de pagamento" + "\n [0] = Cart�o de Cr�dito"
							+ "\n [1] = Cart�o de D�bito" + "\n [2] = Dinheiro" + "\n [3] = Bitcoin\n -> ");
					pagamento = inputCadastro.nextInt();
					System.out.println();
				}

				// PAGAMENTOS EM DINHEIRO E EM BITCOIN

				switch (pagamento) {
				case 0:
					desconto = 1.0;
					formaPagamento = "Cart�o de Cr�dito";
					break;
				case 1:
					desconto = 1.0;
					formaPagamento = "Cart�o de D�bito";
					break;
				case 2:
					desconto = 0.1;
					formaPagamento = "Dinheiro";
					break;
				case 3:
					desconto = 0.15;
					formaPagamento = "Bitcoin";
					break;
				}

				// QUARTOS DISPONIVEIS

				if (quartosTotais > 0) {
					isQuartoDisponivel = true;
					if (isQuartoDisponivel) {
						System.out.println("Temos " + quartosTotais + " quartos dispon�veis: \n"
								+ "N�mero de Quartos Econ�micos = [ " + quartoEconomico + " ]\n"
								+ "N�mero de Quartos Executivos = [ " + quartoExecutivo + " ]\n"
								+ "N�mero de Su�tes Master = [ " + suiteMaster + " ]");

						System.out.println("Em qual quarto o(a) Sr(a)." + nomeCompleto + " gostaria de se hospedar:\n");
						System.out.print("Para selecionar o 'Quarto Econ�mico', digite [ 1 ]\n"
								+ "Para selecionar o 'Quarto Executivo', digite [ 2 ]\n"
								+ "Para selecionar a 'Su�te Master', digite [ 3 ]\n -> ");
						quartoDesejado = inputCadastro.nextInt();

						while (quartoDesejado != 1 && quartoDesejado != 2 && quartoDesejado != 3) {
							System.out.print("Para selecionar o 'Quarto Econ�mico', digite [ 1 ]\n"
									+ "Para selecionar o 'Quarto Executivo', digite [ 2 ]\n"
									+ "Para selecionar a 'Su�te Master', digite [ 3 ]\n -> ");
							quartoDesejado = inputCadastro.nextInt();
						}

						System.out.println("....................");

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

						while (inputDiaEntrada <= 0 || inputDiaEntrada > 31 || inputMesEntrada <= 0
								|| inputMesEntrada > 12 || inputDiaSaida <= 0 // 31
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
							quartoEconomico--;
							quarto = "Quarto Econ�mico";
							break;
						case 2:
							valorTotal = diasHospedado * diariaExecutivo;
							quartoExecutivo--;
							quarto = "Quarto Executivo";
							break;
						case 3:
							valorTotal = diasHospedado * diariaSuiteMaster;
							quarto = "Su�te Master";
							suiteMaster--;
							break;
						}

						valorTotal = valorTotal - (valorTotal * desconto);

						System.out.println("Voc� ficar� " + diasHospedado + " dias hospedado no " + hotelNome
								+ " e pagar� um total de R$" + valorTotal);
						System.out.println("\n....................");
						System.out.println("Deseja fazer outro cadastro: \n[0] = Sim" + "\n[1] = N�o");
						cadastrarNovamente = inputSelecionar.nextInt();
					}
				} else {
					System.out.println("Sr(a)." + nomeCompleto + ", sinto lhe informar que a " + hotelNome
							+ " est� sem quartos dispon�veis.");
				}
				inputCadastro.nextLine();
				if (cadastrarNovamente == 1) {
					System.out.println("+-----------------------------+");
					System.out.println("| NOME " + nomeCompleto);
					System.out.println("| CPF " + CPF);
					System.out.println("| RG " + RG);
					System.out.println("| QUARTO " + quarto);
					if (pagamento == 3) {
						System.out.println("| FORMA DE PAGAMENTO " + formaPagamento + " | R$1.00 = 0.00002 BTC | ");
						valorTotal *= cotacaoBTC;
						System.out.println("| TOTAL " + valorTotal + "BTC");
					} else {
						System.out.println("| FORMA DE PAGAMENTO " + formaPagamento);
						System.out.println("| TOTAL R$" + valorTotal);
					}
					System.out.println("+-----------------------------+");
					System.out.println();
				}
			}

			inputCadastro.close();
			inputSelecionar.close();
			input.close();

			break;

		case 2:
			System.out.println("--------------------------------");
			System.out.println("Localiza��o: ITACAR� - BA");
			System.out.println("Rua Augusta, 101");
			System.out.println("CEP: 45520-000");
			System.out.println("TEL: 4002-8922");
			System.out.println("--------------------------------");
			break;
		}

	}
}
