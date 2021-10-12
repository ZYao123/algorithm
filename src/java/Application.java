import com.leetcode.TreeNode;
import com.leetcode.lcp.lcp_34;
import com.util.graph.Node;
import com.util.graph.NodeHeap;
import unit.treeTest;

import java.io.File;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
//        (new java.Application()).rename("./src/com/leetcode");
//        System.out.println("Hello World!!");

//        TreeNode root = treeTest.stringToTreeNode("[4,1,3,9,null,null,2]");
//        lcp_34 l = new lcp_34();
//        int max = l.maxValue(root, 2);
//        System.out.println(max);
        NodeHeap heap = new NodeHeap();
        Node t = new Node(1);
        heap.offer(t);
        heap.offer(new Node(5));
        heap.offer(new Node(3));
        heap.setValue(t, 10);
        System.out.println(heap.peek().value);
        System.out.println(heap.poll().value);
        System.out.println(heap.poll().value);
        System.out.println(heap.poll().value);
        System.out.println(heap.size());
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
