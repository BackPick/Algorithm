
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, TreeNode> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()
                .trim());

        for (int i = 0; i < N; i++) {
            String[] nodeInfo = br.readLine()
                    .split(" ");
            char root  = nodeInfo[0].charAt(0);
            char left  = nodeInfo[1].charAt(0);
            char right = nodeInfo[2].charAt(0);
            // 키가 없다면
            if (!nodes.containsKey(root)) {
                nodes.put(root, new TreeNode(root));
            }
            TreeNode rootNode = nodes.get(root);
            if (left != '.') {
                if (!nodes.containsKey(left)) {
                    nodes.put(left, new TreeNode(left));
                }
                rootNode.left = nodes.get(left);
            }
            if (right != '.') {
                if (!nodes.containsKey(right)) {
                    nodes.put(right, new TreeNode(right));
                }
                rootNode.right = nodes.get(right);
            }
        }
        TreeNode root = nodes.get('A');
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTravalsal(root);
        System.out.println();
    }

    private static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }

    private static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value);
        inOrderTraversal(node.right);
    }

    private static void postOrderTravalsal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTravalsal(root.left);
        postOrderTravalsal(root.right);
        System.out.print(root.value);
    }
}

class TreeNode {
    char     value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char value) {
        this.value = value;
        this.left  = null;
        this.right = null;
    }
}