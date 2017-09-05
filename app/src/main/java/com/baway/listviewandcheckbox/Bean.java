package com.baway.listviewandcheckbox;

/**
 * 类的描述：
 * 时间：  2017/9/5.10:02
 * 姓名：chenlong
 */

public class Bean {
    private boolean checked;
    private String str;

    public Bean(boolean checked, String str) {
        this.checked = checked;
        this.str = str;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
