import time

import ddddocr
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from io import BytesIO
from PIL import Image

s = Service("D:\install\chromedriver_win32\chromedriver.exe")
options = Options()
# options.binary_location = "C:\Program Files\Google\Chrome\Application\chrome.exe"
# r代表后面的字符串斜杠不转义，''表示python识别空格
options.add_argument(r"user-data-dir=C:\Users\zhengpeng\AppData\Local\Google\Chrome\User''Data\Default\Login''Data")
driver = webdriver.Chrome(options=options, service=s)


def sign_vpn():
    try:
        driver.get("https://tly.com/modules/index.php")
        time.sleep(2)  # 延时加载
        # 点击签到
        driver.find_element(By.XPATH, r'/html/body/div[1]/div/section[2]/div[2]/div[3]/div/div[2]/p[2]/button').click()
        # 识别图形验证码
        captcha = driver.find_element(By.XPATH, r'//*[@id="captcha"]/img')
        image = Image.open(BytesIO(captcha.screenshot_as_png))
        ocr = ddddocr.DdddOcr()
        res = ocr.classification(image)
        print(res)
        # 输入验证码完成签到
        driver.find_element(By.XPATH, r'//*[@id="modal-default"]/div[2]/div/div[2]/form/div[2]/div/input').send_keys(
            res)
        driver.find_element(By.XPATH, r'//*[@id="modal-default"]/div[2]/div/div[2]/form/div[3]/div/input').click()
        print("签到成功")
        return True
    except Exception as e:
        print("签到失败", e)
        return False


if __name__ == '__main__':
    pass
    for index in range(5):
        result = sign_vpn()
        if result:
            break
    driver.close()
