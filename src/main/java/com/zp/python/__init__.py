import decimal
import copy

if __name__ == '__main__':
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

    # for i in range(5,10,2): # 创建整数列表 range(3) = range(0,3) 是0,1,2,3
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
    s = []