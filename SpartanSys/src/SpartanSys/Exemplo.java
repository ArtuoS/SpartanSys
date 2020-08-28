package SpartanSys;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Clairton Luz
 */
public class Exemplo {

	public static void main(String[] args) {
		// Cria um Objeto LocalDate com a data atual.
//		LocalDate hoje = LocalDate.now();

		// Cria um Objeto LocalDate com a data 26/09/2020.
			
		LocalDate outraData = LocalDate.of(2020, Month.DECEMBER, 30);
		LocalDate dataInicial = LocalDate.of(2021, Month.JANUARY, 2);
		
//		java.time.Month m = new java.time.Month();
		

		// Calcula a diferenša de dias entre as duas datas
		long diferencaEmDias = ChronoUnit.DAYS.between(dataInicial, outraData);
		// Calcula a diferenša de meses entre as duas datas
		long diferencaEmMes = ChronoUnit.MONTHS.between(dataInicial, outraData);
		// Calcula a diferenša de anos entre as duas datas
		long diferencaEmAnos = ChronoUnit.YEARS.between(dataInicial, outraData);

		// Exibe a diferenša em dias entre as datas
		System.out.println("Diferenša em dias entre " + dataInicial + " e " + outraData + " = " + (diferencaEmDias - (diferencaEmDias * 2)));
		// Exibe a diferenša em meses entre as datas
		System.out.println("Diferenša em meses entre " + dataInicial + " e " + outraData + " = " + diferencaEmMes);
		// Exibe a diferenša em anos entre as datas
		System.out.println("Diferenša em anos entre " + dataInicial + " e " + outraData + " = " + diferencaEmAnos);
	}

}