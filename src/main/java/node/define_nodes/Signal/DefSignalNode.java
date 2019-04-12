package node.define_nodes.Signal;

import node.BlockNode;
import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.ListUtils;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

public class DefSignalNode extends ListNode {
    // define Signal toggle: On = 1, Off = 0, on = "hej";
    private String ID;

    // Constructores for signals with ranges:
    public DefSignalNode(ParserRuleContext ctx, String ID, RangeNode rangeNode) {
        super(ctx, rangeNode);
        this.ID = ID;
    }

    // Constructors for defining Signals with enumvalues:
    public DefSignalNode(ParserRuleContext ctx, ArrayList<EnumNode> enums, String ID) {
        // Super requires ArrayList<Node> so the enums list is converted to <Node> type with combineNodeList
        super(ctx, ListUtils.combineNodeLists(new ArrayList<>(), enums));
        this.ID = ID;
    }

    public RangeNode getRangeNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof RangeNode){
                return (RangeNode) node;
            }
        }
        return null;
    }

    public ArrayList<EnumNode> getEnumNodes(){
        ArrayList<EnumNode> enums = new ArrayList<>();
        for (Node node: super.getChildren()) {
            if(node instanceof EnumNode){
                enums.add((EnumNode) node);
            }
        }
        return enums;
    }

    public DefSignalNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public DefSignalNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

    public String getID() {
        return ID;
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    @Override
    public String toString() {
        return "DefSignalNode(" +
                "ID='" + ID + '\'' +
                ')';
    }
}

