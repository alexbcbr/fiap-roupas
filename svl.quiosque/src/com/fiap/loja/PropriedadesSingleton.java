package com.fiap.loja;

import java.io.IOException;
import java.util.Properties;

public class PropriedadesSingleton {
	
		private static Properties p;
		public static final String ARQ = "arquivo.properties";
		
		public static Properties getInstance() {
			if (p == null){
				try {
					p = new Properties();
					p.load(PropriedadesSingleton.class.getResourceAsStream(ARQ));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return p;
		}
}
