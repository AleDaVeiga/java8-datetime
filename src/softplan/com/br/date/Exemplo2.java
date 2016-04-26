package softplan.com.br.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Exemplo2 {

	private String dataFormatada;

	// Data = Domingo, 14 de Fevereiro
	public void calculaDiaDoSalario(LocalDate data) {
		exibe(data.with(TemporalAdjusters.lastDayOfMonth()));
		// Segunda-feira, 29 de Fevereiro
	}

	// Data = Domingo, 14 de Fevereiro
	public void calculaDiaDaFestaDeAniversarioDoMes(LocalDate data) {
		exibe(data.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		// Sexta-feira, 26 de Fevereiro
	}

	// Data = Domingo, 14 de Fevereiro
	public void calculaDiaDaReuniaoDePais(LocalDate data) {
		exibe(data.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.MONDAY)));
		// Segunda-feira, 8 de Fevereiro
	}

	// Data = Domingo, 14 de Fevereiro
	public void calculaDiaDoProximoJogo(LocalDate data) {
		exibe(data.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));
		// Quarta-feira, 17 de Fevereiro
	}

	// Data = Domingo, 14 de Fevereiro
	public void calculaDiaDePagarAsContas(LocalDate data) {
		LocalDate dataDePagarAsContas = data.with(TemporalAdjusters.lastDayOfMonth()).plusDays(5);
		if (dataDePagarAsContas.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
			dataDePagarAsContas = dataDePagarAsContas.plusDays(2);
		} else if (dataDePagarAsContas.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			dataDePagarAsContas = dataDePagarAsContas.plusDays(1);
		}
		exibe(dataDePagarAsContas);
		// Segunda-feira, 7 de Março
	}

	// Data = Domingo, 14 de Fevereiro
	public void calculaDiaParaIrAoBanco(LocalDate data) {
		exibe(data.with(new AjustarParaDiaUtil()));
		// Segunda-feira, 7 de Março
	}
	
	private void exibe(LocalDate data) {
		dataFormatada = data.format(DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM"));
		System.out.println(dataFormatada);
	}

	public String getDataFormatada() {
		return dataFormatada;
	}
}
