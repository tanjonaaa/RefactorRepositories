package CrudOperations;

import Annotations.Column;
import Annotations.Model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AutoCrudOperations<T> implements CrudOperations<T>{

    private static final String FIND_ALL_QUERY = "select {columns} from \"%s\"";

    //Get the class of the generic parameter <T>
    private Class<?> toClass(){
        return ((Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    //Get the name of the corresponding Table with the value of Model annotation
    // Model(table = ...)
    private String getTableName(){
        return this.toClass().getAnnotation(Model.class).table();
    }

    //Get all columns with the @Column annotation
    private List<String> getColumns(){
        List<Field> fields = List.of(this.toClass().getDeclaredFields());

        return
                fields.stream()
                        .filter(field -> field.isAnnotationPresent(Column.class))
                        .map(Field::getName)
                        .toList()
                ;
    }

    @Override
    public List<T> findAll() {
        /*
        * Get the table name
        * Get the columns list
        * */
        System.out.println(String.format(FIND_ALL_QUERY, this.getTableName()).replace(
                "{columns}", String.join(", ", this.getColumns())
        ));
        return List.of();
    }

    @Override
    public T save(T t) {
        return null;
    }
}
