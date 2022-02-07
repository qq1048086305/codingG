package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 19:27
 * @Version 1.0
 * @description:
 */
public class leecode393UTF8编码检验 {
    public int get(int x, int k) {
        return (x >> k) & 1;
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (get(data[i], 7) == 0) {
                continue;
            }
            int k = 0;
            while (k <= 4 && get(data[i], 7 - k) == 1) {
                k++;
            }
            if (k == 1 || k > 4) {
                return false;
            }
            for (int j = 0; j < k - 1; j++) {
                int t = i + j + 1;
                if (t >= data.length) {
                    return false;
                }
                if (!(get(data[t], 7) == 1 && get(data[t], 6) == 0)) {
                    return false;
                }
            }
            i += k - 1;
        }
        return true;
    }
}
