/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
原地复制
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node h1 = head;
        // Node pre = new Node(-1);
        // pre.next = head;
        while(h1 != null){
            Node cur = new Node(h1.val);
            cur.next = h1.next;
            h1.next = cur;
            h1 = cur.next;
        }
        Node h2 = head;
        while(h2 != null){
            if(h2.random != null){
                h2.next.random = h2.random.next;
            }
            h2 = h2.next.next;
        }
        Node tmp = head.next;
        Node ans = tmp;
        // for循环遍历
        // for (Node node = head; node != null; node = node.next.next)
        while(tmp != null){
            head.next = tmp.next;
            if(head.next != null){
                tmp.next = head.next.next;
            }
            tmp = tmp.next;
            head = head.next;
        }
        return ans;
        // Node p1 = pre;
        // int l = 0;
        // while(h1 != null){
        //     if(l % 2 == 1){
        //         if(p1.random != null){
        //             h1.random = p1.random.next;
        //         }
        //     }
        //     h1 = h1.next;
        //     p1 = p1.next;
        //     l++;
        // }
        // Node p2 = new Node(-1);
        // Node ans = p2;
        // while(h != null){
        //     if(l % 2 == 1){
        //         p2.next = h;
        //         p2 = p2.next;
        //     }
        //     else{
        //         pre.next = h;
        //         pre = pre.next;
        //     }
        //     h = h.next;
        //     l--;
        // }
        // pre.next = null;
        // return ans.next;
    }
}

// // HashMap存储
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head == null){
//             return head;
//         }
//         Node h1 = head;
//         Node tmp = new Node(head.val);
//         Node ans = tmp;
//         // 迭代完tmp已经到末尾
//         while(h1.next != null){
//             Node next = new Node(h1.next.val);
//             tmp.next = next;
//             h1 = h1.next;
//             tmp = tmp.next;
//         }
//         // // pre建立LinkedList
//         // Node h2 = head;
//         // Node pre = new Node(-1);
//         // while(h2 != null){
//         //     Node tmp = new Node(h2.val);
//         //     pre.next = tmp;
//         //     pre = pre.next;
//         //     h2 = h2.next;
//         // }
//         Map<Node,Node> m = new HashMap<>();
//         Node h2 = head;
//         tmp = ans;
//         while(h2 != null){
//             // (tmp,h2)则无法根据value找key
//             m.put(h2,tmp);
//             h2 = h2.next;
//             tmp = tmp.next;
//         }
//         // System.out.println(m.entrySet());
//         Node h3 = head;
//         while(h3 != null){
//             if(h3.random != null){
//                 m.get(h3).random = m.get(h3.random);
//             }
//             h3 = h3.next;
//         }
//         return ans;
//     }
// }
