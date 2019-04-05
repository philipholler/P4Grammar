package semantics;

import node.base.Node;

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
    public SignalTypeSymbol(String id, Node declarationNode, ArrayList<FieldSymbol> signalLiterals) {
        super(id, declarationNode);
        TYPE = SIGNAL_TYPE.LITERALS;
        this.signalLiterals = signalLiterals;
    }

    // Constructor for SignalType with an integer range
    public SignalTypeSymbol(String id, Node declarationNode, int lowerBound, int upperBound) {
        super(id, declarationNode);
        TYPE = SIGNAL_TYPE.INT_RANGE;
        this.intLowerBound = lowerBound;
        this.intUpperBound = upperBound;
    }

    // Constructor for SignalType with a float range
    public SignalTypeSymbol(String id, Node declarationNode, float lowerBound, float upperBound) {
        super(id, declarationNode);
        TYPE = SIGNAL_TYPE.FLOAT_RANGE;
        this.floatLowerBound = lowerBound;
        this.floatUpperBound = upperBound;
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




}
