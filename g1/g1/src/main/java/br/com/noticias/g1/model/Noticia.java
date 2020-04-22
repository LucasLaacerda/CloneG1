package br.com.noticias.g1.model;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

import br.com.noticias.g1.controller.WebCaptura;

public class Noticia {
	
    private ArrayList<String> noticias = new ArrayList();
    private static Document paginaFinal;
    
	public Document getPaginaFinal() {
		return paginaFinal;
	}

	public void setPaginaFinal(Document paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public ArrayList<String> getNoticias() {
		return noticias;
	}

	public void setNoticias(ArrayList<String> noticias) {
		this.noticias = noticias;
	}
  
   
	public static String atualizaG1() {
		
		
		return paginaFinal.toString();
	}

}
