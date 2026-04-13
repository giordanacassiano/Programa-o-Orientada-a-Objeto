public class FabricaDePadroes {

    public static void main(String[] args) {
        int n = 5;

        System.out.println("=== TRIÂNGULO ===");
        // TODO 1: Alinhado à direita
        for (int i = 1; i <= n; i++) {
            // Imprime espaços: n-i
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            // Imprime asteriscos: i
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        System.out.println("\n=== TRIÂNGULO INVERTIDO ===");
        // TODO 2: Invertido e alinhado à direita
        for (int i = n; i >= 1; i--) {
            // Imprime espaços: n-i
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            // Imprime asteriscos: i
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        System.out.println("\n=== LOSANGO ===");
        // TODO 3: Losango centralizado
        // Parte Superior (Crescente)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            // Quantidade de asteriscos para ímpar: 2*i - 1
            for (int j = 0; j < (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
        // Parte Inferior (Decrescente)
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            for (int j = 0; j < (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
    }
}
