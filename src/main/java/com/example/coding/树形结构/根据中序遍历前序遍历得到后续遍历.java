package com.example.coding.树形结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/15 15:50
 * @Version 1.0
 * @description:
 */
public class 根据中序遍历前序遍历得到后续遍历 {
    //https://diamiko.blog.luogu.org/solution-p1827
    static void dfs(String pre,String inor)
    {
        if(pre.isEmpty())return;
        //如果序列空了，就没必要继续了
        char root=pre.charAt(0);
        //取到前序序列的首字母，即根节点
        int k=inor.indexOf(root);
        //找到中序序列中根节点的位置
        //删去前序序列中的根节点
        //从0开始切割k个 不包括k
        String leftpre=pre.substring(1,k+1);
        //从k开始切割到最后不包括k
        String rightpre=pre.substring(k+1);
        //从0开始切到k不包括k
        String leftinor=inor.substring(0,k);
        //从k+1开始切割到最后不包括k
        String rightinor=inor.substring(k+1);
        dfs(leftpre,leftinor);
        dfs(rightpre,rightinor);
        System.out.printf("%c",root);
        //因为要输出后序序列，所以是左右根
        //先遍历左子树，再右子树，再根节点
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String in;
        in = sc.readLine();
        String pre;
        pre = sc.readLine();
        dfs(pre, in);
    }
}
