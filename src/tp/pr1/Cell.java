package tp.pr1;

public class Cell {
	private int valor;//valor de la cell
	private Position pos;//posicion de la cell
	
	public void setPosicion(int fila,int columna) {
		pos = new Position();
		pos.setColumna(columna);
		pos.setFila(fila);
	}
	public void setValor(int valor) {
		this.valor=valor;
	}
	public Position getPosicion() {
		return pos;
	}
	public int getValor() {
		return valor;
	}
	
	//metodo que comprueba un cell vacia
	public boolean isEmpty() {
		if(valor==0)
			return true;
		return false;
	}
	//metodo para fusionar 2 cells la cell incial se convierte en vacia
	public boolean fusion(Cell vecina) {
		if(valor==vecina.valor && accedente(vecina)) {
			vecina.valor=mutador(vecina);
			valor=0;
			return true;
		}
		return false;
	}
	//metodo para resolver si dos cell son adyacentes
	private boolean accedente(Cell adyacente) {
		int columna=Math.abs(pos.getColumna()-adyacente.pos.getColumna());
		int fila=Math.abs(pos.getFila()-adyacente.pos.getFila());
		//si la diferencia entre columnas o(exclusiva) filas es 1 son adyacentes
		if(fila!=columna && (fila==1 || columna==1))
			return true;
		return false;
	}
	
	//metodo para cambiar el valor ce una cell
	private int mutador(Cell vecina) {
		int resultado =valor+vecina.valor;
		return resultado;
	}
	
	public String toString() {
		return String.valueOf(valor);
	}
	
}
