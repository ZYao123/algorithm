import com.baidu.main;

import java.io.File;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
//        (new Application()).rename("./src/com/leetcode");
//        System.out.println("Hello World!!");

        String a = "ABACABAD";
        String b = "BBC ABACABACABAD ABCDABDE";
        System.out.println("next =" + Arrays.toString(a.toCharArray()));
        int result = kmp(b, a);

        //打印结果：和字符串获得匹配的位置
        System.out.println("resultPosion:" + result);
        main run = new main();
        run.run();
        StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.toString().trim();
    }

    private void rename(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File f : files) {
                    if (!f.isDirectory()) {
//                        System.out.println("文件:" + f.getAbsolutePath());
//                        System.out.println("文件名:" + f.getName());
                        String newFileName = createNewName(f.getName());
                        System.out.println(newFileName);
                        f.renameTo(new File(newFileName));
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    private String createNewName(String fileName) {
        String prefix = "Solution";
        String substring = fileName.substring(prefix.length());
        String[] split = substring.split("\\.");
        String str = split[0];
        if (str.length() == 0)
            return fileName;
        while (str.charAt(0) == '_')
            str = str.substring(1);
        return prefix + '_' + Integer.parseInt(str) + ".java";
    }

    /**
     * KMP 匹配
     */
    public static int kmp(String str, String dest) {
        //1.首先计算出 部分匹配表
        int[] next = kmpnext(dest);

        System.out.println("next =" + Arrays.toString(next));
        //2.查找匹配位置
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 计算部分匹配表
     */
    public static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;

        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
