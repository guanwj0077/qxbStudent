package com.qxb.student.common.view.recycler.bean;

/**
 * 展开
 *
 * @author winky
 * @date 2018/7/24
 */
public class ExpandableEntity<G, C> {

    /**
     * head data
     */
    private G groupData;

    /**
     * childDatas
     */
    private C childDatas;

    /**
     * 是否展开,  默认不展开
     */
    private boolean isExpand = false;

    public ExpandableEntity(G groupData, C childDatas) {
        this(groupData, childDatas, false);
    }

    public ExpandableEntity(G groupData, C childDatas, boolean isExpand) {
        this.groupData = groupData;
        this.childDatas = childDatas;
        this.isExpand = isExpand;
    }

    public G getGroupData() {
        return groupData;
    }

    public C getChildDatas() {
        return childDatas;
    }

    public boolean isExpand() {
        return isExpand;
    }
}
