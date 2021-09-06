import java.util.*;

class Node{
		int data;
		Node next;
		Node(int  d)
		{
			data=d;
		}
}

class linkedList{
	public static Node insNode(Node head,int data){
		Node n = new Node(data);
		n.next=null;
		if(head==null){
			head=n;
		}
		else{
			Node first = head;
			while(first.next!=null)
			{
				first=first.next;
			}
			first.next=n;
		}
		return head;
	}
	
	public static void display(Node head){
		Node start=head;
		System.out.println("Entered data are as follows:");
		while(start!=null)
		{
			System.out.println(start.data);
			start=start.next;
		}
	}
	
	public static Node IBeg(Node head,int data){
		Node g=new Node(data);
		g.next=head;
		head=g;
		return head;
	}
	
	public static Node Iintm(Node head,int data,int loc){
		Node g = new Node(data);
		int cnt=1;
		Node start = head;
		while(cnt++<loc)
		{
			start=start.next;
		}
		g.next=start.next;
		start.next=g;
		
		return head;
	}
	public static void main(String args[]){
		System.out.println("Enter the no. of data you wish to enter:");
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		Node head = null;
		while(N-- >0)
		{
			System.out.println("Enter the data:");
			int data=sc.nextInt();
			//Node head = null;
			head=insNode(head,data);
		}
		
		System.out.println("Enter the data to insert at beg:");
		int dt=sc.nextInt();
		head=IBeg(head,dt);
		
		System.out.println("Enter the loc to insert data:");
		int loc = sc.nextInt();
		System.out.println("Enter the data to insert:");
		int dt2= sc.nextInt();
		head=Iintm(head,dt2,loc);
		
		display(head);
	}
}
