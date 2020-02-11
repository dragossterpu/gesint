package ro.per.online.modelo.filters;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que contiene la información del paginado
 *
 * @author EZENTIS
 */
@Setter
@Getter
public class PaginacionFilter implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2325303040499472116L;
    
    /**
     * pagina
     */
    private long pagina;

    /**
     * tamanioPagina
     */
    private long tamanioPagina;

}
