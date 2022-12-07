package com.enigmacamp.courseproject.repository.specification;

import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.CourseInfo;
import com.enigmacamp.courseproject.model.CourseType;
import com.enigmacamp.courseproject.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CourseSpecification implements Specification<Course> {

    private final SearchCriteria searchCriteria;

    public CourseSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    private Join<Course, CourseInfo> infoJoin(Root<Course> root) {
        return root.join("courseInfo");
    }

    private Join<Course, CourseType> typeJoin(Root<Course> root) {
        return root.join("courseType");
    }

    @Override
    public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Path<String> path;

        if (searchCriteria.getField().equals("typeName")) {
            path = typeJoin(root).get(searchCriteria.getField());
        } else if (searchCriteria.getField().equals("duration") || searchCriteria.getField().equals("level")) {
            path = infoJoin(root).get(searchCriteria.getField());
        } else {
            path = root.get(searchCriteria.getField());
        }

        switch (searchCriteria.getQueryOperator()) {
            default:
            case EQUALS:
                if (searchCriteria.getValue() instanceof String) {
                    return criteriaBuilder.equal(criteriaBuilder.lower(path), "%" + ((String) searchCriteria.getValue()).toLowerCase() + "%");
                }
                return criteriaBuilder.equal(path, "%" + searchCriteria.getValue() + "%");
            case DOES_NOT_EQUAL:
                if (searchCriteria.getValue() instanceof String) {
                    return criteriaBuilder.notEqual(criteriaBuilder.lower(path), "%" + ((String) searchCriteria.getValue()).toLowerCase() + "%");
                }
                return criteriaBuilder.notEqual(path, "%" + searchCriteria.getValue() + "%");
            case CONTAINS:
                if (searchCriteria.getValue() instanceof String) {
                    return criteriaBuilder.equal(criteriaBuilder.lower(path), "%" + ((String) searchCriteria.getValue()).toLowerCase() + "%");
                }
                return criteriaBuilder.like(path, "%" + searchCriteria.getValue() + "%");
            case DOES_NOT_CONTAIN:
                if (searchCriteria.getValue() instanceof String) {
                    return criteriaBuilder.equal(criteriaBuilder.lower(path), "%" + ((String) searchCriteria.getValue()).toLowerCase() + "%");
                }
                return criteriaBuilder.notLike(path, "%" + searchCriteria.getValue() + "%");
            case LESS_THAN:
                return criteriaBuilder.lessThan(path, searchCriteria.getValue().toString());
            case LESS_THAN_EQUAL:
                return criteriaBuilder.lessThanOrEqualTo(path, searchCriteria.getValue().toString());
            case GREATER_THAN:
                return criteriaBuilder.greaterThan(path, searchCriteria.getValue().toString());
            case GREATER_THAN_EQUAL:
                return criteriaBuilder.greaterThanOrEqualTo(path, searchCriteria.getValue().toString());
        }
    }

}
