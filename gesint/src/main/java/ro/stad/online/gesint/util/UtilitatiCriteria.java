package ro.stad.online.gesint.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import ro.stad.online.gesint.constante.Constante;

/**
 * Clasa de utilități pentru a stabili condițiile de criterii.
 * @author STAD
 *
 */
@Component
public final class UtilitatiCriteria {

	/**
	 * Metoda de a stabili un criteriu de căutare pe un criteriu cu valoarea nulă pe un câmp.
	 *
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setCondicionNull(final Criteria criteria, final String numeCamp) {
		criteria.add(Restrictions.isNull(numeCamp));
	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe un criteriu cu operatorul mai mare de.
	 *
	 * @param dataIncepand Date
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaDataMaiMare(final Date dataIncepand, final Criteria criteria,
			final String numeCamp) {
		if (dataIncepand != null) {
			final Date dataIncepandEgal = new Date(dataIncepand.getTime());
			criteria.add(Restrictions.ge(numeCamp, dataIncepandEgal));
		}

	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe un criteriu cu operatorul mai mic de.
	 *
	 * @param dataPana Date
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaDataMaiMica(final Date dataPana, final Criteria criteria,
			final String numeCamp) {
		if (dataPana != null) {
			final Date dataPanaEgal = new Date(dataPana.getTime());
			criteria.add(Restrictions.lt(numeCamp, dataPanaEgal));
		}

	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe un criteriu cu operatorul mai mic de.
	 *
	 * @param dataPana Date
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaDataMaiMicaSauEgala(final Date dataPana, final Criteria criteria,
			final String numeCamp) {
		if (dataPana != null) {
			final Date dataPanaEgal = new Date(dataPana.getTime() + TimeUnit.DAYS.toMillis(1));
			criteria.add(Restrictions.le(numeCamp, dataPanaEgal));
		}

	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe criterii cu același operator și aceeași valoare booleană.
	 *
	 * @param valoare Boolean
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaEgalitateBoolean(final Boolean valoare, final Criteria criteria,
			final String numeCamp) {
		if (valoare != null) {
			criteria.add(Restrictions.eq(numeCamp, valoare));
		}
	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe un criteriu cu același operator între enume.
	 *
	 * @param valoare Object
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaEgalitateEnum(final Object valoare, final Criteria criteria,
			final String numeCamp) {
		if (valoare != null) {
			criteria.add(Restrictions.eq(numeCamp, valoare));
		}
	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe criterii cu același operator și aceeași valoare int.
	 *
	 * @param valoare Object
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaEgalitateInt(final Object valoare, final Criteria criteria,
			final String numeCamp) {
		if (valoare != null && !Constante.SPATIU.equals(valoare.toString().trim())) {
			criteria.add(Restrictions.eq(numeCamp, Integer.parseInt(valoare.toString().trim())));
		}
	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe criterii cu același operator și aceeași valoare long.
	 *
	 * @param valoare Object
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaEgalitateLong(final Object valoare, final Criteria criteria,
			final String numeCamp) {
		if (valoare != null && !Constante.SPATIU.equals(valoare.toString().trim())) {
			criteria.add(Restrictions.eq(numeCamp, Long.parseLong(valoare.toString().trim())));
		}
	}

	/**
	 * Metoda de a stabili un criteriu de căutare pe un criteriu cu operatorul similar.
	 *
	 * @param valoare Object
	 * @param criteria Criteria
	 * @param numeCamp String
	 */
	public static void setConditieCriteriaTextLike(final Object valoare, final Criteria criteria,
			final String numeCamp) {
		if (valoare != null && !((String) valoare).equals(Constante.SPATIU) && !Constante.SPATIU.equals(valoare)) {
			criteria.add(Restrictions.ilike(numeCamp, valoare.toString().trim(), MatchMode.ANYWHERE));
		}
	}

	/**
	 * Constructor privat
	 */
	private UtilitatiCriteria() {

	}
}