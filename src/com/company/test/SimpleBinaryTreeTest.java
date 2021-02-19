package com.company.test;

import com.company.ds.SimpleBinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleBinaryTreeTest {
    @Test
    public void addToBinaryTree(){
        SimpleBinaryTree<Integer> bt = new SimpleBinaryTree<Integer>();
        bt.add(11);
        bt.add(22);
        bt.add(33);
        assertEquals(3,bt.getCount());
    }

    @Test
    public void containsObjectInBinaryTree(){
        SimpleBinaryTree<Integer> bt = new SimpleBinaryTree<Integer>();
        bt.add(11);
        bt.add(22);
        bt.add(33);
        assertTrue(bt.contains(11));
        assertFalse(bt.contains(1234));
    }
}
