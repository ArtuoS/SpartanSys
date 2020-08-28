package SpartanSys;

import java.util.Date;
import java.util.Scanner;
import java.text.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.time.*;

public class SistemaDatas {

	public static void main(String[] args) {

		Date date = new Date();
		Scanner input = new Scanner(System.in);
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

		int anoAtual = 1900 + date.getYear();
		int mesAtual = 1 + date.getMonth();
		int diaAtual = date.getDate();

		LocalDate localDate = LocalDate.of(anoAtual, mesAtual, diaAtual); // anoAtual, mesAtual, diaAtual
		System.out.println(localDate + "\n");

		System.out.println("....................\n");

		System.out.print("Dia da entrada: ");
		int inputDiaEntrada = input.nextInt();
		int diaEntrada = inputDiaEntrada;

		System.out.print("M�s da entrada: ");
		int inputMesEntrada = input.nextInt();
		int mesEntrada = inputMesEntrada;

		System.out.print("Ano da entrada: ");
		int inputAnoEntrada = input.nextInt();
		int anoEntrada = inputAnoEntrada;

		System.out.println();

		System.out.print("Dia da sa�da: ");
		int inputDiaSaida = input.nextInt();
		int diaSaida = inputDiaSaida;

		System.out.print("M�s da sa�da: ");
		int inputMesSaida = input.nextInt();
		int mesSaida = inputMesSaida;

		System.out.print("Ano da sa�da: ");
		int inputAnoSaida = input.nextInt();
		int anoSaida = inputAnoSaida;

		while (diaEntrada <= 0 || diaEntrada > 31 || mesEntrada <= 0 || mesEntrada > 12 || diaSaida <= 0 // 31
				|| diaSaida > 31 || mesSaida <= 0 || mesSaida > 12 || anoEntrada > anoSaida) {

			System.out.println("....................");

			System.out.println("Insira uma data v�lida!");

			System.out.print("Dia da entrada: ");
			inputDiaEntrada = input.nextInt();
			diaEntrada = inputDiaEntrada;

			System.out.print("M�s da entrada: ");
			inputMesEntrada = input.nextInt();
			mesEntrada = inputMesEntrada;

			System.out.print("Ano da entrada: ");
			inputAnoEntrada = input.nextInt();
			anoEntrada = inputAnoEntrada;

			System.out.print("Dia da sa�da: ");
			inputDiaSaida = input.nextInt();
			diaSaida = inputDiaSaida;

			System.out.print("M�s da sa�da: ");
			inputMesSaida = input.nextInt();
			mesSaida = inputMesSaida;

			System.out.print("Ano da sa�da: ");
			inputAnoSaida = input.nextInt();
			anoSaida = inputAnoSaida;

			System.out.println("....................");
		}

		LocalDate dataEntrada = LocalDate.of(anoEntrada, mesEntrada, diaEntrada);
		LocalDate dataSaida = LocalDate.of(anoSaida, mesSaida, diaSaida);

		long diasHospedado = ChronoUnit.DAYS.between(dataEntrada, dataSaida);

		System.out.println();
		
		System.out.println("Voc� ficar� " + diasHospedado + " dias hospedado!");
		System.out.println("\n....................");

	}

}
