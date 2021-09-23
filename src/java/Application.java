import java.io.File;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
//        (new java.Application()).rename("./src/com/leetcode");
//        System.out.println("Hello World!!");
        String data = "[]";
        String s = data.substring(1, data.length() - 1);
        System.out.println(s);
        System.out.println(s.length() == 0);
        String[] split = "".split(",");
        System.out.println(split.length);
        System.out.println(Arrays.toString(split));
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
                        String newFileName = helper(f.getName());
                        System.out.println(newFileName);
                        f.renameTo(new File(newFileName));
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    private String helper(String fileName) {
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
}
