import sys
from datetime import datetime
from datetime import timedelta


def timeToInt(t):
    _t = datetime.strptime(t.strip(), "%H:%M")
    return int(str(_t.hour) + (str(_t.minute) if _t.minute >= 10 else "0" + str(_t.minute)))


13:00
14:00 15:00
14:26 14:59
14:30 14:40
14:00 15:59

n = int(input())

preStartTime = timeToInt("00:00")
preEndTime = timeToInt("23:59")

isBreak = False

for _ in range(0, n):
    col = sys.stdin.readline()
    [startTime, endTime] = col.split('~')

    _startTime = timeToInt(startTime)
    _endTime = timeToInt(endTime)

    if _startTime <= preEndTime:
        preStartTime = _startTime if _startTime > preStartTime else preStartTime
        preEndTime = _endTime if _endTime < preEndTime else preEndTime
    else:
        isBreak = True
        break

if isBreak:
    print(-1)
else:
    print("{hour1}:{min1} ~ {hour2}:{min2}".format(hour1=str(preStartTime)[:2], min1=str(preStartTime)[2:],
                                                   hour2=str(preEndTime)[:2], min2=str(preEndTime)[2:]))
