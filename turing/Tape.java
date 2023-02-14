
/*
 * Your task is to implement a Java class named Tape that represents a Turing Machine tape,
 *  which is a doubly-linked list of cells. 
 *  Each cell contains a character and has pointers to the next and previous cells. 
 * The Tape class should include methods for getting and setting the content of the current cell, moving left and right along the tape (creating new cells if necessary), and getting the contents of the entire tape as a String. 
 * The Tape class should also have a constructor that creates a tape with a single cell containing a blank space, and sets the current cell pointer to that cell. 
 * You can test your implementation using the provided TestTape, TestTapeGUI, and TestTuringMachine programs.
 */


 package turing;

 /**
  * Represents a Turing Machine tape, which is a doubly-linked list of cells.
  * Each cell contains a character and has pointers to the next and previous cells.
  */
 public class Tape {
     private Cell currentCell;
 
     /**
      * Constructs a new tape with a single cell containing a blank space, and sets the current cell pointer to that cell.
      */
     public Tape() {
         Cell initialCell = new Cell();
         initialCell.content = ' ';
         currentCell = initialCell;
     }
 
     /**
      * Gets the current cell on the tape.
      *
      * @return The current cell.
      */
     public Cell getCurrentCell() {
         return currentCell;
     }
 
     /**
      * Gets the content of the current cell on the tape.
      *
      * @return The content of the current cell.
      */
     public char getContent() {
         return currentCell.content;
     }
 
     /**
      * Sets the content of the current cell on the tape.
      *
      * @param ch The character to set as the content of the current cell.
      */
     public void setContent(char ch) {
         currentCell.content = ch;
     }
 
     /**
      * Moves the current cell pointer one cell to the left on the tape, creating a new cell if necessary.
      * If a new cell is created, its content is set to a blank space.
      */
     public void moveLeft() {
         if (currentCell.prev == null) {
             Cell newCell = new Cell();
             newCell.content = ' ';
             newCell.next = currentCell;
             currentCell.prev = newCell;
         }
         currentCell = currentCell.prev;
     }
 
     /**
      * Moves the current cell pointer one cell to the right on the tape, creating a new cell if necessary.
      * If a new cell is created, its content is set to a blank space.
      */
     public void moveRight() {
         if (currentCell.next == null) {
             Cell newCell = new Cell();
             newCell.content = ' ';
             newCell.prev = currentCell;
             currentCell.next = newCell;
         }
         currentCell = currentCell.next;
     }
 
     /**
      * Gets the contents of the entire tape as a String, omitting leading and trailing blank spaces.
      *
      * @return The contents of the tape as a String.
      */
     public String getTapeContents() {
         StringBuilder sb = new StringBuilder();
         Cell startCell = currentCell;
         while (startCell.prev != null) {
             startCell = startCell.prev;
         }
         while (startCell != null && startCell.content == ' ') {
             startCell = startCell.next;
         }
         while (startCell != null) {
             sb.append(startCell.content);
             startCell = startCell.next;
         }
         while (sb.length() > 0 && sb.charAt(sb.length()-1) == ' ') {
             sb.setLength(sb.length()-1);
         }
         return sb.toString();
     }
 }
 
/*
 * In this implementation, the Tape class has an instance variable currentCell that points to the current cell on the tape. The constructor creates an initial cell with a blank space and sets the current cell pointer to it.

The getCurrentCell, getContent, and setContent methods are straightforward, just returning or setting the content of the current cell or the current cell pointer itself.

The moveLeft and moveRight methods are a bit more complex. They first check if there is a previous or next cell to move to, respectively. If there is not, they create a new cell with a blank space and add it to the tape to the left or right of the current cell. Then, they update the current cell pointer to point to the new cell (or the existing previous or next cell).

The getTapeContents method is the most complex. It first finds the leftmost non-blank cell by traversing the tape to the left from the current cell. Then, it appends the contents of each cell to a StringBuilder until it reaches the right end of the tape (i.e., a cell with a null next pointer). Finally, it removes any trailing blank spaces from the StringBuilder and returns the resulting String.

You can test this implementation using the provided TestTape program or by integrating it into a larger program that uses a Turing Machine with a tape.
 */