import java.util.Scanner;

public class BubbleSort<T extends Comparable<T>> {
    private T[] array;

    public BubbleSort(T[] array) {
        this.array = array;
    }

    public void sort() {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public void printSortedArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        while (flag == 0) {
            System.out.print("Press 1 to input own array or 0 to see example usage (1/0): ");
            String userInput = scanner.nextLine().toLowerCase();

            if ("1".equals(userInput)) {
                flag = 1;
                System.out.print("Enter the size of the array: ");
                int size = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the elements of the array (separated by spaces)\n(You can enter elements of mixed/differnt data types or only one data type): ");
                String[] inputArray = scanner.nextLine().split(" ");

                boolean treatAsString = false;
                for (int i = 0; i < inputArray.length; i++) {
                    if (!inputArray[i].matches("-?\\d+(\\.\\d+)?")) {
                        treatAsString = true;
                        break; 
                    }
                }
                if (treatAsString) {
                    String[] userStringArray = inputArray.clone();
                    BubbleSort<String> userStringBubbleSort = new BubbleSort<>(userStringArray);
                    userStringBubbleSort.sort();
                    System.out.print("Sorted Array: ");
                    userStringBubbleSort.printSortedArray();
                } else {
                   
                    boolean treatAsDouble = false;
                    for (int i = 0; i < inputArray.length; i++) {
                        if (inputArray[i].contains(".")) {
                            treatAsDouble = true;
                            break;  
                        }
                    }

                    if (treatAsDouble) {
                        Double[] userDoubleArray = new Double[inputArray.length];
                        for (int i = 0; i < inputArray.length; i++) {
                            userDoubleArray[i] = Double.parseDouble(inputArray[i]);
                        }

                        BubbleSort<Double> userDoubleBubbleSort = new BubbleSort<>(userDoubleArray);
                        userDoubleBubbleSort.sort();
                        System.out.print("Sorted Double Array: ");
                        userDoubleBubbleSort.printSortedArray();
                    } else {
                        Integer[] userIntArray = new Integer[inputArray.length];
                        for (int i = 0; i < inputArray.length; i++) {
                            userIntArray[i] = Integer.parseInt(inputArray[i]);
                        }

                        BubbleSort<Integer> userIntBubbleSort = new BubbleSort<>(userIntArray);
                        userIntBubbleSort.sort();
                        System.out.print("Sorted Integer Array: ");
                        userIntBubbleSort.printSortedArray();
                    }
                }
            } else if ("0".equals(userInput)) {
                flag = 1;
                // Example usage
                Integer[] intArray = {5, 3, 8, 1, 2};
                BubbleSort<Integer> intBubbleSort = new BubbleSort<>(intArray);
                intBubbleSort.sort();
                System.out.print("Sorted Integer Array: ");
                intBubbleSort.printSortedArray();

                Double[] doubleArray = {5.7, 3.2, 8.6, 1.0, 2.8};
                BubbleSort<Double> doubleBubbleSort = new BubbleSort<>(doubleArray);
                doubleBubbleSort.sort();
                System.out.print("Sorted Double Array: ");
                doubleBubbleSort.printSortedArray();

                String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
                BubbleSort<String> stringBubbleSort = new BubbleSort<>(stringArray);
                stringBubbleSort.sort();
                System.out.print("Sorted String Array: ");
                stringBubbleSort.printSortedArray();
            } else {
                System.out.println("Invalid input.");}
        } scanner.close();
    }
}
