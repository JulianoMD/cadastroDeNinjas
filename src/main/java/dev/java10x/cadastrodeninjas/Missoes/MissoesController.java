package dev.java10x.cadastrodeninjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Adiciona uma nova missão", description = "Rota adiciona uma nova missão e insere no banco de dados")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão adicionada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na adição da missão")
    })
    private MissoesModel adicionarMissao(@RequestBody MissoesModel missoesModel) {
        return missoesService.adicionarMissao(missoesModel);
    }

    // Listar todas as missoes (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Rota lista todas as missões cadastradas no banco de dados")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de missões retornada com sucesso")
    })
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Listar missao por id (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão por Id", description = "Rota lista uma missão pelo seu Id")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão retornada com sucesso")
    })
    public MissoesModel ListarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    // Alterar dados das missoes (UPDATE)
    @PutMapping("/alterarID")
    @Operation(summary = "Altera a missão por Id", description = "Rota altera uma missão pelo seu Id")
    public String alterarMissaoPorId() {
        return "Alterar Missao por id";
    }

    // Apagar missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta a missão por Id", description = "Rota deleta uma missão pelo seu Id")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso")
    })
    public void deletarMissaoPorId(@PathVariable Long Id) {
        missoesService.deletarMissaoPorId(Id);
    }


}
