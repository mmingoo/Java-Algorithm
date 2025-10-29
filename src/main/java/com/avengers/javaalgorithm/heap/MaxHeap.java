package com.avengers.javaalgorithm.heap;

import java.util.ArrayList;

public class MaxHeap {


    public static void main (String[] args){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(4);
        System.out.println(maxHeap.heap); // [null, 8, 6, 7, 2, 5, 4]
        System.out.println(maxHeap.delete()); // 8 을 반환해야 합니다!
        System.out.println(maxHeap.heap); // [null, 7, 6, 4, 2, 5]
    }

    ArrayList<Integer> heap;

    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(null);
    }

    public void insert(int num){
        // 1. 원소를 맨 끝에 추가
        this.heap.add(num);
        int curIdx = this.heap.size()-1;

        while (curIdx != 1){

            //2. 부모랑 비교해서 자식이 더 크다면 위치를 변경
            int parentIdx = curIdx/2;
            if(this.heap.get(curIdx) > this.heap.get(parentIdx)){
                int temp = this.heap.get(parentIdx);
                this.heap.set(parentIdx,this.heap.get(curIdx));
                this.heap.set(curIdx, temp);
                curIdx = parentIdx;
            }else{
                break;
            }
        }
    }

    public int delete(){

        // 최상위 부모노드와 마지막 체인지
        int temp = this.heap.get(1);
        this.heap.set(1, this.heap.get(heap.size()-1));
        this.heap.set(this.heap.size()-1, temp);

        // 변경한 후 마지막 삭제
        int prevMax = this.heap.remove(this.heap.size() - 1); // 8
        int curIdx = 1;

        while(curIdx <= this.heap.size()-1){
            int leftChildIdx = curIdx*2;
            int rightChildIdx = curIdx*2+1;
            int maxIdx = curIdx;


            // 자식 노드와 부모노드를 비교해서 더 크다면 위치
            if(leftChildIdx <= this.heap.size() - 1 && this.heap.get(leftChildIdx) > this.heap.get(maxIdx)){
                maxIdx = leftChildIdx;
            }

            if(rightChildIdx <= this.heap.size() -1 && this.heap.get(rightChildIdx) > this.heap.get(maxIdx)){
                maxIdx = rightChildIdx;
            }

            if(maxIdx == curIdx){
                break;
            }

            temp = this.heap.get(curIdx);
            this.heap.set(curIdx, this.heap.get(maxIdx));
            this.heap.set(maxIdx, temp);
            curIdx = maxIdx;
        }

        return prevMax;
    }


}

