package com.example.osnovy_algoritmov2;

import java.util.Arrays;
import java.util.Random;


public class IntegerListLogic implements IntegerList {
    public static Integer[] nums = new Integer[100_000];
    int size = nums.length-1;

    @Override
    public Integer add(Integer item) {
        growIfNeeded();
        validate(item);
        nums[size--] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validate(item);
        validateIndex(index);
        growIfNeeded();
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
        nums[index] = item;
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
        Integer[] numsCopy = toArray();
        sortInsertion(numsCopy);
       return binarySearch(numsCopy,item);
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

    public void sort(Integer[] arr){
        quickSort(arr,0, arr.length-1);
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

    private void growIfNeeded() {
        if (size == nums.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    public static void randomArray() {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100_000);
        }
    }


    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


    private void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;

            }
            arr[j] = temp;
        }
    }
    private boolean binarySearch(Integer[] nums,Integer item){
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == nums[mid]) {
                return true;
            }

            if (item < nums[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow(){
        nums = new Integer [nums.length + nums.length/2];
    }

    private static void swapElements(int[] arr, int i1, int i2) {
        int temp = arr[i2];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }





}
