package com.springframework.studentrecordapi.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.springframework.studentrecordapi.domain.ClassDetails;
import com.springframework.studentrecordapi.web.model.ClassDetailsBean;

@Mapper
public interface ClassDetailsMapper {
    @Mapping(target = "isHoliday", ignore = true)
    ClassDetailsBean entityToBean(ClassDetails dt);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    ClassDetails beanToEntity(ClassDetailsBean dt);
}
