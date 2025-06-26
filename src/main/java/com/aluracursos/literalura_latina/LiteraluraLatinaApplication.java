package com.aluracursos.literalura_latina;

import com.aluracursos.literalura_latina.principal.Principal;
import com.aluracursos.literalura_latina.repository.AutorRepository;
import com.aluracursos.literalura_latina.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraluraLatinaApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository librorepo;
	@Autowired
	private AutorRepository autorrepo;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraLatinaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(librorepo, autorrepo);
		principal.muestraElMenu();
	}
}
