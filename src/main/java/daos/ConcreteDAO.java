package daos;

import java.util.Collections;
import java.util.List;

public class ConcreteDAO <T> implements DAO {

    List<T> newList;


    public Object findById(int id) {
        for (T findId : newList)
            if (findId.equals(0))
            return findId;
        return null;
    }

    public List findAll(){
        return Collections.singletonList(newList.size());
    }

    public Object update(Object dto) {
        return dto;
    }

    public Object create(Object dto) {
        return dto;
    }

    public void delete(int id) {

    }
}
