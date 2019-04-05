package exceptions;

public class TypeUndefinedException extends SemanticException {

    private String typeID;

    public TypeUndefinedException(String typeID) {
        super("Type : " + typeID + " is undefined");
        this.typeID = typeID;
    }

    public String getTypeID() {
        return typeID;
    }
}
