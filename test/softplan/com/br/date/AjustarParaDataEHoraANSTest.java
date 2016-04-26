package softplan.com.br.date;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

import org.junit.Before;
import org.junit.Test;

public class AjustarParaDataEHoraANSTest {
	private AjustarParaDataEHoraANS ajustador;

	@Before
	public void setUp() throws Exception {
		ajustador = new AjustarParaDataEHoraANS();
	}

	@Test
	public void testCalculaANS_DataEHoraNormal() {
		Temporal dataAjustada = ajustador.adjustInto(LocalDateTime.of(2016, Month.MARCH, 8, 10, 50));

		assertEquals("Terça-feira, 08/03/2016 às 11:50", formata(dataAjustada));
	}

	@Test
	public void testCalculaANS_DataEHoraForaExpediente() {
		Temporal dataAjustada = ajustador.adjustInto(LocalDateTime.of(2016, Month.MARCH, 7, 19, 50));

		assertEquals("Terça-feira, 08/03/2016 às 09:00", formata(dataAjustada));
	}

	@Test
	public void testCalculaANS_DataEHoraForaDiaUtil() {
		Temporal dataAjustada = ajustador.adjustInto(LocalDateTime.of(2016, Month.MARCH, 5, 14, 50));

		assertEquals("Segunda-feira, 07/03/2016 às 09:00", formata(dataAjustada));
	}
	
	private String formata(Temporal dataEHora) {
		return ((LocalDateTime)dataEHora).format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy 'às' HH:mm"));
	}
}