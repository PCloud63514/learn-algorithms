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
    private final Object[] _nodes;

    public Heap(Comparator<T> comparator) {
        this._comparator = comparator;
        this._nodes = new Object[this._capacity];
    }

    public void push(T argument) {
        if (_capacity <= _last) {
            resize();
        }
        _nodes[++_last] = argument;
    }

    public T pop() {

        T node = (T) _nodes[0];

        // 전부 땡겨야한다.
        return node;
    }

    private void swap() {

    }

    private void resize() {
        _capacity++;
    }

    public int getSize() {
        return this._capacity;
    }
}