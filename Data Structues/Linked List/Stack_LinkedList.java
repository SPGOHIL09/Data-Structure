import java.util.*;
public class Stack_LinkedList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack_Link s = new Stack_Link(); // Declaring the class
        
        boolean flag = true;
        while(flag)
        {
            System.out.println("Enter 1 for Insert\nEnter 2 for Delete\nEnter 3 for Peek\nEnter 4 for Change\nEnter 5 for Display\n Enter 6 for Break : ");
            int n = sc.nextInt();
            switch(n)
            {
                case 1 :
                        s.insert_end();
                        break;
                case 2 : 
                        s.delete_end();
                        break;
                case 3 :
                        s.peek_top();
                        break;
                case 4 :
                        s.change_from_top();
                        break; 
                case 5 :
                        s.display();
                        break;                
                case 6 :
                        flag = false;
                        break; 
            }
        }
    }
}
class MyNode
{       // Create class for creating node 
    int info;
    MyNode next;
    MyNode (int info) //Parameterized Constructor
    {
        this.info = info;
    }
}
class Stack_Link
{               //Class for all the operation
    Scanner sc = new Scanner(System.in);
    MyNode head,tail;       //head and tail of linked list
    int count_node = 0;     //for counting total no of nodes
    public void insert_end()
    {                       // Inserting a node from end 
        System.out.print("Enter element : ");
        int x = sc.nextInt();
        if(head == null)  // if the first node is null
        {
            MyNode m = new MyNode(x);
            head = m;
            tail = head;
            count_node = 1;
            System.out.println("A Node is Inserted!!!");
            System.out.println();
        }
        else
        {
            MyNode n = new MyNode(x);
            tail.next = n;
            tail = n;
            n.next = null;
            System.out.println("A Node is Inserted!!!");
            System.out.println();
            count_node++;
        }
        
    }
    public void display()
    {                              //Printig all the node
        MyNode p = head;
        while(p != null)
        {
            System.out.print(p.info+"-->");
            p = p.next;
        }
        System.out.println("null");
        System.out.println(count_node);
    }
    public void delete_end()
    {                               // Deleting the node from end

        MyNode save = head;
        if(head == null)
        {
            System.out.println("Stack Linked List is Underflow!!!");
            return;
        }
        if(tail == head)
        {
            head = null;
            count_node = 0;
            System.out.println("Linked List is now Empty!!!");
            System.out.println();
        }
        else
        {
            while(save.next != tail)
            {
                    save = save.next;
            }
            System.out.println("Element of the Deleted Node : "+save.info);
            save.next = null;
            tail = save;
            System.out.println("A Node is Deleted!!!");
            System.out.println();
            if(count_node != 0)
                count_node--;
        }
    }
    public void peek_top()
    {                               //Displaying the Element of the Top Node
        MyNode top = head;
        if(top == null)
        {
            System.out.println("Stack Linked List is Empty!!!");
            System.out.println();
            return;
        }
        else
        {
            while(top != tail)
            {
                top = top.next;
            }
        }
        System.out.println("Element at top the Stack Linked List : "+top.info);
        System.out.println();
    }
    public void change_from_top()
    {                               //Change the element from of a node at specified position from top
        MyNode change_node = head;
        int count = 1;
        int pos;
        do 
        {
           System.out.print("Enter position from top to element to change : ");
           pos = sc.nextInt(); 

        }while(count_node - pos + 1 <= 0 || pos <= 0);
        
        int pos_bottom = count_node - pos + 1 ;
        while(pos_bottom != count)
        {
            count++;
            change_node = change_node.next;
        }
        System.out.print("Enter new element : ");
        int x =sc.nextInt();
        change_node.info = x;      
        System.out.println("Element in "+pos+" node from Top is Changed!!!");
        System.out.println();
    }
}