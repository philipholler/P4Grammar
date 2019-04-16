package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;
import node.DevDeclNode;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.InitNode;
import node.ProgramNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.Expression.MultiExprNode;
import node.Statements.ReturnNode;
import node.VarDeclNode;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Signal.DefSignalNode;
import semantics.SymbolTable;
import utils.JavaCodeUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

public class MainGenerationVisitor extends ASTBaseVisitor<Void> {

    ClassBuilder classBuilder;
    public static final String MAIN_CLASS_NAME = "Main";
    public static final String INIT_FUNC_NAME = "init";


    @Override
    public Void visit(ProgramNode node) {
        classBuilder = new ClassBuilder();

        classBuilder.appendPackage(ClassBuilder.SERVER_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEVICE_PACKAGE);

        classBuilder.appendClassDef(MAIN_CLASS_NAME);
        visitChildren(node);
        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);

        JavaFileWriter.writeClass(classBuilder);
        return null;
    }

    @Override
    public Void visit(DevDeclNode node) {
        // The only other types derive from Device with constructor (String hardwareID)
        classBuilder.appendNewObjectDecl(node.getType(), node.getID(), node.getVal());
        return null;
    }

    @Override
    public Void visit(VarDeclNode node) {
        JavaType type = JavaCodeUtils.correspondingJavaType(node.getVarType());

        // Generates : "type x = "
        classBuilder.appendWord(type.keyword).append(node.getID()).appendEquals();
        // visit children to append value that is assigned to the variable
        visit(node.getExpr());
        classBuilder.endLine();

        return null;
    }

    @Override
    public Void visit(AssignmentNode node) {
        classBuilder.append(node.getID()).appendEquals();
        visit(node.getExpr());
        classBuilder.endLine();
        return null;
    }

    @Override
    public Void visit(ReturnNode node) {
        classBuilder.appendWord("return");

        if(node.getReturnVal() != null)
            visit(node.getReturnVal());

        classBuilder.endLine();
        return null;
    }

    @Override
    public Void visit(FloatNode node) {
        classBuilder.append(String.valueOf(node.getVal()));
        return null;
    }

    @Override
    public Void visit(IntegerNode node) {
        classBuilder.append(String.valueOf(node.getVal()));
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        classBuilder.append(String.valueOf(node.getVal()));
        return null;
    }

    @Override
    public Void visit(FuncCallNode node) {
        classBuilder.append(node.getID()).startParan();

        for(int i = 0; i < node.getArguments().size(); i++){
            visit(node.getArguments().get(i));

            if(i != node.getArguments().size() - 1)
                classBuilder.appendComma().appendSpace();
        }

        classBuilder.endParan();
        return null;
    }

    @Override
    public Void visit(InitNode node) {
        classBuilder.appendMethod(INIT_FUNC_NAME, JavaType.VOID.keyword);
        visit(node.getBlock());
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
        return null;
    }

    @Override
    public Void visit(GetFuncNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(SetFuncNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(AddExprNode node) {
        visit(node.getLeftChild());
        classBuilder.appendOperator(node.getOperator().symbol);
        visit(node.getRightChild());
        return null;
    }

    @Override
    public Void visit(MultiExprNode node) {
        // Enclose operands in parentheses to ensure correct order of evaluation
        classBuilder.startParan();
        visit(node.getLeftChild());
        classBuilder.endParan();

        classBuilder.appendOperator(node.getOperator().symbol);

        classBuilder.startParan();
        visit(node.getRightChild());
        classBuilder.endParan();
        return null;
    }

    @Override
    public Void visit(IDNode node) {
        classBuilder.append(node.getID());
        return null;
    }


    @Override
    public Void visit(FunctionNode node) {
        // Create an array of java method input parameters (formal parameters)
        JavaInputParameter[] inputParams = new JavaInputParameter[node.getInputParams().size()];
        for(int i = 0; i < inputParams.length; i++){
            InputParamNode inNode = node.getInputParams().get(i);

            // Convert type from pivot type to java type
            String type = inNode.getType();
            if(SymbolTable.isPrimitiveDataType(type))
                type = JavaCodeUtils.correspondingJavaType(inNode.getType()).keyword;

            inputParams[i] = new JavaInputParameter(type, inNode.getId());
        }

        classBuilder.appendMethod(node.getId(), node.getReturnType(), inputParams);
        visit(node.getBlock());
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        return null;
    }

    @Override
    public Void visit(DefDeviceNode node) {
        return null; // Don't do anything for definitions
    }

    @Override
    public Void visit(DefSignalNode node) {
        return null; // Don't do anything for definitions
    }

    @Override
    public Void visit(EventInputNode node) {
        return null;
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        return null;
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        return null;
    }

    @Override
    public Void visit(EventEveryNode node) {
        return null;
    }
}
