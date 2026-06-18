/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy =new ListNode(0);
//         dummy.next=head;
//         ListNode fast = dummy;
//         ListNode slow = dummy;
//         for(int i=0;i<=n;i++){
//             fast = fast.next;
//         }
//         while(fast != null){
//             fast = fast.next;
//             slow = slow.next;
//         }
//         slow.next = slow.next.next;
//         return dummy.next;
//     }
// }

//  by arraylist

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list=new ArrayList<>();
        ListNode current = head;
        while(current !=null){
            list.add(current);
            current=current.next;
        }
        int size=list.size();
        int removeIndex=size-n;
        if(removeIndex==0){
            return head.next;
        }
        ListNode previous=list.get(removeIndex - 1);
     previous.next=previous.next.next;return head;
    }
}