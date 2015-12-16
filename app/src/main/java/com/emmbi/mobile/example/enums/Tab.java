package com.emmbi.mobile.example.enums;


/**
 * Created by mbagliojr on 2/23/15.
 */
public enum Tab {

    JOB("job", 0),
    MAP("map", 1),
    SPECIALS("specials", 2),
    MESSAGES("messages", 3);

    private String name;
    private int tabNum;

    Tab(String name, int tabNum) {
        this.name = name;
        this.tabNum = tabNum;
    }

    public String getName() {
        return name;
    }

    public int getTabNum() {
        return tabNum;
    }

    public static Tab fromString(String text) {
        if (text != null) {
            for (Tab tab : Tab.values()) {
                if (text.equalsIgnoreCase(tab.name)) {
                    return tab;
                }
            }
        }
        return null;
    }

    public static Tab fromTabNum(int tabNum) {
        for (Tab tab : Tab.values()) {
            if (tabNum == tab.tabNum) {
                return tab;
            }
        }
        return null;
    }

}
