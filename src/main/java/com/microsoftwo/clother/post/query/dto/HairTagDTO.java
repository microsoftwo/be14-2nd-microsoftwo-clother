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
public class HairTagDTO {
    private Integer id;
    private String link;
    private String name;
    private int categoryId;
    private BigDecimal hairTagPositionX;
    private BigDecimal hairTagPositionY;
}
