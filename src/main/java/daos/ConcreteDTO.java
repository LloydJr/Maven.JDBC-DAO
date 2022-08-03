package daos;

public class ConcreteDTO implements DTO{
    private int id;

    public ConcreteDTO(){}

    public ConcreteDTO(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
