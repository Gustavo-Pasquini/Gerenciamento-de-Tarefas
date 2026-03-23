package unicesumar.gerenciamento_de_tarefas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import unicesumar.gerenciamento_de_tarefas.Models.TarefaModel;
import unicesumar.gerenciamento_de_tarefas.Services.TarefaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel request = tarefaService.criarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/tarefas/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefas() {
        List<TarefaModel> resquest = tarefaService.listarTarefas();
        return ResponseEntity.ok().body(resquest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TarefaModel> listarTarefaPorId(@PathVariable Long id) {
        TarefaModel request = tarefaService.listarTarefaPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
