package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaInputParameter;
import codegen.JavaType;
import node.DeclsNode;
import node.VarDeclNode;
import node.base.Node;
import utils.JavaCodeUtils;
import visitor.ASTBaseVisitor;

public class SynchronizedVisitor extends ASTBaseVisitor<Void> {

    private ClassBuilder classBuilder;

    public SynchronizedVisitor(ClassBuilder classBuilder) {
        this.classBuilder = classBuilder;
    }

    @Override
    public Void visit(DeclsNode node) {
        for(Node n : node.getChildren())
            if (n instanceof VarDeclNode)
                visit(n);

        return null;
    }


    @Override
    public Void visit(VarDeclNode node) {
        appendSynchronizedGet(node.getID(), JavaCodeUtils.correspondingJavaType(node.getVarType()));
        appendSynchronizedSet(node.getID(), JavaCodeUtils.correspondingJavaType(node.getVarType()));
        return null;
    }

    private void appendSynchronizedGet(String varName, JavaType type){
        String getterMethodName = ClassBuilder.GET_METHOD_PREFIX + varName;

        classBuilder.appendSynchronized().appendMethod(getterMethodName, type.keyword);
        classBuilder.appendReturnStatement(varName);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    private void appendSynchronizedSet(String varName, JavaType type){
        final String newValueParamName = "newValue";
        JavaInputParameter inputParameter = new JavaInputParameter(type.keyword, newValueParamName);

        String setterMethodName = ClassBuilder.SET_METHOD_PREFIX + varName;
        classBuilder.appendSynchronized().appendMethod(setterMethodName, JavaType.VOID.keyword, inputParameter);
        classBuilder.append("this.").appendAssignment(varName, inputParameter.identifier);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

}
