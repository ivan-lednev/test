package com.lednev;

public class ListItem extends ListItemAbstract {
    private ListItem previous;
    private String value;
    private ListItem next;

    public ListItem(String value){
        this.value = value;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public void setPrevious(ListItem previous) {
        this.previous = previous;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}
