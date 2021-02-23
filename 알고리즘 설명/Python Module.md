# Python Module

파이썬 알고리즘 계산에 효과적인 Module



## itertools

### permutations(순열)

$$
nPr = n!/(n-r)!
$$

##### permutations(array, n)

> array 내의 원소에 대한 순열 결과를 반환한다. n개의 원소를 사용할 수 있다.

```
from itertools import permutations

arr = [1, 2, 3]
print(list(permutations(arr)))
>> [(1, 2, 3), (1, 3, 2), (2, 1, 3), (2, 3, 1), (3, 1, 2), (3, 2, 1)]

print(list(permutaions(arr, 2)))
>> [(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2)]
```



### combinations(조합)

$$
nCr = nPr/r!
$$

##### combinations(array, n!)

> array 내의 원소에 대한 조합의 결과를 반환한다. n개의 원소를 사용할 수 있다.

```
from itertools import combinations

arr = [1, 2, 3]
print(list(combinations(arr,3)))
>> [(1, 2, 3)]
print(list(combinations(arr, 2)))
>> [(1, 2), (1, 3), (2, 3)]
```

