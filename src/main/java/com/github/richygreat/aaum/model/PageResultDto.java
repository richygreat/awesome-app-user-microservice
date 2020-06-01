package com.github.richygreat.aaum.model;

import lombok.Value;

import java.util.List;

@Value
public class PageResultDto<T> {
    Integer totalPages;
    Integer currentPage;
    List<T> items;
}
