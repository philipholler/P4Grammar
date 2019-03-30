package visitor;

import node.*;
import node.base.Node;
import node.define_nodes.*;

public class PrintVisitor extends VisitorBase {

    @Override
    public Object defaultVisit(Node node) {
        System.out.println("No visitor for nodeclass:" + node.getClass().getName());
        return null;
    }

    public Object visit(VarDeclNode node){
        return "[(VarDeclNode) VarType: " + node.getVarType() + " ID: " +  node.getID() + " Val: " + node.getVal() + "]";
    }

    @Override
    public Object visit(ProgramNode node) {
        return "[(ProgramNode)" + visit(node.getChild()) + "]";
    }

    @Override
    public Object visit(EnumValuesNode node) {
        return "[(EnumValuesNode)]";
    }

    @Override
    public Object visit(DeclsNode node) {
        String s = "";

        for(Node child: node.getChildren()){
            s += visit(child);
        }

        return "[(DeclsNode) " + s + "]";
    }

    @Override
    public Object visit(DefNode node) {
        if(node instanceof DefSignalNode){
            return "[(DefNode) SignalDef: " + ((DefSignalNode) node).getID() + "]";
        }
        if(node instanceof DefDeviceNode){
            return "[(DefNode) DeviceDef: " + ((DefDeviceNode) node).getID() + "]";
        }
        return "[(DefNode)]";
    }

    @Override
    public Object visit(DevDeclNode node) {
        return "[(DevDeclNode) VarType: " + node.getType() + " ID: " + node.getID() + " val: " + node.getVal() + "]";
    }

    @Override
    public Object visit(RangeNode node) {
        return "[(RangeNode)]";
    }

    @Override
    public Object visit(OutputNode node) {
        return "[(OutputNode)]";
    }

    @Override
    public Object visit(InputNode node) {
        return "[(InputNode)]";
    }
}
