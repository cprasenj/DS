package prasenjit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Objects.isNull;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree<T> insert(T data) {
        Node<T> node = new Node<>(data);
        if (getRoot() == null) {
            setRoot(node);
            return this;
        }
        getRoot().insertChild(node);
        return this;
    }

    public Node<T> delete(T data) {
        return null;
    }

    public Node<T> search(T data) {
        return null;
    }

    public Integer size() {
        return Optional.ofNullable(getRoot())
                .map(r -> r.getChildrenCount() + 1)
                .orElse(0);
    }

    public Integer height() {
        return Optional.ofNullable(getRoot())
                .map(r -> r.getDepth() + 1)
                .orElse(0);
    }

    public Integer levelWithMaxSum() {
        return null;
    }

    public Node<T> lca(Node<T> one, Node<T> another) {
        return null;
    }

    public <R> List<R> ldrTraversal(Function<T, R> f) {

        if (isNull(getRoot())) {
            return Collections.emptyList();
        }

        List<R> leftChildren = Optional.ofNullable(getRoot().getLeftChild())
                .map(lc -> lc.getChildren(f))
                .orElse(new ArrayList<>());

        List<R> rightChildren = Optional.ofNullable(getRoot().getRightChild())
                .map(rc -> rc.getChildren(f))
                .orElse(new ArrayList<>());

        R transformedRootData = f.apply(getRoot().getData());

        List<R> children = new ArrayList<>(leftChildren);
        children.add(transformedRootData);
        children.addAll(rightChildren);
        return children;
    }



    public <R> List<R> lrdTraversal(Function<T, R> f) {
        return null;
    }

    public <R> List<R> dlrTraversal(Function<T, R> f) {
        return null;
    }

    public <R> List<R> drlTraversal(Function<T, R> f) {
        return null;
    }

    public <R> List<R> rdlTraversal(Function<T, R> f) {
        return null;
    }

    public <R> List<R> rldTraversal(Function<T, R> f) {
        return null;
    }

    public <R> List<R> preOrderTraversal(Function<T, R> f) {
        return dlrTraversal(f);
    }

    public <R> List<R> inOrderTraversal(Function<T, R> f) {
        return ldrTraversal(f);
    }

    public <R> List<R> postOrderTraversal(Function<T, R> f) {
        return lrdTraversal(f);
    }
}
