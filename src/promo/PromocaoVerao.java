package src.promo;

import src.*;

public class PromocaoVerao implements CalculaMilhas {

	@Override
	public int calculaMilhas(int distancia) {
		return 2*distancia;
	}

}
