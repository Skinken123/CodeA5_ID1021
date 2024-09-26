public class LinkedListStack {
    public static void main(String[] args){
        LinkedList stackList = new LinkedList(0);
        stackList.push(1);
        stackList.push(2);    
        stackList.push(3);
        stackList.push(4);  

        stackList.printList();

        stackList.pop();
        stackList.pop();
       
        stackList.printList();
    }
}
