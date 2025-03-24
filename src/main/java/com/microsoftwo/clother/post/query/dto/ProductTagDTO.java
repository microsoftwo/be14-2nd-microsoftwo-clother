package com.microsoftwo.clother.post.query.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductTagDTO {
    private int id;
    private int productId;
    private BigDecimal productTagPositionX;
    private BigDecimal productTagPositionY;
}
