import java.util.Scanner;

public class GenericAdder<T extends Number> {
    private T value1;
    private T value2;

    public GenericAdder(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T add() {
        if (value1 instanceof Integer && value2 instanceof Integer) {
            return (T) Integer.valueOf(value1.intValue() + value2.intValue());
        } else if (value1 instanceof Double || value2 instanceof Double) {
            return (T) Double.valueOf(value1.doubleValue() + value2.doubleValue());
        } else if (value1 instanceof Long && value2 instanceof Long) {
            return (T) Long.valueOf(value1.longValue() + value2.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported data type");
        }
    }

    public static void main(String[] args) {
        int flag =0;
        Scanner scanner = new Scanner(System.in);
        while (flag ==0) {
        System.out.print("Press 1 to input own numbers or 0 to see example usage (1/0): ");
        String userInput = scanner.nextLine().toLowerCase();

        if ("1".equals(userInput)) {
            flag =1;
            System.out.print("Input Number 1 (Int, Double, Long): ");
            Number num1;
            if (scanner.hasNextLong()) {
                num1 = scanner.nextLong();
            } else if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
            } else {
                num1 = scanner.nextInt();
            }

            System.out.print("Input Number 2 (Int, Double, Long): ");
            Number num2;
            if (scanner.hasNextLong()) {
                num2 = scanner.nextLong();
            } else if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();}
                else {
                num2 = scanner.nextInt();
            }

            GenericAdder<Number> adder = new GenericAdder<>(num1, num2);
            System.out.println("Output: " + num1 + " + " + num2 + " = " + adder.add());
        } else if ("0".equals(userInput)) {
            flag =1;
            // Example usage
            GenericAdder<Integer> intAdder = new GenericAdder<>(5, 10);
            System.out.println("Integer Sum (5 + 10): " + intAdder.add());

            GenericAdder<Double> doubleAdder = new GenericAdder<>(5.5, 10.5);
            System.out.println("Double Sum (5.5 + 10.5): " + doubleAdder.add());

            GenericAdder<Long> longAdder = new GenericAdder<>(100L, 200L);
            System.out.println("Long Sum (100L + 200L): " + longAdder.add());

            GenericAdder<Number> mixedAdder = new GenericAdder<>(5, 10.5);
            System.out.println("Mixed Sum (5 + 10.5): " + mixedAdder.add());
        } else {
            System.out.println("Invalid input. Please enter '1' or '0'.");
        }
    } scanner.close();
    }
}
