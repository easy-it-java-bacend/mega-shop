package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.AccountDto;
import kg.itschool.megashop.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper <Account, AccountDto>{

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Account toEntity(AccountDto accountDto);
}
