package Linked_List;
//import java.util.*;
class sll{
	
	Node head=null;
	Node tail=null;
	private int length;
//-----------------------------------------------------------------------------------------------------------
	void Insert_At_Start(int data) {
		Node nn=new Node(data);
		if(this.head==null) {
			this.head=nn;
			this.tail=nn;
		}else {
			nn.next=this.head;
			this.head=nn;
		}
	}
//-----------------------------------------------------------------------------------------------------------
	void Search_Element(int element) {
		Node temp=this.head;
		boolean found=false;
		int count=0;
		while(temp.next!=null) {
			count++;
			if(temp.data==element) {
				found=true;
				break;
			}else {
				found=false;
			}
			temp=temp.next;
		}
		if(found) {
			System.out.println("Found Element at "+count+" Node");
		}else {
			System.out.println("Not Found");
		}
	}
//-----------------------------------------------------------------------------------------------------------	
	void Find_Length() {
		Node temp=this.head;
		if(this.head==null) {
			System.out.println("The Lenght of Linked list is 0");
		}
		length=1;
		while(temp.next!=null) {
			length++;
			temp=temp.next;
		}
		System.out.println("The Length of the LinkedList is:"+length);
	}
//-----------------------------------------------------------------------------------------------------------
	void Find_Middle_Element() {
		Node temp=this.head;
		Find_Length();
		if(length==0) {
			System.out.println("The LinkedList is Empty so there is no Middle_Element");
		}else {
			int middle=length/2;
			for(int i=1;i<middle;i++) {
				temp=temp.next;
			}
			System.out.println("The Middle Element in the Array is: "+temp.data);
		}
	}

//-----------------------------------------------------------------------------------------------------------	
	void Find_Middle_Element_1() {//leetcode 879 // working for only odd no of elements.
		Node fast=this.head;
		Node slow=this.head;
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println(slow.data);
	}
//-----------------------------------------------------------------------------------------------------------	
	void Insert_At_Last(int data) {
		Node nn=new Node(data);
		if(this.head==null) {
			this.head=nn;
			this.tail=nn;
		}else {
			this.tail.next=nn;
			this.tail=nn;
		}
	}
//-----------------------------------------------------------------------------------------------------------	
	void Insert_At_Middle(int data,int x) {
		Node nn=new Node(data);
		if(head==null) {
			this.head=nn;
			this.tail=nn;
		}else {
			Node temp=this.head;
			while(temp.next.data!=x) {
				temp=temp.next;
			}
			Node c=temp.next;
			temp.next=nn;
			nn.next=c;
		}
	}
//-----------------------------------------------------------------------------------------------------------	
	void Delete_At_Start() {
		if(this.head==null) {
			System.out.print("Empty List");
		}else {
			head=head.next;
		}
	}
//-----------------------------------------------------------------------------------------------------------	
	void Delete_At_End() {
		if(this.head==null) {
			System.out.print("Empty List");
		}else {
			Node temp=this.head;
			while(temp.next!=this.tail) {
				temp=temp.next;
			}
			this.tail=temp;
			this.tail.next=null;
			
		}
		
	}
//-----------------------------------------------------------------------------------------------------------
	void Delete_At_Middle(int data) {
		if(this.head==null) {
			System.out.println("Empty List");
		}else {
			Node temp=this.head;
			while(temp.next.data!=data) {
				temp=temp.next;
			}
			temp.next=temp.next.next;
		}
	}
//-----------------------------------------------------------------------------------------------------------
	void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print("[ "+temp.data+" ]"+" -> ");
			temp=temp.next;
		}
	}
//-----------------------------------------------------------------------------------------------------------
	void Revese() {
		Node temp=this.head;
	}
//-----------------------------------------------------------------------------------------------------------
	void display_Reverse(Node temp) { /*
										The SOP fucntion does not run for every iteration
										but it stores the values in the Stack and Throws out
										All the values At the End out of the Stack
										|10| //Last Iteration
										| 9|
										| 8|
										|. |
										|. |
										| 1| // first Iteration
										|--|
										
										*/
		if(temp==null) {
			return ;
		}
		display_Reverse(temp.next);
		System.out.print("[ "+temp.data+" ]"+" -> ");
	}
	
	
	//Using two Pointer and Sliding Window.
//-----------------------------------------------------------------------------------------------------------	
	void Find_Length1() {
		Node fast=this.head;
		Node slow=this.head;
		int len=0;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			len++;
		}
		int out=(fast==null)? (len*2+1):(len*2);
		System.out.println(out);
		
	}	
//-----------------------------------------------------------------------------------------------------------	
	void Remove_Nth_Node_From_End(int k){
		Node fast=this.head;
		while((k--)>=0) {
			fast=fast.next;
		}
		Node pos = null;
		Node slow=this.head;
		while(fast!=null && fast.next!=null) {
			pos=slow;
			slow=slow.next;
			fast=fast.next;
		}
		pos.next=pos.next.next;//remove Nth Element 
		System.out.println(slow.data);//print Nth Element from Last
		display();
		
	}
	
	//Using Three Pointer and Sliding Window
//-----------------------------------------------------------------------------------------------------------
	void Reverse_Linked_List() {//Leetcode 206
		Node prev=null;
		Node current=head;
		Node next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		this.head=prev;
		display();
	}
//-----------------------------------------------------------------------------------------------------------	
	boolean hasCycle(Node head) {
        if(head==null||head.next==null){
            return false;
        } 
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        return slow==fast;
    }
//-----------------------------------------------------------------------------------------------------------
	void loop(int pos) {
		Node posi=this.head;
		
		while(pos!=1) {
			posi=posi.next;
			pos--;
		}
		tail.next=posi.next;
	}
//-----------------------------------------------------------------------------------------------------------	
	void Loop_Lenght(int pos) {
		Node slow=this.head;
		Node fast=this.head;
		int len=0;
		while(pos!=1) {
			slow=slow.next;
			fast=fast.next;
			pos--;
		}
		System.out.println(slow.data);
		while(fast!=null) {
			len++;
			fast=fast.next;
			if(slow==fast) {
				System.out.println(len);
				break;
			}
		}
	}
//-----------------------------------------------------------------------------------------------------------	
	void Remove_Duplicates_Sorted(Node head) {
		Node temp=this.head;
		while(temp!=null && temp.next!=null) {
			if(temp.data==temp.next.data) {
				temp.next=temp.next.next;
			}else {
				temp=temp.next;
			}
		}
		display();
	}
//-----------------------------------------------------------------------------------------------------------	
	void Bubble_Sort_LinkedList() {
		Node temp=this.head;
		int count=0;
		
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
	
		while(count!=0) {
			temp=this.head;
			for(int i=1;i<count;i++) {
				if(temp.data>temp.next.data) {
					int t=temp.data;
					temp.data=temp.next.data;
					temp.next.data=t;
				}
				temp=temp.next;
			}
			count--;
		}
		display();
	}
//-----------------------------------------------------------------------------------------------------------	
	void Swap_Nodes_beside(Node temp1) {
		Node temp = new Node(temp1.data);//copying a Node(it copies only the data where as if you give temp=temp1 it copies the pointer also so dont do that!!!!)
		int t=temp1.data;
		temp1.data=temp1.next.data;
		temp1.next.data=t;
	}
//-----------------------------------------------------------------------------------------------------------	

}
public class Single_Linked_List {
	public static void main(String[] args) {
		sll s=new sll();
//		int arr[]= {1,3,4,7,1,2,6,8};
		int arr[]= {1,2,4,1,3,4};
		for(int i:arr) {
			s.Insert_At_Last(i);
		}
		s.display();
		System.out.println();
		s.Bubble_Sort_LinkedList();
//		s.Swap_Nodes_beside(s.head);
//		s.Remove_Duplicates_Sorted(s.head);
//		s.Find_Middle_Element_1();
//		s.Insert_At_Middle(3,4);
//		s.Delete_At_Start();
//		s.Delete_At_End();
//		s.Delete_At_Middle(5);
//		s.loop(4);
//		s.Loop_Lenght(2);
//		System.out.println();
//		System.out.println();
//		s.Search_Element(6);
//		s.Find_Length1();
//		s.Find_Middle_Element1();
//		s.Find_Middle_Element();
//		s.Remove_Nth_Node_From_End(1);
//		s.display_Reverse(s.head); // Just 
//		System.out.println();
//		System.out.println();
//		s.Reverse_Linked_List();
//		System.out.println(s.hasCycle(s.head));;
		
		
	}
}