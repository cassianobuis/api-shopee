package Shopee.api_shopee.service;


import Shopee.api_shopee.Entity.Categoria;
import Shopee.api_shopee.Repository.CategoriaRepository;
import Shopee.api_shopee.dto.CategoriaCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public CategoriaCreateDTO findById(UUID id) {
        Categoria categoria = repository.findById(id).orElseThrow();

        CategoriaCreateDTO categoriaCreateDTO = convertToDto(categoria);
        return categoriaCreateDTO;

    }
    public CategoriaCreateDTO save(CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = convertToEntity(categoriaCreateDTO);
        categoria = repository.save(categoria);
        return convertToDto(categoria);
    }
    public CategoriaCreateDTO update(UUID id, CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = convertToEntity(categoriaCreateDTO);
        categoria.setId(null);
        categoria = repository.save(categoria);
        return convertToDto(categoria);
    }
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
    public List<CategoriaCreateDTO> findAll() {
        List<Categoria> categorias = repository.findAll();
        List<CategoriaCreateDTO> categoriasDTO = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriasDTO.add(convertToDto(categoria));
        }
        return categoriasDTO;
    }


    private CategoriaCreateDTO convertToDto(Categoria categoria) {
        CategoriaCreateDTO categoriaCreateDTO = new CategoriaCreateDTO();
        categoriaCreateDTO.setNome(categoria.getNome());
        categoriaCreateDTO.setDescricao(categoria.getDescricao());
        return categoriaCreateDTO;
    }

    private Categoria convertToEntity(CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaCreateDTO.getNome());
        categoria.setDescricao(categoriaCreateDTO.getDescricao());
        return categoria;
    }

}
