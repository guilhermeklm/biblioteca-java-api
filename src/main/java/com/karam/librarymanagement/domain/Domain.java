package com.karam.librarymanagement.domain;

public abstract class Domain {

    public abstract Long getId();

    protected boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }

        if (obj instanceof Long) {
            return ((Long) obj).equals(0L);
        }

        if (obj instanceof Integer) {
            return ((Integer) obj).equals(0);
        }

        if (obj instanceof Double) {
            return ((Double) obj).equals(0.0);
        }

        return false;
    }
}
