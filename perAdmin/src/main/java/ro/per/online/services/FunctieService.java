package ro.per.online.services;

import java.util.List;

import ro.per.online.persistence.entities.PTeam;

/**
 * Interfață pentru serviciul de PTeam.
 *
 * @author STAD
 *
 */
public interface FunctieService {

	/**
	 * Elimina un cuerpo de estado.
	 * 
	 * @param cuerpo a eliminar
	 */
	void delete(PTeam functie);

	/**
	 * Cauta toate functiile
	 *
	 * @return lista de functii.
	 */
	List<PTeam> fiindAll();

	/**
	 * Inregistreaza o functie.
	 * @param functie PTeam
	 * @return functie actualizata
	 */
	PTeam save(PTeam functie);

}
