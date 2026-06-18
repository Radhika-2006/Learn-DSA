// public class Solution { 
//     public ListNode detectCycle(ListNode head) {

//         ListNode slow = head;
//         ListNode fast = head;

//         while (fast != null && fast.next != null) {

//             slow = slow.next;
//             fast = fast.next.next;

//             if (slow == fast) {

//                 ListNode start = head;

//                 while (start != slow) {
//                     start = start.next;
//                     slow = slow.next;
//                 }

//                 return start;
//             }
//         }

//         return null;
//     }
// }

// by hashset
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}