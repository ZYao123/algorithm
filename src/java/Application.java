import java.io.File;

public class Application {

    public static void main(String[] args) {
//        (new Application()).rename("./src/com/leetcode");
        System.out.println("Hello World!!");
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
}
