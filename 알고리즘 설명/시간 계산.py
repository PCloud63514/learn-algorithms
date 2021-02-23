from timeit import default_timer as timer
import datetime

start = timer()

sec = timer() - start
date = str(datetime.timedelta(seconds=sec))
print(date)


# time vs timeit
# timeit 이 더 좋다고 한다. https://stackoverflow.com/questions/17579357/time-time-vs-timeit-timeit
# disk flushing 및 OS Scheduling 과 같은 다른 작업이 컴퓨터에 영향을 미치는 것을 제거하기 위한 반복 테스트.
# 가비지 컬렉션을 비활성화하여 부적절한 순간에 컬렉션 실행을 예약해 해당 프로세스가 결과를 왜곡하지 않도록 한다.


