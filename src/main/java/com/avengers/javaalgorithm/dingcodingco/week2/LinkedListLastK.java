package com.avengers.javaalgorithm.dingcodingco.week2;

public class LinkedListLastK {
    Node head;


    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.next = null;
            this.data = data;
        }
    }


    public LinkedListLastK(int data){
        this.head = new Node(data);
    }

    public void append(int value){
        Node cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public Node getKthNodeFromLast(int moveCnt){
        Node slow = this.head;
        Node fast = this.head;

        for(int i =0; i<moveCnt; i++){
                fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}


class GetKthNodeFromLast {
    public static void main(String[] args) {
        LinkedListLastK linkedList = new LinkedListLastK(6);
        linkedList.append(7);
        linkedList.append(8);

        System.out.println(linkedList.getKthNodeFromLast(2).data);  // 7이 나와야 합니다!
    }
}


