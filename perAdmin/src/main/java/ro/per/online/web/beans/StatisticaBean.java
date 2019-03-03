package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.per.online.constantes.Constantes;
import ro.per.online.modelo.dao.StatisticaJudetDAO;
import ro.per.online.modelo.dao.StatisticaLocalitateDAO;
import ro.per.online.modelo.dto.estadisticas.StatisticaJudetDTO;
import ro.per.online.modelo.dto.estadisticas.StatisticaLocalitateDTO;
import ro.per.online.modelo.filters.StatisticaJudeteBusqueda;
import ro.per.online.persistence.entities.Statistica;
import ro.per.online.services.StatisticaService;
import ro.per.online.services.UserService;

/**
 * Clase utilizada pentru a incarca statistica
 *
 * @author STAD
 *
 */
@Component("statisticaBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constantes.SESSION)
public class StatisticaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Map<String, String> mapa;

	/**
	 * Lista registrelor din mapa.
	 */
	private List<Statistica> listaJudete;

	/**
	 * Service de Statistica.
	 */
	@Autowired
	private transient StatisticaService statisticaService;

	/**
	 * Variabila pentru numarul total de membrii
	 */
	private Long rowCount;

	/**
	 * Servicio de usuarios.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Objeto de búsqueda de usuario.
	 */
	private UsuarioBusqueda userBusqueda;

	/**
	 * Lista de booleanos para el control de la visualización de columnas en la vista.
	 */
	private List<Boolean> list;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaJudetDTO> listaJudeteSuperiorProcentaj;

	/**
	 * Variabila listaLocalitati Superior
	 */
	private List<StatisticaLocalitateDTO> listaLocalitatiSuperiorProcentaj;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaJudetDTO> listaJudSuprProCautare;

	/**
	 * Variabila listaJudeteSuperior
	 */
	private List<StatisticaLocalitateDTO> listaLocSuprProCautare;

	/**
	 * Variabila pentru serviciul de statistica.
	 */
	@Autowired
	private transient StatisticaJudetDAO statisticaJudetService;

	/**
	 * Variabila pentru serviciul de statistica.
	 */
	@Autowired
	private transient StatisticaLocalitateDAO statisticaLocalitateService;

	/**
	 * Variabila pentru datele de cautare ale statisticii.
	 */
	private StatisticaJudeteBusqueda statisticaJudeteBusqueda;

	private String etichetaAB;

	private String etichetaAG;

	private String etichetaB;

	private String etichetaIF;

	private String etichetaAR;

	private String etichetaBC;

	private String etichetaBH;

	private String etichetaBN;

	private String etichetaBR;

	private String etichetaBV;

	private String etichetaBZ;

	private String etichetaCJ;

	private String etichetaCL;

	private String etichetaCT;

	private String etichetaCS;

	private String etichetaCV;

	private String etichetaDB;

	private String etichetaDJ;

	private String etichetaGJ;

	private String etichetaGL;

	private String etichetaGR;

	private String etichetaHD;

	private String etichetaHR;

	private String etichetaIL;

	private String etichetaIS;

	private String etichetaMH;

	private String etichetaMM;

	private String etichetaMS;

	private String etichetaNT;

	private String etichetaOT;

	private String etichetaPH;

	private String etichetaSB;

	private String etichetaSJ;

	private String etichetaSM;

	private String etichetaSV;

	private String etichetaTL;

	private String etichetaTM;

	private String etichetaTR;

	private String etichetaVL;

	private String etichetaVN;

	private String etichetaVS;

	private String etichetaBT;

	private String etichetaLAB;

	private String etichetaLAG;

	private String etichetaLB;

	private String etichetaLIF;

	private String etichetaLAR;

	private String etichetaLBC;

	private String etichetaLBH;

	private String etichetaLBN;

	private String etichetaLBR;

	private String etichetaLBV;

	private String etichetaLBZ;

	private String etichetaLCJ;

	private String etichetaLCL;

	private String etichetaLCT;

	private String etichetaLCS;

	private String etichetaLCV;

	private String etichetaLDB;

	private String etichetaLDJ;

	private String etichetaLGJ;

	private String etichetaLGL;

	private String etichetaLGR;

	private String etichetaLHD;

	private String etichetaLHR;

	private String etichetaLIL;

	private String etichetaLIS;

	private String etichetaLMH;

	private String etichetaLMM;

	private String etichetaLMS;

	private String etichetaLNT;

	private String etichetaLOT;

	private String etichetaLPH;

	private String etichetaLSB;

	private String etichetaLSJ;

	private String etichetaLSM;

	private String etichetaLSV;

	private String etichetaLTL;

	private String etichetaLTM;

	private String etichetaLTR;

	private String etichetaLVL;

	private String etichetaLVN;

	private String etichetaLVS;

	private String etichetaLBT;

	private String numeOrganizatie;

	private Integer totalMembrii;

	/**
	 * Metoda care obtine cele mai bune si slabe localitati
	 */
	public String buttonAction(final String code) {
		obtenerLocalitateSuperiorProcentaj(code);
		return "/estadisticas/statisticaJudete.xhtml?faces-redirect=true";
	}

	/**
	 *
	 *
	 */
	public void cargarEtichetas(final Map<String, String> mapa) {
		for (final Map.Entry<String, String> entry : mapa.entrySet()) {
			if (entry.getKey().equals("AB")) {
				etichetaAB = entry.getValue();
			}
			else if (entry.getKey().equals("AG")) {
				etichetaAG = entry.getValue();
			}
			else if (entry.getKey().equals("B")) {
				etichetaB = entry.getValue();
			}
			else if (entry.getKey().equals("BT")) {
				etichetaBT = entry.getValue();
			}
			else if (entry.getKey().equals("IF")) {
				etichetaIF = entry.getValue();
			}
			else if (entry.getKey().equals("AR")) {
				etichetaAR = entry.getValue();
			}
			else if (entry.getKey().equals("BC")) {
				etichetaBC = entry.getValue();
			}
			else if (entry.getKey().equals("BH")) {
				etichetaBH = entry.getValue();
			}
			else if (entry.getKey().equals("BN")) {
				etichetaBN = entry.getValue();
			}
			else if (entry.getKey().equals("BR")) {
				etichetaBR = entry.getValue();
			}
			else if (entry.getKey().equals("BZ")) {
				etichetaBZ = entry.getValue();
			}
			else if (entry.getKey().equals("BV")) {
				etichetaBV = entry.getValue();
			}
			else if (entry.getKey().equals("CJ")) {
				etichetaCJ = entry.getValue();
			}
			else if (entry.getKey().equals("CL")) {
				etichetaCL = entry.getValue();
			}
			else if (entry.getKey().equals("CS")) {
				etichetaCS = entry.getValue();
			}
			else if (entry.getKey().equals("CT")) {
				etichetaCT = entry.getValue();
			}
			else if (entry.getKey().equals("CV")) {
				etichetaCV = entry.getValue();
			}
			else if (entry.getKey().equals("DB")) {
				etichetaDB = entry.getValue();
			}
			else if (entry.getKey().equals("DJ")) {
				etichetaDJ = entry.getValue();
			}
			else if (entry.getKey().equals("GJ")) {
				etichetaGJ = entry.getValue();
			}
			else if (entry.getKey().equals("GL")) {
				etichetaGL = entry.getValue();
			}
			else if (entry.getKey().equals("GR")) {
				etichetaGR = entry.getValue();
			}
			else if (entry.getKey().equals("HD")) {
				etichetaHD = entry.getValue();
			}
			else if (entry.getKey().equals("HR")) {
				etichetaHR = entry.getValue();
			}
			else if (entry.getKey().equals("IL")) {
				etichetaIL = entry.getValue();
			}
			else if (entry.getKey().equals("IS")) {
				etichetaIS = entry.getValue();
			}
			else if (entry.getKey().equals("MH")) {
				etichetaMH = entry.getValue();
			}
			else if (entry.getKey().equals("MM")) {
				etichetaMM = entry.getValue();
			}
			else if (entry.getKey().equals("MS")) {
				etichetaMS = entry.getValue();
			}
			else if (entry.getKey().equals("NT")) {
				etichetaNT = entry.getValue();
			}
			else if (entry.getKey().equals("OT")) {
				etichetaOT = entry.getValue();
			}
			else if (entry.getKey().equals("PH")) {
				etichetaPH = entry.getValue();
			}
			else if (entry.getKey().equals("SB")) {
				etichetaSB = entry.getValue();
			}
			else if (entry.getKey().equals("SJ")) {
				etichetaSJ = entry.getValue();
			}
			else if (entry.getKey().equals("SM")) {
				etichetaSM = entry.getValue();
			}
			else if (entry.getKey().equals("SV")) {
				etichetaSV = entry.getValue();
			}
			else if (entry.getKey().equals("TL")) {
				etichetaTL = entry.getValue();
			}
			else if (entry.getKey().equals("TM")) {
				etichetaTM = entry.getValue();
			}
			else if (entry.getKey().equals("TR")) {
				etichetaTR = entry.getValue();
			}
			else if (entry.getKey().equals("VL")) {
				etichetaVL = entry.getValue();
			}
			else if (entry.getKey().equals("VN")) {
				etichetaVN = entry.getValue();
			}
			else {
				etichetaVS = entry.getValue();
			}
		}

	}

	public void cargarEtichetasJudet(final Map<String, String> map, final String code) {
		for (final Map.Entry<String, String> entry : mapa.entrySet()) {
			if (entry.getKey().equals("AB")) {
				if (code.equals("AB")) {
					etichetaLAB = entry.getValue();
				}
				else {
					etichetaLAB = "fill:white;";
				}
			}
			else if (entry.getKey().equals("AG")) {
				if (code.equals("AG")) {
					etichetaLAG = entry.getValue();
				}
				else {
					etichetaLAG = "fill:white;";
				}
			}
			else if (entry.getKey().equals("B")) {
				if (code.equals("B")) {
					etichetaLB = entry.getValue();
				}
				else {
					etichetaLB = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BT")) {
				if (code.equals("BT")) {
					etichetaLBT = entry.getValue();
				}
				else {
					etichetaLBT = "fill:white;";
				}
			}
			else if (entry.getKey().equals("IF")) {
				if (code.equals("IF")) {
					etichetaLIF = entry.getValue();
				}
				else {
					etichetaLIF = "fill:white;";
				}
			}
			else if (entry.getKey().equals("AR")) {
				if (code.equals("AR")) {
					etichetaLAR = entry.getValue();
				}
				else {
					etichetaLAR = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BC")) {
				if (code.equals("BC")) {
					etichetaLBC = entry.getValue();
				}
				else {
					etichetaLBC = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BH")) {
				if (code.equals("BH")) {
					etichetaLBH = entry.getValue();
				}
				else {
					etichetaLBH = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BN")) {
				if (code.equals("BN")) {
					etichetaLBN = entry.getValue();
				}
				else {
					etichetaLBN = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BR")) {
				if (code.equals("BR")) {
					etichetaLBR = entry.getValue();
				}
				else {
					etichetaLBR = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BZ")) {
				if (code.equals("BZ")) {
					etichetaLBZ = entry.getValue();
				}
				else {
					etichetaLBZ = "fill:white;";
				}
			}
			else if (entry.getKey().equals("BV")) {
				if (code.equals("BV")) {
					etichetaLBV = entry.getValue();
				}
				else {
					etichetaLBV = "fill:white;";
				}
			}
			else if (entry.getKey().equals("CJ")) {
				if (code.equals("CJ")) {
					etichetaLCJ = entry.getValue();
				}
				else {
					etichetaLCJ = "fill:white;";
				}
			}
			else if (entry.getKey().equals("CL")) {
				if (code.equals("CL")) {
					etichetaLCL = entry.getValue();
				}
				else {
					etichetaLCL = "fill:white;";
				}
			}
			else if (entry.getKey().equals("CS")) {
				if (code.equals("CS")) {
					etichetaLCS = entry.getValue();
				}
				else {
					etichetaLCS = "fill:white;";
				}
			}
			else if (entry.getKey().equals("CT")) {
				if (code.equals("CT")) {
					etichetaLCT = entry.getValue();
				}
				else {
					etichetaLCT = "fill:white;";
				}
			}
			else if (entry.getKey().equals("CV")) {
				if (code.equals("CV")) {
					etichetaLCV = entry.getValue();
				}
				else {
					etichetaLCV = "fill:white;";
				}
			}
			else if (entry.getKey().equals("DB")) {
				if (code.equals("DB")) {
					etichetaLDB = entry.getValue();
				}
				else {
					etichetaLDB = "fill:white;";
				}
			}
			else if (entry.getKey().equals("DJ")) {
				if (code.equals("DJ")) {
					etichetaLDJ = entry.getValue();
				}
				else {
					etichetaLDJ = "fill:white;";
				}
			}
			else if (entry.getKey().equals("GJ")) {
				if (code.equals("GJ")) {
					etichetaLGJ = entry.getValue();
				}
				else {
					etichetaLGJ = "fill:white;";
				}
			}
			else if (entry.getKey().equals("GL")) {
				if (code.equals("GL")) {
					etichetaLGL = entry.getValue();
				}
				else {
					etichetaLGL = "fill:white;";
				}
			}
			else if (entry.getKey().equals("GR")) {
				if (code.equals("GR")) {
					etichetaLGR = entry.getValue();
				}
				else {
					etichetaLGR = "fill:white;";
				}
			}
			else if (entry.getKey().equals("HD")) {
				if (code.equals("HD")) {
					etichetaLHD = entry.getValue();
				}
				else {
					etichetaLHD = "fill:white;";
				}
			}
			else if (entry.getKey().equals("HR")) {
				if (code.equals("HR")) {
					etichetaLHR = entry.getValue();
				}
				else {
					etichetaLHR = "fill:white;";
				}
			}
			else if (entry.getKey().equals("IL")) {
				if (code.equals("IL")) {
					etichetaLIL = entry.getValue();
				}
				else {
					etichetaLIL = "fill:white;";
				}
			}
			else if (entry.getKey().equals("IS")) {
				if (code.equals("IS")) {
					etichetaLIS = entry.getValue();
				}
				else {
					etichetaLIS = "fill:white;";
				}
			}
			else if (entry.getKey().equals("MH")) {
				if (code.equals("MH")) {
					etichetaLMH = entry.getValue();
				}
				else {
					etichetaLMH = "fill:white;";
				}
			}
			else if (entry.getKey().equals("MM")) {
				if (code.equals("MM")) {
					etichetaLMM = entry.getValue();
				}
				else {
					etichetaLMM = "fill:white;";
				}
			}
			else if (entry.getKey().equals("MS")) {
				if (code.equals("MS")) {
					etichetaLMS = entry.getValue();
				}
				else {
					etichetaLMS = "fill:white;";
				}
			}
			else if (entry.getKey().equals("NT")) {
				if (code.equals("NT")) {
					etichetaLNT = entry.getValue();
				}
				else {
					etichetaLNT = "fill:white;";
				}
			}
			else if (entry.getKey().equals("OT")) {
				if (code.equals("OT")) {
					etichetaLOT = entry.getValue();
				}
				else {
					etichetaLOT = "fill:white;";
				}
			}
			else if (entry.getKey().equals("PH")) {
				if (code.equals("PH")) {
					etichetaLPH = entry.getValue();
				}
				else {
					etichetaLPH = "fill:white;";
				}
			}
			else if (entry.getKey().equals("SB")) {
				if (code.equals("SB")) {
					etichetaLSB = entry.getValue();
				}
				else {
					etichetaLSB = "fill:white;";
				}
			}
			else if (entry.getKey().equals("SJ")) {
				if (code.equals("SJ")) {
					etichetaLSJ = entry.getValue();
				}
				else {
					etichetaLSJ = "fill:white;";
				}
			}
			else if (entry.getKey().equals("SM")) {
				if (code.equals("SM")) {
					etichetaLSM = entry.getValue();
				}
				else {
					etichetaLSM = "fill:white;";
				}
			}
			else if (entry.getKey().equals("SV")) {
				if (code.equals("SV")) {
					etichetaLSV = entry.getValue();
				}
				else {
					etichetaLSV = "fill:white;";
				}
			}
			else if (entry.getKey().equals("TL")) {
				if (code.equals("TL")) {
					etichetaLTL = entry.getValue();
				}
				else {
					etichetaLTL = "fill:white;";
				}
			}
			else if (entry.getKey().equals("TM")) {
				if (code.equals("TM")) {
					etichetaLTM = entry.getValue();
				}
				else {
					etichetaLTM = "fill:white;";
				}
			}
			else if (entry.getKey().equals("TR")) {
				if (code.equals("TR")) {
					etichetaLTR = entry.getValue();
				}
				else {
					etichetaLTR = "fill:white;";
				}
			}
			else if (entry.getKey().equals("VL")) {
				if (code.equals("VL")) {
					etichetaLVL = entry.getValue();
				}
				else {
					etichetaLVL = "fill:white;";
				}
			}
			else if (entry.getKey().equals("VN")) {
				if (code.equals("VN")) {
					etichetaLVN = entry.getValue();
				}
				else {
					etichetaLVN = "fill:white;";
				}
			}
			else {
				if (code.equals("VS")) {
					etichetaLVS = entry.getValue();
				}
				else {
					etichetaLVS = "fill:white;";
				}
			}
		}

	}

	/**
	 * Inițializarea datelor.
	 */
	@PostConstruct
	public void init() {
		listaJudeteSuperiorProcentaj = new ArrayList<>();
		listaLocalitatiSuperiorProcentaj = new ArrayList<>();
		statisticaJudeteBusqueda = new StatisticaJudeteBusqueda();
		numeOrganizatie = Constantes.ESPACIO;
		obtenerStatisticaSupInf();
		rowCount = userService.findCount();

	}

	/**
	 * Metoda care obtine cele mai bune judete
	 */
	private void obtenerJudetSuperiorProcentaj() {
		mapa = new HashMap<>();
		listaJudeteSuperiorProcentaj = new ArrayList<>();
		statisticaJudeteBusqueda.setDescendent("DESC");
		statisticaJudeteBusqueda.setGeneralJudetProcentaj("SI");
		listaJudSuprProCautare = statisticaJudetService.filterStatisticaJudetProcentaj(statisticaJudeteBusqueda);
		for (final StatisticaJudetDTO judet : listaJudSuprProCautare) {
			judet.setValoare(obtenerValoare(judet.getProcentaj()));
			if (judet.getValoare().equals("EXCELENT")) {
				judet.setEticheta("albastru");
				mapa.put(judet.getCode_province(), "fill:blue;");

			}
			else if (judet.getValoare().equals("BUN")) {
				judet.setEticheta("verde");
				mapa.put(judet.getCode_province(), "fill:green;");
			}
			else if (judet.getValoare().equals("ACCEPTABIL")) {
				judet.setEticheta("galben");
				mapa.put(judet.getCode_province(), "fill:yellow;");

			}
			else {
				judet.setEticheta("rosu");
				mapa.put(judet.getCode_province(), "fill:red;");
			}
			listaJudeteSuperiorProcentaj.add(judet);
		}
		cargarEtichetas(mapa);
	}

	/**
	 * Metoda care obtine cele mai bune judete
	 */
	private void obtenerLocalitateSuperiorProcentaj(final String code) {
		numeOrganizatie = Constantes.ESPACIO;
		listaLocalitatiSuperiorProcentaj = new ArrayList<>();
		statisticaJudeteBusqueda.setCode_province(code);
		listaLocSuprProCautare = statisticaLocalitateService
				.filterStatisticaLocalitateProcentaj(statisticaJudeteBusqueda);
		numeOrganizatie = listaLocSuprProCautare.get(0).getNumeProvincie();
		totalMembrii = listaLocSuprProCautare.get(0).getTotalMembrii();
		for (final StatisticaLocalitateDTO localitate : listaLocSuprProCautare) {
			if (localitate.getSector() != null) {
				localitate.setNumeLocalitate(localitate.getSector());
			}
			localitate.setValoare(obtenerValoare(localitate.getProcentaj()));
			if (localitate.getValoare().equals("EXCELENT")) {
				localitate.setEticheta("albastru");
			}
			else if (localitate.getValoare().equals("BUN")) {
				localitate.setEticheta("verde");
			}
			else if (localitate.getValoare().equals("ACCEPTABIL")) {
				localitate.setEticheta("galben");
			}
			else {
				localitate.setEticheta("rosu");

			}
			listaLocalitatiSuperiorProcentaj.add(localitate);
		}
		cargarEtichetasJudet(mapa, code);
	}

	/**
	 * Metoda care obtine cele mai bune si slabe judete
	 */
	private void obtenerStatisticaSupInf() {
		obtenerJudetSuperiorProcentaj();
	}

	/**
	 *
	 */
	private String obtenerValoare(final Float procentaj) {
		String valoare = Constantes.ESPACIO;
		if (procentaj >= 0.35) {
			valoare = "EXCELENT";
		}
		else if (procentaj < 0.35 && procentaj >= 0.20) {
			valoare = "BUN";
		}
		else if (procentaj < 0.20 && procentaj >= 0.10) {
			valoare = "ACCEPTABIL";
		}
		else {
			valoare = "NECONVINGATOR";
		}
		return valoare;
	}

}
