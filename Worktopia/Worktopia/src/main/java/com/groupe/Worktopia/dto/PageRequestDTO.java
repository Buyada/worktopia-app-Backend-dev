package com.groupe.Worktopia.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;


@Data
public class PageRequestDTO {
    private Integer pageNo = 0;
    private Integer pageSize = 5;

    public Pageable getPageable(PageRequestDTO pageRequestDTO){
        Integer page = Objects.nonNull(pageRequestDTO.getPageNo()) ? pageRequestDTO.getPageNo() : this.pageNo;
        Integer size = Objects.nonNull(pageRequestDTO.getPageSize()) ? pageRequestDTO.getPageSize() : this.pageSize;

        PageRequest request = PageRequest.of(page, size);
        return request;
    }
}
