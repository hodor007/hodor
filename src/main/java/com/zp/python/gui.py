import os
import win32process
import win32con
import time
import win32gui
import win32api
from selenium.webdriver.common.by import By
from win32com.client import Dispatch
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import subprocess


def open_video():
    """
    打开视频
    :return:
    """
    a = win32api.ShellExecute(0, 'open', 'D:\\1cca73a2cd1d325e0c718d0ee6fc61fd.mp4', '', '', 3)
    time.sleep(5)
    handle = win32gui.FindWindow('WMP Skin Host', "Windows Media Player")
    # handle = win32gui.GetForegroundWindow()
    title = win32gui.GetWindowText(handle)
    cls_name = win32gui.GetClassName(handle)
    print({'类名': cls_name, '标题': title})
    left, top, right, bottom = win32gui.GetWindowRect(handle)
    print(f'left, top, right, bottom  = {left, top, right, bottom}')
    win32gui.SetForegroundWindow(handle)
    win32api.SetCursorPos([right - 50, top - 60])  # 鼠标定位到-坐标系屏幕
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP | win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)  # 执行左单键击，
    # time.sleep(3)
    # win32gui.ShowWindow(handle, win32con.SW_MAXIMIZE)
    # 关闭窗口
    # time.sleep(3)
    # win32gui.PostMessage(handle, win32con.WM_CLOSE, 0, 0)
    # mp = Dispatch("WMPlayer.OCX")
    # tune = mp.newMedia("D:\\1cca73a2cd1d325e0c718d0ee6fc61fd.mp4")
    # mp.currentPlaylist.appendItem(tune)
    # mp.controls.play()
    # to stop playing use
    # mp.controls.stop()


def close_video():
    handle = win32gui.FindWindow('WMP Skin Host', "Windows Media Player")
    win32gui.PostMessage(handle, win32con.WM_CLOSE, 0, 0)


driver = None


def open_sset():
    """
    浏览器打开sset
    """
    global driver
    chrome_driver = 'D:\\install\\Win_911535_chrome-win\\chrome-win\\chromedriver.exe'
    s = Service(chrome_driver)
    options = Options()
    options.binary_location = "D:\\install\\Win_911535_chrome-win\\chrome-win\\chrome.exe"
    options.add_argument('–-incognito')
    options.add_argument('--disable-infobars')
    options.add_argument('--start-maximized')
    options.add_experimental_option("detach", True)
    driver = webdriver.Chrome(options=options, service=s)
    driver.get("http://10.37.0.207/sset")
    driver.find_element(By.XPATH, r'//*[@id="app"]/div/form/div[4]/div/div[1]/input').send_keys('1')
    driver.find_element(By.XPATH, r'//*[@id="app"]/div/form/div[5]/div/button').click()
    # time.sleep(2)
    # driver.minimize_window()
    # time.sleep(2)
    # driver.maximize_window()
    # driver.close()


def close_sset():
    driver.close()


if __name__ == '__main__':
    pass
    # close_video()
    # open_sset()
    # time.sleep(5)
    open_video()
    # close_sset()
