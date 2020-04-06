package prasenjit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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
        if (nonNull(getRoot())) {
            return getRoot().getChildrenCount() + 1;
        }
        return 0;
    }

    public Integer height() {
        return null;
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

        List<R> leftChildren = isNull(getRoot().getLeftChild()) ? new ArrayList<>() :
                getRoot().getLeftChild().getChildren(f);
        List<R> rightChildren = isNull(getRoot().getRightChild()) ? new ArrayList<>() :
                getRoot().getRightChild().getChildren(f);

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
