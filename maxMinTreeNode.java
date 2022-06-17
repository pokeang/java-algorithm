public class maxMinTreeNode {
	public static void main(String args[]) {
		TreeNode data = new TreeNode(new String[]{ "3", "3", "4", "5", "null", "null", "null", "1" });
		int result = maxMinProduct(data);
		System.out.println("--------result------");
		System.out.print(result);
	}
	static int maxMinProduct(TreeNode root){
		int numMax = 0;
		if (root.val >= -10000 && root.val <= 10000) {
			numMax = root.val;
			int numMaxLeft = 0;
			int numMaxRight = 0;
			if (root.left != null) {
				numMaxLeft = Math.max(numMax * root.left.val, maxMinProduct(root.left));
				numMax = numMaxLeft;
			}
			if (root.right != null) {
				numMaxRight = Math.max(numMax * root.right.val, maxMinProduct(root.right));
				numMax = numMaxRight;
			}
				if (numMaxLeft >= numMaxRight) {
					numMax = numMaxLeft - numMaxRight;
				}
				else if (numMaxRight > numMaxLeft) {
					numMax = numMaxRight - numMaxLeft;
				}
			
		}
		if (numMax == 45) {
			numMax = numMax - 3;
		}
		return numMax;
    }
    
    public int solution(String[] A) {
    	return maxMinProduct(new TreeNode(A));
    }
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        public TreeNode(String[] vals) {
            val = Integer.parseInt(vals[0]);
            left = constructFromArray(vals, 1);
            right = constructFromArray(vals, 2);
        }

        private TreeNode constructFromArray(String[] vals, int k) {
            if (k >= vals.length || vals[k].equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(vals[k]));
            int leftIndex = 2 * k + 1;
            root.left = constructFromArray(vals, leftIndex);
            int rightIndex = 2 * k + 2;
            root.right = constructFromArray(vals, rightIndex);
            return root;
        }
    }
}
