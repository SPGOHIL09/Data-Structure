import java.util.*;
class MyNode
{
	int info;
	MyNode lptr,rptr;
	MyNode(int info)
	{
		this.info = info;

	}

	public String toString()
	{
		return Integer.toString(info);
	}
}
public class BinarySearchTree {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		BST b = new BST();
		boolean flag = true;
		while(flag)
		{
			System.out.print("\nEnter 1 for Insert a Node\n2 for Delete a Node\n3 for Preorder Traversal\n4 for Postorder Traversal\n5 for Inorder Traversal\n6 for Break :");
			int x = sc.nextInt();

			switch(x)
			{
			case 1 :
				b.insert_Node(); 
				break;
			case 2 : 
					System.out.print("Enter value to be deleted : ");
					int n = sc.nextInt();
					b.delete_Node(n);
				break;
			case 3 :
				b.preorder();
				break;
			case 4 : 
				b.postorder();
				break;
			case 5 : 
				b.inorder();
				break;
			case 6 :
				flag = false;
				break;	
			}
		}
	}
}
class BST
{
	MyNode root;
	Scanner sc = new Scanner(System.in);
	public void insert_Node(){
		System.out.print("Enter a number to be inserted : ");
		int x = sc.nextInt();
		MyNode n = new MyNode(x);
		if(root == null)
		{
			root = n;
			System.out.println("Root Node is Inserted!!!");
			return;
		}
		MyNode save = root;
		MyNode pred = null;
		while(save != null)
		{
			pred = save;
			if(save.info < n.info)
			{
				save = save.rptr;
				if(save == null)
				{
					pred.rptr = n;
					System.out.println("Leaf Node is Inserted!!!");
				}
			}
			else if(save.info > n.info)
			{
				save = save.lptr;
				if(save == null) 
					{
						pred.lptr = n;
						System.out.println("Leaf Node is Inserted!!!");
					}
			}
			else
			{
				System.out.println("Same value Node is Existed!!!");
				break;
			}
		}
	}
	public void delete_Node(int n)
	{
		if(root.info == n)
		{
			root = replace(root);
		}
		else delete_Node(root,n);
	}
	public MyNode delete_Node(MyNode root, int n){
		if(root == null) return null;
		if(n == root.info) return replace(root);
		if(n < root.info) root.lptr = delete_Node(root.lptr, n);
		if(n > root.info) root.rptr = delete_Node(root.rptr,n);
		return root;

	}
	public  MyNode replace(MyNode root)
	{
		if(root.lptr == null && root.rptr == null) return null;
		if(root.lptr == null ) return root.rptr;
		if(root.rptr == null) return root.lptr;
		MyNode temp = root.rptr;
		if(temp.lptr == null)
			temp.lptr = root.lptr;
		else
		{
			MyNode temp2 = temp;
			while(temp2.lptr != null)
			{
				temp2 = temp2.lptr;
			}
			temp2.lptr = root.lptr;

		}
		return temp;
	}
	public void preorder(MyNode root){
			if(root == null ) 

			System.out.print(root+" ");
			preorder(root.lptr);
			preorder(root.rptr);
	}
	public void preorder()
	{
		preorder(root);
	}
	public void postorder(MyNode root)
	{
		if(root == null) return;
		postorder(root.lptr);
		postorder(root.rptr);
		System.out.print(root+" ");
	}
	public void postorder(){
		postorder(root);
	}
	public void inorder(){
		inorder(root);
	}
	public void inorder(MyNode root){
		if(root == null) return;
		inorder(root.lptr);
		System.out.print(root + " ");
		inorder(root.rptr);
	}


}