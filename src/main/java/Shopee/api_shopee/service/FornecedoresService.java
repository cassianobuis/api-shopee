package Shopee.api_shopee.service;

import Shopee.api_shopee.Entity.Fornecedores;
import Shopee.api_shopee.Repository.FornecedoresRepository;
import Shopee.api_shopee.dto.FornecedoresCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FornecedoresService {
    @Autowired
    private FornecedoresRepository repository;

public FornecedoresCreateDTO findById(UUID id){
    Fornecedores fornecedor = repository.findById(id).orElseThrow();

    FornecedoresCreateDTO fornecedorCreateDTO = convertToDTO(fornecedor);
    return  fornecedorCreateDTO;
}



    public FornecedoresCreateDTO save(FornecedoresCreateDTO fornecedorCreateDTO) {
        Fornecedores fornecedor = convertToEntity(fornecedorCreateDTO);
        fornecedor = repository.save(fornecedor);
        return convertToDTO(fornecedor);
    }

    public FornecedoresCreateDTO update(UUID id, FornecedoresCreateDTO fornecedorCreateDTO) {
    Fornecedores fornecedor = convertToEntity(fornecedorCreateDTO);
    fornecedor.setId(id);
    fornecedor = repository.save(fornecedor);
    return convertToDTO(fornecedor);
    }

    public void deleteById(UUID id) {
    repository.deleteById(id);
    }

    public List<Fornecedores> findAll() {
    List<Fornecedores> fornecedores = repository.findAll();
    List<FornecedoresCreateDTO> fornecedoresCreateDTOS = new ArrayList<>();
    for (Fornecedores fornecedor : fornecedores) {
        fornecedoresCreateDTOS.add(convertToDTO(fornecedor));
    }
    return fornecedores;

    }

    private FornecedoresCreateDTO convertToDTO(Fornecedores fornecedor) {
    FornecedoresCreateDTO fornecedorCreateDTO = new FornecedoresCreateDTO();
    fornecedorCreateDTO.setEndereco(fornecedor.getEndereco());
    fornecedorCreateDTO.setNome(fornecedor.getNome());
    fornecedorCreateDTO.setContato(fornecedor.getContato());
    return fornecedorCreateDTO;
    }
    private Fornecedores convertToEntity(FornecedoresCreateDTO fornecedorCreateDTO) {
    Fornecedores fornecedor = new Fornecedores();
    fornecedor.setEndereco(fornecedorCreateDTO.getEndereco());
    fornecedor.setNome(fornecedorCreateDTO.getNome());
    fornecedor.setContato(fornecedorCreateDTO.getContato());
    return fornecedor;
    }

}
