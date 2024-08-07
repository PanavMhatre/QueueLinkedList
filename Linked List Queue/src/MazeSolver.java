
abstract class MazeSolver {
	
	Maze maze;
	
	boolean isSolved;
	static boolean unSolvable;

	public MazeSolver(Maze maze) {
		this.maze = maze;
		isSolved = false;
		unSolvable=false;
	}
	abstract void makeEmpty();
	abstract boolean isEmpty();
	abstract void add(Square s);
	abstract Square next();
	public boolean isSolved() {
		return isSolved;
	}
	public void step() {
		System.out.println("In Steps");
		Square nextElement = next();
		if(!isSolved()) {
			if(!nextElement.equals(maze.getExit())) {
				System.out.println("In Adding");
				for(Square s: maze.getNeighbors(nextElement)) {
					if(s.getStatus()==Square.WORKING) {
						s.setStatus(Square.EXPLORED);
					}
					if(s.getType()==Square.EXIT) {
						isSolved=true;
						unSolvable=true;
					}
					if(s.getType()!=Square.WALL && s.getStatus()!=Square.EXPLORED) {
						s.setStatus(Square.WORKING);
						add(s);
					}
					
				}
			}
			if(isEmpty()) {      
				unSolvable=true;
			}                    
			
		}
	}
	abstract String getPath();
	abstract void solve();


}
