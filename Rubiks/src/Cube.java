public class Cube
{
	private Face front = new Face('R');
	private Face back = new Face('O');
	private Face left = new Face('G');
	private Face right = new Face('B');
	private Face up = new Face('W');
	private Face down = new Face('Y');


	

	public void rotateFrontClockwise()
	{
		front.rotateClockwise();

		char[] tempUp = up.getRow(2).clone();
		char[] tempRight = right.getColumn(0).clone();
		char[] tempDown = getDown().getRow(0).clone();
		char[] tempLeft = left.getColumn(2).clone();

		right.setColumn(0, tempUp);
		getDown().setRow(0, reverseArray(tempRight));
		left.setColumn(2, tempDown);
		up.setRow(2, reverseArray(tempLeft));
	}

	public void rotateFrontCounterClockwise() 
	{
		front.rotateCounterClockwise();

		char[] tempUp = up.getRow(2).clone();
		char[] tempLeft = left.getColumn(2).clone();

		up.setRow(2, right.getColumn(0));
		right.setColumn(0, reverseArray(getDown().getRow(0)));
		getDown().setRow(0, reverseArray(left.getColumn(2)));
		left.setColumn(2, tempUp);
	}
	// L (Left face clockwise)
	public void rotateLeftClockwise() 
	{
		left.rotateClockwise();

		char[] tempFront = front.getColumn(0).clone();
		char[] tempUp = up.getColumn(0).clone();
		char[] tempBack = back.getColumn(2).clone();
		char[] tempDown = getDown().getColumn(0).clone();

		front.setColumn(0, up.getColumn(0));
		getDown().setColumn(0, reverseArray(tempFront));
		back.setColumn(2, reverseArray(tempDown));
		up.setColumn(0, tempBack);
	}

	// L' (Left face counter-clockwise)
	public void rotateLeftCounterClockwise() 
	{
		left.rotateCounterClockwise();

		char[] tempFront = front.getColumn(0).clone();
		char[] tempUp = up.getColumn(0).clone();
		char[] tempBack = back.getColumn(2).clone();
		char[] tempDown = getDown().getColumn(0).clone();

		front.setColumn(0, reverseArray(tempDown));
		getDown().setColumn(0, tempBack);
		back.setColumn(2, reverseArray(tempUp));
		up.setColumn(0, tempFront);
	}

	// R (Right face clockwise)
	public void rotateRightClockwise() 
	{
		right.rotateClockwise();

		char[] tempFront = front.getColumn(2).clone();
		char[] tempUp = up.getColumn(2).clone();
		char[] tempBack = back.getColumn(0).clone();
		char[] tempDown = getDown().getColumn(2).clone();

		front.setColumn(2, getDown().getColumn(2));
		up.setColumn(2, tempFront);
		back.setColumn(0, reverseArray(tempUp));
		getDown().setColumn(2, reverseArray(tempBack));
	}

	public void rotateRightCounterClockwise() 
	{
		right.rotateCounterClockwise();

		char[] tempUp = up.getColumn(2).clone();
		char[] tempFront = front.getColumn(2).clone();
		char[] tempDown = getDown().getColumn(2).clone();
		char[] tempBack = back.getColumn(0).clone();

		up.setColumn(2, reverseArray(back.getColumn(0)));
		front.setColumn(2, tempUp);
		getDown().setColumn(2, tempFront);
		back.setColumn(0, reverseArray(tempDown));
	}

	// U (Up face clockwise)
	public void rotateUpClockwise() 
	{
		up.rotateClockwise();

		char[] tempFront = front.getRow(0).clone();
		char[] tempLeft = left.getRow(0).clone();
		char[] tempBack = back.getRow(0).clone();
		char[] tempRight = right.getRow(0).clone();

		front.setRow(0, right.getRow(0));
		left.setRow(0, tempFront);
		back.setRow(0, tempLeft);
		right.setRow(0, tempBack);
	}

	// U' (Up face counter-clockwise)
	public void rotateUpCounterClockwise() 
	{
		up.rotateCounterClockwise();

		char[] tempFront = front.getRow(0).clone();
		char[] tempLeft = left.getRow(0).clone();
		char[] tempBack = back.getRow(0).clone();
		char[] tempRight = right.getRow(0).clone();

		front.setRow(0, left.getRow(0));
		left.setRow(0, tempBack);
		back.setRow(0, tempRight);
		right.setRow(0, tempFront);
	}

	// D (Down face clockwise)
	public void rotateDownClockwise() 
	{
		getDown().rotateClockwise();

		char[] tempFront = front.getRow(2).clone();
		char[] tempLeft = left.getRow(2).clone();
		char[] tempBack = back.getRow(2).clone();
		char[] tempRight = right.getRow(2).clone();

		front.setRow(2, left.getRow(2));
		left.setRow(2, tempBack);
		back.setRow(2, tempRight);
		right.setRow(2, tempFront);
	}

	// D' (Down face counter-clockwise)
	public void rotateDownCounterClockwise() 
	{
		getDown().rotateCounterClockwise();

		char[] tempFront = front.getRow(2).clone();
		char[] tempLeft = left.getRow(2).clone();
		char[] tempBack = back.getRow(2).clone();
		char[] tempRight = right.getRow(2).clone();

		front.setRow(2, right.getRow(2));
		left.setRow(2, tempFront);
		back.setRow(2, tempLeft);
		right.setRow(2, tempBack);
	}

	// M (Middle column between Left and Right clockwise as L')
	public void rotateMiddleClockwise() 
	{
		char[] tempFront = front.getColumn(1).clone();
		char[] tempUp = up.getColumn(1).clone();
		char[] tempBack = back.getColumn(1).clone();
		char[] tempDown = getDown().getColumn(1).clone();

		front.setColumn(1, reverseArray(tempDown));
		getDown().setColumn(1, tempBack);
		back.setColumn(1, reverseArray(tempUp));
		up.setColumn(1, tempFront);
	}

	// M' (Middle column between Left and Right counter-clockwise as L)
	public void rotateMiddleCounterClockwise() 
	{
		char[] tempFront = front.getColumn(1).clone();
		char[] tempUp = up.getColumn(1).clone();
		char[] tempBack = back.getColumn(1).clone();
		char[] tempDown = getDown().getColumn(1).clone();

		front.setColumn(1, up.getColumn(1));
		getDown().setColumn(1, reverseArray(tempFront));
		back.setColumn(1, reverseArray(tempDown));
		up.setColumn(1, tempBack);
	}



	// Rotate the Back face clockwise
	public void rotateBackClockwise() {
		back.rotateClockwise();

		char[] tempUp = getUp().getRow(0).clone();
		char[] tempRight = getRight().getColumn(2).clone();
		char[] tempDown = getDown().getRow(2).clone();
		char[] tempLeft = getLeft().getColumn(0).clone();

		getRight().setColumn(2, reverseArray(tempUp));
		getDown().setRow(2, tempRight);
		getLeft().setColumn(0, reverseArray(tempDown));
		getUp().setRow(0, tempLeft);
	}


	// Rotate the Back face counter-clockwise
	public void rotateBackCounterClockwise() {
		back.rotateCounterClockwise();

		char[] tempUp = getUp().getRow(0).clone();
		char[] tempLeft = getLeft().getColumn(0).clone();
		char[] tempDown = getDown().getRow(2).clone();  // Add this line

		getUp().setRow(0, reverseArray(getRight().getColumn(2)));
		getRight().setColumn(2, tempDown);
		getDown().setRow(2, reverseArray(getLeft().getColumn(0)));
		getLeft().setColumn(0, tempUp);
	}




	////////////////////////////////////////////////////////////////////////////



	private char[] reverseArray(char[] arr) {
		char[] reversed = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			reversed[i] = arr[arr.length - 1 - i];
		}
		return reversed;
	}

	public void displayCube() 
	{
		System.out.println("Front:");
		front.display();
		System.out.println("\nBack:");
		back.display();
		System.out.println("\nLeft:");
		left.display();
		System.out.println("\nRight:");
		right.display();
		System.out.println("\nUp:");
		up.display();
		System.out.println("\nDown:");
		getDown().display();
	}

	public String toString() 
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Front:\n");
		appendFace(sb, front);
		sb.append("\nBack:\n");
		appendFace(sb, back);
		sb.append("\nLeft:\n");
		appendFace(sb, left);
		sb.append("\nRight:\n");
		appendFace(sb, right);
		sb.append("\nUp:\n");
		appendFace(sb, up);
		sb.append("\nDown:\n");
		appendFace(sb, down);

		return sb.toString();
	}

	private void appendFace(StringBuilder sb, Face face) 
	{
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(face.getRow(i)[j]).append(" ");
			}
			sb.append("\n");
		}
	}

}