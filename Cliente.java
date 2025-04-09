public class Cliente {
    private int codigo;
    private String nome;
    private double renda;

    public Cliente(int codigo, String nome, double renda) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código do cliente deve ser positivo");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (renda < 0) {
            throw new IllegalArgumentException("Renda deve ser positiva ou zero");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.renda = renda;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getRenda() {
        return renda;
    }

    // Setters
    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código do cliente deve ser positivo");
        }
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public void setRenda(double renda) {
        if (renda < 0) {
            throw new IllegalArgumentException("renda deve ser positiva ou zero");
        }
        this.renda = renda;
    }

    @Override
    public String toString() {
        return codigo + ":" + nome + ":" + renda;
    }
}

