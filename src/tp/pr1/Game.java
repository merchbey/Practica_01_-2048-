package tp.pr1;
import java.util.Random;

public class Game {
	private Board _board;
	private int _size;
	private int _initCells;
	private Random _myRandom;
	
	public Game(int dimension,int iniCells,Random aleatorio) {
		_size=dimension;
		_initCells=iniCells;
		_myRandom=aleatorio;
		_board= new Board(_size);
		for(int i=0; i< _initCells;i++) {
			//este bucle no es correcto
			Position pos = new Position();
			pos.setColumna(_myRandom.nextInt(_size));
			pos.setFila(_myRandom.nextInt(_size));
			_board.setCell(pos, aleatorio());
		}
	}
	
	public void move(Direction dir) {
		
		//ultima parte del metodo !!no es correcto!!
		Position pos = new Position();
		pos.setColumna(_myRandom.nextInt(_size));
		pos.setFila(_myRandom.nextInt(_size));
		_board.setCell(pos, aleatorio());
	}
	
	public void reset() {
		
	}
	
	private int aleatorio() {
		int random=(int) ((Math.random()*10)+1);
		if(random>9)
			return 2;
		else
			return 4;
	}
}
