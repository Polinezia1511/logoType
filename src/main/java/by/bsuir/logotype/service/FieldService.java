package by.bsuir.logotype.service;

import by.bsuir.logotype.entity.Field;

import java.util.List;

public interface FieldService {
    List<Field> getAllFields();

    List<String> getAllFieldTypes();

    Field createField(String label,
                      String options,
                      String fieldType,
                      String required,
                      String isActive);

    List<Field> getAllActiveField();
}
