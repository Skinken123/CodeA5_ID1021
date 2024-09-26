public class LinkedList{
    private Cell first;

    private class Cell{
        int head;
        Cell tail;

        Cell(int val){
            head = val;
            tail = null;
        }
    }

    /*
     * Constructor creating instances of the linked list calls
     * 
     * @param n, determines the lenght of the linked list
     */
    public LinkedList(int n){
        Cell last = null;
        for (int i = 0; i < n; i++) {
            Cell newCell = new Cell(i);
            newCell.tail = last;
            last = newCell;
        }
        first = last;
    }

    /*
     * Adds an item to the beginning of the list
     * Creates a new cell with the item to add
     * Sets the tail of the new cell to be the first item of the list
     * Redirects the first item of the list to be the new cell
     * 
     * @param item, is the item to be added 
     */
    public void add(int item){
        Cell newCell = new Cell(item);
        newCell.tail = first;
        first = newCell;
    }

    /*
     * Returns the lenght of the list
     */
    public int length(){
        int length = 0;
        Cell temporary = first;
        while(temporary != null){
            length++;
            temporary = temporary.tail;
        }
       return length; 
    }


    /*
     * Determines if a specified item is present in the list and returns true or false
     * 
     * @param item, the specific item we are searching for
     */
    public boolean find(int item){
        Cell temporary = first;
        while(temporary != null){
            if (temporary.head == item){
                return true;
            }
            temporary = temporary.tail;
        }
        return false;
    }

    /*
     * Removes a specified item from the list
     * Goes through the list until the item is found or returns if the list did not contain the item
     * When at the cell with the specified item we set the tail of the cell before that cell to the cell after
     * By doing this the cell containing the specified item is no longer connected to the list and will be removed by "gc" = garbage collection
     * 
     * @param item, the item to be removed for the list
     */
    public void remove(int item){
        Cell current = first;
        Cell previous = null;
        while(current != null){
            if (current.head == item){
                if (previous != null){
                    previous.tail = current.tail;
                    return;
                }
                first = current.tail;
                return;
            }
            previous = current;
            current = current.tail;
        }
        return;
    }

    /*
     * Connects the end of the linked list to the beginning of a input linked list b.
     * 
     * @param b is the linked list to be connected to this instance of the linked list.
     */
    public void append(LinkedList b){
        Cell current = first;
        while(current.tail != null){
            current = current.tail;
        }
        current.tail = b.first;
        //b.first = null; // dont get it?
        return;
    }

    // prints all elements stored in every cell head in the linked list
    public void printList(){
        Cell current = first;
        while(current != null){
            System.out.print(current.head + " \n");
            current = current.tail;
        }
        System.out.print("\n");
        return;
    }

    /* push operation for a stack implementation of the linked list
     * works the same as the add operation placing a new item at the top of the stack
     * 
     * @param item, the item to be placed at the top of the stack
     */
    public void push(int item){
        Cell newCell = new Cell(item);
        newCell.tail = first;
        first = newCell;
    }

    /*
     * pop operation for a stack implementation of the linked list
     * creates a referance to the cell at the top of the stack
     * extracts the item stored in that cell
     * redirects the adress of the first cell to be the second cell on the stack thereby removing the first cell from the stack
     */
    public int pop(){
        Cell itemToPop = first;
        int itemToReturn = first.head;
        first = itemToPop.tail;
        return itemToReturn;
    }
}