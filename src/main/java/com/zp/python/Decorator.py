# import time
#
# def time_master(func):
#     def call_func():
#         print("开始运行程序...")
#         start = time.time()
#         func()
#         stop = time.time()
#         print("结束程序运行...")
#         print(f"一共耗费了 {(stop-start):.2f} 秒。") #格式化字符串常量 同format
#     return call_func
#
# @time_master
# def myfunc():
#     time.sleep(2)
#     print("I love FishC.")
#
# myfunc()

###### 带参数装饰器 ######

import time

def logger(msg):
    def time_master(func):
        def call_func():
            start = time.time()
            func()
            stop = time.time()
            print(f"[{msg}]一共耗费了 {(stop-start):.2f}")
        return call_func
    return time_master

@logger(msg="A")
def funA():
    time.sleep(1)
    print("正在调用funA...")

@logger(msg="B")
def funB():
    time.sleep(1)
    print("正在调用funB...")

funA()
funB()