package softplan.com.br.date;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;

public class Exemplo4Test {

	private LocalDateTime dataEHora;
	private Exemplo4 calculadorANSComFusoHorario;

	@Before
	public void setUp() throws Exception {
		dataEHora = LocalDateTime.of(2016, Month.MARCH, 7, 14, 50);
		calculadorANSComFusoHorario = new Exemplo4();
	}

	@Test
	public void testCalculaTempoParaRespostaANSComFusoHorarioSaoPaulo() {
		calculadorANSComFusoHorario.calculaDataEHoraFusoHorarioSaoPaulo(dataEHora);

		assertEquals("Segunda-feira, 07/03/2016 às 15:50 (America/Sao_Paulo)", calculadorANSComFusoHorario.getDataEHoraFormatada());
	}

	@Test
	public void testCalculaTempoParaRespostaANSComFusoHorarioPolonia() {
		ZoneId fusoSaoPaulo = ZoneId.of("America/Sao_Paulo");
		
		calculadorANSComFusoHorario.calculaDataEHoraFusoHorarioPolonia(ZonedDateTime.of(dataEHora, fusoSaoPaulo));

		assertEquals("Terça-feira, 08/03/2016 às 09:00 (Poland)", calculadorANSComFusoHorario.getDataEHoraFormatada());
	}
}