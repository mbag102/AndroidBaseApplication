package com.emmbi.mobile.example.enums;

/**
 * Created by mbagliojr on 8/20/15.
 */
public enum SortOrder {

    ASCENDING,
    DESCENDING;

    public String toString() {
        if(DESCENDING.equals(this)) {
            return "DESC";
        } else {
            return "ASC";
        }
    }
}
