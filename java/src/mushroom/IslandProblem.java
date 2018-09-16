package mushroom;

public class IslandProblem {
	boolean[][] visited;
	int[][] a;
	private int area(int i, int j) {
		if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || visited[i][j] == true || a[i][j] == 0) {
			return 0;
		}
		visited[i][j] = true;
		return (1 + area(i + 1, j) + area(i - 1, j)
				+ area(i, j + 1) + area(i, j - 1));
	}

	public int FindMaxIsland(int[][] a) {
		this.a = a;
		visited = new boolean[a.length][a[0].length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = false;
			}
		}
		
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result = Math.max(result, area(i, j));
			}
		}
		System.out.println("Area is " + result);
		return result;
	}

	public static void main(String[] args) {
		IslandProblem p = new IslandProblem();
		var a1 = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		var a2 = new int[][] {
			{0, 1, 1},
			{0, 0, 1},
			{1, 0, 0},
		};
		p.FindMaxIsland(a1);
		p.FindMaxIsland(a2);
	}

}
