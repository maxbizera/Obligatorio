package Logica;

public class ColeccionNinos {
	private Nino[] arregloNinos;
	private int tope;
	private int maximoNinos;
	private int maximoRegistros;

	
	public ColeccionNinos(int maximoNinos, int maximoRegistros) {
		super();
		this.arregloNinos =null;
		this.tope = 0;
		this.maximoNinos = maximoNinos;
		this.maximoRegistros = maximoRegistros;
	}
	
	public Nino[] getArregloNinos() {
		return arregloNinos;
	}
	public void setArregloNinos(Nino[] arregloNinos) {
		this.arregloNinos = arregloNinos;
	}
	public int getTope() {
		return tope;
	}
	public void setTope(int tope) {
		this.tope = tope;
	}
	public int getMaximoNinos() {
		return maximoNinos;
	}
	public void setMaximoNinos(int maximoNinos) {
		this.maximoNinos = maximoNinos;
	}
	public int getMaximoRegistros() {
		return maximoRegistros;
	}
	public void setMaximoRegistros(int maximoRegistros) {
		this.maximoRegistros = maximoRegistros;
	}

	
	
	
	
	
	

}
