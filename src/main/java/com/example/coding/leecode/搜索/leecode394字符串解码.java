package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 19:41
 * @Version 1.0
 * @description:
 */
public class leecode394字符串解码 {
    public String decodeString(String s) {
        return dfs(s);
    }
    int idx=0;
    public String dfs(String s) {
        StringBuilder ans = new StringBuilder();
        int cur = 0;
        while(idx<s.length()){
            char ch = s.charAt(idx);
            if (ch >= '0' && ch <= '9') cur = cur * 10 + (ch - '0');
            else if (ch == '[') {
                //跳过[
                idx++;
                String sub = dfs(s);
                for (int j = 0; j < cur; ++j) ans.append(sub);
                //用完清0
                cur = 0;
            } else if (ch == ']') return ans.toString();
            else ans.append(ch);
            idx++;
            //每次判断完正常idx++
        }
        return ans.toString();
    }
}
