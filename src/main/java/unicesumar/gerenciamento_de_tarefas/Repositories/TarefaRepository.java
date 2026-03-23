package unicesumar.gerenciamento_de_tarefas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unicesumar.gerenciamento_de_tarefas.Models.TarefaModel;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
