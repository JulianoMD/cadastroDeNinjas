package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Adicionar nova missao (POST)
    public MissoesModel adicionarMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    // Listar todas as missoes (READ)
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Listar missao por id (READ)
    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    // Apagar missao (DELETE)
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
