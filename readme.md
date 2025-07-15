# 🌳 Morris Traversal – Constant Space Tree Traversal

Morris Traversal is a clever algorithm for traversing binary trees **without using recursion or a stack**. It provides **O(n) time complexity** and **O(1) space complexity**, making it a space-efficient alternative to standard traversals.

---

## 🚀 Motivation

In traditional tree traversals (inorder, preorder, postorder), we either use:
- **Recursion**, which uses the call stack (implicit memory)
- **An explicit stack**, which uses additional space

Morris Traversal avoids both by temporarily modifying the tree structure to create **"threads"**—links from a node’s predecessor to the node itself.

---

## 🧠 Core Idea: Threaded Binary Tree

The algorithm relies on the idea of **reusing null right pointers** in a binary tree:
- For a node that has a left subtree, its **inorder predecessor** (rightmost node in the left subtree) will naturally have a `null` right child.
- Morris Traversal temporarily sets this `null` pointer to point back to the current node.
- This creates a "thread" that allows us to **return to the current node** after traversing the left subtree, without recursion or a stack.
- Once done, we **remove the thread** to restore the original tree.

---

## 📘 Traversal Variants

### 🔹 Inorder (Left → Root → Right)

- **Visit rule:** Visit the node *after* exploring the left subtree.
- **When to visit:** When returning via a thread (or if no left child).
- Most straightforward form of Morris traversal.

---

### 🔹 Preorder (Root → Left → Right)

- **Visit rule:** Visit the node *before* exploring the left subtree.
- **When to visit:** Right after creating a thread to the current node.
- Useful when the immediate value of the node is needed (e.g., serialization).

---

### 🔹 Postorder (Left → Right → Root)

- Most complex because the node is visited **after both children**.
- Requires:
  1. Creating a dummy root.
  2. Threading like in inorder.
  3. **Reversing the right boundary** of the left subtree and printing it in reverse.
  4. Restoring the reversed boundary after visiting.

This approach simulates postorder behavior while still achieving O(1) space.

---

## 🟢 Benefits

- **No stack, no recursion** → constant space.
- **Restores original tree structure** after traversal.
- Useful in memory-constrained environments or system-level applications.

---

## 🔴 Limitations

- Tree is **temporarily modified**, so avoid if tree mutability is not allowed.
- More complex to implement and understand than recursive/iterative methods.
- Postorder version is particularly tricky.

---

## 🧾 Summary Table

| Traversal Type | Visit Order        | When Node is Visited           | Additional Logic |
|----------------|--------------------|--------------------------------|------------------|
| Inorder        | Left → Root → Right| After left is done             | None             |
| Preorder       | Root → Left → Right| Before threading               | None             |
| Postorder      | Left → Right → Root| After both children are visited| Requires reverse printing |

---

## 💬 Final Thoughts

Morris Traversal is a powerful technique that shows how we can think differently to optimize space. While it's not always the most intuitive method, mastering it gives deep insight into binary tree structures and low-level memory management.

---




Morris Traversal is a space-optimized tree traversal algorithm that uses no recursion and no stack. It temporarily modifies the tree's structure (by using threaded binary trees) to achieve O(1) space complexity, while maintaining O(n) time.

🌳 Morris Traversal Types:
Traversal Type	Order	Notes
Inorder	Left → Root → Right	Most common form of Morris
Preorder	Root → Left → Right	Visit node before creating thread
Postorder	Left → Right → Root	Hardest; requires reversed path

Let’s go through each with Java code and clear explanation.

✅ 1. Morris Inorder Traversal (Left → Root → Right)
🔸 Algorithm Steps:
Start from the root.

If the node has no left child:

Visit the node.

Move to the right.

If it has a left child:

Find the rightmost node in the left subtree (predecessor).

If the predecessor’s right is null, set it to the current node (threading).

Else, revert the thread, visit the node, move to right.
