package problem_solving.backtracking;

public class RatInMaze {

    public static void main(String[] args) {
        int maze[][] = {{1, 1, 0, 0}, {1, 1, 1, 1}, {0, 0, 1, 0}, {1, 1, 1, 1}};
        int solution[][] = new int[maze.length][maze[0].length];
        boolean b = findRatInMaze(maze, solution, 0, 0);
        if(b) {
            printSolution(solution);
        }
    }

    private static boolean findRatInMaze(int[][] maze, int[][] solution, int x, int y) {
        if (x == maze.length - 1 && y == maze.length - 1) {
            return true;
        }
        if (isValid(maze, x, y)) {
            solution[x][y] = 1;
            if (findRatInMaze(maze, solution, x + 1, y) || findRatInMaze(maze, solution, x, y + 1)) {
                return true;
            }
            solution[x][y] = 0;
        }
        return false;
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length && maze[x][y] != 0;
    }


    private static void printSolution(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

}
