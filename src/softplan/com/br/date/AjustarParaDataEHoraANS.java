package softplan.com.br.date;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class AjustarParaDataEHoraANS implements TemporalAdjuster {
	public Temporal adjustInto(Temporal dataEHoraParaAjuste) {
		Temporal dataEHoraAjustada = dataEHoraParaAjuste.plus(1, ChronoUnit.HOURS);
		dataEHoraAjustada = ajustarDiaUtil(dataEHoraAjustada);
		dataEHoraAjustada = ajustarFimExpediente(dataEHoraAjustada);
		return dataEHoraAjustada;
	}

	private Temporal ajustarDiaUtil(Temporal dataEHoraParaAjuste) {
		Temporal diaUtilComHora = dataEHoraParaAjuste.with(new AjustarParaDiaUtil());
		if (dataEHoraParaAjuste.until(diaUtilComHora, ChronoUnit.DAYS) > 0) {
			return ajustarInicioExpediente(diaUtilComHora).plus(1, ChronoUnit.HOURS);
		}
		return dataEHoraParaAjuste;
	}

	private Temporal ajustarInicioExpediente(Temporal dataEHoraParaAjuste) {
		return dataEHoraParaAjuste.with(LocalTime.of(8, 0));
	}

	private Temporal ajustarFimExpediente(Temporal dataEHoraParaAjuste) {
		Temporal fimExpediente = dataEHoraParaAjuste.with(LocalTime.of(17, 0));
		if (fimExpediente.until(dataEHoraParaAjuste, ChronoUnit.HOURS) > 0) {
			return ajustarInicioExpediente(dataEHoraParaAjuste.plus(1, ChronoUnit.DAYS)).plus(1, ChronoUnit.HOURS);
		}
		return dataEHoraParaAjuste;
	}
}
