package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar nova missao (POST)
    @PostMapping("/adicionar")
    private MissoesModel adicionarMissao(@RequestBody MissoesModel missoesModel) {
        return missoesService.adicionarMissao(missoesModel);
    }

    // Listar todas as missoes (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Listar missao por id (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel ListarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    // Alterar dados das missoes (UPDATE)
    @PutMapping("/alterarID")
    public String alterarMissaoPorId() {
        return "Alterar Missao por id";
    }

    // Apagar missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long Id) {
        missoesService.deletarMissaoPorId(Id);
    }


}
