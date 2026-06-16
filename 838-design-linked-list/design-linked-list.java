class MyLinkedList {
    Node head; //null
    int size; //0

    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
        }
    }
    public MyLinkedList() {
        head=null;
        size=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size) return -1;
        Node temp=head;
        for(int i=0; i<index; i++)
        temp=temp.next;
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node n=new Node(val);
        n.next=head;
        head=n;
        size++;
    }
    
    public void addAtTail(int val) {
        Node n=new Node(val);
        size++;
        if(head==null){
            head=n;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        temp=temp.next;
        temp.next=n;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>size)
        return;
        if (index==size){
            addAtTail(val);
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }

        Node n=new Node(val);
        Node temp=head;
        for(int i=0; i<index-1; i++)
        temp=temp.next;
        n.next=temp.next;
        temp.next=n;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) //invalid case
        return;
        size--;
        if(index==0){
            head=head.next;
            return;
        }
        Node temp=head;
        for(int i=0; i<index-1; i++)
        temp=temp.next;
        temp.next=temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */