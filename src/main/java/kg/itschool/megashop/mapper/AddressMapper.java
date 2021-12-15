package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.AddressDto;

import kg.itschool.megashop.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper extends BaseMapper<Address, AddressDto>{

    public static final AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

}
