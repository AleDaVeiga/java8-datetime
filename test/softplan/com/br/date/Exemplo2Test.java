package softplan.com.br.date;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class Exemplo2Test {

	private LocalDate dataParaCalcular;
	private Exemplo2 formatador;

	@Before
	public void setUp() throws Exception {
		dataParaCalcular = LocalDate.of(2016, Month.FEBRUARY, 14);
		formatador = new Exemplo2();

		System.out.println(dataParaCalcular);
		// 2016-02-14
	}

	@Test
	public void testCalculaDiaDoSalario() {
		formatador.calculaDiaDoSalario(dataParaCalcular);

		assertEquals("Segunda-feira, 29 de Fevereiro", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaDaFestaDeAniversarioDoMes() {
		formatador.calculaDiaDaFestaDeAniversarioDoMes(dataParaCalcular);

		assertEquals("Sexta-feira, 26 de Fevereiro", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaDaReuniaoDePais() {
		formatador.calculaDiaDaReuniaoDePais(dataParaCalcular);

		assertEquals("Segunda-feira, 8 de Fevereiro", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaDoProximoJogo() {
		formatador.calculaDiaDoProximoJogo(dataParaCalcular);

		assertEquals("Quarta-feira, 17 de Fevereiro", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaDePagarAsContas_QuintoDiaUtil() {
		formatador.calculaDiaDePagarAsContas(LocalDate.of(2016, Month.JANUARY, 14));

		assertEquals("Sexta-feira, 5 de Fevereiro", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaDePagarAsContas_Sabado() {
		formatador.calculaDiaDePagarAsContas(LocalDate.of(2016, Month.FEBRUARY, 14));

		assertEquals("Segunda-feira, 7 de Março", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaDePagarAsContas_Domingo() {
		formatador.calculaDiaDePagarAsContas(LocalDate.of(2016, Month.MAY, 14));

		assertEquals("Segunda-feira, 6 de Junho", formatador.getDataFormatada());
	}

	@Test
	public void testCalculaDiaParaIrAoBanco() {
		formatador.calculaDiaParaIrAoBanco(LocalDate.of(2016, Month.MARCH, 5));

		assertEquals("Segunda-feira, 7 de Março", formatador.getDataFormatada());
	}
}