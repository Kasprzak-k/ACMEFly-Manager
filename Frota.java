
import java.util.ArrayList;
import java.util.List;

public class Frota {

    // Lista de carros
    private List<CarroVoador> carros;

    // Construtor
    public Frota() {
        this.carros = new ArrayList<>();
    }

    // Adiciona um carro se não existir outro igual
    public boolean adicionaCarroVoador(CarroVoador cv) {
        for (CarroVoador carro : carros) {
            if (carro.getNumero() == cv.getNumero() || carro.getPlaca().equals(cv.getPlaca())) {
                return false;
            }
        }
        carros.add(cv);
        return true;
    }

    // Procura carro pelo número
    public CarroVoador consultaCarroVoador(int numero) {
        for (CarroVoador carro : carros) {
            if (carro.getNumero() == numero) {
                return carro;
            }
        }
        return null;
    }

    // Procura carro pela placa
    public CarroVoador consultaCarroVoador(String placa) {
        for (CarroVoador carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }
}
