package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class PivotIndexTest {

    private PivotIndex pivotIndex;

    @BeforeEach
    void setUp() {
        pivotIndex = new PivotIndex();
    }

    @Test
    void testPivotInMiddle() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        assertEquals(3, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testNoPivot() {
        int[] nums = {1, 2, 3};
        assertEquals(-1, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testPivotAtBeginning() {
        int[] nums = {2, 1, -1};
        assertEquals(0, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testSingleElement() {
        int[] nums = {10};
        assertEquals(0, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testTwoElements_NoPivot() {
        int[] nums = {1, -1};
        assertEquals(-1, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0};
        assertEquals(0, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testMultiplePivots_LeftmostChosen() {
        int[] nums = {0, 1, -1, 0};
        assertEquals(0, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testPivotAtBeginning_whenItLooksLikeEnd() {
        // earlier I mistakenly expected 5 — correct leftmost pivot is 0
        int[] nums = {-1, -1, -1, 0, 1, 1};
        assertEquals(0, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testNegativeNumbers_NoPivot() {
        // earlier I incorrectly expected 5 here — there is no pivot
        int[] nums = {-2, -1, -1, -1, -2, 7};
        assertEquals(-1, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testLargeNumbersPivotAtEndIndex3() {
        // total = 0, pivot is index 3
        int[] nums = {1000, -500, -500, 0};
        assertEquals(3, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testLargeArrayWithoutPivot() {
        int n = 10000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = 1;
        assertEquals(-1, pivotIndex.pivotIndex(nums));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(-1, pivotIndex.pivotIndex(nums));
    }
}
