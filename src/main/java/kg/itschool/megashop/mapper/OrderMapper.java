package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.OrderDto;
import kg.itschool.megashop.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto>{

    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Order toEntity(OrderDto orderDto);
}
