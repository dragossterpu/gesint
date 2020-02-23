package ro.stad.online.gesint.services.impl;

import java.io.File;
import java.util.List;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.Statistica;
import ro.stad.online.gesint.persistence.entities.enums.TipStatisticaEnum;
import ro.stad.online.gesint.persistence.repositories.StatisticaRepository;
import ro.stad.online.gesint.services.StatisticaService;
import ro.stad.online.gesint.util.PdfGenerareStatistica;

/**
 * Implementación del servicio de Statistica.
 *
 * @author STAD
 *
 */
@Service
public class StatisticaServiceImpl implements StatisticaService {

        /**
         * Repositoriu de Statistica.
         */
        @Autowired
        private StatisticaRepository statisticaRepository;

        /**
         * Generator de PDF.
         */
        @Autowired
        private PdfGenerareStatistica generadorPDF;

        /**
         * Metoda care exporta statistica într-un fișier PDF descărcabil.
         * @param sondaj Sondaj
         * @param fileImg Fișier cu imaginea care va fi încorporată în PDF.
         * @return Fluxul de date cu PDF-ul generat
         * @throws GesintException Posibilă excepție
         */
        @Override
        public StreamedContent exportar(final Sondaj sondaj, final File fileImg) throws GesintException {
                generadorPDF.setSondaj(sondaj);
                generadorPDF.setFileImg(fileImg);
                return generadorPDF.exportarPdf();
        }

        /**
         * Metoda care cauta statisticile
         * @param tip TipStatisticaEnum
         * @param marca String
         * @param isjudet Boolean
         * @return lista List<Statistica>
         */
        @Override
        public List<Statistica> findByTipStatisticaAndMarcaAndIsjudet(final TipStatisticaEnum tip, final String marca,
                        final Boolean isjudet) {
                return statisticaRepository.findByTipStatisticaAndMarcaAndIsjudetOrderByProcentajDesc(tip, marca,
                                isjudet);
        }

}
