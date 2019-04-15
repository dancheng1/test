<%
    //response.sendRedirect(request.getContextPath()+"/index");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>

    <meta charset="utf-8">
    <title>博雅领航教育咨询（北京）有限公司</title>
    <meta name="description" content="博雅领航教育咨询（北京）有限公司">
    <meta name="author" content="www.dancheng.com">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/front/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/front/responsive.css">
    <link rel='stylesheet' href="${pageContext.request.contextPath}/static/css/front/camera.css">

    <link href='${pageContext.request.contextPath}/static/img/front/favicon.ico' rel='icon' type='image/x-icon'/>

    <script type='text/javascript' src='${pageContext.request.contextPath}/static/js/front/jquery.min.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/static/js/front/jquery.easing.1.3.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/static/js/front/camera.min.js'></script>

    <script>
        jQuery(function(){
            jQuery('#camera_wrap').camera({
                height: '400px',
                loader: 'bar',
                pagination: false,
                thumbnails: true
            });
        });
    </script>

</head>
<body>
<!--------------Header--------------->
<header>

    <div class="wrap-header">
        <div id="logo"><a href="#"><img style="height: 70px" src="${pageContext.request.contextPath}/static/img/front/logo.png"/></a></div>
    </div>
</header>

<!--------------Content--------------->
<section id="content">
    <div class="zerogrid">
        <div id="university" class="row block01">

        </div>
    </div>
</section>
<!--------------Footer--------------->
<footer>
    <div class="zerogrid">
        <div class="row block02">
            <section class="col-3">
                <div class="heading"><h2>关于我们</h2></div>
                <div class="content">
                    我们的理念：<br/>
                    教育投入一定要得到回报，以结果为导向<br/>
                    做真正有益于学生的工作，帮助学生顺利升入理想名校！
                </div>
            </section>
        </div>
    </div>
    <div class="copyright">
        <p>Copyright © 2019 - <a href="http://www.pronavi.cn/" target="_blank" title="博雅领航">博雅领航</a></p>
    </div>
</footer>

<script>

    $(document).ready(function(){
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
            tbody = $("#university");
//        <div class="col-1-3">
//                <article>
//                    <a target="_blank" href="blog.html"><img src="${pageContext.request.contextPath}/static/img/front/thumb1.jpg" class="grayscale"/></a>
//                    <h2>北京大学<br><a href=''>报名方式</a></h2>
//                </article>
//            </div>
            for ( var i =0;i< data.rows.length;i++) {
                var obj = data.rows[i];
                var registrationTime = "暂无"
                if(obj.registrationTime != ""){
                    registrationTime = obj.registrationTime;
                }
                var divbody = $("<div class='col-1-3'></div>").appendTo(tbody);
                var articlebody = $("<article></article>").appendTo(divbody);
                var abody = $("<a target='_blank' href='${pageContext.request.contextPath}/" + obj.picClickLink + "'><img src='${pageContext.request.contextPath}/" + obj.picLink + "' class='grayscale'/>" + "</a>").appendTo(articlebody);
                var h2body = $("<h4>" + obj.schoolName + "<br><a target='_blank' href='" + obj.registrationConditionLink + "'>报名条件</a><br/>报名时间：<br/>" + registrationTime + "</h2>").appendTo(articlebody);
            }
        }
    });

</script>

</body>
</html>