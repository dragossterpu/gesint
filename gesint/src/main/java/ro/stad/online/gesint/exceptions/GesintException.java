package ro.stad.online.gesint.exceptions;

/**
 * Excepție personalizată a aplicatiei
 *
 * @author STAD
 *
 */
public class GesintException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Mesaj de excepție.
         */
        String mesaj;

        /**
         * Excepție generală fără parametri.
         */

        public GesintException() {
                super();
        }

        /**
         * Excepție generală
         * @param e Excepción
         */
        public GesintException(final Exception e) {
                super(e);
                mesaj = e.getMessage();
        }

        /**
         * Suprascrierea metodei getMessage() pentru a afișa mesajul personalizat.
         */
        @Override
        public String getMessage() {
                return mesaj;
        }

        /**
         * Excepție cu mesaj.
         * @param mesaj Mesaj care va fi afișat la lanzarea excepției.
         */
        public GesintException(final String mesaj) {
                super(mesaj);
        }
}
