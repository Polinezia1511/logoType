package by.bsuir.logotype.validator;

public interface FieldValidator {
    String validateFieldData(String label,
                             String options,
                             String fieldType,
                             String required,
                             String isActive);
}
