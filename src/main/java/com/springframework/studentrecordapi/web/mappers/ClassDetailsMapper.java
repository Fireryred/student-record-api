package com.springframework.studentrecordapi.web.mappers;

import org.mapstruct.Mapper;

import com.springframework.studentrecordapi.domain.ClassDetails;
import com.springframework.studentrecordapi.web.model.ClassDetailsBean;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassDetailsMapper {
    ClassDetailsBean entityToBean(ClassDetails dt);

    ClassDetails beanToEntity(ClassDetailsBean dt);
}
