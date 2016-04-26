package softplan.com.br.date;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class AjustarParaDiaUtil implements TemporalAdjuster {
	
	@Override
	public Temporal adjustInto(Temporal diaParaAjuste) {
		int diaDaSemana = diaParaAjuste.get(ChronoField.DAY_OF_WEEK);

		if (diaDaSemana == DayOfWeek.SATURDAY.getValue()) {
			return diaParaAjuste.plus(2, ChronoUnit.DAYS);
		} else if (diaDaSemana == DayOfWeek.SUNDAY.getValue()) {
			return diaParaAjuste.plus(1, ChronoUnit.DAYS);
		}
		return diaParaAjuste;
	}
}
