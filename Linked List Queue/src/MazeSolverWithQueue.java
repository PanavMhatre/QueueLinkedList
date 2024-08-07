public class MazeSolverWithQueue extends MazeSolver {
	
	MyQueue queue;

	public MazeSolverWithQueue(Maze maze) {
		super(maze);
		queue = new MyQueue();
		add(maze.getExit());
		add(maze.getStart());     
	}

	@Override
	void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void add(Square s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Square next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void solve() {
		// TODO Auto-generated method stub
		
	}
	
}
