# import config
from requests import get, post

app_id = "wxfb2cda75651ba0a1"
# 公众号appSecret
app_secret = "ae7c365d9ba34783c6f5378dca4480a7"
# 接收公众号消息的微信号
myself = "ojNc16DnobAcJx4Sx7NJPZchMBrU"

class weixin:


    def get_access_token(self):
        # appId
        # appSecret
        post_url = ("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={}&secret={}"
                    .format(app_id, app_secret))
        access_token = get(post_url).json()['access_token']
        # print(access_token)
        return access_token


    def get_ciba(self):
        url = "http://open.iciba.com/dsapi/"
        headers = {
            'Content-Type': 'application/json',
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) '
                          'AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36'
        }
        r = get(url, headers=headers)
        note_en = r.json()["content"]
        note_ch = r.json()["note"]
        return note_ch, note_en


    def send_message(self,template_id, content):
        # 获取accessToken
        access_token = self.get_access_token()
        # 接收的用户
        to_user = myself
        url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={}".format(access_token)
        data = {
            "touser": to_user,
            "template_id": template_id,
            "url": "http://weixin.qq.com/download",
            "topcolor": "#FF0000",
            "data": {
                "content": {
                    "value": content,
                    "color": "#00FFFF"
                }
            }
        }
        headers = {
            'Content-Type': 'application/json',
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) '
                          'AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36'
        }
        response = post(url, headers=headers, json=data)
        print(response.text)


    # # 公众号推送消息
    # send_message(self, accessToken, "")
