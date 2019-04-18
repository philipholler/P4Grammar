package codegen;

public enum JavaType {
    INT("int", "Integer"), DOUBLE("double", "Double"),
    STRING("String", "String"), FLOAT("float", "Float"),
    VOID("void", "Void"), LONG("long", "LONG");

    public final String keyword;
    public final String objectType;
    JavaType(String keyword, String objectType){
        this.keyword = keyword;
        this.objectType = objectType;
    }


}
