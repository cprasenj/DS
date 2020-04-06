package prasenjit;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> ancestor;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node (T data) {
        this.data = data;
    }

    public Node<T> getAncestor() {
        return ancestor;
    }

    public void setAncestor(Node<T> ancestor) {
        this.ancestor = ancestor;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void insertChild(Node<T> other) {
        if (data.compareTo(other.data) == 0) {
            return;
        }
        if (data.compareTo(other.data) > 0) {
            if (isNull(leftChild)) {
                this.leftChild = other;
            }
            this.leftChild.insertChild(other);
        } else {
            if (isNull(rightChild)) {
                this.rightChild = other;
            }
            this.rightChild.insertChild(other);
        }

    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public <R> List<R> getChildren(Function<T, R> f) {
        List<R> leftChildren = isNull(leftChild) ? new ArrayList<>() :
                leftChild.getChildren(f);

        List<R> rightChildren = isNull(rightChild) ? new ArrayList<>() :
                rightChild.getChildren(f);

        R transformedRoot = f.apply(data);
        List<R> children = new ArrayList<>(leftChildren);
        children.add(transformedRoot);
        leftChildren.addAll(rightChildren);
        return children;
    }

    public Integer getChildrenCount() {
        Integer left = nonNull(leftChild) ? leftChild.getChildrenCount() + 1 : 0;
        Integer right = nonNull(rightChild) ? rightChild.getChildrenCount() + 1 : 0;
        return left + right;
    }
}
