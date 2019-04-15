<%--
  Created by IntelliJ IDEA.
  User: 13455
  Date: 2017/1/10
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>博雅领航教育咨询（北京）有限公司</title>
    <meta name="keywords" content="博雅领航教育咨询（北京）有限公司">
    <meta name="description" content="博雅领航教育咨询（北京）有限公司">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/ky.ico">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min.css" rel="stylesheet">

</head>

<body>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins emp">
                <div class="ibox-title row">
                    <div class="col-sm-4 col-sm-offset-5">
                        <h2>添加大学信息</h2>
                    </div>
                    <a class="fa fa-close pull-right"  data-dismiss="modal" href="javascript:history.go(-1);"></a>
                </div>
                <div class="ibox-content">
                    <div class="row m-t-md">
                        <h4>基本信息</h4>
                        <hr />
                    </div>
                    <div class="row m-t-md">
                        <div class="form-group col-sm-4">
                            <label for="picLink">校徽</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <img id="picLinkImg" src="#" style="height: 40px; width: 40px"/>
                            <input type="hidden" id="picLink" name="picLink" value="" />
                            <hr/>
                            <form id="uploadForm1" enctype="multipart/form-data">
                                <input id="picLinkImg1" type="file" name="file" style="float: left;" />
                                <button id="uploadImg" type="button" class="btn btn-primary">校徽上传</button>
                            </form>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="picClickLink">简介</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a id="picClickLinka" href="" target="_blank" >简介链接：</a>
                            <input type="text" id="picClickLink" name="picClickLink" value="" readonly />
                            <hr/>
                            <form id="uploadForm2" enctype="multipart/form-data">
                                <input id="picClickLink1" type="file" name="file" style="float: left;" />
                                <button id="uploadJianJie" type="button" class="btn btn-primary">简介上传</button>
                            </form>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="egistrationConditionLink">报名条件</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a id="egistrationConditionLinka" href="" target="_blank" >报名条件链接：</a>
                            <input type="text" id="egistrationConditionLink" name="egistrationConditionLink" value="" readonly />
                            <hr/>
                            <form id="uploadForm3" enctype="multipart/form-data">
                                <input id="egistrationConditionLink1" type="file" name="file" style="float: left;" />
                                <button id="uploadTiao" type="button" class="btn btn-primary">报名条件上传</button>
                            </form>
                        </div>
                    </div>
                    <form role="form" class="form-inline m-t" id="addp1">
                        <div class="row">
                            <div class="form-group col-sm-4">
                                <label for="schoolName">大学名称</label>
                                <input type="text" placeholder="请输入大学名称" id="schoolName" class="form-control" name="schoolName" value="">
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="registrationTime">报名时间</label>
                                <input type="text" id="registrationTime" class="form-control" name="registrationTime" placeholder="请输入报名时间" value="" >
                            </div>
                        </div>
                        <div class="row m-t-md">
                            <div class="form-group col-sm-4 col-sm-offset-4">
                                <button class="btn btn-primary" type="button" id="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/iCheck/icheck.min.js"></script>
</body>

<script>
    $(document).ready(function() {
        //员工添加
        $("#addp1 button#submit").click(function(){
            var json = '{"schoolName":"' + $("#schoolName").val() + '", "picLink":"' + $("#picLink").val() + '' +
                    '", "picClickLink":"' + $("#picClickLink").val() + '", "registrationTime":"'+ $("#registrationTime").val() +'' +
                    '", "registrationConditionLink":"' + $("#egistrationConditionLink").val() + '"}';
            console.log(json)
            $.ajax({
                type:"post",
                url:"add",
                contentType:"application/json;charset=utf-8",
                data:json,
                success:function(data){
                    alert(data.msg);
                    location.href="index";
                },
                error:function(data){
                    alert(data.msg);
                }
            });
        });


        $("#uploadImg").click(function() {
            var foData = new FormData($('#uploadForm1')[0])
            console.log(foData)
            $.ajax({
                url: 'http://localhost:8080/university/driverUpload',
                type: 'POST',
                data: foData,
                cache: false,
                processData: false,
                contentType: false,
                success:function(data){
                    console.log(data.url)
                    var url = "../" + data.url;
                    console.log(url)
                    $('#picLinkImg').attr("src", url)
                    $('#picLink').val(data.url)
//                    location.reload();
                },
                error:function(data){
                    console.log(data)
                    alert("失败");
                }
            });
        });

        $("#uploadJianJie").click(function() {
            var foData = new FormData($('#uploadForm2')[0])
            console.log(foData)
            $.ajax({
                url: 'http://localhost:8080/university/driverUpload',
                type: 'POST',
                data: foData,
                cache: false,
                processData: false,
                contentType: false,
                success:function(data){
                    console.log(data.url)
                    var url = "../" + data.url;
                    console.log(url)
                    $('#picClickLinka').attr("href", url)
                    $('#picClickLink').val(data.url)
                    alert("成功");
//                        location.reload();
                },
                error:function(data){
                    console.log(new FormData(data))
                    alert("失败");
                }
            });
        });

        $("#uploadTiao").click(function() {
            var foData = new FormData($('#uploadForm3')[0])
            console.log(foData)
            $.ajax({
                url: 'http://localhost:8080/university/driverUpload',
                type: 'POST',
                data: foData,
                cache: false,
                processData: false,
                contentType: false,
                success:function(data){
                    console.log(data.url)
                    var url = "../" + data.url;
                    console.log(url)
                    $('#egistrationConditionLinka').attr("href", url)
                    $('#egistrationConditionLink').val(data.url)
                    alert("成功");
//                        location.reload();
                },
                error:function(data){
                    console.log(new FormData(data))
                    alert("失败");
                }
            });
        });
    });
</script>

</html>
