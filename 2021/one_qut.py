# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
from datetime import datetime
from datetime import timedelta
import time


def timeToInt(t, last=False):
    _t = datetime.strptime(t.strip(), "%H:%M")
    if last:
        if _t.hour != 23 and _t.minute != 59:
            _t = _t + timedelta(minutes=1)
        return int(str(_t.hour) + (str(_t.minute) if _t.minute >= 10 else "0" + str(_t.minute)))
    return int(str(_t.hour) + str(_t.minute))


def timeCompare(t1, t2, tUp=True):
    tToi1 = timeToInt(t1)
    tToi2 = timeToInt(t2)

    if (tUp):
        if tToi1 > tToi2:
            return t2
        else:
            return t1
    else:
        if tToi1 < tToi2:
            return t2
        else:
            return t1

n = int(input())

_startTime = "00:00"
_endTime = "23:59"

timeStamp = list()

for _ in range(0, n):
    col = sys.stdin.readline()
    [startTime, endTime] = col.split('~')
    _startTime = timeCompare(_startTime, startTime, False)
    _endTime = timeCompare(_endTime, endTime)
    timeStamp.append(range(timeToInt(startTime), timeToInt(endTime, True)))

check = True
data = set(timeStamp.pop())
for _ in range(0, n - 1):
    com = list(data & set(timeStamp.pop()))
    if len(com) <= 0:
        check = False
        break
    else:
        data = set(com)

if check:
    print("{startTime}~{endTime}".format(startTime=_startTime, endTime=_endTime))
else:
    print(-1)
