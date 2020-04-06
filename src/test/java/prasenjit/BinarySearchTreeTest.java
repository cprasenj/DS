package prasenjit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;


public class BinarySearchTreeTest {

    @Test
    public void shouldInsertValuesInTheTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(10);
        assertEquals(Integer.valueOf(1), bst.size());

        bst.insert(5);
        assertEquals(Integer.valueOf(2), bst.size());

        bst.insert(2);
        assertEquals(Integer.valueOf(3), bst.size());

        BinarySearchTree<Double> bst1 = new BinarySearchTree<>();
        bst1.insert(10.1);
        assertEquals(Integer.valueOf(1), bst1.size());

        bst1.insert(5.2);
        assertEquals(Integer.valueOf(2), bst1.size());

        bst1.insert(2.3);
        assertEquals(Integer.valueOf(3), bst1.size());

    }

    @Test
    public void shouldDoInOrderTraversal() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(2);

        List<Integer> actual = bst.inOrderTraversal(Function.identity());
        List<Integer> expected = Arrays.asList(2, 5, 10);

        assertEquals(expected, actual);
        assertEquals(Integer.valueOf(3), bst.size());

        bst.insert(-109);
        assertEquals(Arrays.asList(-109, 2, 5, 10), bst.inOrderTraversal(Function.identity()));
        assertEquals(Integer.valueOf(4), bst.size());

    }

}