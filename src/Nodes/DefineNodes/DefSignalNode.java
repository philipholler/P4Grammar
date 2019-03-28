package Nodes.DefineNodes;

import Nodes.Base.Node;
import Nodes.EnumValuesNode;
import Nodes.RangeNode;
import Visitors.AbstractVisitor;

import java.util.ArrayList;

/**
 * TODO ERROR HANDLING I CONSTRUCTORS
 */

public class DefSignalNode extends DefNode {
    // define Signal toggle: On = 1, Off = 0, on = "hej";
    private String ID;
    private EnumValuesNode enumValues;
    private RangeNode rangeNode;


    // Constructores for signals with ranges:
    public DefSignalNode(String ID, RangeNode rangeNode) {
        this.ID = ID;
        this.rangeNode = rangeNode;
    }
    public DefSignalNode(ArrayList<Node> children, String ID, RangeNode rangeNode) {
        super(children);
        this.ID = ID;
        this.rangeNode = rangeNode;
    }

    // Constructors for defining Signals with enumvalues:
    public DefSignalNode(String ID, EnumValuesNode enumValues) {

        this.ID = ID;
        this.enumValues = enumValues;
    }
    public DefSignalNode(ArrayList<Node> children, String ID, EnumValuesNode enumValues) {
        super(children);
        this.ID = ID;
        this.enumValues = enumValues;
    }

    public DefSignalNode() {
    }

    public DefSignalNode(ArrayList<Node> children) {
        super(children);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }

    public String getID() {
        return ID;
    }

    public EnumValuesNode getEnumValues() {
        return enumValues;
    }

    public RangeNode getRangeNode() {
        return rangeNode;
    }
}

