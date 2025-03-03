import java.util.Scanner;
import java.util.Random;

public class Main 
{
    public static void scrambleCube(Cube cube, int numMoves) 
    {
        String[] possibleMoves = {"F", "F'", "L", "L'", "R", "R'", "U", "U'", "D", "D'", "M", "M'"};
        Random rand = new Random();
        StringBuilder algorithm = new StringBuilder();

        for (int i = 0; i < numMoves; i++) {
            String move = possibleMoves[rand.nextInt(possibleMoves.length)];
            algorithm.append(move).append(" ");
            performMove(cube, move);
        }
        System.out.println("Scramble algorithm: " + algorithm.toString());
    }

    public static void solveWhiteCross(Cube cube) 
    {
        char targetColor = 'W';  // White color

        // Find the positions of the white edge pieces (with white on top)
        int[][] whiteEdgePositions = 
        	{
            {1, 0}, {0, 1}, {1, 2}, {2, 1}
        };

        for (int i = 0; i < whiteEdgePositions.length; i++) 
        {
            int row = whiteEdgePositions[i][0];
            int col = whiteEdgePositions[i][1];

            // Check if the edge piece is already solved
            if (cube.getDown().getTile(row, col) == targetColor) {
                continue;  // Already solved
            }

            // Determine the target position for the white sticker
            int targetRow = 1;
            int targetCol = 1;

            if (row == 0) {
                targetRow = 2;
            } else if (row == 2) {
                targetRow = 0;
            }

            if (col == 0) {
                targetCol = 1;
            } else if (col == 2) {
                targetCol = 1;
            }

            // Rotate the D face so that the white edge piece is in the bottom layer
            while (cube.getDown().getTile(row, col) != targetColor) {
                cube.rotateDownClockwise();
            }

            // Rotate the white sticker into the correct position (D to U)
            while (cube.getUp().getTile(targetRow, targetCol) != targetColor) {
                cube.rotateUpClockwise();
            }
        }
    }

    public static void performMove(Cube cube, String move) {
        switch (move) {
            case "F":
                cube.rotateFrontClockwise();
                break;
            case "F'":
                cube.rotateFrontCounterClockwise();
                break;
            case "L":
                cube.rotateLeftClockwise();
                break;
            case "L'":
                cube.rotateLeftCounterClockwise();
                break;
            case "R":
                cube.rotateRightClockwise();
                break;
            case "R'":
                cube.rotateRightCounterClockwise();
                break;
            case "U":
                cube.rotateUpClockwise();
                break;
            case "U'":
                cube.rotateUpCounterClockwise();
                break;
            case "D":
                cube.rotateDownClockwise();
                break;
            case "D'":
                cube.rotateDownCounterClockwise();
                break;
            case "M":
                cube.rotateMiddleClockwise();
                break;
            case "M'":
                cube.rotateMiddleCounterClockwise();
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cube cube = new Cube();

        while (true)
        {
            cube.displayCube();
            System.out.println("Enter move (e.g., F for Front, F' for Front counter-clockwise, S to scramble, Q to quit, B to solve Beginner's Method):");
            String move = sc.nextLine().toUpperCase().trim();

            switch (move) 
            {
                case "F":
                case "F'":
                case "L":
                case "L'":
                case "R":
                case "R'":
                case "U":
                case "U'":
                case "D":
                case "D'":
                case "M":
                case "M'":
                    performMove(cube, move);
                    break;
                case "Q":
                    System.exit(0);
                    break;
                case "S":
                    System.out.print("Enter the number of moves for the scramble: ");
                    int numMoves = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    scrambleCube(cube, numMoves);
                    break;
                case "B":
                    solveWhiteCross(cube);
                    cube.displayCube();
                    break;
                default:
                    System.out.println("Invalid move. Please try again.");
                    break;
            }
        }
    }
}
