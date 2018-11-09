package ro.per.online.web.beans;

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
import ro.per.online.constantes.Constantes;

/**
 * Bean que mantiene un contról de las páginas que se visitan de modo que siempre se sepa dónde se encuentra el usuario
 * y éste pueda navegar hacia atrás a un menú superior hasta llegar al index.
 *
 * @author STAD
 *
 */
@Component("navegacionBean")
@Scope(Constantes.SESSION)
@Getter
@Setter
@NoArgsConstructor
public class NavegacionBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable para almacenar el camino de migas.
	 */
	private DynamicMenuModel caminoMigas;

	/**
	 * Busca si el paso ya está en el camino, de ser así borra los que estén detrás y sino, se añade como nuevo paso al
	 * final del camino.
	 *
	 * @param nombre de la vista
	 * @param ruta de la vista
	 */
	public void adelante(final String nombre, final String ruta) {
		final List<MenuElement> elementos = caminoMigas.getElements();
		DefaultMenuItem e = null;
		final ListIterator<MenuElement> it = elementos.listIterator();
		boolean yaEsta = false;
		while (it.hasNext() && !yaEsta) {
			e = (DefaultMenuItem) it.next();
			yaEsta = nombre.equals(e.getValue());
		}
		if (yaEsta) {
			elementos.subList(it.nextIndex(), elementos.size()).clear();
		}
		else {
			final DefaultMenuItem nuevo = new DefaultMenuItem();
			nuevo.setUrl(ruta);
			nuevo.setValue(nombre);
			caminoMigas.addElement(nuevo);
		}
	}

	/**
	 * Crea el camino de migas de pan con la página principal como primer elemento del menú.
	 *
	 */
	public void iniciarCamino() {
		caminoMigas = new DynamicMenuModel();
		final DefaultMenuItem inicio = new DefaultMenuItem();
		inicio.setUrl("/index.xhtml");
		inicio.setIcon("ui-icon-home");
		inicio.setTitle("Menú Principal");
		caminoMigas.addElement(inicio);
	}

	/**
	 * PostConstruct, inicializa el bean.
	 *
	 */
	@PostConstruct
	public void init() {
		iniciarCamino();
	}

	/**
	 * Recomienza el camino al acceder a una opción del menú.
	 *
	 * @param nombre de la vista
	 * @param ruta de la vista
	 */
	public void recomenzar(final String nombre, final String ruta) {
		iniciarCamino();
		adelante(nombre, ruta);
	}

}
