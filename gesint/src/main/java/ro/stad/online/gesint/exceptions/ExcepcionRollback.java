package ro.stad.online.gesint.exceptions;

/**
 * Excepție personalizată.
 * 
 * @author STAD
 *
 */
public class ExcepcionRollback extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        /**
         * Excepție generală fără parametri.
         */

        public ExcepcionRollback() {
                super();
        }

        /**
         * Excepție generală.
         * @param e Excepción
         */
        public ExcepcionRollback(final Exception e) {
                super(e);
        }

        /**
         * Excepție cu mesaj.
         * @param mesaj Mesaj care va fi afișat la lanzarea excepției.
         */
        public ExcepcionRollback(final String mesaj) {
                super(mesaj);
        }

}
