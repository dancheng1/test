$(function(){
	//jquery将表单序列化成json
    $.fn.serializeJson=function(){  
        var serializeObj={};  
        var array=this.serializeArray();  
        var str=this.serialize();  
        $(array).each(function(){  
            if(serializeObj[this.name]){  
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);  
                }else{  
                    serializeObj[this.name]=[serializeObj[this.name],this.value];  
                }  
            }else{  
                serializeObj[this.name]=this.value;   
            }  
        });  
        return serializeObj;  
    };  
    $("input[disabled]").css('background','#fff');


    function backNum(data){
        var row = data.rows
        $('#schoolName').val(row.schoolName)
        $('#registrationTime').val(row.registrationTime)
        $('#egistrationConditionLink').val(row.registrationConditionLink)
        $('#picLink').val(row.picLink)
        $('#picClickLink').val(row.picClickLink)
        $('#unId').val(row.id)

        $('#picLinkImg').attr("src", "../" + row.picLink)
        $('#picClickLinka').attr("href", "../" + row.picClickLink)
        $('#egistrationConditionLinka').attr("href", "../" + row.registrationConditionLink)
	}


    var update_str = $("#index_data_update").val();
    var jsonObj = eval('(' + update_str + ')');
    console.log(jsonObj);

    console.log(JSON.stringify(jsonObj));
    if(JSON.stringify(jsonObj) != '{"a":"1"}')
        backNum(jsonObj);


    //员工更新
    $("#addp1 button#submit").click(function(){
        var json = '{"id":"' + $("#unId").val() + '","schoolName":"' + $("#schoolName").val() + '", "picLink":"' + $("#picLink").val() + '' +
            '", "picClickLink":"' + $("#picClickLink").val() + '", "registrationTime":"'+ $("#registrationTime").val() +'' +
            '", "registrationConditionLink":"' + $("#egistrationConditionLink").val() + '"}';
        $.ajax({
            type:'post',
            url:'update',
            contentType:"application/json;charset=utf-8",
            data:json,
            success:function(data){
                console.log(data);
                location.href="index";
            },
            error:function(data){
                alert(data.msg);
                console.log(data);
            }
        })
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
                alert("成功");
//                        location.reload();
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


})
	
