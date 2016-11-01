import java.awt.*;
import java.applet.*;
import java.io.*;

public class Knights extends TextApplet {
	
	private Reader reader; 
	
	public void run() {
		reader = new Reader();
		String [] rowStrings = readInput();
		while (rowStrings != null) {
			if (verifyInput(rowStrings)) {
				PhonePad pad = new PhonePad(rowStrings);
				println("Processing " + pad + " ...");
				int result = pad.countPhoneNumbers();
				println("Number of phone numbers for " + pad + " = " + result);
			} else {
				System.out.println("ERROR");
				System.out.println(rowStrings.length);
				for (int i = 0; i < rowStrings.length; i++) {
					System.out.println(rowStrings[i]);
				}
			}
			rowStrings = readInput();
		}
	}
	
	public String []  readInput () {
		// Assume input is well-formed (i.e., number n specifying number of rows 
		// followed by that number of rows). Read input for one phone pad and
		// return it as an array of strings. Return null if there is no more input. 
		String numRowsString = reader.readLine();
		try {
			int n = Integer.parseInt(numRowsString);
			// Make a string array with n slots and fill it.
			String [] rowStrings = new String [n];
			for (int i = 0; i < n; i++) {
				rowStrings[i] = reader.readLine();
			}
			return rowStrings;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public boolean verifyInput (String [] rows) {
		// Verify that input is valid (has no missing digits, duplicate
		// digits, or rows of uneven length.
		// If valid, return true, else return false.
		return true; // Flesh this out. 
	}
		
}


class PhonePad {
	
	private char [] [] buttons;
	private int numRows;
	private int numCols;
	
	private String numberStack = ""; // For debugging only
	
	public PhonePad (String [] rows) {
		numRows = rows.length;
		numCols = rows[0].length(); // Assume rows non-empty.
		buttons = new char [numRows] [numCols];
		// Initialize button array with chars from rows
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				buttons[r][c] = rows[r].charAt(c);
			}
		}
	}
	
	public int countPhoneNumbers () {
		// Return the total number of 7-digit knight-moves phone numbers in pad not beginning with 0.
		int count = 0;
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if (charAt(r,c) != '0') {// Numbers must not start with 0
					count = count + countPhoneNumbersOfLength(7, r, c);
				}
			}
		}
		return count;
	}
	
	public int countPhoneNumbersOfLength (int n, int r, int c) {
		// Return the total number of n-digit knight-moves phone numbers starting
		// from row r and column c.
		if (outOfBounds(r,c)) {
			// We're outside the pad, so no numbers can begin here.
			return 0;
		} else {
			char button = charAt(r,c);
			if (button  == '.') {
				// We're at dot, so no numbers can begin here.
				return 0;
			} else if (n == 1) {
				// We're at a legal spot; count it as a one-digit phone number.
				push(button); // debugging
				pop(); // debugging
				return 1;
			} else {
				push(button); // debugging
				setCharAt(r,c,'.'); // Put a "breadcrumb" at this position so don't revisit.
				// Count all possible phone numbers with one less digit starting
				// at knight's move offsets from this position
				int result = countPhoneNumbersOfLength(n-1,r-2,c-1)
										 + countPhoneNumbersOfLength(n-1,r-2,c+1)
										 + countPhoneNumbersOfLength(n-1,r+2,c-1)
									 	 + countPhoneNumbersOfLength(n-1,r+2,c+1)
									 	 + countPhoneNumbersOfLength(n-1,r-1,c-2)
									 	 + countPhoneNumbersOfLength(n-1,r-1,c+2)
									 	 + countPhoneNumbersOfLength(n-1,r+1,c-2)
									 	 + countPhoneNumbersOfLength(n-1,r+1,c+2);
				pop();  // debugging
				setCharAt(r,c,button); // Remove "breadcrumb" from position.
				return result; 
			}
		}
	}
	
	public char charAt(int row, int col) {
		return buttons[row][col];
	}
		
	public char setCharAt(int row, int col, char ch) {
		return buttons[row][col] = ch;
	}
	
	public boolean outOfBounds(int row, int col) {
		return (row < 0) || (row >= numRows) || (col < 0) || (col >= numCols);
	}
	
	public void push (char c) {
		numberStack = numberStack + c;
		System.out.println(numberStack);
	}
	
	public void pop () {
		numberStack = numberStack.substring(0,numberStack.length() - 1);
	}
	
	public String toString() {
		// Returns a string representation for this phone pad.
		StringBuffer sb = new StringBuffer();
		sb.append("Pad[");
		for (int r = 0; r < numRows; r++) {
			sb.append("[");
			for (int c = 0; c < numCols; c++) {
				sb.append(charAt(r,c));
			}
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}
	
}

class Reader {
	
	private static final int EOF = -1; // End of file integer.
	private static final int EOLN = (int) '\n'; // End of line character.
	
	private FileInputStream inputStream;
	
	public Reader () {
		this(chooseFilename());
	}
	
	public Reader (String filename) {
		try	{
			inputStream = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry -- there is no file with name:\n" + filename);
		}
	}

	public String readLine() {
		// Read characters up to the next newline, and return them
		// as a string. The newline is consumed but not returned in the string.
		try {
			StringBuffer sb = new StringBuffer();
			int i = inputStream.read(); // Returns next character from standard input,
		                               // or -1 if no such character.
		  System.out.println("Read:" + ((char) i));                           
			while ((i != EOF) && (i != EOLN)) {
				sb.append((char) i);
				i = inputStream.read();
				System.out.println("Read:" + ((char) i));                           
			}
			return sb.toString();
		} catch (IOException e) {
			return "";
		}
	}
	
	public static String chooseFilename() {
   	String currentFolder, selectedFile, fullPath = "";
    	FileDialog fd = new FileDialog(null, "Select a file.", FileDialog.LOAD);
    	fd.show();
    	if (fd.getFile() != null) {
           currentFolder = fd.getDirectory();
           selectedFile = new String(fd.getFile());
           fullPath = currentFolder + "/" + selectedFile;
		}
    	return fullPath;
	}  
	
}
