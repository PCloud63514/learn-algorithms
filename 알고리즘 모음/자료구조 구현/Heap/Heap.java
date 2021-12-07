// https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
// https://kim6394.tistory.com/222
// https://st-lab.tistory.com/205
// https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
// https://ko.wikipedia.org/wiki/%ED%9E%99_(%EC%9E%90%EB%A3%8C_%EA%B5%AC%EC%A1%B0)
// https://st-lab.tistory.com/243
// https://twpower.github.io/137-heap-implementation-in-cpp
class Heap<T> {
    private final Comparator<T> _comparator;
    private int _capacity = 10;
    private int _last = 0;
    private Object[] _nodes;

    public Heap(Comparator<T> comparator) {
        this._comparator = comparator;
        this._nodes = new Object[this._capacity];
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
        
        while (childIdx < _last) {
             if (childIdx + 1 < _last) {
                 
             }
        }
        
        if(childIdx + 1 <= _last) {
            // 클 경우 오른쪽 트리의 노드가
            childIdx = _comparator.compare((T)_nodes[childIdx], (T)_nodes[childIdx + 1]) == 1 ? childIdx : childIdx + 1;
        }

        while (childIdx <= _last && 1 == _comparator.compare((T) _nodes[parentIdx], (T) _nodes[childIdx])) {
            swap(parentIdx, childIdx);
            parentIdx = childIdx;
            childIdx = childIdx * 2;

            if(childIdx + 1 <= _last) {
                // 클 경우 오른쪽 트리의 노드가
                childIdx = _comparator.compare((T)_nodes[childIdx], (T)_nodes[childIdx + 1]) == 1 ? childIdx : childIdx + 1;
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

    public int getSize() {
        return this._capacity;
    }
}

class UpComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        if (i1 > i2)
            return 1;
        return 0;
    }
}
