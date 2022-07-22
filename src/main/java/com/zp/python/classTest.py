class Turtle:
    head = 1
    eyes = 2

    def __init__(self, head):
        self.head = head

    def crawl(self):
        print("asadasdsa")


class B(Turtle):
    """
    继承
    """

    def __init__(self, legs):
        # Turtle.__init__(self, 3)
        super().__init__(self, 3)
        self.legs = legs

    def add(self):
        return self.legs + self.head


class C:
    """
    组合
    """
    a = Turtle()

    def say(self):
        self.a.crawl()  # self不能丢

class D:
    """
      _slots_ 固定属性，无法再动态添加，子类不会生效
    """
    _slots_ =["x","y"]
    def __init__(self,z):
        self.z = z  # 会报错，不存在z属性

    def __new__(cls, *args, **kwargs):  # 对象创建之前执行 init之前
        pass
    def __del__(self):  # 对象销毁前，即没有引用的时候 执行
        pass