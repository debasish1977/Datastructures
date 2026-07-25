//Floyd’s Cycle Detection Algorithm

package com.debu.DataStructure.HashTable;

public class CyclicLinkList {
    public boolean hasCycle(Node head)
    {
        Node slow = head;
        Node fast = head;

        if(slow!=null && fast!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)
            {
                return true;
            }
        }
        return false;
    }
}
