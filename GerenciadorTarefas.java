import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO 1: Enum Status
enum Status {
    PENDENTE, EM_ANDAMENTO, CONCLUIDA
}

class Tarefa {
    // TODO 2: Atributos, Construtor, Getters, Setters e toString
    private int id;
    private String titulo;
    private Status status;

    public Tarefa(int id, String titulo, Status status) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("ID: %d | [%-12s] | Título: %s", id, status, titulo);
    }
}

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(String titulo) {
        // TODO 3: Auto-incremento e Status inicial PENDENTE
        Tarefa nova = new Tarefa(proximoId++, titulo, Status.PENDENTE);
        tarefas.add(nova);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        tarefas.forEach(System.out::println);
    }

    public void filtrarPorStatus(Status status) {
        // TODO 4: Streams para filtragem
        List<Tarefa> filtradas = tarefas.stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com o status: " + status);
        } else {
            filtradas.forEach(System.out::println);
        }
    }

    public void atualizarStatus(int id, Status novoStatus) {
        // TODO 5: Busca por ID e atualização
        Tarefa tarefa = tarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com ID " + id + " não encontrada."));
        
        tarefa.setStatus(novoStatus);
    }

    public static void main(String[] args) {
        GerenciadorTarefas gm = new GerenciadorTarefas();
        gm.adicionar("Estudar Java");
        gm.adicionar("Fazer exercícios");
        gm.adicionar("Revisar código");
        
        gm.atualizarStatus(1, Status.CONCLUIDA);
        gm.atualizarStatus(2, Status.EM_ANDAMENTO);
        
        System.out.println("\n--- Todas as tarefas ---");
        gm.listar();
        
        System.out.println("\n--- Tarefas pendentes ---");
        gm.filtrarPorStatus(Status.PENDENTE);
    }
}
