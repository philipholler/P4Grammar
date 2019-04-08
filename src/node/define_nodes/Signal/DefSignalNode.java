package node.define_nodes.Signal;

import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.ListUtils;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

/**
 * TODO ERROR HANDLING I CONSTRUCTORS
 */

public class DefSignalNode extends ListNode {
    // define Signal toggle: On = 1, Off = 0, on = "hej";
    private String ID;
    private RangeNode rangeNode;
    private ArrayList<EnumNode> enumValues = new ArrayList<>();

    // Constructores for signals with ranges:
    public DefSignalNode(ParserRuleContext ctx, String ID, RangeNode rangeNode) {
        super(ctx, rangeNode);
        this.ID = ID;
        this.rangeNode = rangeNode;
    }

    // Constructors for defining Signals with enumvalues:
    public DefSignalNode(ParserRuleContext ctx, ArrayList<EnumNode> enums, String ID) {
        // Super requires ArrayList<Node> so the enums list is converted to <Node> type with combineNodeList
        super(ctx, ListUtils.combineNodeLists(new ArrayList<>(), enums));
        this.enumValues.addAll(enums);
        this.ID = ID;
    }



    public DefSignalNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public ArrayList<EnumNode> getEnumValues() {
        return enumValues;
    }

    public DefSignalNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

    public String getID() {
        return ID;
    }

    public RangeNode getRangeNode() {
        return rangeNode;
    }

    @Override
    public String toString() {
        if(rangeNode != null){
            return "DefSignalNode(" +
                    "ID='" + ID + '\'' +
                    ')';
        } else {
            return "DefSignalNode(" +
                    "ID='" + ID + ')' + '\'';
        }
    }

    @Override
    public String getTreeString(int indentation) {
        if(rangeNode == null){
            return super.getTreeString(indentation);
        }
        else {
            return StringUtils.getIndentedString(indentation) +
                    this.toString() + "\n" + rangeNode.getTreeString(indentation + 1);
        }
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}

