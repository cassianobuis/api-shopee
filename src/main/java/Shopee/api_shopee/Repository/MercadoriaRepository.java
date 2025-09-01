package Shopee.api_shopee.Repository;

import Shopee.api_shopee.Entity.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MercadoriaRepository extends
        JpaRepository<Mercadoria, UUID> {
}
