
    public class CarroVoador {
        private int numero;
        private String placa;
        private double valor;
        private Cliente cliente;

        public CarroVoador(int numero, String placa, double valor) {
            if (numero <= 0) {
                throw new IllegalArgumentException("Número do carro deve ser positivo");
            }
            if (placa == null || placa.trim().isEmpty()) {
                throw new IllegalArgumentException("Placa não pode ser vazia");
            }
            if (valor <0) {
                throw new IllegalArgumentException("Valor deve ser positivo");
            }
            
            this.numero = numero;
            this.placa = placa;
            this.valor = valor;
            this.cliente = null;
        }



        public int getNumero() {
            return numero;
        }

        public String getPlaca() {
            return placa;
        }

        public double getValor() {
            return valor;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        @Override
        public String toString() {
            return numero + ":" + placa + ":" + valor;
        }
    }