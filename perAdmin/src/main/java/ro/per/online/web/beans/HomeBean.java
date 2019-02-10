package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.modelo.dao.StatisticaDAO;
import ro.per.online.modelo.dto.estadisticas.StatisticaDTO;
import ro.per.online.modelo.filters.StatisticaBusqueda;

/**
 * Bean para la página de Home .
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("homeBean")
@Scope(Constantes.SESSION)
public class HomeBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variabila pentru datele de cautare ale statisticii.
	 */
	private StatisticaBusqueda statisticaBusqueda;

	/**
	 * Variabila pentru statisticaDTO.
	 */
	private List<StatisticaDTO> statisticaDTO;

	/**
	 * Variabila pentru serviciul de statistica.
	 */
	@Autowired
	private transient StatisticaDAO statisticaService;

	/**
	 * Método inicializador del bean.
	 */
	@PostConstruct
	public void init() {
		statisticaBusqueda = new StatisticaBusqueda();
		statisticaDTO = new ArrayList<>();
		cautareDateFiltru();
		obtinemDate();
	}

	/**
	 * 
	 */
	private void obtinemDate() {
		statisticaDTO = statisticaService.filterGeneraleStatistica(statisticaBusqueda);
		if (!statisticaDTO.isEmpty()) {
			final StatisticaDTO statistica = statisticaDTO.get(0);
		}
	}

	private void cautareDateFiltru() {
		statisticaBusqueda.setFechaDesde(new Date());
		statisticaBusqueda.setFechaUltimAn(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 1));
		statisticaBusqueda.setFechaUltimiDoiAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 2));
		statisticaBusqueda.setFechaUltimiTreiAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 3));
		statisticaBusqueda.setFechaUltimiPatruAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 4));
		statisticaBusqueda.setFechaUltimiCinciAni(calculaRestarFechaAn(statisticaBusqueda.getFechaDesde(), 5));
		statisticaBusqueda.setFechaUltimaLuna(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 1));
		statisticaBusqueda.setFechaUltimDouaLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 2));
		statisticaBusqueda.setFechaUltimTreiLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 3));
		statisticaBusqueda.setFechaUltimPatruLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 4));
		statisticaBusqueda.setFechaUltimCinciLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 5));
		statisticaBusqueda.setFechaUltimSaseLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 6));
		statisticaBusqueda.setFechaUltimSapteLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 7));
		statisticaBusqueda.setFechaUltimOptLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 8));
		statisticaBusqueda.setFechaUltimNouaLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 9));
		statisticaBusqueda.setFechaUltimZeceLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 10));
		statisticaBusqueda.setFechaUltimUnspeLuni(calculaRestarFechaLuna(statisticaBusqueda.getFechaDesde(), 11));

		statisticaBusqueda.setFechaUltimaLunaAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 1));
		statisticaBusqueda
				.setFechaUltimDouaLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 2));
		statisticaBusqueda
				.setFechaUltimTreiLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 3));
		statisticaBusqueda
				.setFechaUltimPatruLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 4));
		statisticaBusqueda
				.setFechaUltimCinciLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 5));
		statisticaBusqueda
				.setFechaUltimSaseLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 6));
		statisticaBusqueda
				.setFechaUltimSapteLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 7));
		statisticaBusqueda
				.setFechaUltimOptLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 8));
		statisticaBusqueda
				.setFechaUltimNouaLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 9));
		statisticaBusqueda
				.setFechaUltimZeceLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 10));
		statisticaBusqueda
				.setFechaUltimUnspeLuniAnTrecut(calculaRestarFechaLuna(statisticaBusqueda.getFechaUltimAn(), 11));
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private Date calculaRestarFechaAn(Date fecha, int numarAn) {
		Date newDate = fecha;
		final Calendar calDesde = Calendar.getInstance();
		calDesde.setTime(newDate);
		final Calendar calHasta = Calendar.getInstance();
		int anulProv = calDesde.get(Calendar.YEAR);
		int luna = calDesde.get(Calendar.MONTH);
		int zi = calDesde.get(Calendar.DAY_OF_MONTH);
		int anFinal = anulProv - numarAn;
		calHasta.set(anFinal, luna, zi);
		final Date fechaHasta = calHasta.getTime();
		return fechaHasta;
	}

	/**
	 * Cargar datos estadísticos.
	 */
	private Date calculaRestarFechaLuna(Date fecha, int numarLuna) {
		Date newDate = fecha;
		final Calendar calDesde = Calendar.getInstance();
		calDesde.setTime(newDate);
		final Calendar calHasta = Calendar.getInstance();
		int anFinal = calDesde.get(Calendar.YEAR);
		int lunaProv = calDesde.get(Calendar.MONTH);
		int zi = calDesde.get(Calendar.DAY_OF_MONTH);
		int luna = lunaProv - numarLuna;
		calHasta.set(anFinal, luna, zi);
		final Date fechaHasta = calHasta.getTime();
		return fechaHasta;
	}
}
