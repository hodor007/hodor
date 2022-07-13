import decimal

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

    # for i in range(5,10,2):
    #     print(i)