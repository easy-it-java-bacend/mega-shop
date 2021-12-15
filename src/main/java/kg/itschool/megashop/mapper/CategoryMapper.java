package kg.itschool.megashop.mapper;

import kg.itschool.megashop.model.dto.CategoryDto;
import kg.itschool.megashop.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto>{

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
