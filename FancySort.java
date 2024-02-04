import java.util.Scanner;

public class FancySort<T extends Comparable<T>> {
    private T[] array;

    public FancySort(T[] array) {
        this.array = array;
    }

    public void sort() {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                //using fancyCompare
                if (fancyCompare(array[i - 1], array[i]) > 0) {
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

    //compare method
    private int fancyCompare(T a, T b) {
        if (a instanceof String && b instanceof String) {
            return Integer.compare(((String) a).length(), ((String) b).length());
        } else if (a instanceof Integer && b instanceof Integer) {
            return Integer.compare(countNonZeroDigits((Integer) a), countNonZeroDigits((Integer) b));
        } else if (a instanceof Double && b instanceof Double) {
            return Double.compare(getSignificand((Double) a), getSignificand((Double) b));
        } else {
            return a.compareTo(b);
        }
    }

    private int countNonZeroDigits(Integer num) {
        int count = 0; int digit =0;
        while(num!=0)
        {
            digit= num % 10;
            if(digit!=0){
                count++;
            }
            num = num/10;
        }
        return count;
    }
    
    private double getSignificand(Double num) {
        String numString = num.toString();
        int dotIndex = numString.indexOf('.');
        if (dotIndex != -1) {
            return Double.parseDouble(numString.substring(0, dotIndex) + numString.substring(dotIndex + 1));
        }
        return num; 
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
                    FancySort<String> userStringBubbleSort = new FancySort<>(userStringArray);
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

                        FancySort<Double> userDoubleBubbleSort = new FancySort<>(userDoubleArray);
                        userDoubleBubbleSort.sort();
                        System.out.print("Sorted Double Array: ");
                        userDoubleBubbleSort.printSortedArray();
                    } else {
                        Integer[] userIntArray = new Integer[inputArray.length];
                        for (int i = 0; i < inputArray.length; i++) {
                            userIntArray[i] = Integer.parseInt(inputArray[i]);
                        }

                        FancySort<Integer> userIntBubbleSort = new FancySort<>(userIntArray);
                        userIntBubbleSort.sort();
                        System.out.print("Sorted Integer Array: ");
                        userIntBubbleSort.printSortedArray();
                    }
                }
            
            } else if ("0".equals(userInput)) {
                flag = 1;
                // Example usage
                Integer[] intArray = {502, 32, 124 , 100, 2};
                FancySort<Integer> intFancySort = new FancySort<>(intArray);
                intFancySort.sort();
                System.out.print("Sorted Integer Array: ");
                intFancySort.printSortedArray();

                Double[] doubleArray = {5.7306, 3.022, 83.6, 1.40, 2.8};
                FancySort<Double> doubleFancySort = new FancySort<>(doubleArray);
                doubleFancySort.sort();
                System.out.print("Sorted Double Array: ");
                doubleFancySort.printSortedArray();

                String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
                FancySort<String> stringFancySort = new FancySort<>(stringArray);
                stringFancySort.sort();
                System.out.print("Sorted String Array: ");
                stringFancySort.printSortedArray();
            } else {
                System.out.println("Invalid input.");
            }
        }
        scanner.close();
    }
}
