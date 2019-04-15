<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <link href="${pageContext.request.contextPath}/static/css/plugins/footable/footable.core.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min.css" rel="stylesheet">
    <%--<base target="_blank">--%>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>大学信息</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link" title="折叠">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a href="insert" target="_self" class='cha'  data-toggle='modal' data-target='#myModal' title="添加大学">
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表格...">
                    <table id="employee" class="footable table table-stripped toggle-arrow-tiny" data-page-size="8" data-filter=#filter>
                        <thead>
                        <tr>
                            <th data-toggle="true">大学编号</th>
                            <th>大学名称</th>
                            <th>校徽</th>
                            <th>点击校徽显示的pdf</th>
                            <th>报名时间</th>
                            <th>报名条件</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="5">
                                <ul class="pagination pull-right"></ul>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
                <input type="hidden" id="index_data_update" name="index_data_update" value="{a:'1'}" />
                <div class="ibox ">
                    <div class="ibox-content">
                        <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content animated bounceInRight">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/footable/footable.all.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/content.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/empControl.js"></script>

<script>
    $(document).ready(function(){
        $(".footable").footable();
        $(".footable2").footable()
        params = {};
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/university/getAll",
            data:JSON.stringify(params),
            async:false,
            contentType:"application/json;charset=UTF-8",
            success:function(data){
                showEm(data);
                console.log(data);
            },
            error:function(data){
                alert(data.isSuccess)
            }
        });
        function showEm(data){
            tbody=$("#employee>tbody");
            for ( var i =0;i< data.rows.length;i++) {
                var tr=$("<tr class='dc_style'></tr>").appendTo(tbody);
                var obj = data.rows[i];
                var td1=$("<td>"+obj.id+"</td>").appendTo(tr);
                var td2=$("<td>"+obj.schoolName+"</td>").appendTo(tr);
                var td3=$("<td>" + "<img src='/" + obj.picLink + "' style='height: 40px; width: 40px' />" +"</td>").appendTo(tr);
                var td4=$("<td>" + "<a href='/" + obj.picClickLink + "' target='_blank' >简章</a>" + "</td>").appendTo(tr);
                var td5=$("<td>" + obj.registrationTime + "</td>").appendTo(tr);
                var td8=$("<td>" + "<a href='/" + obj.registrationConditionLink + "' target='_blank' >报名条件</a>" + "</td>").appendTo(tr);
                var tdcon=$("<td><a href='update' class='cha'  data-toggle='modal' data-target='#myModal' onclick='edit("+obj.id+")'><i class='fa fa-edit text-navy'></i> 修改</a><a href='#' onclick='dlt("+obj.id+")'><i class='fa fa-close text-danger'></i> 删除</a></td>").appendTo(tr);
            }
        }
    });
    function edit(id){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/university/findById",
            data:JSON.stringify({"id":id}),
            contentType:"application/json;charset=UTF-8",
            success:function(data){
                $("#index_data_update").val(JSON.stringify(data))
            },
            error:function(data){
                alert(data.isSuccess);
            }
        });
    }
    function dlt(id){
        if(confirm("确认删除吗")){
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/university/delete",
                data:JSON.stringify({"id":id}),
                contentType:"application/json;charset=UTF-8",
                success:function(data){
                    alert('删除成功');
                    location.href="index"
                },
                error:function(data){
                }
            });
        }
    }
</script>
</body>
</html>