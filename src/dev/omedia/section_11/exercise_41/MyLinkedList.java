package dev.omedia.section_11.exercise_41;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {

        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;

        while (currentItem != null) {
            int comparisonValue = currentItem.compareTo(newItem);
            if (comparisonValue == 0) return false;  // if it returns 0 means they are equal and the item already exits;

            if (comparisonValue < 0) {
                if (currentItem.next() == null) {
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
                currentItem = currentItem.next();
            }

            if (comparisonValue > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                } else {
                    this.root = newItem;
                }
                newItem.setNext(currentItem).setPrevious(newItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) return false;

        System.out.println("Deleting item " + item.getValue());
        for (ListItem currentItem = this.root; currentItem != null; currentItem = currentItem.next()) {
            int comparisonValue = currentItem.compareTo(item);
            if (comparisonValue == 0) { // Find the matching item else return false
                if (currentItem == this.root) this.root = currentItem.next();
                else currentItem.previous().setNext(currentItem.next());
                if (currentItem.next() != null) currentItem.next().setPrevious(currentItem.previous());
                return true;
            }
        }
        return false;
    }


    @Override
    public void traverse(ListItem root) {

        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}