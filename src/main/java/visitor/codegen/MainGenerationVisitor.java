package visitor.codegen;

import codegen.ClassBuilder;
import node.DevDeclNode;
import node.VarDeclNode;
import visitor.ASTBaseVisitor;

public class MainGenerationVisitor extends ASTBaseVisitor<ClassBuilder> {

    ClassBuilder classBuilder = new ClassBuilder();
    public static final String MAIN_CLASS_NAME = "Main";

    @Override
    public ClassBuilder visit(VarDeclNode node) {
        classBuilder.appendPackage(ClassBuilder.SERVER_PACKAGE);
        classBuilder.appendClassDef(MAIN_CLASS_NAME);

        visitChildren(node);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        return super.visit(node);
    }


    @Override
    public ClassBuilder visit(DevDeclNode node) {



        return super.visit(node);
    }

}
