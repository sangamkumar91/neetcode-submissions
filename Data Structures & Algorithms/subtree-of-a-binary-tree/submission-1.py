# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isEqual(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None and subRoot is None:
            return True
        if root is None or subRoot is None:
            return False
        if root.val != subRoot.val:
            return False
        return self.isEqual(root.left, subRoot.left) and self.isEqual(root.right, subRoot.right)
        

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if subRoot is None:
            return True
        if root is None:
            return False
        result = False
        result = self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
        if root.val == subRoot.val:
            result = result or self.isEqual(root, subRoot)
        return result 
        