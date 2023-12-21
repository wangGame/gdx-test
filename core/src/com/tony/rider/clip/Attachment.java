package com.tony.rider.clip;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 15:26
 */
abstract public class Attachment {
    String name;

    public Attachment (String name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null.");
        this.name = name;
    }

    /** The attachment's name. */
    public String getName () {
        return name;
    }

    public String toString () {
        return getName();
    }
}
