void morrisInorder(Node root) {
    Node current = root;
    while (current != null) {
        if (current.left == null) {
            System.out.print(current.data + " ");
            current = current.right;
        } else {
            Node predecessor = current.left;
            while (predecessor.right != null && predecessor.right != current) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                predecessor.right = current;  // Threading
                current = current.left;
            } else {
                predecessor.right = null;  // Remove thread
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }
}
