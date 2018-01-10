import java.util.Arrays;

public class MyArrayList<anyType> implements ListInterface<anyType> {
    private Object[] list = new Object[10];
    private int numElements = 0;

    public MyArrayList() {
    }

    public boolean add(anyType x) {
        if (numElements + 1 > list.length) {
            doubleCapacity();
        }

        list[numElements] = x;
        numElements++;
        return true;
    }

    public boolean add(int index, anyType x) {
        if (numElements + 1 > list.length) {
            doubleCapacity();
        }

        System.arraycopy(list, index, list, index + 1, numElements - 1 - index);
        list[index] = x;
        numElements++;
        return true;
    }

    public void clear() {
        numElements = 0;
        list = new Object[10];
    }

    public boolean contains(anyType x) {
        for(int i = 0; i < numElements; ++i) {
            if (list[i].equals(x)) {
                return true;
            }
        }

        return false;
    }

    public anyType get(int index) {
        return (anyType)list[index];
    }

    public int indexOf(anyType x) {
        for(int i = 0; i < numElements; ++i) {
            if (list[i].equals(x)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public int lastIndexOf(anyType x) {
        for(int i = numElements - 1; i >= 0; --i) {
            if (list[i].equals(x)) {
                return i;
            }
        }

        return -1;
    }

    public anyType remove(int index) {
        anyType removed = (anyType)list[index];
        System.arraycopy(list, index + 1, list, index, numElements - 1 - index);
        numElements--;
        if (numElements < list.length / 3) {
            cutCapacity();
        }

        return removed;
    }

    public boolean remove(anyType x) {
        for(int i = 0; i < numElements; i++) {
            if (list[i].equals(x)) {
                remove(i);
                break;
            }
        }

        if (numElements < list.length / 3) {
            cutCapacity();
        }

        return true;
    }

    public int size() {
        return numElements;
    }

    public anyType set(int index, anyType x) {
        list[index] = x;
        return (anyType)list[index];
    }

    public anyType[] toArray() {
        return (anyType[]) Arrays.copyOf(list, numElements);
    }

    public void trimToSize() {
        list = Arrays.copyOf(list, numElements);
    }

    private void doubleCapacity() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    private void cutCapacity() {
        list = Arrays.copyOf(list, list.length / 2);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("[");
        for(int i = 0; i < numElements; ++i) {
            stringbuilder.append(list[i]).append(", ");
        }
        if (stringbuilder.length() > 2) {
            stringbuilder.deleteCharAt(stringbuilder.lastIndexOf(","));
        }
        stringbuilder.setLength(stringbuilder.toString().trim().length());
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
