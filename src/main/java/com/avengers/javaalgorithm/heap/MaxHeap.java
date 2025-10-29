package com.avengers.javaalgorithm.heap;

import java.util.ArrayList;

public class MaxHeap {


    public static void main (String[] args){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(6);
        System.out.println(maxHeap.heap);
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

}

