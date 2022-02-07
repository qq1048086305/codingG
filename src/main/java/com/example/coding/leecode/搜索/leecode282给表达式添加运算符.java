package com.example.coding.leecode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 14:28
 * @Version 1.0
 * @description:
 */
public class leecode282给表达式添加运算符 {
    List<String> ans = new ArrayList<>();
    char[] path = new char[100];

    public List<String> addOperators(String num, int target) {
        // 题解：https://www.acwing.com/solution/content/332/
        // 开始时：a + b * _， 的代数结构，初始化：a为0，b为1
        dfs(num, 0, 0, 0, 1, target);
        return ans;
    }
    // 把前面时式子维护成：a + b * _， 的代数结构（离散数学）
    public void dfs(String num, int u, int len, long a, long b, int target) {
        if(u == num.length()) {
            if(a == target) ans.add(new String(path, 0, len - 1));
        }else {
            long c = 0;
            for(int i = u; i < num.length(); i ++) {
                c = c * 10 + num.charAt(i) - '0';
                path[len ++] = num.charAt(i);

                // 由于让最后一个数字后面多添加一个+，所以最后的a就是整个表达式的答案
                // +
                path[len] = '+';
                dfs(num, i + 1, len + 1, a + b * c, 1, target);

                // 当i为n-1时，就代表是最后一个数字了。
                if(i + 1 < num.length()) {
                    // -
                    path[len] = '-';
                    dfs(num, i + 1, len + 1, a + b * c, -1, target);

                    // *
                    path[len] = '*';
                    dfs(num, i + 1, len + 1, a, b * c, target);
                }
                // 要去除前导0的情况,只允许单独出现一个0
                if(num.charAt(u) == '0') break;
            }
        }

    }
}
