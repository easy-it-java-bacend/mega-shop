package kg.itschool.megashop.mapper;

import org.mapstruct.Mapping;

import java.util.List;

public interface BaseMapper<ENTITY, DTO>{

    ENTITY toEntity(DTO dto);
    DTO toDto (ENTITY entity);
    List<ENTITY> toEntityList(List<DTO> dtoList);
    List<DTO> toDtoList(List<ENTITY> entityListList);
}