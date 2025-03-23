package com.microsoftwo.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryDTO {
    private int id; // 카테고리 번
    private String name; // 카테고리 명
    private int parentId; // 상위 카테고리 번호
    private List<CategoryDTO> children; // 하위 카테고리 목록
}
