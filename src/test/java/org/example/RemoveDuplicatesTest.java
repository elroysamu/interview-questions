package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private RemoveDuplicates removeDuplicates;

    @BeforeEach
    void setUp() {
        removeDuplicates = new RemoveDuplicates();
    }

    @Test
    void testExample1() {
        int[] nums = {1, 1, 2};
        int expectedLength = 2;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        // Check that first 2 elements are correct
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testExample2() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expectedLength = 5;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        // Check that first 5 elements are correct
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int expectedLength = 0;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
    }

    @Test
    void testSingleElement() {
        int[] nums = {1};
        int expectedLength = 1;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(1, nums[0]);
    }

    @Test
    void testNoDuplicates() {
        int[] nums = {1, 2, 3, 4, 5};
        int expectedLength = 5;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        // All elements should remain the same
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
        assertEquals(5, nums[4]);
    }

    @Test
    void testAllDuplicates() {
        int[] nums = {2, 2, 2, 2, 2};
        int expectedLength = 1;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(2, nums[0]);
    }

    @Test
    void testTwoElements_NoDuplicates() {
        int[] nums = {1, 2};
        int expectedLength = 2;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testTwoElements_WithDuplicates() {
        int[] nums = {1, 1};
        int expectedLength = 1;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(1, nums[0]);
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-3, -3, -1, -1, 0, 0, 1, 1};
        int expectedLength = 4;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(-3, nums[0]);
        assertEquals(-1, nums[1]);
        assertEquals(0, nums[2]);
        assertEquals(1, nums[3]);
    }

    @Test
    void testLargeArray() {
        // Create array with pattern: [0,0,1,1,2,2,...,49,49]
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i / 2;
        }

        int expectedLength = 50;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);

        // Verify first 50 elements are [0,1,2,...,49]
        for (int i = 0; i < 50; i++) {
            assertEquals(i, nums[i]);
        }
    }

    @Test
    void testConsecutiveDuplicatesAtEnd() {
        int[] nums = {1, 2, 3, 4, 4, 4, 4};
        int expectedLength = 4;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
    }

    @Test
    void testConsecutiveDuplicatesAtBeginning() {
        int[] nums = {1, 1, 1, 1, 2, 3, 4};
        int expectedLength = 4;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
    }

    @Test
    void testAlternatingPattern() {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int expectedLength = 5;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
        assertEquals(5, nums[4]);
    }

    @Test
    void testManyDuplicatesOfSameElement() {
        int[] nums = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int expectedLength = 1;
        int actualLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, actualLength);
        assertEquals(5, nums[0]);
    }

    @Test
    void testReturnValueMatchesModifiedArrayLength() {
        int[] nums = {1, 1, 2, 3, 3, 3, 4, 5, 5};
        int actualLength = removeDuplicates.removeDuplicates(nums);

        // Verify that elements from index 0 to actualLength-1 are unique and sorted
        for (int i = 1; i < actualLength; i++) {
            assertTrue(nums[i] > nums[i-1],
                    "Element at index " + i + " should be greater than previous element");
        }
    }
}