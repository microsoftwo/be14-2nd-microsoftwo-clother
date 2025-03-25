package com.microsoftwo.clother.product.command.domain.repository;

import com.microsoftwo.clother.product.command.domain.aggregate.ProductRegist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductRegist, Integer> {

}
