package unicesumar.gerenciamento_de_tarefas.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicesumar.gerenciamento_de_tarefas.Models.TarefaModel;
import unicesumar.gerenciamento_de_tarefas.Repositories.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel criarTarefa(TarefaModel pedidoModel) {
        return tarefaRepository.save(pedidoModel);
    }

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public TarefaModel listarTarefaPorId(Long id) {
        return tarefaRepository.findById(id).get();
    }

    public void deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

}
