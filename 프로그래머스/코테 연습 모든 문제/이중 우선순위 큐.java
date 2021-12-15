package com.pcloud.jcodetest;

import java.util.Comparator;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        Heap<Integer> integerHeap = new Heap<>(Heap.UpComparator.INSTANCE);

        for (String op : operations) {
            String[] opSplit = op.split(" ");
            String symbol = opSplit[0];
            int num = Integer.parseInt(opSplit[1]);

            if ("D".equals(symbol)) {
                if (0 < num) {
                    integerHeap.popOfLast();
                } else {
                    integerHeap.pop();
                }
            } else if ("I".equals(symbol)) {
                integerHeap.push(num);
            }
        }

        if (!integerHeap.isEmpty()) {
            Integer min = integerHeap.peek();
            Integer max = integerHeap.popOfLast();

            answer[0] = max;
            answer[1] = min;
        }


        return answer;
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
        if (1 <= _last) return (T)_nodes[1];
        else return null;
    }

    public boolean isEmpty() {
        return _last == 0;
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

    public T popOfLast() {
        if (0 >= _last) return null;
        return (T)_nodes[_last--];
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

    static class UpComparator implements Comparator<Integer> {
        static UpComparator INSTANCE = new UpComparator();
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1 > i2)
                return 1;
            return 0;
        }
    }
}
