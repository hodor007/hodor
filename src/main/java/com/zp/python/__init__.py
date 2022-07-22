import decimal
import copy

# https://fishc.com.cn/forum.php?mod=forumdisplay&fid=360&filter=typeid&typeid=769
# from com.zp.python.classTest import Turtle

if __name__ == '__main__':
    pass
    # 正常的浮点型有精度问题
    # a = decimal.Decimal('0.1')
    # b = decimal.Decimal('0.2')
    # print(a + b)
    # a = 3//2  # 向下取整
    # b = -3//2
    # divmod(-3,2) # 返回向下取整和取模值
    # abs(-3) # 绝对值 or 复数的模
    # int('5');int(3.14)
    # pow(2,3) # 2的3次方
    # a = bool('') # 值为0为false,空的序列和集合是false
    # 1 == True
    # 0 == False
    # not True # 取反
    # 短路逻辑 抛出影响结果的值
    # 3 and 4  # 4
    # 3 or 4  # 3
    # 条件
    # if elif else
    # small  = a if a<b else b  和下面一样
    # if a<b :
    # small = a
    # else
    # small = b

    # 当循环条件不再为真的时候，else语句才会被执行 break虽然跳出但是还是为真
    #     i = 1
    # while i<5:
    #     print("循环内，i的值是",i)
    #     if i == 2:
    #         break
    #     i += 1
    # else:
    #     print("循环外，i的值是",i)

    # 99乘法表
    # i = 1
    # while i<=9:
    #     j=1
    #     while j<=i:
    #         print(j,"*",i,"=",j * i,end =" ")
    #         j += 1
    #     print()
    #     i += 1

    # for
    # for each in "FishC":
    #     print(each)

    # for i in range(5,10,2): # 创建整数列表 range(3) = range(0,3) 是0,1,2 不包括结尾
    #     print(i)

    # 数组
    # temp = [1,2,3,4,5,"heihei"]
    # # temp[-1]
    # # temp[:3]
    # # temp[3:]
    # # temp[0:5:2]
    # temp.append("孤寡")
    # temp.extend(["a","b","c"])
    # temp[temp(s):]=[7,8,9]
    # temp.insert[1,2] # 在1的位置添加2
    # temp.remove("heihei") #之后删除匹配到的第一个，指定元素不存在会报错
    # temp.pop(2) #移除位置2的元素
    # temp.clear() #清除数组
    # temp * 3 # 重复3次  [[0]] * 3 生成的会指向同一个[0]
    # 二维数组
    # matrix = [[1,2,3],[4,5,6],[7,8,9]]
    # for i in matrix:
    #     for each in i:
    #         print(each, end=' ')
    #     print()
    # matrix[1][2]
    # t = [123,"hodor",456]  #数组赋值给变量  解包
    # x,y,z = t

    # x = "peng"
    # y = "peng"
    # x = [1,2,3]
    # y = [1,2,3] 内存地址不同 所以is结果为false  字符数是指向了统一地址块
    # print(x is y)

    # 浅拷贝
    # x = [1,2,3]
    # y = x.copy()  # 等同于 y = x[:]    copy.copy(x)
    # 深拷贝 子对象也会拷贝
    # y = copy.deepcopy(x)
    # oho = [1,2,3,4]
    # oho = [i * 2 for i in oho] #列表推导式，创建新列表赋给之前   expression for target in iterable
    # print(oho)
    # s = [[0] * 3 for i in range(3)]

    # 元祖 比数组轻量，迅速
    # x = (1,2,3,4,5,"sas")  # 不允许修改

    # 字符串
    # x = "12321"
    # "是回文数。" if x == x[::-1] else "不是回文数。" # 带了负号就是倒叙排序
    # ".".join(["www", "ilovefishc", "com"]) # 'www.ilovefishc.com'
    # "1+2={}, 2的平方是{}，3的立方是{}".format(1+2, 2*2, 3*3*3) # 格式化字符串
    # "{1}看到{0}就很激动！".format("小甲鱼", "漂亮的小姐姐")  # 位置索引
    # "我叫{name}，我爱{fav}。".format(name="小甲鱼", fav="Pyhon") # 关键字索引

    # 字典
    # d = {"吕布":"口口布", "关羽":"关习习"}   # b = dict(吕布="口口布", 关羽="关习习", 刘备="刘baby")
    # d["吕布"]
    # dict.fromkeys("FishC")  #{'F': None, 'i': None, 's': None, 'h': None, 'C': None}
    # d.update({'i':105, 'h':104}) # d['s'] = 115 修改
    # d.setdefault('C', "code")  查找一个键是否存在于字典中，如果在，返回它对应的值；如果不在，给它指定一个新的值：
    # items()、keys() 和 values() 三个方法分别用于获取字典的键值对、键和值三者的视图对象。 当字典内容改变时，视图对象的内容也会相应地跟着改变
    # d = {x:ord(x) for x in "FishC"} # {'F': 70, 'i': 105, 's': 115, 'h': 104, 'C': 67}  字典推导式

    # 集合 无序且唯一  类似hashSet
    # set("FishC")
    # frozenset() 不支持修改

    # 函数
    # def myfunc():
    #     pass
    # def div(x,y):
    #     return x/y
    # print(div(4,2))
    # print(div(y=4,x=2))
    # def div(x,y=2): # 设置默认值
    #     return x/y
    # def div(x=2,y): # 报错，默认值的参数放后面
    #     return x/y
    # 收集参数
    # def myfunc(*args):
    #     print("有{}个参数。",format(len(args)))
    # myfunc(1,2,3,'12')
    # 函数返回多个值  按元祖打包返回
    # def myfunc():
    #     return 1,2,3
    # x,y,z = myfunc()
    # 字典参数
    # def myfunc(**kwargs):
    #     print(kwargs)
    # myfunc(a=1,b=2,c=3)
    # 解包
    # args=(1,2,3,4)
    # def myfunc(a,b,c,d):
    #     print(a,b,c,d)
    # myfunc(*args)  # 元祖加*解包成参数
    # 通常我们无法在嵌套函数的内部修改外部函数变量的值，除非使用 nonlocal 语句破除限制：

    # 闭包  所谓闭包（closure），也有人称之为工厂函数（factory function）  这里 power() 函数就像是一个工厂，由于参数不同，得到了两个不同的 “生产线”，一个是 square()，一个是 cube()，前者是返回参数的平方，后者是返回参数的立方。
    #      def power(exp):
    #          def exp_of(base):
    #             return base ** exp
    #          return exp_of  # 函数作为返回值
    #
    #      square = power(2) # 函数作为变量
    #      cube = power(3)
    #     square
    # <function power.<locals>.exp_of at 0x000001CF6A1FAF70>
    # >>> square(2)
    #
    # >>> cube(2)
    # 8
    # 函数作为入参

    # 生成器 每次遇到 yield 时函数会暂停并保存当前所有的运行信息，返回 yield 的值,
    # def fib(): #生成器实现斐波拉切数列
    #     back1, back2 = 0, 1
    #     while True:
    #         yield back1
    #         back1, back2 = back2, back1 + back2

    # 对象
    # t1 = Turtle()
    # t1.crawl()
    # t1.mouth = 3
    # print(dir(t1))
    # c = Turtle(1)

    # # 异常
    # class BusinessException(Exception):
    #     pass
    # try:
    #     1 / 0
    #     520 + "abc"
    # # except:
    # #     print("出错啦")
    # except (ZeroDivisionError, ValueError) as e:
    #     print(e)
    #     raise BusinessException("手动抛出异常")
    # except TypeError:
    #     pass
    # finally:  # 是否异常都执行
    #     print("没得四")

    # assert

