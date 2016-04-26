package softplan.com.br.date;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Exemplo1 {
	private String dataFormatada;

	// Data = 2016-04-14T20:17
	public void formataDataPadraoISOBasico(LocalDateTime data) {
		exibe(data.format(DateTimeFormatter.BASIC_ISO_DATE));
		// 20160414
	}

	// Data = 2016-04-14T20:17
	public void formataData(LocalDateTime data) {
		exibe(data.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		// 14/04/2016
	}

	// Data = 2016-04-14T20:17
	public void formataDataComHora(LocalDateTime data) {
		exibe(data.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
		// 14/04/16 20:17
	}

	// Data = 2016-04-14T20:17
	public void formataDataPorExtenso(LocalDateTime data) {
		exibe(data.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		// 14 de Abril de 2016
	}

	// Data = 2016-04-14T20:17
	public void formataDataPorExtensoComDiaDaSemana(LocalDateTime data) {
		Locale brasil = new Locale("pt", "BR");
		exibe(data.format(DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy", brasil)));
		// Quinta-feira, 14 de Abril de 2016
	}

	// Data = 2016-04-14T20:17
	public void formataDataComDiaDaSemanaEHoraEFuso(ZonedDateTime dataEHora) {
		exibe(dataEHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy 'às' HH:mm (VV)")));
		// Quinta-feira, 14/04/2016 às 20:17 (America/Sao_Paulo)
	}

	private void exibe(String dataFormatada) {
		this.dataFormatada = dataFormatada;
		System.out.println(dataFormatada);
	}

	public String getDataFormatada() {
		return dataFormatada;
	}
}
