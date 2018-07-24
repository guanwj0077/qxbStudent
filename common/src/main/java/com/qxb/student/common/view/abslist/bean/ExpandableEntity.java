package com.qxb.student.common.view.abslist.bean;

import java.util.Collections;
import java.util.List;

/**
 * @author winky
 * @date 2018/7/24
 */
public class ExpandableEntity<P, C> {

    private P parent;
    private List<C> child;

    public ExpandableEntity(P parent, C child) {
        this(parent, Collections.singletonList(child));
    }

    public ExpandableEntity(P parent, List<C> child) {
        this.parent = parent;
        this.child = child;
    }

    public P getParent() {
        return parent;
    }

    public List<C> getChild() {
        return child;
    }
}
