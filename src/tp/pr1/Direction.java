package tp.pr1;

public enum Direction {
UP(-1,0), DOWN(1,0), LEFT(0,-1), RIGHT(0,1);
	
	
	int filaIncrementada;
	int columnaIncrementada;
	
	private Direction(int fila, int columna){
		this.filaIncrementada = fila;
		this.columnaIncrementada = columna;
		
	}
	
	public int getFilaIncrementada(){
	return filaIncrementada;	
	}
	public int getColumnaIncrementada(){
		return columnaIncrementada;
	}
}
