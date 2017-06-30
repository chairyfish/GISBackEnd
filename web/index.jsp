<%--
  Created by IntelliJ IDEA.
  User: chairyfish
  Date: 2017/6/24
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接口列表</title>
</head>
<body>

<h2>地大校园房产管理系统接口列表 </h2>

<table>
    <tr>
        <td class="a"><b>接口名称</b></td>
        <td class="b"><b>接口地址</b></td>
        <td class="c"><b>接口字段</b></td>
        <td class="c"><b>接口示例</b></td>
    </tr>
    <tr>
        <td class="a">用户登录</td>
        <td class="b">http://112.74.173.33/GISBackEnd/login</td>
        <td class="c">number,password</td>
        <td class="d"><a href="/GISBackEnd/login?number=20141001143&password=123456">示例</a></td>
    </tr>
    <tr>
        <td class="a">用户注册</td>
        <td class="b">http://112.74.173.33/GISBackEnd/regist</td>
        <td class="c">number,name,password</td>
        <td class="d"><a
                href="/GISBackEnd/regist?number=20141001143&name=董欣怡&password=123456">示例</a></td>
    </tr>
    <tr>
        <td class="a">新增建筑物信息*</td>
        <td class="b">http://112.74.173.33/GISBackEnd/addbuilding</td>
        <td class="c">bname,btype,bdescription,bfunction,bcampus</td>
        <td class="d"><a href="/GISBackEnd/test">示例</a></td>
    </tr>
    <tr>
        <td class="a">bname查询建筑物</td>
        <td class="b">http://112.74.173.33/GISBackEnd/buildingbyname</td>
        <td class="c">bname</td>
        <td class="d"><a href="/GISBackEnd/buildingbyname?bname=体育馆">示例</a></td>
    </tr>
    <tr>
        <td class="a">bid查询建筑物</td>
        <td class="b">http://112.74.173.33/GISBackEnd/buildingbyid</td>
        <td class="c">bid</td>
        <td class="d"><a href="/GISBackEnd/buildingbyid?bid=12">示例</a></td>
    </tr>
    <tr>
        <td class="a">bfunc查询建筑物</td>
        <td class="b">http://112.74.173.33/GISBackEnd/buildingbyfunc</td>
        <td class="c">bfunction</td>
        <td class="d"><a href="/GISBackEnd/buildingbyfunc?bfunction=羽毛球">示例</a></td>
    </tr>
    <tr>
        <td class="a">btype查询建筑物</td>
        <td class="b">http://112.74.173.33/GISBackEnd/buildingbytype</td>
        <td class="c">btype</td>
        <td class="d"><a href="/GISBackEnd/buildingbytype?btype=活动场地">示例</a></td>
    </tr>
    <tr>
        <td class="a">bid查询设备</td>
        <td class="b">http://112.74.173.33/GISBackEnd/equipmentbybid</td>
        <td class="c">bid</td>
        <td class="d"><a href="/GISBackEnd/equipmentbybid?bid=1">示例</a></td>
    </tr>
    <tr>
        <td class="a">新增报修</td>
        <td class="b">http://112.74.173.33/GISBackEnd/addfix</td>
        <td class="c">ename,bname,fhousenumber,uid,ftel,fremark</td>
        <td class="d"><a
                href="/GISBackEnd/addfix?ename=课桌&bname=教三楼&fhousenumber=301&uid=1&ftel=13110002000&fremark=课桌更换">示例</a>
        </td>
    </tr>
    <tr>
        <td class="a">uid获取报修信息</td>
        <td class="b">http://112.74.173.33/GISBackEnd/fixbyuid</td>
        <td class="c">uid</td>
        <td class="d"><a href="/GISBackEnd/fixbyuid?uid=1">示例</a></td>
    </tr>
    <tr>
        <td class="a">查询所有报修信息*</td>
        <td class="b">http://112.74.173.33/GISBackEnd/fixall</td>
        <td class="c">无</td>
        <td class="d"><a href="/GISBackEnd/fixall">示例</a></td>
    </tr>
    <tr>
        <td class="a">报修信息分页查询*</td>
        <td class="b">http://112.74.173.33/GISBackEnd/fixpage</td>
        <td class="c">p(页码)</td>
        <td class="d"><a href="/GISBackEnd/fixpage?p=2">示例</a></td>
    </tr>
    <tr>
        <td class="a">日期范围内的报修信息</td>
        <td class="b">http://112.74.173.33/GISBackEnd/fixbytime</td>
        <td class="c">starttime,endtime,p(页码)</td>
        <td class="d"><a
                href="/GISBackEnd/fixbytime?starttime=2016-01-01&endtime=2016-04-01&p=2">示例</a></td>
    </tr>
    <tr>
        <td class="a">bid查询活动信息</td>
        <td class="b">http://112.74.173.33/GISBackEnd/activitybybid</td>
        <td class="c">bid</td>
        <td class="d"><a href="/GISBackEnd/activitybybid?bid=18">示例</a></td>
    </tr>
    <tr>
        <td class="a">查询某教室今天的状态</td>
        <td class="b">http://112.74.173.33/GISBackEnd/roomstate</td>
        <td class="c">bname,cnumber</td>
        <td class="d"><a href="/GISBackEnd/roomstate?bname=教二楼&cnumber=307">示例</a></td>
    </tr>
    <tr>
        <td class="a">某建筑某节课无课的教室</td>
        <td class="b">http://112.74.173.33/GISBackEnd/emptyclass</td>
        <td class="c">bname,classnum</td>
        <td class="d"><a href="/GISBackEnd/emptyclass?bname=教三楼&classnum=2">示例</a></td>
    </tr>
</table>
</body>

<style>
    .a {
        width: 200px;
    }

    .b {
        width: 450px;
    }

    .c {
        width: 200px;
    }
</style>
</html>
