package softplan.com.br.date;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Exemplo3Test {

	private Exemplo3 calculadorANS;

	@Before
	public void setUp() throws Exception {
		calculadorANS = new Exemplo3();
	}

	@Test
	public void testCalculaDataEHoraForaDiaUtil() {
		calculadorANS.calculaDataEHoraForaDiaUtil();

		assertEquals("Segunda-feira, 07/03/2016 às 09:00", calculadorANS.getDataEHoraFormatada());
	}

	@Test
	public void testCalculaDataEHoraForaExpediente() {
		calculadorANS.calculaDataEHoraForaExpediente();

		assertEquals("Terça-feira, 08/03/2016 às 09:00", calculadorANS.getDataEHoraFormatada());
	}

	@Test
	public void testCalculadataEHoraNormal() {
		calculadorANS.calculadataEHoraNormal();

		assertEquals("Terça-feira, 08/03/2016 às 11:50", calculadorANS.getDataEHoraFormatada());
	}
}