package com.microsoftwo.clother.product.command.domain.aggregate;

// 사용자가 등록 신청한 제품

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RegistedProduct {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "name")
    private String name;

    @Column(name = "product_link")
    private String productLink;


}
