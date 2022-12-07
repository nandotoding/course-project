package com.enigmacamp.courseproject.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

    private String field;
    private Object value;
    private QueryOperator queryOperator;
    private SearchOperation searchOperation;

}
