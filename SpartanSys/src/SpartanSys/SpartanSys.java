package SpartanSys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.awt.List;

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

		System.out.print(" [1] - Cadastrar \n" + " [2] - Informações sobre o Hotel\n -> ");
		byte selecionarOpcao = inputSelecionar.nextByte();
		while (selecionarOpcao < 1 || selecionarOpcao > 2) {
			System.out.println("\nTENTE NOVAMENTE\n");
			System.out.print("[1] - Cadastrar \n" + "[2] - Informaçoes sobre o Hotel\n -> ");
			selecionarOpcao = inputSelecionar.nextByte();
		}

		// -------------------------------------
		// VÁRIAVEIS E COISAS ÚTEIS DO CÓDIGO
		// -------------------------------------
		String nomeCompleto = "";
		ArrayList<String> arrayNomeCompleto = new ArrayList<String>();

		String CPF = "";
		ArrayList<String> arrayCPF = new ArrayList<String>();

		String RG = "";
		ArrayList<String> arrayRG = new ArrayList<String>();

		int pagamento = 0;
		ArrayList<Integer> arrayPagamento = new ArrayList<Integer>();

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
		ArrayList<String> arrayQuarto = new ArrayList<String>();

		boolean isQuartoDisponivel = false;
		// -------------------------------------

		// -------------------------------------
		String formaPagamento = "";
		ArrayList<String> arrayFormaPagamento = new ArrayList<String>();

		double desconto = 1.0;
		double valorTotal = 1.0;
		ArrayList<Double> arrayValorTotal = new ArrayList<Double>();

		double cotacaoBTC = 0.00002;
		final String hotelNome = "Quality Hotel";
		// -------------------------------------

		switch (selecionarOpcao) {
		case 1:
			Scanner inputCadastro = new Scanner(System.in);

			// NOME, CPF, RG, FORMA DE PAGAMENTO

			while (cadastrarNovamente == 0) {

				System.out.print("\nInsira seu nome completo: ");
				nomeCompleto = inputCadastro.nextLine();
				arrayNomeCompleto.add(nomeCompleto);

				System.out.print("Insira seu CPF: ");
				CPF = inputCadastro.nextLine();
				arrayCPF.add(CPF);

				System.out.print("Insira seu RG: ");
				RG = inputCadastro.nextLine();
				arrayRG.add(RG);

				System.out.print("\nInsira a forma de pagamento" + "\n [0] = Cartão de Crédito"
						+ "\n [1] = Cartão de Débito" + "\n [2] = Dinheiro" + "\n [3] = Bitcoin\n -> ");
				pagamento = inputCadastro.nextInt();
				System.out.println();

				while (pagamento != 0 && pagamento != 1 && pagamento != 2 && pagamento != 3) {
					System.out.print("\nInsira a forma de pagamento" + "\n [0] = Cartão de Crédito"
							+ "\n [1] = Cartão de Débito" + "\n [2] = Dinheiro" + "\n [3] = Bitcoin\n -> ");
					pagamento = inputCadastro.nextInt();
					System.out.println();
				}

				// PAGAMENTOS EM DINHEIRO E EM BITCOIN

				switch (pagamento) {
				case 0:
					desconto = 0.0;
					formaPagamento = "Cartão de Crédito";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				case 1:
					desconto = 0.0;
					formaPagamento = "Cartão de Débito";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				case 2:
					desconto = 0.1;
					formaPagamento = "Dinheiro";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				case 3:
					desconto = 0.15;
					formaPagamento = "Bitcoin";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				}

				// QUARTOS DISPONIVEIS

				if (quartosTotais > 0) {
					isQuartoDisponivel = true;
					if (isQuartoDisponivel) {
						System.out.println("Temos " + quartosTotais + " quartos disponíveis: \n"
								+ "Número de Quartos Econômicos = [ " + quartoEconomico + " ]\n"
								+ "Número de Quartos Executivos = [ " + quartoExecutivo + " ]\n"
								+ "Número de Suítes Master = [ " + suiteMaster + " ]");

						System.out.println("Em qual quarto o(a) Sr(a)." + nomeCompleto + " gostaria de se hospedar:\n");
						System.out.print("Para selecionar o 'Quarto Econômico', digite [ 1 ]\n"
								+ "Para selecionar o 'Quarto Executivo', digite [ 2 ]\n"
								+ "Para selecionar a 'Suíte Master', digite [ 3 ]\n -> ");
						quartoDesejado = inputCadastro.nextInt();

						while (quartoDesejado != 1 && quartoDesejado != 2 && quartoDesejado != 3) {
							System.out.print("Para selecionar o 'Quarto Econômico', digite [ 1 ]\n"
									+ "Para selecionar o 'Quarto Executivo', digite [ 2 ]\n"
									+ "Para selecionar a 'Suíte Master', digite [ 3 ]\n -> ");
							quartoDesejado = inputCadastro.nextInt();
						}

						System.out.println("....................");

						System.out.print("Dia da entrada: ");
						inputDiaEntrada = input.nextInt();

						System.out.print("Mês da entrada: ");
						inputMesEntrada = input.nextInt();

						System.out.print("Ano da entrada: ");
						inputAnoEntrada = input.nextInt();

						System.out.println();

						System.out.print("Dia da saída: ");
						inputDiaSaida = input.nextInt();

						System.out.print("Mês da saída: ");
						inputMesSaida = input.nextInt();

						System.out.print("Ano da saída: ");
						inputAnoSaida = input.nextInt();

						while (inputDiaEntrada <= 0 || inputDiaEntrada > 31 || inputMesEntrada <= 0
								|| inputMesEntrada > 12 || inputDiaSaida <= 0 // 31
								|| inputDiaSaida > 31 || inputMesSaida <= 0 || inputMesSaida > 12
								|| inputAnoEntrada > inputAnoSaida) {

							System.out.println("....................");

							System.out.println("Insira uma data válida!");

							System.out.print("Dia da entrada: ");
							inputDiaEntrada = input.nextInt();

							System.out.print("Mês da entrada: ");
							inputMesEntrada = input.nextInt();

							System.out.print("Ano da entrada: ");
							inputAnoEntrada = input.nextInt();

							System.out.println();

							System.out.print("Dia da saída: ");
							inputDiaSaida = input.nextInt();

							System.out.print("Mês da saída: ");
							inputMesSaida = input.nextInt();

							System.out.print("Ano da saída: ");
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
							quarto = "Quarto Econômico";
							arrayQuarto.add(quarto);
							break;
						case 2:
							valorTotal = diasHospedado * diariaExecutivo;
							quartoExecutivo--;
							quarto = "Quarto Executivo";
							arrayQuarto.add(quarto);
							break;
						case 3:
							valorTotal = diasHospedado * diariaSuiteMaster;
							quarto = "Suíte Master";
							arrayQuarto.add(quarto);
							suiteMaster--;
							break;
						}

						valorTotal = valorTotal - (valorTotal * desconto);
//						arrayValorTotal.add(valorTotal);

						System.out.println("Você ficará " + diasHospedado + " dias hospedado no " + hotelNome
								+ " e pagará um total de R$" + valorTotal);
						System.out.println("\n....................");
						System.out.println("Deseja fazer outro cadastro: \n[0] = Sim" + "\n[1] = Não");
						cadastrarNovamente = inputSelecionar.nextInt();
					}
				} else {
					System.out.println("Sr(a)." + nomeCompleto + ", sinto lhe informar que a " + hotelNome
							+ " está sem quartos disponíveis.");
				}
				inputCadastro.nextLine();

				if (cadastrarNovamente == 1) {
					System.out.println("+-----------------------------+");
					System.out.println("| NOME " + arrayNomeCompleto.get(0));
					System.out.println("| CPF " + arrayCPF.get(0));
					System.out.println("| RG " + arrayRG.get(0));
					System.out.println("| QUARTO " + arrayQuarto.get(0));
					if ((int) (arrayPagamento.get(0)) == 3) {
						System.out.println("| FORMA DE PAGAMENTO " + arrayFormaPagamento.get(0) + " | R$1.00 = 0.00002 BTC |"); // + " | R$1.00 =
																									// 0.00002 BTC | "
						valorTotal *= cotacaoBTC;
						arrayValorTotal.add(valorTotal);
						
						System.out.println("| TOTAL " + arrayValorTotal.get(0) + "BTC");
					} else {
						arrayValorTotal.add(valorTotal);
						System.out.println("| FORMA DE PAGAMENTO " + arrayFormaPagamento.get(0));
						System.out.println("| TOTAL R$" + arrayValorTotal.get(0));
					}
					System.out.println("+-----------------------------+");
					System.out.println();
				}
			}

			inputCadastro.close();
			inputSelecionar.close();
			input.close();

			break;

		}
	}
}
