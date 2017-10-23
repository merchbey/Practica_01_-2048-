package tp.pr1;
import java.util.Scanner;

public class Controller {
	private Game game;
	private Scanner in;
	
	public void run() {
		String comando;
		Direction dir;
		System.out.println("instruccion >");
		comando=in.nextLine().toUpperCase();
		switch (comando) {
		case "MOVE":
			System.out.println("Move must be followed by a direction: up, down, left or right");
			break;
		case "MOVE UP":
			dir=Direction.UP;
			game.move(dir);
			break;
		case "MOVE DOWN":
			dir=Direction.DOWN;
			game.move(dir);
			break;
		case "MOVE LEFT":
			dir=Direction.LEFT;
			game.move(dir);
			break;
		case "MOVE RIGHT":
			dir=Direction.RIGHT;
			game.move(dir);
			break;
		case "EXIT":
			
			break;
		case "RESET":
			game.reset();
			break;
		case "HELP":
			System.out.println("Move <direction>: execute a move in one of the four directions, up, down, left, right");
			System.out.println("Reset: start a new game");
			System.out.println("Help: print this help message");
			System.out.println("Exit: terminate the program");
			break;
		default:
			System.out.println("Unknown command");
		
			
		}
		
	}
}
