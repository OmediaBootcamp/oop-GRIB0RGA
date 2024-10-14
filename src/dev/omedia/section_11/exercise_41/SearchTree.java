package dev.omedia.section_11.exercise_41;


public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (root == null) {
            root = newItem;
            return true;
        }
        ListItem currentItem = root;


        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison == 0) {
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }

            if (comparison < 0) {
                if (currentItem.next() == null) {
                    currentItem.setNext(newItem);
                    return true;
                }
                currentItem = currentItem.next();
            }

            if (comparison > 0) {
                if (currentItem.previous() == null) {
                    currentItem.setPrevious(newItem);
                    return true;
                }
                currentItem = currentItem.previous();
            }
        }

        return false;

    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) return false;

        System.out.println("Deleting item " + item.getValue());
        ListItem currentItem = root, parentItem = root;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if (comparison == 0) {
                performRemoval(currentItem, parentItem);
                return true;
            }

            parentItem = currentItem;
            currentItem = comparison < 0 ? currentItem.next() : currentItem.previous();
        }

        return false;
    }


    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
                return;
            }
            if (parent.previous() == item) {
                parent.setPrevious(item.previous());
                return;
            }
            if (parent == item) {
                root = item.previous();  // Root case\
                return;
            }
        }

        if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
                return;
            }
            if (parent.previous() == item) {
                parent.setPrevious(item.next());
                return;
            }
            if (parent == item) {
                root = item.next();  // Root case
                return;
            }
        }

        if (item.next() != null && item.previous() != null) {
            ListItem current = item.next(), leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());

            if (leftmostParent == item) {
                item.setNext(current.next());
                return;
            }
            if (leftmostParent != item) {
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {

        if (root != null) {
            traverse(root.previous()); // to the left of root
            System.out.println(root.getValue());
            traverse(root.next()); // to the right of root
        }
    }
}
