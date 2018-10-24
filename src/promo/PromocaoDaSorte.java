package src.promo;

import src.*;
import java.util.Random;

public class PromocaoDaSorte implements CalculaMilhas {

	@Override
	public int calculaMilhas(int distancia) {
        Random r = new Random(System.currentTimeMillis());
        int percent = r.nextInt(60)+10;
        double taxa = percent/100.0;
		return distancia+(int)(distancia*taxa);
	}

}
