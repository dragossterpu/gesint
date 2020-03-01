package ro.stad.online.gesint.jobs;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.SondajService;
import ro.stad.online.gesint.util.FacesUtilities;

/**
 *
 * Tareas automaticas.
 *
 * @author ATOS
 *
 */
@Component
@Slf4j
public class JobQuartz {

	/**
	 * Variala utilizata pentru injectarea serviciului de sondale.
	 */
	@Autowired
	private SondajService sondajService;

	/**
	 * Serviciul de înregistrare a activității.
	 */
	@Autowired
	private RegistruActivitateService regActividadService;

	/**
	 * Sondaje finalizate.
	 */
	private List<Sondaj> sondajeFinalizate;

	/**
	 * Metodă folosită pentru a calcula procentajul voturilor la sondajele inchise
	 * @param se executa in fiecare noapte la ora 12.
	 */
	@Scheduled(cron = "30 * * * * *")
	public void actualizeazaProcentajSondaj() {
		try {
			sondajeFinalizate = sondajService.cautareSondajeFinalizate();
			for (final Sondaj sond : sondajeFinalizate) {
				sond.setActiv(false);
				sond.setProcentajAbt(obtinereProcentaj(sond.getTotalVoturiAbt(), sond.getTotalVoturi()));
				sond.setProcentajNu(obtinereProcentaj(sond.getTotalVoturiNu(), sond.getTotalVoturi()));
				sond.setProcentajDa(obtinereProcentaj(sond.getTotalVoturiDa(), sond.getTotalVoturi()));
				sondajService.save(sond);
				log.info("Sondajul a fost actualizat și finalizat");

			}

		}
		catch (final DataAccessException e) {
			FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, RegistruEnum.EROARE.getDescriere(),
					Constante.DESCEROAREMESAJ);
			log.error("A apărut o eroare la actualizarea și finalizarea sondajului ");
			final String descriere = "A apărut o eroare la modificarea sondajului";
			this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(), e);
			log.error(descriere);

		}

	}

	/**
	 * Metoda care calculeaza procentajul total de voturi
	 * @param numar Integer numar de voturi
	 * @return divFinal Float
	 */
	private Float obtinereProcentaj(final Integer numar, final Integer totalVoturi) {
		final int num = numar * NumarMagic.NUMBERHUNDRED;
		final float div = ((float) num / totalVoturi);
		return Math.round(div * NumarMagic.NUMBERHUNDRED) / NumarMagic.NUMBERHUNDREDF;

	}

}
