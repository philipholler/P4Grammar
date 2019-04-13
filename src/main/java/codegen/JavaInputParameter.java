package codegen;

public class JavaInputParameter {

    public final JavaType TYPE;
    public final String identifier;

    public JavaInputParameter(JavaType TYPE, String identifier) {
        this.TYPE = TYPE;
        this.identifier = identifier;
    }
}
