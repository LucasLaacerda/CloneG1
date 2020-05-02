package br.com.noticias.g1;

import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.noticias.g1.controller.WebCaptura;
import br.com.noticias.g1.model.Noticia;

@RestController
@SpringBootApplication
public class G1Application extends Noticia{

	public static void main(String[] args) {
		SpringApplication.run(G1Application.class, args);
	}
	@RequestMapping("/cloneg1")
	public String atualizaG1(){	
		Noticia news = new Noticia();
		WebCaptura captura = new WebCaptura();
		captura.main(null, news);
		return captura.atualizaG1(); //Herança
	}
}
