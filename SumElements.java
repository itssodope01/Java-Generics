import java.util.List;

public class SumElements {

    public static double sumElements(List<? extends Number> elements) {
        double sum = 0.0;
        for (Number element : elements) {
            sum += element.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        //testing
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        List<Double> doubleList = List.of(1.5, 2.7, 3.5, 4.5, 5.5);
        List<Long> longList = List.of(100L, 200L, 300L, 400L, 500L);

        double sumInteger = sumElements(integerList);
        double sumDouble = sumElements(doubleList);
        double sumLong = sumElements(longList);

        System.out.println("Sum of Integer elements: " + sumInteger);
        System.out.println("Sum of Double elements: " + sumDouble);
        System.out.println("Sum of Long elements: " + sumLong);
    }
}
