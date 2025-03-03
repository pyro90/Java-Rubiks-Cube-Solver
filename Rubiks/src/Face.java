import java.util.Arrays;

public class Face 
{
    private char[][] tiles;

    // Constructor to initialize the face with a given color
    public Face(char color) {
        tiles = new char[3][3];
        fillFace(color);
    }

    // Method to fill the face with a specific color
    private void fillFace(char color) 
    {
        for (char[] row : tiles) {
            Arrays.fill(row, color);
        }
    }

    // Method to rotate the face clockwise
    public void rotateClockwise() {
        // Implementation to rotate the face clockwise
        // ...
    }

    // Method to rotate the face counter-clockwise
    public void rotateCounterClockwise() {
        // Implementation to rotate the face counter-clockwise
        // ...
    }

    // Method to get a specific tile on the face
    public char getTile(int row, int col) {
        return tiles[row][col];
    }

    // Method to set a specific tile on the face
    public void setTile(int row, int col, char color) {
        tiles[row][col] = color;
    }

    // Method to display the face
    public void display() 
    {
        // Implementation to display the face
        // ...
    }

	public Object getRow(int i) 
	{
		
		return null;
	}
}