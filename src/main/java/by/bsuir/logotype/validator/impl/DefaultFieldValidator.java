package by.bsuir.logotype.validator.impl;

import by.bsuir.logotype.entity.FieldType;
import by.bsuir.logotype.validator.FieldValidator;
import org.springframework.stereotype.Service;

@Service
public class DefaultFieldValidator implements FieldValidator {
    private static final String EMPTY_LABEL = "label should be not empty";
    private static final String NO_OPTION = "Should be at lest 1 option";
    private static final String NO_ERROR_MESSAGE = "";

    @Override
    public String validateFieldData(String label, String options, String fieldType, String required, String isActive) {
        if (label.isEmpty()) {
            return EMPTY_LABEL;
        }
        FieldType type = FieldType.valueOf(fieldType);
        if ((type.equals(FieldType.CHECKBOX) || type.equals(FieldType.COMBOBOX) || type.equals(FieldType.RADIO_BUTTON))
                && options.isEmpty()) {
            return NO_OPTION;
        }
        return NO_ERROR_MESSAGE;
    }
}
