package node.base;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

public abstract class LeafNode extends Node {


    public LeafNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

}
