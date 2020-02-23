package ro.stad.online.gesint.services;

import org.primefaces.event.FileUploadEvent;

/**
 * Implementarea serviciului de operațiuni masive.
 * @author STAD
 */
public interface OperatieMasivaFisierService {

        /**
         * Procesează operarea masivă a unui fișier și efectuează acțiunea relevantă în BBDD.
         * @param event FileUploadEvent
         * @param tipRegistru tipul de operațiune
         * @param mesajExceptie mensaj în cazul apariției unor erori
         */
        void procesareOperatieMasivaFisier(final FileUploadEvent event, String tipRegistru, String mesajExceptie);

}
