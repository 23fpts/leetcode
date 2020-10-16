package thc.daily;

import thc.utils.TreeNode;

/**
 * @author thc
 * @Title:
 * @Package thc.daily
 * @Description:
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/</p>
 *
 * 二叉查找树（Binary Search Tree），
 * （又：二叉搜索树，二叉排序树）它或者是一棵空树，
 * 或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *                         若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *                         它的左、右子树也分别为二叉排序树。
 * 二叉搜索树作为一种经典的数据结构，它既有链表的快速插入与删除操作的特点，又有数组快速查找的优势；
 * 所以应用十分广泛，例如在文件系统和数据库系统一般会采用这种数据结构进行高效率的排序与检索操作。 [1]
 * @date 2020/10/12 1:21 下午
 */
public class P530_getMinimumDifference {

    private static class ResultMap {
        private int min;
        private TreeNode prev;

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public TreeNode getPrev() {
            return prev;
        }

        public void setPrev(TreeNode prev) {
            this.prev = prev;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        return inOrderTraversal(root, null, min).getMin();
    }

    private ResultMap inOrderTraversal(TreeNode root, TreeNode prev, int min) {
        ResultMap resultMap = new ResultMap();
        resultMap.setMin(min);
        resultMap.setPrev(prev);
        // 边界判断
        if (root==null) {
            return resultMap;
        }
        // 左子树
        resultMap = inOrderTraversal(root.getLeft(), prev, min);
        System.out.println("root:"+root.getVal());
        System.out.print("previous:");
        System.out.println(resultMap.getPrev()==null? "null" : resultMap.getPrev().getVal());
        if (resultMap.getPrev()!=null) {
            System.out.println("min-prev:"+min);
            min = Math.min(resultMap.getMin(), root.getVal()- resultMap.getPrev().getVal());
            System.out.println("min-now:"+min);
        }
        // 右子树
        resultMap = inOrderTraversal(root.getRight(), root, min);
        return resultMap;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.setLeft(new TreeNode(1));
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.setLeft(new TreeNode(3));
        treeNode1.setRight(new TreeNode(5));
        treeNode.setRight(treeNode1);
        TreeNode.inOrderTraversal(treeNode);
        P530_getMinimumDifference test = new P530_getMinimumDifference();
        int min = test.getMinimumDifference(treeNode);
        System.out.println(min);

        System.out.println("newnewnew");
        System.out.println("[334,277,507,null,285,null,678]");
        TreeNode tree334 = new TreeNode(334);
        //
        TreeNode tree227 = new TreeNode(277);
        tree227.setRight(new TreeNode(285));
        //
        TreeNode tree507 = new TreeNode(507);
        tree507.setRight(new TreeNode(678));

        //
        tree334.setLeft(tree227);
        tree334.setRight(tree507);
        test.getMinimumDifference(tree334);
    }

}
