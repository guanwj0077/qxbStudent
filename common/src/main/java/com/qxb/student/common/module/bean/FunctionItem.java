package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author winky
 * @date 2018/7/26
 */
@Entity(tableName = "FunctionItem")
public class FunctionItem {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String item_name;
    private String item_type;
    private String level;
    private String need_pay;
    private String pic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNeed_pay() {
        return need_pay;
    }

    public void setNeed_pay(String need_pay) {
        this.need_pay = need_pay;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
