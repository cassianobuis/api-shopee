package Shopee.api_shopee.Repository;

import Shopee.api_shopee.Entity.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedoresRepository extends
        JpaRepository<Fornecedores, UUID> {
}
