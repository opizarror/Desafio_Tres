package desafio_project;


import java.util.List;

import com.previred.desafio.tres.uf.vo.Uf;



public class RangosUfsOrden {
	private String inicio;
	private String fin;
	private List<UFs> UFs;
	private List<Uf> Ufs;
	
		
	public List<Uf> getUfs() {
		return Ufs;
	}
	public void setUfs(List<Uf> ufs) {
		Ufs = ufs;
	}
	public List<UFs> getUFs() {
		return UFs;
	}
	public void setUFs(List<UFs> uFs) {
		UFs = uFs;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}


}
