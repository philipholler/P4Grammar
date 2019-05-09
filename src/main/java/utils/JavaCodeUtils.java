package utils;

import codegen.JavaType;

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
                throw new RuntimeException("The data '" + type + "' is not a primitive in java");
        }
    }

    public static JavaType correspondingJavaType(String type){
        switch (type){
            case "int": return JavaType.INT;
            case "float" : return JavaType.FLOAT;
            case "string" : return JavaType.STRING;
            // String technically isn't a primitive in Java, but is included because it behaves almost identically
            // to other primitives
            default:
                throw new RuntimeException("The data '" + type +
                        " does not have a corresponding primitive type in java");
        }
    }

}
