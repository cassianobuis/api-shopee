package Shopee.api_shopee.service;

import Shopee.api_shopee.Entity.Mercadoria;
import Shopee.api_shopee.Repository.MercadoriaRepository;
import Shopee.api_shopee.dto.MercadoriaCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository repository;

    public Mercadoria findById(UUID id) {
        Mercadoria mercadoria = repository.findById(id).orElseThrow();

        MercadoriaCreateDTO mercadoriaCreateDTO = convertToDTO(mercadoria);
        return mercadoria;

    }
    public MercadoriaCreateDTO save(MercadoriaCreateDTO mercadoriaCreateDTO) {
        Mercadoria mercadoria = convertToEntity(mercadoriaCreateDTO);
        mercadoria = repository.save(mercadoria);
        return convertToDTO(mercadoria);
    }
    public MercadoriaCreateDTO update(UUID id, MercadoriaCreateDTO mercadoriaCreateDTO) {
        Mercadoria mercadoria = convertToEntity(mercadoriaCreateDTO);
        mercadoria.setId(id);
        mercadoria = repository.save(mercadoria);
        return convertToDTO(mercadoria);
    }
    public void DeleteById(UUID id) {
        repository.deleteById(id);
    }
    public List<MercadoriaCreateDTO> findAll() {
        List<Mercadoria> mercadorias = repository.findAll();
        List<MercadoriaCreateDTO> mercadoriaCreateDTOs = new ArrayList<>();
        for (Mercadoria mercadoria : mercadorias) {
            mercadoriaCreateDTOs.add(convertToDTO(mercadoria));
        }
        return mercadoriaCreateDTOs;

    }

    private MercadoriaCreateDTO convertToDTO(Mercadoria mercadoria) {
        MercadoriaCreateDTO mercadoriaDTO = new MercadoriaCreateDTO();
        mercadoriaDTO.setCategoria(mercadoriaDTO.getCategoria());
        mercadoriaDTO.setNome(mercadoria.getNome());
        mercadoriaDTO.setPreco(mercadoria.getPreco());
        return mercadoriaDTO;

    }
    private Mercadoria convertToEntity(MercadoriaCreateDTO mercadoriaCreateDTO) {
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setCategoria(mercadoria.getCategoria());
        mercadoria.setNome(mercadoriaCreateDTO.getNome());
        mercadoria.setPreco(mercadoriaCreateDTO.getPreco());
        return mercadoria;
    }

}
