package softplan.com.br.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Exemplo4 {

	private String dataEHoraFormatada;

	// Data = Segunda-feira, 7 de Março 14:50
	public void calculaDataEHoraFusoHorarioSaoPaulo(LocalDateTime dataEHora) {
		ZoneId fusoSaoPaulo = ZoneId.of("America/Sao_Paulo");
		ZonedDateTime dataEHoraSaoPaulo = ZonedDateTime.of(dataEHora, fusoSaoPaulo);
		exibe(calculaTempoParaRespostaANS(dataEHoraSaoPaulo));
		// Segunda-feira, 07/03/2016 às 15:50 (America/Sao_Paulo)
	}

	// Data = Segunda-feira, 7 de Março 14:50
	public void calculaDataEHoraFusoHorarioPolonia(ZonedDateTime dataEHora) {
		ZoneId fusoPolonia = ZoneId.of("Poland");
		ZonedDateTime dataEHoraPolonia = dataEHora.withZoneSameInstant(fusoPolonia);
		exibe(calculaTempoParaRespostaANS(dataEHoraPolonia));
		// Terça-feira, 08/03/2016 às 09:00 (Poland)
	}

	private ZonedDateTime calculaTempoParaRespostaANS(ZonedDateTime dataEHora) {
		return dataEHora.with(new AjustarParaDataEHoraANS());
	}

	private void exibe(ZonedDateTime dataEHora) {
		dataEHoraFormatada = dataEHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy 'às' HH:mm (VV)"));
		System.out.println(dataEHoraFormatada);
	}

	public String getDataEHoraFormatada() {
		return dataEHoraFormatada;
	}
}