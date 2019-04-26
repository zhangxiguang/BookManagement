<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>图书管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="browsermode" content="application">
    <meta name="x5-fullscreen" content="true">
    <meta name="x5-page-mode" content="app">

    <script src="js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="css/auth.css">
    <script src="js/auth.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js" charset="utf-8"></script>
</head>
<body>
<div class="container">
    <table>
        <tr>
            <td>
                欢迎您:
            </td>
            <td>
                ${sessionScope.loginuesr.nickname} <span><a href="#">安全退出</a></span>
            </td>
        </tr>
    </table>
</div>
<div class="container" style="padding-top: 80px">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">增加图书</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">删除图书</a></li>
        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">修改图书</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">查找图书</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <!--增加图书-->
        <div role="tabpanel" class="tab-pane active container" id="home" style="padding-top: 40px">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputBook1" class="col-sm-2 control-label">图书名称(必填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputBook1" placeholder="图书名称">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputBook2" class="col-sm-2 control-label">图书作者(必填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputBook2" placeholder="图书作者">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputBook3" class="col-sm-2 control-label">图书出版社(必填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputBook3" placeholder="图书出版社">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputBook4" class="col-sm-2 control-label">图书类别(必填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputBook4" placeholder="图书类别">
                    </div>
                </div>

            </form>

            <form name="upxml" action="/bookServlet?method=upxml" method="post" enctype="multipart/form-data">
                <div class="container">
                    <span style="font-size: 14px;color: dodgerblue;float: left;">或者你可以直接选择xml文件进行导入哦</span>
                    <input id="upfile" type="file" name="xmlfile"/>

                </div>

            </form>

            <button id="submit2" type="button" class="btn btn-success">提交文件</button>
            <button id="submit1" type="button" class="btn btn-success">提交数据</button>

            <button type="button" class="btn btn-danger">取消</button>
        </div>


        <!--删除图书-->
        <div role="tabpanel" class="tab-pane  container" id="profile">
            <form class="form-horizontal">
                <span style="font-size: 14px;color: red">请任意输入其中一项信息，进行删除</span>
                <div class="form-group">
                    <label for="delBook1" class="col-sm-2 control-label">图书名称(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="delBook1" placeholder="图书名称">
                    </div>
                </div>

                <div class="form-group">
                    <label for="delBook2" class="col-sm-2 control-label">图书编号(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="delBook2" placeholder="图书编号">
                    </div>
                </div>
            </form>

            <button id="delButton" type="button" class="btn btn-success">确认删除</button>
            <button type="button" class="btn btn-danger">取消删除</button>
            <script>
                $("body").delegate('#delButton','click', function () {
                    // alert("tet")
                    var bookname = $("#delBook1").val()
                    var bookid = $("#delBook2").val()

                    console.log(bookname, bookid)

                    if (bookname.length == 0 && bookid.length == 0) {
                        alert("请输入任意一项信息，进行删除！")
                    }
                    else if (bookname.length != 0 && bookid.length != 0) {
                        alert("请输入任意一项信息，进行删除！")
                    }
                    else if (bookname.length != 0 && bookid.length == 0) {
                        $.get("/bookServlet?method=delBook1&bookname=" + bookname, function () {
                            $("#delBook1").val("")
                            alert("图书名称:" + bookname + ",删除成功！")
                        })
                    }
                    else if (bookname.length == 0 && bookid.length != 0) {
                        $.get("/bookServlet?method=delBook2&bookid=" + bookid, function () {
                            $("#delBook2").val("")
                            alert("图书编号:" + bookid + ",删除成功！")
                        })

                    }
                })
            </script>
        </div>




        <!--修改图书-->
        <div role="tabpanel" class="tab-pane" id="messages">
            <form class="form-horizontal">
                <span style="font-size: 14px;color: red">请输入图书编号，确认图书信息，进行修改</span>
                <div class="form-group">
                    <label for="modBook" class="col-sm-2 control-label">图书编号(必填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook" placeholder="图书编号">
                    </div>
                </div>
                <span style="font-size: 14px;color: red">您要修改的图书信息如下：</span>
                <table class="table table-bordered">
                    <tr>
                        <td>图书编号</td>
                        <td>图书名称</td>
                        <td>图书作者</td>
                        <td>图书出版社</td>
                        <td>图书类别</td>
                        <td>借出时间</td>
                        <td>归还时间</td>
                        <td>图书状态</td>
                    </tr>
                    <tr>
                        <td id="modInfo1"></td>
                        <td id="modInfo2"></td>
                        <td id="modInfo3"></td>
                        <td id="modInfo4"></td>
                        <td id="modInfo5"></td>
                        <td id="modInfo6"></td>
                        <td id="modInfo7"></td>
                        <td id="modInfo8"></td>
                    </tr>
                </table>
                <span style="font-size: 14px;color: red">请选择您要修改的信息</span>
                <div class="form-group">
                    <label for="modBook11" class="col-sm-2 control-label">图书名称(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook11" placeholder="图书名称">
                    </div>
                </div>

                <div class="form-group">
                    <label for="modBook12" class="col-sm-2 control-label">图书作者(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook12" placeholder="图书作者">
                    </div>
                </div>

                <div class="form-group">
                    <label for="modBook13" class="col-sm-2 control-label">图书出版社(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook13" placeholder="图书出版社">
                    </div>
                </div>

                <div class="form-group">
                    <label for="modBook14" class="col-sm-2 control-label">图书类别(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook14" placeholder="图书类别">
                    </div>
                </div>

                <div class="form-group">
                    <label for="modBook15" class="col-sm-2 control-label">图书借出时间(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook15" placeholder="图书借出时间">
                    </div>
                </div>

                <div class="form-group">
                    <label for="modBook16" class="col-sm-2 control-label">图书归还时间(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook16" placeholder="图书归还时间">
                    </div>
                </div>

                <div class="form-group">
                    <label for="modBook17" class="col-sm-2 control-label">图书状态(选填项)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="modBook17" placeholder="图书状态">
                    </div>
                </div>

            </form>

            <button id="modButton" type="button" class="btn btn-success">确认修改</button>
            <button type="button" class="btn btn-danger">取消修改</button>
            <script>
                $("body").delegate('#modButton','click', function () {
                    // alert("tet")
                    var bookname = $("#modBook1").val()
                    var bookid = $("#modBook2").val()

                    console.log(bookname, bookid)

                    if (bookname.length == 0 && bookid.length == 0) {
                        alert("请输入任意一项信息，进行修改！")
                    }
                    else if (bookname.length != 0 && bookid.length != 0) {
                        alert("请输入任意一项信息，进行修改！")
                    }
                    else if (bookname.length != 0 && bookid.length == 0) {
                        $.get("/bookServlet?method=delBook1&bookname=" + bookname, function () {
                            $("#delBook1").val("")
                            alert("图书名称:" + bookname + ",修改成功！")
                        })
                    }
                    else if (bookname.length == 0 && bookid.length != 0) {
                        $.get("/bookServlet?method=delBook2&bookid=" + bookid, function () {
                            $("#delBook2").val("")
                            alert("图书编号:" + bookid + ",修改成功！")
                        })

                    }
                })
            </script>
        </div>
        <!--查找图书-->
        <div role="tabpanel" class="tab-pane" id="settings">setting</div>
    </div>


</div>
<script>
    $(function () {
        $.post(
            "/bookServlet?method=firstLoad"
        )
    })
</script>
</body>
</html>
