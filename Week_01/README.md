学习笔记

Java  Queue源码分析
1.Queue是一个接口,继承了Collections接口
2.add offer 添加
3.remove poll 删除
4.element peek 返回队列的头
5.add,remove,element方法操作失败会抛异常;offer,poll,peek操作失败会返回null

Java PriorityQueue源码分析
1.PriorityQueue是一个实现类,继承了AbstractQueue类,实现了Serializable接口
2.默认初始容量11
3.默认元素数量为0
4.默认改动次数为0
5.grow方法扩充容量:
	老容量为queue的长度;
	如果老容量小于64,新容量为老容量加上2
	否则新容量为老容量加上老容量的一半
	如果新容量大于定义的最大数组长度,调用hugeCapacity方法
	新queue为原来queue的复制且容量为新容量
6.hugeCapacity方法巨大容量
	如果参数小于0抛出异常
	如果参数大于最大数组长度 返回Integer的最大值
	否则返回 最大数组长度
7.add方法调用offer方法
8.offer添加元素
	如果元素为空 抛异常 否则继续
	改动次数+1
	如果老元素数量大于等于队列的长度 调用grow方法
	元素数量+1
	如果老元素数量为0 queue下标为0的元素为传入的元素
	否则 调用siftUp方法
	返回 true
9.peek方法返回queue下标为0的元素
	如果没有 返回null
10.remove方法移除元素
	调用indexOf返回元素的下标
	如果为-1 fanhuifalse
	否则 调用 removeAt方法 返回 true
11.clear方法清空queue
	改动次数+1
	遍历queue 将每个元素置为null
	元素数量改为0

总结
第一次分析源码,将自己觉得重要的部分并且看得懂的部分分析出来,积累经验。

	

