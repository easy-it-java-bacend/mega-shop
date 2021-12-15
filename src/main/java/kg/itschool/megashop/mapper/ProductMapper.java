package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.ProductDto;
import kg.itschool.megashop.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Override
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Product toEntity(ProductDto productDto);
}
