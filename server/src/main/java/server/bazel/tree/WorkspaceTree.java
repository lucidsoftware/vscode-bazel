package server.bazel.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WorkspaceTree {
    private static final Logger logger = LogManager.getLogger(WorkspaceTree.class);
    private Node root;

    public WorkspaceTree(Package rootPackage) {
        this.root = new Node(rootPackage, null);
    }

    public Node getRoot() {
        return this.root;
    }

    @Override
    public String toString() {
        return "WorkspaceTree{" +
                "root=" + root +
                '}';
    }

    public static class Node {
        private Node parent;
        private Package value;
        private List<Node> children;

        public Node(Package value, Node parent) {
            this.parent = parent;
            this.value = value;
            this.children = new ArrayList<>();
        }

        public Package getValue() {
            return value;
        }

        public Node addChild(Package value) {
            Node child = new Node(value, this);
            this.children.add(child);
            return child;
        }

        public Optional<Node> getChild(String childPath) {
            for(Node node : children) {
                if(node.value.getPackageName().equals(childPath)) {
                    return Optional.of(node);
                }
            }
            return Optional.empty();
        }

        public boolean isRoot() {
            return this.parent == null;
        }

        public boolean isLeaf() {
            return this.children.isEmpty();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parent, value, children);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", children=" + children +
                    '}';
        }
    }
}
