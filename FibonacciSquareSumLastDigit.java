import java.util.Scanner;

public class FibonacciSquareSumLastDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Leer entrada del usuario
        System.out.print("INGRESE EL DIGITO: ");
        long n = scanner.nextLong(); // Leer valor de n
        scanner.close(); // Cerrar el Scanner

        // Obtener el último dígito de la suma de los cuadrados de los primeros n números de Fibonacci
        int lastDigit = getFibonacciSquareSumLastDigit(n);
        System.out.println("EL RESULTADO ES: " + lastDigit); // Imprimir el resultado
    }

    // Método para obtener el último dígito de la suma de los cuadrados de Fibonacci hasta n
    public static int getFibonacciSquareSumLastDigit(long n) {
        // Reducir n y n+1 usando el período Pisano mod 10 que es 60
        int reducedN = (int) (n % 60);
        int reducedNPlus1 = (int) ((n + 1) % 60);

        // Calcular Fibonacci mod 10 para los valores reducidos
        int fibN = calculateFibonacciMod(reducedN); // F(n) mod 10
        int fibNPlus1 = calculateFibonacciMod(reducedNPlus1); // F(n+1) mod 10

        // Multiplicar F(n) y F(n+1) y obtener el último dígito del resultado
        int result = (fibN * fibNPlus1) % 10;

        return result;
    }

    // Método para calcular Fibonacci(n) mod 10
    public static int calculateFibonacciMod(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int temp = (previous + current) % 10;
            previous = current;
            current = temp;
        }

        return current;
    }
}