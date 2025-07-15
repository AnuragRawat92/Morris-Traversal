void reversePath(Node from, Node to) {
    if (from == to) return;
    Node x = from, y = from.right, z;
    while (x != to) {
        z = y.right;
        y.right = x;
        x = y;
        y = z;
    }
}

void printReverse(Node from, Node to) {
    reversePath(from, to);
    Node p = to;
    while (true) {
        System.out.print(p.data + " ");
        if (p == from) break;
        p = p.right;
    }
    reversePath(to, from);
}
void morrisPostorder(Node root) {
    Node dummy = new Node(0);
    dummy.left = root;
    Node current = dummy;

    while (current != null) {
        if (current.left == null) {
            current = current.right;
        } else {
            Node predecessor = current.left;
            while (predecessor.right != null && predecessor.right != current) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                predecessor.right = current;
                current = current.left;
            } else {
                printReverse(current.left, predecessor);
                predecessor.right = null;
                current = current.right;
            }
        }
    }
}
