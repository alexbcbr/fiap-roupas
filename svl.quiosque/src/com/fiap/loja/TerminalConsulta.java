package com.fiap.loja;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TerminalConsulta {
	private static final Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		Calendar hoje =  Calendar.getInstance();
		DateFormat fmt = DateFormat.getDateInstance(java.text.DateFormat.MEDIUM);
		System.out.println(PropriedadesSingleton.getInstance().getProperty("empresa") + "\t\tData: " + fmt.format(hoje.getTime()));
		System.out.println("************************************");

		System.out.print("Codigo do Produto:");
		String txtCodigo = teclado.next();
		log.debug("Peguei o valor:" + txtCodigo);

		if (txtCodigo.equals("401"))
			System.out.println("Descricao:" + "Camiseta Masculina Manga Curta");
		else
			System.out.println("Descricao:" + "Camiseta Feminina Manga Cumprida Rosa");
		
		System.out.println("************************************");
		
		log.warn("Fim de Aplicacao");

	}

}
