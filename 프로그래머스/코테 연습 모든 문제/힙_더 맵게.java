import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Heap<Long> heap = new Heap<Long>(new UpComparator());
        int answer = 0;
        
        for (int i = 0; i < scoville.length; i++) {
            heap.push(Integer.toUnsignedLong(scoville[i]));
        }

        while(true) {
            if (1 <= heap.size() && K <= heap.peek()) return answer;
            if (1 >= heap.size()) return -1;
            
            Long p1 = heap.pop();
            Long p2 = heap.pop();
            Long sum = p1 + (p2 * 2);
            answer++;
            heap.push(sum);
        }
    }
}

class Heap<T> {
    private final Comparator<T> _comparator;
    private int _capacity = 10;
    private int _last = 0;
    private Object[] _nodes;

    public Heap(Comparator<T> comparator) {
        this._comparator = comparator;
        this._nodes = new Object[this._capacity];
    }

    public T peek() {
        if (1 <= _last) 
            return (T)_nodes[1];
        else
            return null;
    }
    
    public void push(T argument) {
        if (_capacity <= _last + 1) {
            resize();
        }
        _nodes[++_last] = argument;

        int childIdx = _last;
        int parentIdx = childIdx / 2;

        while(1 < childIdx && 1 == _comparator.compare((T) _nodes[parentIdx], (T) _nodes[childIdx])) {
            swap(parentIdx, childIdx);
            childIdx = parentIdx;
            parentIdx = childIdx / 2;
        }
    }

    public T pop() {
        if (0 >= _last) return null;
        int parentIdx = 1;
        int childIdx = parentIdx * 2;

        Object node = _nodes[parentIdx];
        swap(parentIdx, _last--);

        if(childIdx + 1 <= _last) {
            childIdx = _comparator.compare((T)_nodes[childIdx], (T)_nodes[childIdx + 1]) != 1 ? childIdx : childIdx + 1;
        }

        while (childIdx <= _last && 1 == _comparator.compare((T) _nodes[parentIdx], (T) _nodes[childIdx])) {
            swap(parentIdx, childIdx);
            parentIdx = childIdx;
            childIdx = childIdx * 2;

            if(childIdx + 1 <= _last) {
                childIdx = _comparator.compare((T)_nodes[childIdx], (T)_nodes[childIdx + 1]) != 1 ? childIdx : childIdx + 1;
            }
        }
        return (T)node;
    }

    private void swap(int i1, int i2) {
        Object temp = _nodes[i1];
        _nodes[i1] = _nodes[i2];
        _nodes[i2] = temp;
    }

    private void resize() {
        int capacity = _capacity + (_capacity / 2);
        Object[] obj = new Object[capacity];

        if (_capacity - 1 >= 0) System.arraycopy(_nodes, 1, obj, 1, _capacity - 1);

        _nodes = obj;
        _capacity = capacity;
    }

    public int size() {
        return this._last;
    }
}

class UpComparator implements Comparator<Long> {
    @Override
    public int compare(Long i1, Long i2) {
        if (i1 > i2)
            return 1;
        return 0;
    }
}