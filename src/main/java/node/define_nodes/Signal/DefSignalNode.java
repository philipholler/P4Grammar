package node.define_nodes.Signal;

import node.BlockNode;
import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SignalType;
import semantics.SymbolTable;
import utils.ListUtils;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

public class DefSignalNode extends ListNode {
    // define Signal toggle: On = 1, Off = 0, on = "hej";
    private String ID;
    private final SignalType signalType;

    // Constructors for signals with ranges:
    public DefSignalNode(ParserRuleContext ctx, String ID, RangeNode rangeNode) {
        super(ctx, rangeNode);
        this.ID = ID;
        if(rangeNode.getType().equals(SymbolTable.INT_TYPE_ID))
            signalType = SignalType.INT_RANGE;
        else
            signalType = SignalType.FLOAT_RANGE;
    }

    // Constructors for defining Signals with enumvalues:
    public DefSignalNode(ParserRuleContext ctx, ArrayList<EnumNode> enums, String ID) {
        // Super requires ArrayList<Node> so the enums list is converted to <Node> type with combineNodeList
        super(ctx, ListUtils.combineNodeLists(new ArrayList<>(), enums));
        this.ID = ID;
        this.signalType = SignalType.LITERALS;
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

    public DefSignalNode(ParserRuleContext ctx) { // todo Kan de her ikke bare fjernes?
        super(ctx);
        signalType = null;
    }

    public DefSignalNode(ParserRuleContext ctx, ArrayList<Node> children) { // todo ^
        super(ctx, children);
        signalType = null;
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
                "SIGNAL_ID='" + ID + '\'' +
                ')';
    }

    public SignalType getSignalType() {
        return signalType;
    }
}

