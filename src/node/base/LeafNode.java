package node.base;

import utils.StringUtils;

public abstract class LeafNode extends Node {


    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

}
