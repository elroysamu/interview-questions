package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    private MoveZeros moveZeros;

    @BeforeEach
    void setUp() {
        moveZeros = new MoveZeros();
    }

    @Test
    void testBasicCase() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testSingleZero() {
        int[] nums = {0};
        int[] expected = {0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testSingleNonZero() {
        int[] nums = {1};
        int[] expected = {1};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testNoZeros() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testZerosAtBeginning() {
        int[] nums = {0, 0, 0, 1, 2, 3};
        int[] expected = {1, 2, 3, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testZerosAtEnd() {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] expected = {1, 2, 3, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testZerosInMiddle() {
        int[] nums = {1, 2, 0, 0, 3, 4};
        int[] expected = {1, 2, 3, 4, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testAlternatingZerosAndNumbers() {
        int[] nums = {0, 1, 0, 2, 0, 3, 0, 4};
        int[] expected = {1, 2, 3, 4, 0, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testTwoElements_ZeroFirst() {
        int[] nums = {0, 1};
        int[] expected = {1, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testTwoElements_ZeroSecond() {
        int[] nums = {1, 0};
        int[] expected = {1, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testTwoElements_BothZeros() {
        int[] nums = {0, 0};
        int[] expected = {0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-1, 0, -2, 0, 3, -4};
        int[] expected = {-1, -2, 3, -4, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testLargeNumbers() {
        int[] nums = {0, 1000000, 0, -1000000, 0};
        int[] expected = {1000000, -1000000, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testDuplicateNonZeroNumbers() {
        int[] nums = {1, 0, 1, 0, 1};
        int[] expected = {1, 1, 1, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int[] expected = {};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testRelativeOrderPreserved() {
        int[] nums = {4, 0, 2, 0, 1, 0, 3};
        int[] expected = {4, 2, 1, 3, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);

        // Verify relative order of non-zero elements is preserved
        // Original non-zero order: 4, 2, 1, 3
        // Result non-zero order should be: 4, 2, 1, 3
        assertEquals(4, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(1, nums[2]);
        assertEquals(3, nums[3]);
    }

    @Test
    void testLargeArray() {
        int[] nums = new int[1000];
        int[] expected = new int[1000];

        // Fill array with pattern: even indices = 0, odd indices = index value
        int nonZeroIndex = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = i;
                expected[nonZeroIndex++] = i;
            }
        }
        // Fill remaining positions with zeros
        while (nonZeroIndex < 1000) {
            expected[nonZeroIndex++] = 0;
        }

        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testConsecutiveZeros() {
        int[] nums = {1, 2, 0, 0, 0, 0, 3, 4};
        int[] expected = {1, 2, 3, 4, 0, 0, 0, 0};
        moveZeros.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void testZeroCountCorrect() {
        int[] nums = {0, 1, 0, 2, 0, 3, 0};
        int originalZeroCount = 0;
        for (int num : nums) {
            if (num == 0) originalZeroCount++;
        }

        moveZeros.moveZeroes(nums);

        // Count zeros at the end
        int zerosAtEnd = 0;
        for (int i = nums.length - 1; i >= 0 && nums[i] == 0; i--) {
            zerosAtEnd++;
        }

        assertEquals(originalZeroCount, zerosAtEnd);
    }

    @Test
    void testNonZeroElementsCountCorrect() {
        int[] nums = {5, 0, 1, 0, 3, 0, 7, 8};
        int originalNonZeroCount = 0;
        for (int num : nums) {
            if (num != 0) originalNonZeroCount++;
        }

        moveZeros.moveZeroes(nums);

        // Count non-zero elements at the beginning
        int nonZeroCount = 0;
        for (int i = 0; i < nums.length && nums[i] != 0; i++) {
            nonZeroCount++;
        }

        assertEquals(originalNonZeroCount, nonZeroCount);
    }
}