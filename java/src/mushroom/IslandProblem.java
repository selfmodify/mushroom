package mushroom;

public class IslandProblem {
	
	public int FindMaxIsland(int[][]a) {
		
		return 0;
	}

	public static void main(String[] args) {
		IslandProblem p = new IslandProblem();
		var a = new int[][] {
			 {0,0,1,0,0,0,0,1,0,0,0,0,0},
		     {0,0,0,0,0,0,0,1,1,1,0,0,0},
		     {0,1,1,0,1,0,0,0,0,0,0,0,0},
		     {0,1,0,0,1,1,0,0,1,0,1,0,0},
		     {0,1,0,0,1,1,0,0,1,1,1,0,0},
		     {0,0,0,0,0,0,0,0,0,0,1,0,0},
		     {0,0,0,0,0,0,0,1,1,1,0,0,0},
		     {0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		p.FindMaxIsland(a);		
	}

}
