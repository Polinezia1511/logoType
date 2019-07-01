package by.bsuir.logotype.dao;

import by.bsuir.logotype.entity.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldDao extends CrudRepository<Field, Integer> {
    List<Field> findAllByIsActiveIsTrue();
}
