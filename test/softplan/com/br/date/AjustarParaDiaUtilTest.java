package softplan.com.br.date;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;

import org.junit.Before;
import org.junit.Test;

public class AjustarParaDiaUtilTest {

	private AjustarParaDiaUtil ajustador;

	@Before
	public void setUp() throws Exception {
		ajustador = new AjustarParaDiaUtil();
	}

	@Test
	public void testCalculaDiaUtil() {
		Temporal dataAjustada = ajustador.adjustInto(LocalDate.of(2016, Month.FEBRUARY, 5));

		assertEquals("2016-02-05", dataAjustada.toString());
	}

	@Test
	public void testCalculaDiaUtil_Sabado() {
		Temporal dataAjustada = ajustador.adjustInto(LocalDate.of(2016, Month.MARCH, 5));

		assertEquals("2016-03-07", dataAjustada.toString());
	}

	@Test
	public void testCalculaDiaUtil_Domingo() {
		Temporal dataAjustada = ajustador.adjustInto(LocalDate.of(2016, Month.JUNE, 5));

		assertEquals("2016-06-06", dataAjustada.toString());
	}
}