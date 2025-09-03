package Shopee.api_shopee.Controller;

import Shopee.api_shopee.Entity.Mercadoria;
import Shopee.api_shopee.dto.MercadoriaCreateDTO;
import Shopee.api_shopee.service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mercadoria")
public class MercadoriaController {
    @Autowired
    private MercadoriaService service;

    @GetMapping("/{id}")
    public Mercadoria findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }
    @GetMapping
    public List<MercadoriaCreateDTO> findAll() {
        return service.findAll();
    }
    @PostMapping
    public MercadoriaCreateDTO save(@RequestBody MercadoriaCreateDTO mercadoriaCreateDTO) {
        return service.save(mercadoriaCreateDTO);
    }
    @PutMapping("/{id}")
    public MercadoriaCreateDTO update(@PathVariable("id")UUID id, @RequestBody MercadoriaCreateDTO mercadoriaCreateDTO) {
        return service.update(id, mercadoriaCreateDTO);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.DeleteById(id);
    }
}
