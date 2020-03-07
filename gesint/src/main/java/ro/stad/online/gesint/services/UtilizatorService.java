package ro.stad.online.gesint.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.model.filters.FiltruEchipa;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.pojo.AnNumarPojo;

/**
 * Interfață pentru serviciul de Echipa.
 *
 * @author STAD
 *
 */
public interface UtilizatorService {

	/**
	 * Metoda care stabileste o lista de utilizatori pentru eliminarea logica.
	 * @param listaUtilizatori Lista de utilizatori a modificar
	 * @return lista de utilizatori modificada
	 */
	List<Utilizator> bajaLogica(List<String> listaUtilizatori);

	/**
	 * Metoda care returneaza o lista cu numele utilizatorilor care sunt in baza de date.
	 * @param listaNume lista cu numele utilizatorilor
	 * @return lista cu numele utilizatorilor List<String>
	 */
	List<String> cautareListaNumeUtilizator(List<String> listaNume);

	/**
	 * Metoda care cauta utilizatori cu criteria fara paginare.
	 * @param filtruUtilizator FiltruUtilizator
	 * @return lista de utilizatori
	 */
	List<Utilizator> cautareUtilizator(FiltruUtilizator filtruUtilizator);

	/**
	 * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
	 * @param first primul element
	 * @param pageSize dimensiunea fiecărei pagini de rezultate
	 * @param sortField câmpul dupa care sunt sortate rezultatele
	 * @param sortOrder direcția de ordonare (ascendent / descendent)
	 * @param filtruUtilizator FiltruUtilizator Obiect care conține criteriile de căutare
	 * @return Lista de utilizatori List<Utilizator>
	 *
	 */
	List<Utilizator> cautareUtilizatorCentralCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			FiltruUtilizator filtruUtilizator);

	/**
	 * Metoda care cauta utilizatori folosind parametrii din filtru.
	 * @param filtruUtilizator FiltruUtilizator
	 * @return lista List<Utilizator>
	 */
	List<Utilizator> cautareUtilizatorCriteria(FiltruUtilizator filtruUtilizator);

	/**
	 * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
	 * @param first primul element
	 * @param pageSize dimensiunea fiecărei pagini de rezultate
	 * @param sortField câmpul dupa care sunt sortate rezultatele
	 * @param sortOrder direcția de ordonare (ascendent / descendent)
	 * @param filtruUtilizator FiltruUtilizator Obiect care conține criteriile de căutare
	 * @return Lista de utilizatori List<Utilizator>
	 *
	 */
	List<Utilizator> cautareUtilizatorCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
			FiltruUtilizator filtruUtilizator);

	/**
	 * Metoda care cauta utilizatori conducere locala folosind parametrii din filtru.
	 * @param filtruEchipa FiltruEchipa
	 * @return lista List<Utilizator>
	 */
	List<Utilizator> cautareUtilizatorCriteriaLocal(FiltruEchipa filtruEchipa);

	/**
	 * Metodă care elimină un utilizator.
	 * @param username Utilizator
	 */
	void delete(Utilizator utilizator);

	/**
	 * Metodă care modifică un utilizator în inactiv.
	 * @param listaUtilizatori Lista de utilizatori pentru modificare
	 * @return lista List<Utilizator> lista de utilizatori modificati
	 */
	List<Utilizator> dezactivare(List<String> listaUtilizatori);

	/**
	 * Metodă care returnează toţi utilizatorii inregistraţi în baza de date.
	 * @return lista List<Utilizator> lista de utilizatori
	 */
	List<Utilizator> fiindAll();

	/**
	 * Metodă care returnează utilizatorul inregistrat în baza de date.
	 * @param id String
	 * @return Utilizator user
	 */
	Utilizator fiindOne(String id);

	/**
	 * Metodă care caută utilizatori dupa email sau documentul de identitate ignorând majuscule.
	 * @param email String email dupa care se cauta
	 * @param cnp documentul utilizatorului
	 * @return lista List<Utilizator> lista cu resultatul cautari
	 *
	 */
	List<Utilizator> findByEmailIgnoreCaseOrDocIdentitateIgnoreCase(String email, String cnp);

	/**
	 * Metodă care caută un utilizator după CNP.
	 * @param cnp String - cnp-ul utilizatorului
	 * @return User
	 */
	Utilizator findByIdCard(String cnp);

	/**
	 * Metodă care caută utilizatori după județ și echipă.
	 * @param jude Judet
	 * @param listaEchipa List<Functie>
	 * @return lista List<Utilizator>
	 */
	List<Utilizator> findByJudetSiEchipa(Judet jude, List<Functie> listaEchipa);

	/**
	 * Metodă care caută utilizatori după localitate.
	 * @param loca Localitate
	 * @return lista List<Utilizator>
	 */
	List<Utilizator> findByLocality(Localitate loca);

	/**
	 * Metodă care caută utilizatori după nume.
	 * @param "destinatar" String
	 * @return lista List<Utilizator>
	 */
	List<Utilizator> findByName();

	/**
	 * Metodă care caută utilizatori după tipul de echipă.
	 * @param functie Functie
	 * @return Utilizator utilizator
	 */
	Utilizator findByTeam(Functie functie);

	/**
	 * Metodă care caută utilizatori după tipul de echipa si judet
	 * @param functie Functie
	 * @param jud Judet
	 * @return Utilizator utilizator
	 */
	Utilizator findByTeamAndJudet(Functie functie, Judet jud);

	/**
	 * Metoda care obține numărul de registre din baza de date
	 * @return Long
	 */
	Long findCount();

	/**
	 * Metodă care caută utilizatori după tipul de sex
	 * @param membru
	 * @return int
	 */
	int findUsersBySex(AnNumarPojo membru);

	/**
	 * Metodă care obține lista de utilizatori din baza de date dupa filtrele din Criteria.
	 * @param filtruUtilizator FiltruUtilizator
	 * @param criteria Criteria
	 * @return lista List<Utilizator> lista utilizatori returnati
	 */
	int getCounCriteria(FiltruUtilizator filtruUtilizator);

	/**
	 * Metodă care obține lista de utilizatori din baza de date dupa filtrele din Criteria.
	 * @param filtruUtilizator FiltruUtilizator
	 * @param criteria Criteria
	 * @return lista List<Utilizator> lista utilizatori returnati
	 */
	int getCounCriteriaCentral(FiltruUtilizator filtruUtilizator);

	/**
	 * Metodă care primeste un fișier din care se recupereaza datele pentru a genera un Document care va fi stocat în
	 * baza de date. Lasă obiectul pregatit pentru salvare.
	 * @param file byte[] fisier care se va stoca in baza de date
	 * @param utilizator Utilizator
	 * @return Document document stocat in bbdd
	 */
	Utilizator incarcareImaginaFaraStocare(byte[] bs, Utilizator user) throws IOException;

	/**
	 * Metodă care salveazîn o listîn de utilizatori în baza de date.
	 * @param utilizatori List<Utilizator>
	 * @return lista List<Utilizator> lista de utilizatori inregistrati
	 */
	List<Utilizator> salvat(List<Utilizator> utilizatori);

	/**
	 * Metodă care salveazîn o listîn de utilizatori provizorii în baza de date.
	 * @param listUsers List<Utilizator>
	 * @return lista List<Utilizator> lista de utilizatori inregistrati
	 *
	 */
	List<Utilizator> save(List<Utilizator> listUsers);

	/**
	 * Metodîn care salvează sau actualizează un utilizator în baza de date.
	 * @param entity Utilizator
	 * @return utilizator Utilizator
	 */
	Utilizator save(Utilizator entity);
}
