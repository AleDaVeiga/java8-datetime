package softplan.com.br.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Exemplo3 {

	private String dataEHoraFormatada;

	// Data = Sabádo, 5 de Março 14:50
	public void calculaDataEHoraForaDiaUtil() {
		LocalDateTime dataEHoraForaDiaUtil = LocalDateTime.of(2016, Month.MARCH, 5, 14, 50);
		exibe(dataEHoraForaDiaUtil.with(new AjustarParaDataEHoraANS()));
		// Segunda-feira, 07/03/2016 às 09:00
	}

	// Data = Segunda-feira, 7 de Março 19:50
	public void calculaDataEHoraForaExpediente() {
		LocalDateTime dataEHoraForaExpediente = LocalDateTime.of(2016, Month.MARCH, 7, 19, 50);
		exibe(dataEHoraForaExpediente.with(new AjustarParaDataEHoraANS()));
		// Terça-feira, 08/03/2016 às 09:00
	}

	// Data = Terça-feira, 8 de Março 10:50 
	public void calculadataEHoraNormal() {
		LocalDateTime dataEHoraNormal = LocalDateTime.of(2016, Month.MARCH, 8, 10, 50);
		exibe(dataEHoraNormal.with(new AjustarParaDataEHoraANS()));
		// Terça-feira, 08/03/2016 às 11:50
	}

	private void exibe(LocalDateTime dataEHora) {
		dataEHoraFormatada = dataEHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy 'às' HH:mm"));
		System.out.println(dataEHoraFormatada);
	}

	public String getDataEHoraFormatada() {
		return dataEHoraFormatada;
	}
}