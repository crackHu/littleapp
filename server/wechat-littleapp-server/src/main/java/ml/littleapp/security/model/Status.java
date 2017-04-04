package ml.littleapp.security.model;
public enum Status {
    NEW(1), READY(2), CLOSED(3);

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    Status(int id) {
        this.id = id;
    }
    
}


