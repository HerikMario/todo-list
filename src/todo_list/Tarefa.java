package todo_list;

public class Tarefa {
    private String titulo;
    private String descricao;
    private String dataDeEntrega;
    private int prioridade;
    private boolean concluida;
    private String responsavel;

    public Tarefa(String titulo, String descricao, String dataDeEntrega, int prioridade, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeEntrega = dataDeEntrega;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        String info = String.format("\nTítulo: %s\nDescrição: %s\nData de entrega: %s\nResponsável: %s", titulo, descricao, dataDeEntrega, responsavel);
        return info;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDataDeEntrega() {
        return dataDeEntrega;
    }
    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    
}
