package src.promo;

import src.*;

public class ClienteFrequente implements CalculaMilhas {

	@Override
	public int calculaMilhas(int distancia) {
		int qtdade = distancia;
		if (distancia > 2000) {
			qtdade += (int)(qtdade*1.1);
		}
		return qtdade;
	}

}
