package ro.per.online.modelo.filters;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clase que contiene la información del paginado.
 * @author EZENTIS
 */
@Setter
@Getter
public class OrdenacionFilter implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8585064563976203239L;

    /*
     * tipo de Orden
     */
    private String tipoOrden;

    /*
     * Campo de ordenacion
     */
    private String campoOrden;

}
