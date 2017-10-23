package tp.pr1;

public class Board {
	private Cell[][] _board;
	private int _boardSize;
	private MoveResults resultado;
	
	public Board(int size) {
		_boardSize=size;
		_board = new Cell[_boardSize][_boardSize];
		for(int i=0;i<_board.length;i++) {
			for(int j=0;j<_board.length;j++) {
				_board[i][j]= new Cell();
				_board[i][j].setPosicion(i, j);
			}	
		}
		resultado = new MoveResults();
	}
	
	public void setCell(Position pos,int value) {
		//System.out.println(_board[0][0].getValor());
		Cell casilla=new Cell();
		casilla.setValor(value);
		casilla.setPosicion(pos.getFila(), pos.getColumna());
		_board[pos.getFila()][pos.getColumna()]= casilla;
	}
	
	public MoveResults executeMove(Direction dir) {
		resultado = new MoveResults();
		//desplazar
		//fusionar
		//volver a desplazar
		//nueva casilla
		desplazar(dir);
		fusionar(dir);
		desplazar(dir);
		resultado.setMoved(true);
		
		return resultado;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
        for (int i=0; i<_board.length; i++) {
            sb.append("|");
            for (int j=0; j<_board.length; j++) {
                sb.append(_board[i][j]+"   |");
            }
            sb.append("\n");
        }
        sb.append("\n"+" Maximo "+resultado.getMaxToken()+" Puntuacion "+resultado.getScore());
        return sb.toString();
	}
	
	//metodo para desplazar
	public void desplazar(Direction dir) {
		int desplColumna[] = new int[_boardSize];//una variable por columna
		int desplFila=0;//contador de desplazamientos de fila
		int aux;
		if(dir.equals(Direction.UP)||dir.equals(Direction.LEFT)) {
			for(int i=0;i<_boardSize;i++) {
				desplFila=0;//reset del contador de despazamientos
				for(int j=0;j<_boardSize;j++) {
					if(_board[i][j].isEmpty()) {
							desplFila=desplFila+dir.columnaIncrementada;
							desplColumna[j]=desplColumna[j]+dir.filaIncrementada;
					}else {
							//desplazar por intercambios
							aux=_board[i+desplColumna[j]][j+desplFila].getValor();
							_board[i+desplColumna[j]][j+desplFila].setValor(_board[i][j].getValor());
							_board[i][j].setValor(aux);
					}
				}
			}
		}else {
			for(int i=_boardSize-1;i>=0;i--) {
				desplFila=0;//reset del contador de despazamientos
				for(int j=_boardSize-1;j>=0;j--) {
					if(_board[i][j].isEmpty()) {
							desplFila=desplFila+dir.columnaIncrementada;
							desplColumna[j]=desplColumna[j]+dir.filaIncrementada;
					}else {
							//desplazar por intercambios
							aux=_board[i+desplColumna[j]][j+desplFila].getValor();
							_board[i+desplColumna[j]][j+desplFila].setValor(_board[i][j].getValor());
							_board[i][j].setValor(aux);
					}
				}
			}
		}
	}
	// metodo que ejecuta las fusiones pertinentes y actualiza casilla Maxima y puntuacion
	private void fusionar(Direction dir) {
		int incremento;
		if(dir.equals(Direction.UP)||dir.equals(Direction.LEFT)) {
			//recorrer el array
			for(int i=0;i<_boardSize;i++) {
				for(int j=0;j<_boardSize;j++) {
					//comprueba que no se salga del array
					if(i-dir.filaIncrementada<_boardSize && j-dir.columnaIncrementada<_boardSize) {
						//calculo del incremento, fusion unica(sin dos seguidas),actualizacion de moveResult
						incremento=_board[i][j].getValor();
						_board[i-dir.filaIncrementada][j-dir.columnaIncrementada].fusion(_board[i][j]);
						incremento=_board[i][j].getValor()-incremento;
						resultado.setScore(incremento*2);
						resultado.setMaxToken(_board[i][j].getValor());
					}
					
				}
			}
		}else {
			//lo mismo pero para las otras dos direcciones
			for(int i=_boardSize-1;i>=0;i--) {
				for(int j=_boardSize-1;j>=0;j--) {
					if(i-dir.filaIncrementada>=0 && j-dir.columnaIncrementada>=0) {
						incremento=_board[i][j].getValor();
						_board[i-dir.filaIncrementada][j-dir.columnaIncrementada].fusion(_board[i][j]);
						incremento=_board[i][j].getValor()-incremento;
						resultado.setScore(incremento*2);
						resultado.setMaxToken(_board[i][j].getValor());
					}
					
				}
			}
		}
	}
	
	public static void main(String[]args) {
		Board prueba=new Board(4);
		
		Position pos=new Position();
		pos.setColumna(0);
		pos.setFila(0);
		prueba.setCell(pos, 2);
		pos.setColumna(1);
		pos.setFila(1);
		prueba.setCell(pos, 4);
		pos.setColumna(2);
		pos.setFila(2);
		prueba.setCell(pos, 2);
		pos.setColumna(3);
		pos.setFila(3);
		prueba.setCell(pos, 4);
		pos.setColumna(0);
		pos.setFila(1);
		prueba.setCell(pos, 2);
		pos.setColumna(0);
		pos.setFila(2);
		prueba.setCell(pos, 4);
		pos.setColumna(0);
		pos.setFila(3);
		prueba.setCell(pos, 2);
		pos.setColumna(1);
		pos.setFila(0);
		prueba.setCell(pos, 4);
		pos.setColumna(3);
		pos.setFila(0);
		prueba.setCell(pos, 4);
		pos.setColumna(2);
		pos.setFila(3);
		prueba.setCell(pos, 2);
		prueba.executeMove(Direction.RIGHT);
		prueba.executeMove(Direction.UP);
		System.out.println(prueba);
	}//*/
}
