package src;

public class ClienteCiaAerea {
    private int codigo;
    private String nome;
    private CalculaMilhas calculoMilhas;

    public ClienteCiaAerea(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		calculoMilhas = new CalculoNormal();
	}

    public void setCalculoMilhas(CalculaMilhas calculo) {
    	calculoMilhas = calculo;
    }

    public int milhasAcumuladas(int distancia) {
        return calculoMilhas.calculaMilhas(distancia);
    }

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "ClienteCiaAerea [codigo=" + codigo + ", nome=" + nome + "]";
	}
}
