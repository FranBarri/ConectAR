package sistema;

import javax.swing.JOptionPane;

import org.geonames.InvalidParameterException;
import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

import gSon.Localidad;

public class Geonames {
	public static void buscarPorNombre(String nombre) throws InvalidParameterException {
		WebService.setUserName("franbarri");
		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		searchCriteria.setQ(nombre);
		searchCriteria.setCountryCode("AR");
		searchCriteria.setStyle(Style.FULL);
		ToponymSearchResult searchResult;
		try {
			searchResult = WebService.search(searchCriteria);
			if (searchResult.getToponyms().size() > 0) {
				for (Toponym toponym : searchResult.getToponyms()) {
					Localidad local = Registro.generarLocalidad(toponym.getName(), toponym.getAdminName1(), toponym.getLatitude(), toponym.getLongitude());
					Registro.registrarLocalidad(local);
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se encontraron resultados para: " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
