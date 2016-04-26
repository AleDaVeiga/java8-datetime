package softplan.com.br.date;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import org.junit.Before;
import org.junit.Test;

public class Exemplo1Test {

	private LocalDateTime dataParaFormatar;
	private Exemplo1 formatador;

	@Before
	public void setUp() throws Exception {
		dataParaFormatar = LocalDateTime.of(2016, Month.APRIL, 14, 20, 17);
		formatador = new Exemplo1();

		System.out.println(dataParaFormatar);
		// 2016-04-14T20:17
	}

	@Test
	public void testDataPadraoISOBasico() {
		formatador.formataDataPadraoISOBasico(dataParaFormatar);

		assertEquals("20160414", formatador.getDataFormatada());
	}

	@Test
	public void testDataLocal() {
		formatador.formataData(dataParaFormatar);

		assertEquals("14/04/2016", formatador.getDataFormatada());
	}

	@Test
	public void testDataComHora() {
		formatador.formataDataComHora(dataParaFormatar);

		assertEquals("14/04/16 20:17", formatador.getDataFormatada());
	}

	@Test
	public void testDataPorExtenso() {
		formatador.formataDataPorExtenso(dataParaFormatar);

		assertEquals("14 de Abril de 2016", formatador.getDataFormatada());
	}

	@Test
	public void testDataPorExtensoComDiaDaSemana() {
		formatador.formataDataPorExtensoComDiaDaSemana(dataParaFormatar);

		assertEquals("Quinta-feira, 14 de Abril de 2016", formatador.getDataFormatada());
	}

	@Test
	public void testDataComDiaDaSemanaEHoraEFuso() {
		formatador.formataDataComDiaDaSemanaEHoraEFuso(dataParaFormatar.atZone(ZoneId.systemDefault()));

		assertEquals("Quinta-feira, 14/04/2016 às 20:17 (America/Sao_Paulo)", formatador.getDataFormatada());
	}
}