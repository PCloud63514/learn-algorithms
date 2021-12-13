import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = Arrays.stream(jobs).map(Job::new).collect(Collectors.toList());
        Heap<Job> jobHeap = new Heap<Job>(JobComparator.INSTANCE);
        int answer = 0;
        int taskCount = 0;
        int currTime = 0;
        int totalTime = 0;
        jobList.sort((o1, o2) -> o1.start - o2.start);
        while (taskCount < jobList.size() || !jobHeap.isEmpty()) {
            if (taskCount < jobList.size() && jobList.get(taskCount).start <= currTime) {
                jobHeap.push(jobList.get(taskCount++));
                continue;
            }

            if (!jobHeap.isEmpty()) {
                Job job = jobHeap.pop();
	  // 최종 결과 시간 - start + process = 수행 시간
                totalTime += currTime - job.start + job.process;
	  // 결과 + 결과 = 최종 결과 시간
                currTime += job.process;
            } else {
                currTime = jobList.get(taskCount).start;
            }
        }
        answer = totalTime / jobList.size();
        return answer;
    }
}

class Job {
    int start;
    int process;

    public Job(int[] obj) {
        this.start = obj[0];
        this.process = obj[1];
    }
    
    public Job(int start, int process) {
        this.start = start;
        this.process = process;
    }
}

class JobComparator implements Comparator<Job> {
    static JobComparator INSTANCE = new JobComparator();
    @Override
    public int compare(Job i1, Job i2) {
        if (i1.process > i2.process)
            return 1;
        return 0;
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

    public boolean isEmpty() {
        return _nodes[_last] == null;
    }

    public T last() {
        return (T)_nodes[_last];
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