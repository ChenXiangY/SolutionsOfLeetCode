package com.ClassSolutions;

import java.util.ArrayList;

/**
 * 155题,最小栈.
 *
 * @author Chen Xiangyu
 * @version 1.0
 * @classname ListNode
 * @date 2019/2/6
 */

/**
 * 155题,最小栈.
 *
 * @author Chen Xiangyu
 * @version 1.0
 * @classname ListNode
 * @date 2019/2/6
 */
public class MinStack {

    ArrayList<Integer> minStack;
    Integer min = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack = new ArrayList<>();
    }

    public void push(int x) {
//        判断最小值.
        if (min == null) {
            min = x;
        } else if (x <= min) {
            this.minStack.add(min);
            this.min = x;
        }
        this.minStack.add(x);

    }

    public void pop() {
        if (this.minStack.size() == 0) {
            min = null;
            return ;
        }
        int temp = this.minStack.get(minStack.size()-1);
        this.minStack.remove(minStack.size()-1);
        if (temp==min){
            if (this.minStack.size() == 0) {
                min = null;
                return ;
            }else{
                this.min = this.minStack.get(this.minStack.size() -1 );
                this.minStack.remove(minStack.size()-1);
            }
        }
    }

    public int top() {
        return this.minStack.get(minStack.size() == 0 ? 0 : minStack.size() - 1);
    }

    public int getMin() {
        for(int i = 0; i < this.minStack.size() - 1; i++){
            System.out.print(this.minStack.get(i) + "\t");
        }
        System.out.println();
        return this.min;
    }
}



