package com.example.coding.leecode.字符串;

/**
 * @Author 神様だよ
 * @Date 2021/12/6 16:18
 * @Version 1.0
 * @description:
 */
public class leecode227表达式求值 {
    /**
     * 开两个栈，数字栈和操作符栈，统一原则，遇到操作符时才进行数的操作
     *
     * eval()操作：将数字栈pop()出两个数字分别对应b和a，再从操作符栈pop()出操作符号，进行相应操作后将结果数字加入到数字栈中，
     *
     * 1、将'*'和'/'设为2级优先级，'+'和'-'设为1级优先级
     * 2、当遇到数字时，则读取连续的一个完整数字，再直接加入到数字栈中
     * 3、当遇到操作符时，若操作符栈顶元素的优先级比当前遇到的操作符优先级高，则一直进行eval()操作
     * 4、最后操作符栈中还存在元素，因此一直进行eval()操作，最终返回结果
     */

    //https://leetcode.com/problems/basic-calculator-ii/submissions/
}
