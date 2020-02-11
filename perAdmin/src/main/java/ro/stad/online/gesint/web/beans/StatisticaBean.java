package ro.per.online.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import ro.per.online.persistence.entities.Optiune;
import ro.per.online.persistence.entities.PProvince;
import ro.per.online.persistence.entities.PTeam;
import ro.per.online.persistence.entities.Statistica;
import ro.per.online.persistence.entities.Users;
import ro.per.online.services.OptiuneService;
import ro.per.online.services.PTeamService;
import ro.per.online.services.ProvinceService;
import ro.per.online.services.StatisticaService;
import ro.per.online.services.TeamService;
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

	/**
	 * Constante log
	 */
	private static final Logger LOG = LoggerFactory.getLogger(StatisticaBean.class.getSimpleName());

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Vatiable map
	 */
	public static Map<String, String> mapa;

	/**
	 * Lista registrelor din mapa.
	 */
	private List<Statistica> listaJudete;

	/**
	 * Lista registrelor de optiuni.
	 */
	private List<Optiune> listaOptiuni;

	/**
	 * Service de Statistica.
	 */
	@Autowired
	private transient StatisticaService statisticaService;

	/**
	 * Service de Optiune.
	 */
	@Autowired
	private transient OptiuneService optiuneService;

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

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaAB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaAG;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaIF;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaAR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBC;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBH;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBN;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBV;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBZ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaCJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaCL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaCT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaCS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaCV;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaDB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaDJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaGJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaGL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaGR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaHD;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaHR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaIL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaIS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaMH;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaMM;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaMS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaNT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaOT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaPH;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaSB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaSJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaSM;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaSV;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaTL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaTM;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaTR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaVL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaVN;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaVS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaBT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLAB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLAG;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLIF;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLAR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBC;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBH;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBN;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBV;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBZ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLCJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLCL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLCT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLCS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLCV;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLDB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLDJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLGJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLGL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLGR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLHD;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLHR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLIL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLIS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLMH;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLMM;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLMS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLNT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLOT;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLPH;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLSB;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLSJ;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLSM;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLSV;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLTL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLTM;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLTR;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLVL;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLVN;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLVS;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String etichetaLBT;

	/**
	 * Variabila pentru culoarea etichetei sectorului
	 */
	private String etichetaLS1;

	/**
	 * Variabila pentru culoarea etichetei sectorului
	 */
	private String etichetaLS2;

	/**
	 * Variabila pentru culoarea etichetei sectorului
	 */
	private String etichetaLS3;

	/**
	 * Variabila pentru culoarea etichetei sectorului
	 */
	private String etichetaLS4;

	/**
	 * Variabila pentru culoarea etichetei sectorului
	 */
	private String etichetaLS5;

	/**
	 * Variabila pentru culoarea etichetei sectorului
	 */
	private String etichetaLS6;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private String numeOrganizatie;

	/**
	 * Variabila pentru culoarea etichetei judetului
	 */
	private Integer totalMembrii;

	/**
	 * Presedinte Filiala.
	 */
	private Users presedinteFiliala;

	/**
	 * Conducere Filiala.
	 */
	private List<Users> conducereFiliala;

	/**
	 * Variabila utilizata pentru a injecta serviciul functilor
	 *
	 */
	@Autowired
	private PTeamService pteamService;

	/**
	 * Variabila utilizata pentru a injecta serviciul provinciei.
	 *
	 */
	@Autowired
	private ProvinceService provinceService;

	/**
	 * Variabila pentru a vizualiza stema judetului
	 */
	private String codulProvinciei;

	/**
	 * Variabila pentru judet
	 */
	private PProvince judet;

	/**
	 * Variabila pentru a verifica daca prezentam svg-ul Bucurestiului
	 */
	private String esteBucuresti;

	/**
	 * Service de functii.
	 */
	@Autowired
	private TeamService teamService;

	/**
	 * Metoda care obtine cele mai bune si slabe localitati
	 */
	public String buttonAction(final String code) {
		LOG.info("buttonAction.String code: " + code);
		esteBucuresti = "NU";
		if (code.equals("B")) {
			esteBucuresti = "DA";
		}
		codulProvinciei = Constantes.ESPACIO;
		presedinteFiliala = new Users();
		conducereFiliala = new ArrayList<>();
		listaOptiuni = new ArrayList<>();

		userBusqueda = new UsuarioBusqueda();
		judet = new PProvince();
		PTeam team = new PTeam();
		final Long idTeam = 21L;
		team = teamService.findOne(idTeam);
		obtenerLocalitateSuperiorProcentaj(code);
		final PProvince prov = provinceService.findById(code);
		listaOptiuni = optiuneService.findByCodeProvince(prov);
		judet = prov;
		presedinteFiliala = userService.findByTeamAndProvince(team, prov);
		final List<PTeam> lista = new ArrayList<>();
		incarcamToateFunctileLocale(lista);
		conducereFiliala = userService.findByProvinceAndTeam(prov, lista);
		codulProvinciei = code;
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
	 * @param localitate
	 */
	private void incarcareEticheteSectoare(final StatisticaLocalitateDTO localitate) {
		if (localitate.getSector() != null && localitate.getCodeProvincie().equals("B")) {

			if (localitate.getSector().equals("Sector 5")) {
				if (localitate.getEticheta().equals("verde")) {
					etichetaLS5 = "fill:green;";
				}
				else if (localitate.getEticheta().equals("galben")) {
					etichetaLS5 = "fill:yellow;";
				}
				else {
					etichetaLS5 = "fill:red;";
				}
			}
			if (localitate.getSector().equals("Sector 4")) {
				if (localitate.getEticheta().equals("verde")) {
					etichetaLS4 = "fill:green;";
				}
				else if (localitate.getEticheta().equals("galben")) {
					etichetaLS4 = "fill:yellow;";
				}
				else {
					etichetaLS4 = "fill:red;";
				}
			}
			if (localitate.getSector().equals("Sector 3")) {
				if (localitate.getEticheta().equals("verde")) {
					etichetaLS3 = "fill:green;";
				}
				else if (localitate.getEticheta().equals("galben")) {
					etichetaLS3 = "fill:yellow;";
				}
				else {
					etichetaLS3 = "fill:red;";
				}
			}
			if (localitate.getSector().equals("Sector 2")) {
				if (localitate.getEticheta().equals("verde")) {
					etichetaLS2 = "fill:green;";
				}
				else if (localitate.getEticheta().equals("galben")) {
					etichetaLS2 = "fill:yellow;";
				}
				else {
					etichetaLS2 = "fill:red;";
				}
			}
			if (localitate.getSector().equals("Sector 1")) {
				if (localitate.getEticheta().equals("verde")) {
					etichetaLS1 = "fill:green;";
				}
				else if (localitate.getEticheta().equals("galben")) {
					etichetaLS1 = "fill:yellow;";
				}
				else {
					etichetaLS1 = "fill:red;";
				}
			}
			if (localitate.getSector().equals("Sector 6")) {
				if (localitate.getEticheta().equals("verde")) {
					etichetaLS6 = "fill:green;";
				}
				else if (localitate.getEticheta().equals("galben")) {
					etichetaLS6 = "fill:yellow;";
				}
				else {
					etichetaLS6 = "fill:red;";
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
		esteBucuresti = "NU";
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
		LOG.info("obtenerJudetSuperiorProcentaj.listaJudSuprProCautare.size: " + listaJudSuprProCautare.size());
		for (final StatisticaJudetDTO judet : listaJudSuprProCautare) {
			judet.setValoare(obtenerValoare(judet.getProcentaj()));
			if (judet.getValoare().equals("BUN")) {
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
		LOG.info("obtenerLocalitateSuperiorProcentaj.listaLocSuprProCautare.size: " + listaLocSuprProCautare.size());
		numeOrganizatie = listaLocSuprProCautare.get(0).getNumeProvincie();
		totalMembrii = listaLocSuprProCautare.get(0).getTotalMembrii();
		for (final StatisticaLocalitateDTO localitate : listaLocSuprProCautare) {

			if (localitate.getSector() != null) {
				localitate.setNumeLocalitate(localitate.getSector());
			}
			localitate.setValoare(obtenerValoare(localitate.getProcentaj()));
			if (localitate.getValoare().equals("BUN")) {
				localitate.setEticheta("verde");
			}
			else if (localitate.getValoare().equals("ACCEPTABIL")) {
				localitate.setEticheta("galben");
			}
			else {
				localitate.setEticheta("rosu");

			}
			incarcareEticheteSectoare(localitate);

			if (localitate.getSector() != null || !localitate.getCodeProvincie().equals("B")) {
				listaLocalitatiSuperiorProcentaj.add(localitate);
			}
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
		if (procentaj >= 50) {
			valoare = "BUN";
		}
		else if (procentaj < 50 && procentaj >= 30) {
			valoare = "ACCEPTABIL";
		}
		else {
			valoare = "NECONVINGATOR";
		}
		return valoare;
	}

	/**
	 * @param lista
	 *
	 */
	private void incarcamToateFunctileLocale(final List<PTeam> lista) {
		final PTeam functia = pteamService.findById(21L);
		lista.add(functia);
		final PTeam functia2 = pteamService.findById(29L);
		lista.add(functia2);
		final PTeam functia3 = pteamService.findById(28L);
		lista.add(functia3);
	}
}
