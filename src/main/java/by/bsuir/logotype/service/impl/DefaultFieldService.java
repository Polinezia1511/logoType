package by.bsuir.logotype.service.impl;

import by.bsuir.logotype.dao.FieldDao;
import by.bsuir.logotype.entity.Field;
import by.bsuir.logotype.entity.FieldType;
import by.bsuir.logotype.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultFieldService implements FieldService {
    @Autowired
    private FieldDao fieldDao;

    @Override
    public List<Field> getAllFields() {
        return new ArrayList<Field>((Collection<? extends Field>) fieldDao.findAll());
    }

    @Override
    public List<String> getAllFieldTypes() {
        Object[] fieldTypes = FieldType.values();
        List<String> fieldTypeNames = Arrays.stream(fieldTypes).map(p -> p.toString()).collect(Collectors.toList());
        System.out.println(fieldTypeNames);
        return fieldTypeNames;
    }

    @Override
    public Field createField(String label, String options, String fieldType, String required, String isActive) {
        Field field = new Field();
        field.setLabel(label);
        field.setRequired(!required.isEmpty());
        field.setIsActive(!isActive.isEmpty());
        field.setType(FieldType.valueOf(fieldType));
        fieldDao.save(field);

        return null;
    }
}
