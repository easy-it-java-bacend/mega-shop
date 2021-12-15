package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.CustomerDto;
import kg.itschool.megashop.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Customer toEntity(CustomerDto customerDto);
}
