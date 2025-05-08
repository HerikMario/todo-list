package todo_list;

import java.util.ArrayList;

public class Usuario {
    private String login;
    private String senha;
    private String cargo;
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private ArrayList<Tarefa> tarefasConcluidas = new ArrayList<Tarefa>();

     public Usuario(String login, String senha, String cargo) {
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public void criarTarefas(String titulo, String descricao, String dataDeEntraga, int prioridade){
            Tarefa novaTarefa = new Tarefa(titulo, descricao, dataDeEntraga, prioridade, login);
            tarefas.add(novaTarefa);

            //printa o estado atual da lista
            tarefas.sort((t1, t2) -> Integer.compare(t2.getPrioridade(), t1.getPrioridade()));
            System.out.println("\n======================================================");
            System.out.println("A lista se encontra assim:");
            System.out.println("======================================================");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa.toString());
            }
    }

    public void marcarConcluida(String titulo){
            if (!tarefas.isEmpty()){
                boolean deuBom = false;
                for (Tarefa tarefa : tarefas) {
                    if (titulo.equals(tarefa.getTitulo())) {
                        tarefas.remove(tarefa);
                        tarefasConcluidas.add(tarefa);
                        System.out.printf("\nTarefa '%s' marcada como concluída com sucesso!!\n", tarefa.getTitulo());
                        deuBom = true;
                        if (tarefas.isEmpty()) {
                            System.out.println("================================");
                            System.out.println("Você concluiu todas as tarefas!");
                            System.out.println("================================");
                        }
                        return;
                    }
                }
                if (!deuBom) {
                    for (Tarefa tarefa : tarefasConcluidas) {
                        if (titulo.equals(tarefa.getTitulo())) {
                            System.out.printf("\nTarefa '%s' já está marcada como concluída!!\n", tarefa.getTitulo());
                        }
                    }
                }
    
                //printa o estado atual da lista
                tarefas.sort((t1, t2) -> Integer.compare(t2.getPrioridade(), t1.getPrioridade()));
                System.out.println("\n======================================================");
                System.out.println("A lista se encontra assim:");
                System.out.println("======================================================");
                for (Tarefa tarefa : tarefas) {
                    System.out.println(tarefa.toString());
                }
            } else {
                System.out.println("\nNão existem tarefas cadastradas!\n");
            }
    }

    public void vizualizarHistorico(){
            if (!tarefasConcluidas.isEmpty()){
                tarefasConcluidas.sort((t1, t2) -> Integer.compare(t2.getPrioridade(), t1.getPrioridade()));
                System.out.println("\n======================================================");
                System.out.println("O histórico se encontra assim:");
                System.out.println("======================================================");
                for (Tarefa tarefa : tarefasConcluidas) {
                    System.out.println(tarefa.toString() + "\nConcluída: Sim");
                }
            } else {
                System.out.println("\nNão existem tarefas concluídas!\n");
            }
    }

    //getters e setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public ArrayList<Tarefa> getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas(ArrayList<Tarefa> tarefasConcluidas) {
        this.tarefasConcluidas = tarefasConcluidas;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    
}
