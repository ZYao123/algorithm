package com;

import java.util.LinkedList;


/*
链接：https://www.nowcoder.com/questionTerminal/430180b66a7547e1963b69b1d0efbd3c
来源：牛客网

请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 */
public class FoldPaper {
    LinkedList<String> list;

    public String[] foldPaper(int n) {
        list = new LinkedList<>();
        helper(1, n, true);
        String[] res = new String[list.size()];
        int idx = 0;
        for (String str : list) {
            res[idx++] = str;
        }
        return res;
    }

    private void helper(int deep, int n, boolean down) {
        if (deep > n)
            return;
        helper(deep + 1, n, true);
        list.add(down ? "down" : "up");
        helper(deep + 1, n, false);
    }
}
