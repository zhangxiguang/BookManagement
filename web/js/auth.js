$(document).ready(function () {
    $('#myTabs a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })

    $("#submit1").click(function () {
        var bookname = $("#inputBook1").val();
        var bookauth = $("#inputBook2").val();
        var bookpublic = $("#inputBook3").val();
        var bookclass = $("#inputBook4").val();

        console.log(bookname, bookauth, bookpublic, bookclass)
        if (bookname.length != 0 && bookauth.length != 0 && bookpublic != 0 && bookclass.length != 0) {
            $.get("/bookServlet?method=addBook&bookname=" + bookname + "&bookauth=" + bookauth + "&bookpublic=" + bookpublic + "&bookclass=" + bookclass, function () {
                alert("图书添加成功")
            })

        }

    })

    $('body').on('click', '#submit2', function () {
        var fileObj = document.getElementById("upfile").files[0]; // 获取文件对象

        // console.log(fileObj)

        var FileController = "/bookServlet?method=upxml";// 接收上传文件的后台地址

        var form = new FormData();
        form.append("file", fileObj);                           // 文件对象


        var xhr = new XMLHttpRequest();

        xhr.open("post", FileController, true);

        xhr.onload = function () {

            alert("添加成功")
            // console.log("添加成功")

        };

        xhr.send(form);
    })

    // $("body").delegate('#delButton','click', function () {
    //         alert("tet")
    //         var bookname = $("#delBook1").val()
    //         var bookid = $("#delBook2").val()
    //
    //         console.log(bookname, bookid)
    //
    //         if (bookname.length == 0 && bookid.length == 0) {
    //             alert("请输入任意一项信息，进行删除！")
    //         }
    //         else if (bookname.length != 0 && bookid.length != 0) {
    //             alert("请输入任意一项信息，进行删除！")
    //         }
    //         else if (bookname.length != 0 && bookid.length == 0) {
    //             $.get("/bookServlet?method=delBook1&bookname=" + bookname, function () {
    //                 alert("图书名称:" + bookname + ",删除成功！")
    //             })
    //         }
    //         else if (bookname.length == 0 && bookid.length != 0) {
    //             $.get("/bookServlet?method=delBook2&bookid=" + bookid, function () {
    //                 alert("图书编号:" + bookid + ",删除成功！")
    //             })
    //
    //         }
    // })


});