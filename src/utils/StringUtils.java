package utils;

public class StringUtils {


    public static String getIndentedString(int indentations){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indentations; i++){
            sb.append("     ");
        }
        return sb.toString();
    }

}
