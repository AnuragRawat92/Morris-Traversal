void morrisPreorder(Node root) {
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
                System.out.print(current.data + " ");  // Visit before threading
                predecessor.right = current;
                current = current.left;
            } else {
                predecessor.right = null;
                current = current.right;
            }
        }
    }
}
