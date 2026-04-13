public class Personagem {
    // TODO 1: Atributos privados
    private String nome;
    private int vida;
    private int ataque;

    // TODO 2: Construtor com validações
    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    // TODO 3: Getters e Setter
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    // TODO 4: Sobrescrita do toString()
    @Override
    public String toString() {
        return String.format("[%s] Vida: %d | Ataque: %d", nome, vida, ataque);
    }

    public static void main(String[] args) {
        Personagem p = new Personagem("Guerreiro", 100, 25);
        System.out.println(p); // Deve imprimir: [Guerreiro] Vida: 100 | Ataque: 25
        
        p.setVida(-10);
        System.out.println("Vida após set negativo: " + p.getVida()); // Deve ser 0
        
        p.setVida(50);
        System.out.println("Vida após set válido: " + p.getVida()); // Deve ser 50
    }
}
