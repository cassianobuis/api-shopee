package Shopee.api_shopee.Repository;

import Shopee.api_shopee.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends
        JpaRepository<Categoria, UUID> {
}
