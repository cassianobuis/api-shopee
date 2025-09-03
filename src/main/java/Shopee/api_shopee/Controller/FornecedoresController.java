package Shopee.api_shopee.Controller;


import Shopee.api_shopee.Entity.Fornecedores;
import Shopee.api_shopee.dto.FornecedoresCreateDTO;
import Shopee.api_shopee.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fornecedor")
public class FornecedoresController {
    @Autowired
    private FornecedoresService service;

    @GetMapping("/{id}")
    public FornecedoresCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }
    @GetMapping
    public List<Fornecedores> findAll() {
        return service.findAll();
    }
    @PostMapping
    public FornecedoresCreateDTO save(@RequestBody FornecedoresCreateDTO fornecedoresCreateDTO) {
        return service.save(fornecedoresCreateDTO);
    }
    @PutMapping("/{id}")
        public FornecedoresCreateDTO update(@PathVariable("id") UUID id,
                                            @RequestBody FornecedoresCreateDTO fornecedoresCreateDTO)
        {
        return service.update(id, fornecedoresCreateDTO);
        }
        @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
        }
}
