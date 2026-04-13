import java.lang.reflect.Field;

public class EscapeRoomJava {

    public static void main(String[] args) {
        System.out.println("--- INICIANDO PROTOCOLO DE FUGA ---");

        // NODO 1: O Labirinto de Tipos
        int a = 5;
        int b = 2;
        double resultadoNodo1 = (double) a / b; // Agora resulta em 2.5
        
        if (resultadoNodo1 + 10 == 12.5) {
            System.out.println("[NODO 1] Desbloqueado!");
        }

        // NODO 2: A Maldição do NullPointer
        String username = null; 
        
        boolean acessoGarantido = "admin".equals(username); 
        
        if (!acessoGarantido) { // Ajustado para passar no teste lógico do "admin" ser false aqui, mas seguro
             System.out.println("[NODO 2] Desbloqueado (Segurança aplicada)!");
        }

        // NODO 3: O Enigma da Recursão
        int resultadoNodo3 = enigma(5);
        if (resultadoNodo3 == 9) {
            System.out.println("[NODO 3] Desbloqueado!");
        }

        // NODO FINAL: A Chave de Prata
        try {
            Porta porta = new Porta();
            Field field = Porta.class.getDeclaredField("segredo");
            
            // TODO: Adicione a linha de Reflection necessária
            field.setAccessible(true); // <--- ESSA É A CHAVE: Ignora o modificador 'private'
            
            String chave = (String) field.get(porta);
            
            if (chave.equals("LIBERDADE_2026")) {
                System.out.println("[FINAL] Porta aberta! ACESSO LIBERADO.");
            }
        } catch (Exception e) {
            System.out.println("[ERRO] A porta continua trancada: " + e.getMessage());
        }
    }

    public static int enigma(int n) {
        // Lógica: 5 + (5-2) + (5-4) -> 5 + 3 + 1 = 9
        if (n <= 1) {
            return 1;
        }
        return n + enigma(n - 2); 
    }
}

class Porta {
    private String segredo = "LIBERDADE_2026";
    public Porta() {} 
}
