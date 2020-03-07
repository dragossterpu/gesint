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
import ro.stad.online.gesint.persistence.entities.enums.SituatieSondajEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.SondajService;
import ro.stad.online.gesint.services.SondajVotService;
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
         * Variala utilizata pentru injectarea serviciului de sondaje.
         */
        @Autowired
        private SondajService sondajService;

        /**
         * Variala utilizata pentru injectarea serviciului de votanti de sondaj.
         */
        @Autowired
        private SondajVotService sondajVotService;

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
         * Sondaje finalizate.
         */
        private List<Sondaj> sondajeActivare;

        /**
         * Metodă folosită pentru a activa sondajele programate
         * @param se executa in fiecare noapte la ora 12.01
         */
        @Scheduled(cron = "30 * * * * *")
        public void activeazaSondaj() {
                try {
                        // Obtinem sondajele finalizate
                        this.sondajeActivare = this.sondajService.cautareSondajePentruActivare();
                        for (final Sondaj sond : this.sondajeActivare) {
                                // Activam sondajul
                                sond.setActiv(SituatieSondajEnum.ACTIV);
                                // Salvam sondajul dupa actualizare
                                this.sondajService.save(sond);
                                log.info("Sondajul a fost activat. Începând din acest moment se poate vota. Sondajul cu identificatorul: "
                                                + sond.getId());
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("A apărut o eroare la activarea sondajului ");
                        final String descriere = "A apărut o eroare la modificarea sondajului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(),
                                        e);
                        log.error(descriere);

                }

        }

        /**
         * Metodă folosită pentru a calcula procentajul voturilor la sondajele inchise
         * @param se executa in fiecare noapte la ora 12.
         */
        @Scheduled(cron = "30 * * * * *")
        public void actualizeazaProcentajSondaj() {
                try {
                        // Obtinem sondajele finalizate
                        this.sondajeFinalizate = this.sondajService.cautareSondajeFinalizate();
                        for (final Sondaj sond : this.sondajeFinalizate) {
                                // Dezactivam sondajul
                                sond.setActiv(SituatieSondajEnum.FINALIZAT);
                                // Calculam procentajele
                                sond.setProcentajAbt(
                                                obtinereProcentaj(sond.getTotalVoturiAbt(), sond.getTotalVoturi()));
                                sond.setProcentajNu(obtinereProcentaj(sond.getTotalVoturiNu(), sond.getTotalVoturi()));
                                sond.setProcentajDa(obtinereProcentaj(sond.getTotalVoturiDa(), sond.getTotalVoturi()));
                                // Salvam sondajul dupa finalizare
                                this.sondajService.save(sond);
                                // Eliminam toti votanti din baza de date
                                this.sondajVotService.deleteBySondaj(sond);
                                log.info("Sondajul a fost actualizat și finalizat . Au fost eliminați toți votanții acestui sondaj din baza de date");
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        log.error("A apărut o eroare la actualizarea și finalizarea sondajului ");
                        final String descriere = "A apărut o eroare la modificarea sondajului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.SONDAJ.getDescriere(),
                                        e);
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
