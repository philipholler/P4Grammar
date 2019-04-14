package utils;

public class JavaCodeUtils {

    public static String primitiveToObject(String type){
        switch (type){
            case "int": return "Integer";
            case "double" : return "Double";
            case "float" : return "Float";
            case "String" : return "String";
            // String technically isn't a primitive in Java, but is included because it behaves almost identically
            // to other primitives
            default:
                throw new RuntimeException("The value '" + type + "' is not a primitive in java");
        }

    }

}
