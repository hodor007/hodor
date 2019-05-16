package com.zp.tbk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: zhengpeng
 * @Date: 2019/4/7 14:59
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("'.*'");
        Matcher matcher = pattern.matcher("var url = 'https://a.m.taobao.com/i577536759382.htm?price=77&sourceType=item&sourceType=item&suid=694fd554-35ec-4293-917e-c68e595a7978&ut_sk=1.XDmNJaeA7TYDAH%2FNPyFPVoUN_21646297_1554609249016.Copy.1&un=28956b9d7bd081ae762ef2865d2eb66f&share_crt_v=1&sp_tk=77+lRkJZdWJ6SWxDUk/vv6U=&cpp=1&shareurl=true&spm=a313p.22.1xn.1024034459898&short_name=h.eZUN6aU';");
        if (matcher.find()) {
            String collegeId = matcher.group(0);
            System.out.println(collegeId);
        }
    }
}
