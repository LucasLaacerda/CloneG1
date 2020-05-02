package br.com.noticias.g1.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import br.com.noticias.g1.model.Noticia;

public class WebCaptura extends Noticia{
	private static final String URL_API = "https://g1.globo.com/";
	static Document pagina = null;
	static Document g1 = null;
	 public void main(String[] args,Noticia news){
		
		 HttpURLConnection con = null;
			try {
				File input = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\templates\\g1.html");
				pagina = Jsoup.parse(input, "UTF-8");
				URL url = new URL(URL_API);
				con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.connect();
				switch (con.getResponseCode()) {
				case 200:
					System.out.println("JSON recebido!");
					
					String json = getJson(url);
					Document doc = Jsoup.parse(json);
					Elements divs = doc.getElementsByClass("bastian-feed-item");
					g1 = Jsoup.parse(divs.toString());
					String primeirasDivs [] = new String [3];
				    ArrayList<String> arrayDiv = new ArrayList();		
				    
					for(int i=0;i<=primeirasDivs.length-1;i++) {
						
						pagina.getElementById("d"+i).appendChild(divs.get(i+1));//G1
						arrayDiv.add(i,divs.get(i+1).toString());
//						System.out.println(i+" ----------------------");
//						System.out.println(""+primeirasDivs[i]);
//						System.out.println(" ------------------------");
					}
					
					
					
					news.setNoticias(arrayDiv);
					news.setPaginaFinal(pagina);
				
					break;
					
				case 500:
					System.out.println("Status 500");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (con != null)
					con.disconnect();
			}
			
			
	}
	 
	 
	 
	 public static String getJson(URL url) {
			if (url == null)
				throw new RuntimeException("URL é null");

			String html = null;
			StringBuilder sB = new StringBuilder();
			try (BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()))) {
				while ((html = bR.readLine()) != null)
					sB.append(html);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return sB.toString();
		}
	 
	

}
