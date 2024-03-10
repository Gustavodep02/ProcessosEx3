package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController(){
		
	}
	private String os(){
		return System.getProperty("os.name");// pega o SO e retorna
		 
	}
	public void exibeDistro() {
		String so = os();
		if (so.contains("Windows")) {
			System.out.println("Sistema Windows");
		}else {
			String processo = "cat /etc/os-release";
			try {
				Process process = Runtime.getRuntime().exec(processo);
				InputStream fluxo = process.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				System.out.println(so+" "+linha);
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
