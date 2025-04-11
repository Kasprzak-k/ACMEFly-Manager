
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ACMEFly {

    // Objetos principais do sistema
    private Frota frota;
    private Clientela clientela;

    // Construtor
    public ACMEFly() {
        frota = new Frota();
        clientela = new Clientela();
    }

    // Método principal que executa as operações
    public void executar() {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("dadosentrada.txt"));
            PrintWriter saida = new PrintWriter(new FileWriter("dadossaida.txt"));

            // 1. Cadastrar carros voadores
            String linha;
            while (!(linha = entrada.readLine()).equals("-1")) {
                int numero = Integer.parseInt(linha);
                String placa = entrada.readLine();
                double valor = Double.parseDouble(entrada.readLine());

                CarroVoador carro = new CarroVoador(numero, placa, valor);
                if (!frota.adicionaCarroVoador(carro)) {
                    saida.println("1:erro-carro repetido.");
                } else {
                    saida.println("1:" + numero + ":" + placa + ":" + valor);
                }
            }

            // 2. Cadastrar clientes
            while (!(linha = entrada.readLine()).equals("-1")) {
                int codigo = Integer.parseInt(linha);
                String nome = entrada.readLine();
                double renda = Double.parseDouble(entrada.readLine());

                Cliente cliente = new Cliente(codigo, nome, renda);
                if (!clientela.adicionaCliente(cliente)) {
                    saida.println("2:erro-cliente repetido.");
                } else {
                    saida.println("2:" + codigo + ":" + nome + ":" + renda);
                }
            }

            // 3. Mostrar carro mais barato
            CarroVoador maisBarato = null;
            double menorValor = Double.MAX_VALUE;
            for (int i = 1; i <= 1000; i++) {
                CarroVoador carro = frota.consultaCarroVoador(i);
                if (carro != null && carro.getValor() < menorValor) {
                    menorValor = carro.getValor();
                    maisBarato = carro;
                }
            }
            if (maisBarato == null) {
                saida.println("3:nenhum carro encontrado.");
            } else {
                saida.println("3:" + maisBarato.getNumero() + ":" + maisBarato.getPlaca() + ":" + maisBarato.getValor());
            }

            // 4. Mostrar cliente com maior renda
            Cliente maiorRenda = clientela.clienteComMaiorRenda();
            if (maiorRenda == null) {
                saida.println("4:nenhum cliente encontrado.");
            } else {
                saida.println("4:" + maiorRenda.getCodigo() + ":" + maiorRenda.getNome() + ":" + maiorRenda.getRenda());
            }

            // 5. Vender carros voadores
            while (!(linha = entrada.readLine()).equals("-1")) {
                int codigoCliente = Integer.parseInt(linha);
                int numeroCarro = Integer.parseInt(entrada.readLine());

                Cliente cliente = clientela.consultaCliente(codigoCliente);
                if (cliente == null) {
                    saida.println("5:erro-cliente inexistente.");
                    continue;
                }

                CarroVoador carro = frota.consultaCarroVoador(numeroCarro);
                if (carro == null) {
                    saida.println("5:erro-carro inexistente.");
                    continue;
                }

                if (carro.getCliente() != null) {
                    saida.println("5:erro-carro possui cliente.");
                    continue;
                }

                carro.setCliente(cliente);
                saida.println("5:" + codigoCliente + ":" + numeroCarro);
            }

            // 6. Mostrar cliente com mais carros
            Cliente clienteMaisCarros = null;
            int maxCarros = 0;

            for (int i = 1; i <= 1000; i++) {
                Cliente cliente = clientela.consultaCliente(i);
                if (cliente != null) {
                    int carrosCliente = 0;
                    for (int j = 1; j <= 1000; j++) {
                        CarroVoador carro = frota.consultaCarroVoador(j);
                        if (carro != null && carro.getCliente() == cliente) {
                            carrosCliente++;
                        }
                    }
                    if (carrosCliente > maxCarros) {
                        maxCarros = carrosCliente;
                        clienteMaisCarros = cliente;
                    }
                }
            }

            if (clienteMaisCarros == null) {
                saida.println("6:erro-nenhum cliente encontrado.");
            } else {
                saida.println("6:" + clienteMaisCarros.getNome() + ":" + maxCarros);
            }

            // 7. Mostrar dados de um carro específico
            linha = entrada.readLine();
            String placa = linha;
            CarroVoador carro = frota.consultaCarroVoador(placa);

            if (carro == null) {
                saida.println("7:erro-carro inexistente.");
            } else if (carro.getCliente() == null) {
                saida.println("7:erro-carro sem cliente.");
            } else {
                Cliente dono = carro.getCliente();
                saida.println("7:" + placa + ":" + dono.getNome());
            }

            // Fecha os arquivos
            entrada.close();
            saida.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
}
