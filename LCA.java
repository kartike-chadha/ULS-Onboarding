import java.util.*;

class LCA {
    static class ListNode{
        Integer value;
        ListNode left,right;
    }
    static ListNode createNode(int value){
        ListNode newNode = new ListNode();
        newNode.value = value;
        newNode.left = null;
        newNode.right = null;

        return newNode;
    }

    static ListNode LevelOrder(ListNode root, Integer value){
        if (root == null){
            root = createNode(value);
            return root;
        }
    
        if (value <= root.value)
            root.left = LevelOrder(root.left, value);
        else
            root.right = LevelOrder(root.right, value);
        return root;
    }

    static ListNode constructBst(List<Integer> levelOrderBST, int numOfElements){
        if (numOfElements == 0) 
            return null; 
            
        ListNode root = null;
    
        for(int i = 0; i < numOfElements; i++){
            if(levelOrderBST.get(i)!=null)
            root = LevelOrder(root, levelOrderBST.get(i)); //call LevelOrder for each element which is not null and place it in the BST
        }
        return root;
    }


    static ListNode lca(ListNode node, int p, int q){
        if (node == null)
            return null;

        if (node.value > p && node.value > q)
            return lca(node.left, p, q); //if both p and q are on one side of the current node, current node cant be the LCA

        if (node.value < p && node.value < q)
            return lca(node.right, p, q);
 
        return node; //if the p and q are on two different sides of the current node then then node is LCA
    }


 

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<Integer> levelOrderBST = new ArrayList<>();
        int numOfElements = Integer.parseInt(sc.nextLine()); //Enter num of elements
        String input;
        for(int i=0;i<numOfElements;i++){ //Enter each element in one line each and leave line empty for null
            input = sc.nextLine();
            if(input.isEmpty()){
                levelOrderBST.add(null);
            }else{
                levelOrderBST.add(Integer.parseInt(input));
            }
        }
        ListNode root = constructBst(levelOrderBST,numOfElements);
        int p = sc.nextInt();
        int q = sc.nextInt();
        ListNode lcaNode = lca(root, p, q);
        if(lcaNode!=null){
            System.out.println(lcaNode.value);
        }else{
            System.out.println("p and q not present");
        }
    }
}