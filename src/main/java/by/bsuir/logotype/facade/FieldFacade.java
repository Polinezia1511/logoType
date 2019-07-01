package by.bsuir.logotype.facade;

import by.bsuir.logotype.dto.FieldWithOptions;
import by.bsuir.logotype.entity.Field;

import java.util.List;

public interface FieldFacade {
    List<FieldWithOptions> createFieldsWithOption(List<Field> fields);
}
