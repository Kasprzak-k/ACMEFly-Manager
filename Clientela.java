
import java.util.ArrayList;
import java.util.List;

public class Clientela {

    // Lista de clientes
    private List<Cliente> clientes;

    // Construtor
    public Clientela() {
        this.clientes = new ArrayList<>();
    }

    // Adiciona um cliente se não existir outro com mesmo código
    public boolean adicionaCliente(Cliente c) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == c.getCodigo()) {
                return false;
            }
        }
        clientes.add(c);
        return true;
    }

    // Procura cliente pelo código
    public Cliente consultaCliente(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    // Retorna cliente com maior renda
    public Cliente clienteComMaiorRenda() {
        if (clientes.isEmpty()) {
            return null;
        }

        Cliente maiorRenda = clientes.get(0);
        for (Cliente cliente : clientes) {
            if (cliente.getRenda() > maiorRenda.getRenda()) {
                maiorRenda = cliente;
            }
        }
        return maiorRenda;
    }
}
