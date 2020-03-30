package desafio_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.previred.desafio.tres.uf.DatosUf;
import com.previred.desafio.tres.uf.Valores;
import com.previred.desafio.tres.uf.vo.Uf;
import com.previred.desafio.tres.uf.vo.Ufs;




public class Despliega {
	private final static int LIMIT_LIST = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Valores valoresRango = new Valores();
			Ufs	rangosUF = valoresRango.getRango();
			Set<Uf>	ufsRangosValores = rangosUF.getUfs();

			//obtener listado de clase Datos con el rango de getRango para que retorne el rango sin lagunas
			DatosUf listadoDatos = DatosUf.getInstance();//retorna desde 1 Ene 2010 - 31 Dic 2014
			List<Uf> filterDatosUfs = listadoDatos.getUfs(rangosUF.getInicio(), rangosUF.getFin());

			//elimino lo que ya tengo en getRango, de la lista sin lagunas
			Set<Uf> listAllFilterRange = new HashSet<Uf>(filterDatosUfs); 
			listAllFilterRange.removeAll(rangosUF.getUfs());

			//se asigna listado que contiene lo que le faltaba a rangos de la clase Valores
			ufsRangosValores.addAll(listAllFilterRange);

			//set a objeto de clase Valores la lista sin lagunas
			rangosUF.setUfs(ufsRangosValores);

			//se ordena la lista sin lagunas
			List<Uf> rangoUfsOrderList = rangosUF.getUfs().stream().sorted((e2, e1) -> 
			e1.getFecha().compareTo(e2.getFecha())).collect(Collectors.toList());

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDateI = dateFormat.format(rangosUF.getInicio());
			String strDateF = dateFormat.format(rangosUF.getFin());

			//Se itera el listado para asignar cada dato al nuevo ArrayList con los nombres de atributos nuevos 
			Iterator<Uf> iteratorValores = rangoUfsOrderList.iterator(); 
			List <UFs> UFsList = new ArrayList<UFs>();
			RangosUfsOrden rangosUFs = new RangosUfsOrden();
			rangosUFs.setInicio(strDateI);
			rangosUFs.setFin(strDateF);

			//se itera la lista para obtener valores de UF y Fecha y asignarlos a los nuevos nombres de atributos
			int acum = 0;
			while (iteratorValores.hasNext() && acum<LIMIT_LIST) {
				acum = acum + 1;
				Uf ufValor = iteratorValores.next(); 
				UFs ufDato = new UFs(); 
				ufDato.setDato(ufValor.getValor());
				ufDato.setFecha(dateFormat.format(ufValor.getFecha()));
				UFsList.add(ufDato);
			}

			//Se asigna nuevo listado 
			rangosUFs.setUFs(UFsList);

			//se convierte a Json la lista sin lagunas
			final Gson prettyGsonRangosValores = new GsonBuilder().setPrettyPrinting().create();
			final String ordenado = prettyGsonRangosValores.toJson(rangosUFs);		

			//se genera archivo de salida en formato Json
			File directorio = new File("c:\\Desafio3");

			if (!directorio.exists()) {
				if (directorio.mkdirs()) {
					String ruta = "c:\\Desafio3/valores.json";
					FileWriter fileWriter = new FileWriter(ruta);
					fileWriter.write(ordenado);
					fileWriter.close();
				} 
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
