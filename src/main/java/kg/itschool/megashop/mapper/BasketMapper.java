package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.BasketDto;
import kg.itschool.megashop.model.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BasketMapper extends BaseMapper<Basket, BasketDto> {

    public static final BaseMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Basket toEntity(BasketDto basketDto);
}
