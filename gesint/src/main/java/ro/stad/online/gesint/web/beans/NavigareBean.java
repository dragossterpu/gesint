package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DynamicMenuModel;
import org.primefaces.model.menu.MenuElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;

/**
 * Bean care menține un control al paginilor care sunt vizitate, astfel încât să știi întotdeauna unde se află
 * utilizatorul și să poată naviga înapoi la un meniu superior până ajunge la index.
 *
 * @author STAD
 *
 */
@Component(Constante.NAVIGAREBEAN)
@Scope(Constante.SESSION)
@Getter
@Setter
@NoArgsConstructor
public class NavigareBean implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Variabilă pentru a stoca the Breadcrumbs..
         */
        private DynamicMenuModel breadcrumbs;

        /**
         * Metodă folosită pentru a căuta dacă pasul este deja, dacă da, le șterge pe cele din spate și, dacă nu, este
         * adăugat ca un nou pas.
         * @param nume numele paginii
         * @param url url-ul paginii
         */
        public void inainte(final String nume, final String url) {
                final List<MenuElement> elemente = breadcrumbs.getElements();
                DefaultMenuItem e = null;
                final ListIterator<MenuElement> it = elemente.listIterator();
                boolean exista = false;
                while (it.hasNext() && !exista) {
                        e = (DefaultMenuItem) it.next();
                        exista = nume.equals(e.getValue());
                }
                if (exista) {
                        elemente.subList(it.nextIndex(), elemente.size()).clear();
                }
                else {
                        final DefaultMenuItem nou = new DefaultMenuItem();
                        nou.setUrl(url);
                        nou.setValue(nume);
                        breadcrumbs.addElement(nou);
                }
        }

        /**
         * Metodă folosită pentru a crea breadcrumbs cu pagina principală ca prim element de meniu.
         *
         */
        public void inceputBreadcrumbs() {
                breadcrumbs = new DynamicMenuModel();
                final DefaultMenuItem inceput = new DefaultMenuItem();
                inceput.setUrl("/index.xhtml");
                inceput.setIcon("ui-icon-home");
                inceput.setTitle("Menú Principal");
                breadcrumbs.addElement(inceput);
        }

        /**
         * Metoda init() de NavigareBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                inceputBreadcrumbs();
        }

        /**
         * Metodă folosită pentru a reporni Breadcrumbs accesând o opțiune de meniu.
         * @param nume numele paginii
         * @param url url-ul paginii
         */
        public void reincepere(final String nume, final String url) {
                inceputBreadcrumbs();
                inainte(nume, url);
        }

}
