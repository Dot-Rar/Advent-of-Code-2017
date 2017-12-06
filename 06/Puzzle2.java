import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle2 {

    public static void main(String[] args) {
        int[] initialBank = new int[]{4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5};
        List<int[]> previous = new ArrayList<>();
        previous.add(initialBank);

        int cycles = 0;
        boolean firstMatch = false;

        while (true) {
            cycles++;

            int[] bank = Arrays.copyOf(previous.get(previous.size() - 1), initialBank.length);

            ElementWithIndex<Integer> maxTuple = getMax(bank);
            int max = maxTuple.element;
            int index = maxTuple.index;

            bank[index] = 0;

            int indexToAppend = index;
            for (int i = 0; i < max; i++) {
                indexToAppend++;
                if (indexToAppend >= bank.length) indexToAppend = 0;
                bank[indexToAppend] = bank[indexToAppend] + 1;
            }

            if (previous.stream().anyMatch(arr -> Arrays.equals(arr, bank))) {
                if(firstMatch) {
                    break;
                }
                else {
                    firstMatch = true;
                    cycles = 0;
                    previous.clear();
                    previous.add(bank);
                }
            }
            else previous.add(bank);
        }

        System.out.println(cycles);
    }

    private static ElementWithIndex<Integer> getMax(int[] stack) {
        Integer max = null;
        Integer index = null;

        for(int i = 0; i < stack.length; i++) {
            int element = stack[i];

            if(max == null || element > max) {
                max = element;
                index = i;
            }
        }

        return new ElementWithIndex<>(index, max);
    }

    private static class ElementWithIndex<T> {

        private final int index;
        private final T element;

        public ElementWithIndex(Integer index, T element) {
            this.element = element;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public T getElement() {
            return element;
        }
    }
}
