package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaType;
import node.DevDeclNode;
import node.ProgramNode;
import node.VarDeclNode;
import semantics.SymbolTable;
import utils.JavaCodeUtils;
import visitor.ASTBaseVisitor;

public class MainGenerationVisitor extends ASTBaseVisitor<ClassBuilder> {

    ClassBuilder classBuilder;
    public static final String MAIN_CLASS_NAME = "Main";

    @Override
    public ClassBuilder visit(ProgramNode node) {
        classBuilder = new ClassBuilder();


        classBuilder.appendPackage(ClassBuilder.SERVER_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEVICE_PACKAGE);
        classBuilder.appendClassDef(MAIN_CLASS_NAME);
        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);

        visitChildren(node);

        JavaFileWriter.writeClass(classBuilder);
        return null;
    }

    @Override
    public ClassBuilder visit(VarDeclNode node) {
        visitChildren(node);


        return super.visit(node);
    }


    @Override
    public ClassBuilder visit(DevDeclNode node) {
        if(SymbolTable.isPrimitiveDataType(node.getType())){
            JavaType type = JavaCodeUtils.correspondingJavaType(node.getType());
            classBuilder.appendPrimitiveDecl(type, node.getID(), node.getVal());
        }else{
            // The only other types derive from Device with constructor (String hardwareID)
            classBuilder.appendNewObjectDecl(node.getType(), node.getID(), node.getVal());
        }

        return super.visit(node);
    }

}
