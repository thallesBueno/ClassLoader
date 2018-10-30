package src;

import java.util.*;
import java.io.*;

public class App {

	/*
		Acessa o diretório promo/;
		Carrega todos os .class para o java;
		Adiciona todas as classes que estavam no diretório na LinkedList;
		retorna a LinkedList
	*/
	public static LinkedList<CalculaMilhas> attPromos(){

		LinkedList<CalculaMilhas> promos = new LinkedList<>();
		// ClassLoader
		ClassLoader cl = App.class.getClassLoader();
		//Carregas todos os arquivos do diretório promo/
		File dir = new File("./src/promo");
		String[] aux = dir.list();

		// Pega todos os aquivos que terminam com .class e carrega eles
		for(String s : aux)
			if(s.endsWith(".class"))
				try
				{
					Class c = cl.loadClass("src.promo." + s.substring(0,s.length()-6));
					promos.add((CalculaMilhas)c.newInstance());
				}
				catch(Exception e)
				{
					System.out.println(e);
				}

			return promos;

	}
	
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		LinkedList<CalculaMilhas> promos = attPromos();

		while(true){
			System.out.println("------------------");
			System.out.println("\n1 - Promocoes disponiveis");
			System.out.println("2 - Usar promocoes");
			System.out.println("3 - Carregar promocoes");
			System.out.println("4 - exit \n");
			System.out.println("------------------");

			String c = in.next();

			switch(c){
				case "1":
					System.out.println("");
					for(CalculaMilhas p : promos)
						System.out.println(p.getClass().getSimpleName());
					break;

				case "2":
					if(promos.size() < 1){
						System.out.println("não tem promos");
					break;
			}
					System.out.println();
					int i = 1;
					for(CalculaMilhas p : promos)
						System.out.println(i++ + "- " + p.getClass().getSimpleName());

					System.out.println("\nEscolha uma promoção:");
					i = in.nextInt();

					System.out.println("Digite um valor: ");
					int valor = in.nextInt();

					int milhas = promos.get(i-1).calculaMilhas(valor);
					System.out.println("A promoção " + promos.get(i-1).getClass().getSimpleName() + " da "+ milhas + " milhas" );
					break;

				case "3":
					promos = attPromos();
					break;

				case "4":
					System.exit(0);
					break;
			}
		}
	}
}
