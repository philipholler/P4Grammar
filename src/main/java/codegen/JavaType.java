package codegen;

public enum JavaType {
    INT("int"), DOUBLE("double"), STRING("String"), FLOAT("float"), VOID("void");

    public final String keyword;
    JavaType(String s){
        keyword = s;
    }

}
