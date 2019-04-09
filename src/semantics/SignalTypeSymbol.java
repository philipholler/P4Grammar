package semantics;

import exceptions.user_side.CompileErrorException;
import node.DeclsNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.base.Node;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Signal.EnumNode;

import java.util.ArrayList;

public class SignalTypeSymbol extends Symbol{

    /**
     * A custom signal definition can contain only one of these 3 kinds of values:
     *      Integer range   (ie. 0.5 to 6.3)
     *      Float range     (ie. 0 to 100)
     *      Literals        (A list of IDs translating to a certain value (of any primitive type))
     *
     *  Note : One SignalType can contain literals of multiple different types (floats, ints and strings)
     */
    private enum SIGNAL_TYPE{
        INT_RANGE, FLOAT_RANGE, LITERALS;
    }

    private final SIGNAL_TYPE TYPE;

    private float floatLowerBound, floatUpperBound;
    private int intLowerBound, intUpperBound;
    private ArrayList<FieldSymbol> signalLiterals = new ArrayList<>();

    // Constructor for SignalType with a list of literal values
    public SignalTypeSymbol(Node declarationNode, String id, ArrayList<FieldSymbol> signalLiterals) {
        super(id, declarationNode);
        TYPE = SIGNAL_TYPE.LITERALS;
        this.signalLiterals = signalLiterals;
    }

    // Constructor for SignalType with an integer range
    public SignalTypeSymbol(Node declarationNode, String id, int lowerBound, int upperBound) {
        super(id, declarationNode);
        TYPE = SIGNAL_TYPE.INT_RANGE;
        this.intLowerBound = lowerBound;
        this.intUpperBound = upperBound;
    }

    // Constructor for SignalType with a float range
    public SignalTypeSymbol(Node declarationNode, String id, float lowerBound, float upperBound) {
        super(id, declarationNode);
        TYPE = SIGNAL_TYPE.FLOAT_RANGE;
        this.floatLowerBound = lowerBound;
        this.floatUpperBound = upperBound;
    }

    public SignalTypeSymbol(DefSignalNode declarationNode) {
        super(declarationNode.getID(), declarationNode);

        // For a signal type with a range
        if(declarationNode.getRangeNode() != null){
            if(declarationNode.getRangeNode().getType().equals("float")){
                this.TYPE = SIGNAL_TYPE.FLOAT_RANGE;
                if(declarationNode.getRangeNode().getLeftChild() instanceof FloatNode && declarationNode.getRangeNode().getLeftChild() instanceof FloatNode){
                    this.floatLowerBound = ((FloatNode) declarationNode.getRangeNode().getLeftChild()).getVal();
                    this.floatUpperBound = ((FloatNode) declarationNode.getRangeNode().getRightChild()).getVal();
                }
            } else if (declarationNode.getRangeNode().getType().equals("int")){
                this.TYPE = SIGNAL_TYPE.INT_RANGE;
                if(declarationNode.getRangeNode().getLeftChild() instanceof IntegerNode && declarationNode.getRangeNode().getLeftChild() instanceof IntegerNode){
                    this.floatLowerBound = ((IntegerNode) declarationNode.getRangeNode().getLeftChild()).getVal();
                    this.floatUpperBound = ((IntegerNode) declarationNode.getRangeNode().getRightChild()).getVal();
                }
            } else {
                throw new CompileErrorException("Error in SignalTypeSymbol constructor");
            }
        } // For a signal type with enum values
         else {
             this.TYPE = SIGNAL_TYPE.LITERALS;
            for (EnumNode node: declarationNode.getEnumValues()) {
                this.signalLiterals.add(new FieldSymbol(node));
            }
        }

    }

    /**
     * @return true if the given value is within the defined range for this SignalType. Returns false otherwise.
     */
    public boolean isLegalSignalValue(int val){
        if(TYPE == SIGNAL_TYPE.INT_RANGE)
            return (val >= intLowerBound && val <= intUpperBound);

        return false;
    }

    /**
     * @return true if the given value is within the defined range for this SignalType. Returns false otherwise.
     */
    public boolean isLegalSignalValue(float val){
        if(TYPE == SIGNAL_TYPE.FLOAT_RANGE)
            return (val >= floatLowerBound && val <= floatUpperBound);

        return false;
    }

    /**
     * @param ID The literal id for the signal value
     * @return true if the given ID is defined for this SignalType. False otherwise.
     */
    public boolean isLegalSignalValue(String ID){
        if(TYPE == SIGNAL_TYPE.LITERALS)
            for(FieldSymbol s : signalLiterals)
                if(s.id.equals(ID)) return true;


        return false;
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder();

        if(TYPE == SIGNAL_TYPE.INT_RANGE){
            values = new StringBuilder(intLowerBound + "..." + intUpperBound);
        }else if(TYPE == SIGNAL_TYPE.FLOAT_RANGE){
            values = new StringBuilder(floatLowerBound + "..." + floatUpperBound);
        }else{
            for(FieldSymbol s : signalLiterals)
                values.append(s.toString()).append(", ");

            values.delete(values.length() - 2, values.length()); // Remove last comma and space
        }

        return "Signal: " + id + " - " + TYPE + "(" + values + ")";
    }
}
