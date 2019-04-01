package node.define_nodes.Signal;

import node.base.ListNode;
import node.base.Node;
import utils.StringUtils;
import visitor.AbstractVisitor;

import java.util.ArrayList;

/**
 * TODO ERROR HANDLING I CONSTRUCTORS
 */

public class DefSignalNode extends ListNode {
    // define Signal toggle: On = 1, Off = 0, on = "hej";
    private String ID;
    private RangeNode rangeNode;


    // Constructores for signals with ranges:
    public DefSignalNode(String ID, RangeNode rangeNode) {
        this.ID = ID;
        this.rangeNode = rangeNode;
    }

    // Constructors for defining Signals with enumvalues:
    public DefSignalNode(ArrayList<Node> enums, String ID) {
        super(enums);
        this.ID = ID;
    }

    public DefSignalNode() {
    }

    public DefSignalNode(ArrayList<Node> children) {
        super(children);
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
}

