package com.example.osnovy_algoritmov2;

import java.security.PublicKey;
import java.util.Arrays;

public class IntegerListLogic implements IntegerList {
    Integer[] nums = new Integer[12];
    int size = nums.length;

    @Override
    public Integer add(Integer item) {
        sizeValidate();
        validate(item);
        nums[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validate(item);
        validateIndex(index);
        sizeValidate();
        if (index == size) {
            nums[size++] = item;
            return item;
        }
        System.arraycopy(nums, index, nums, index - 1, size - index);
        nums[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validate(item);
        nums[index] = Integer.valueOf(item);
        return item;
    }

    @Override
    public Integer remove(Integer item) throws ElementNotFoundException {
        validate(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index == size) {
            nums[size--] = null;
            return item;
        }

        System.arraycopy(nums, index + 1, nums, index, size - index);

        size--;
        return item;
    }

    @Override
    public Integer remove(int index) throws ElementNotFoundException {
        validateIndex(index);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        Integer item = nums[index];
        if (index == size) {
            nums[size--] = null;
            return item;
        }

        System.arraycopy(nums, index + 1, nums, index, size - index);

        size--;

        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return nums[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(nums, otherList.toArray());

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;

    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(nums, size);

    }


    private void validate(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void sizeValidate() {
        if (size == nums.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }


}
