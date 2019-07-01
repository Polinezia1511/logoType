package by.bsuir.logotype.facade.impl;

import by.bsuir.logotype.dto.FieldWithOptions;
import by.bsuir.logotype.entity.Field;
import by.bsuir.logotype.entity.FieldType;
import by.bsuir.logotype.facade.FieldFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultFieldFacade implements FieldFacade {
    @Override
    public List<FieldWithOptions> createFieldsWithOption(List<Field> fields) {
        return fields.stream().map(p -> {
            FieldWithOptions fieldWithOptions = new FieldWithOptions();
            fieldWithOptions.setField(p);
            if (p.getType().equals(FieldType.COMBOBOX) ||
                    p.getType().equals(FieldType.CHECKBOX) ||
                    p.getType().equals(FieldType.RADIO_BUTTON)) {
                String[] fieldOptions = p.getFieldOption().split(",");
                fieldWithOptions.setOptions(new ArrayList<>(Arrays.asList(fieldOptions)));
            }
            return fieldWithOptions;
        }).collect(Collectors.toList());
    }
}
