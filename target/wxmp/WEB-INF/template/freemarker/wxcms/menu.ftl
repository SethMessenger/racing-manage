<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Wechat+ 后台主题UI框架 - 主页</title>
    <meta name="keywords" content="Wechat+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="Wechat+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/res/news/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/res/news/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="/res/news/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="/res/news/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="/res/news/css/animate.min.css" rel="stylesheet">
    <link href="/res/news/css/style.min.css?v=4.0.0" rel="stylesheet">
    <base target="_blank">

    <script src="/res/news/js/jquery.min.js?v=2.1.4"></script>
    <script src="/res/news/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="/res/news/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="/res/news/js/demo/peity-demo.min.js"></script>
    <script src="/res/news/js/content.min.js?v=1.0.0"></script>
    <script src="/res/news/js/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="/res/news/js/plugins/gritter/jquery.gritter.min.js"></script>
    <script src="/res/news/js/plugins/easypiechart/jquery.easypiechart.js"></script>
    <script src="/res/news/js/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="/res/news/js/demo/sparkline-demo.min.js"></script>
    <script>
        $(document).ready(function () {

        }
    </script>
    <!-- 注入腾讯分析服务 http://ta.qq.com/analysis/function -->
<#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>菜单管理</h5>
                    <div class="ibox-tools">
                    </div>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>菜单名称</th>
                            <th>是否启用</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list pagination.items as menuGroup>
                        <tr class="gradeX">
                            <td>${menuGroup_index + 1}</td>
                            <td>${menuGroup.name}</td>
                            <#if menuGroup.enable == 1>
                                <td>是</td>
                            <#else >
                                <td>否</td>
                            </#if>
                            <td class="text-navy">
                                <button class="btn btn-primary" onclick="doDeleteLocal('${menuGroup.id}','${menuGroup.enable}')">删除</button>
                                <button class="btn btn-primary" onclick="">配置</button>
                                <#if menuGroup.enable == 1>
                                    <button class="btn btn-primary" onclick="doPublishMenu()" disabled = disabled>生成微信菜单</button>
                                    <button class="btn btn-primary" onclick="doCancelPublishMenu()">删除微信菜单</button>
                                <#else >
                                    <button class="btn btn-primary" onclick="doPublishMenu()">生成微信菜单</button>
                                    <button class="btn btn-primary" onclick="doCancelPublishMenu()" disabled = disabled>删除微信菜单</button>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th>序号</th>
                            <th>菜单名称</th>
                            <th>是否启用</th>
                            <th>操作</th>
                        </tr>
                        </tfoot>
                    </table>

                </div>
            </div>
        </div>

    </div>
</div>
</body>

<script type="text/javascript">
    function doDeleteLocal(id,enable){
        if(enable == '1'){
            alert("是正在使用的微信账号菜单不能删除");
        }else{
            if(confirm("确定删除本地菜单?")){
                //同步访问
                var result = "";
                $.ajax({
                    url:path + '/wxcms/accountMenuGroup/deleteMenu',
                    type:'POST',
                    async: false,
                    dataType:'json',
                    data:{"id":id},
                    success:function(msg){
                        result = msg;
                    },
                    error:function(msg){
                        alert("删除本地菜单异常");
                    }
                });

                if(result == "1"){
                    alert("删除本地菜单成功");
                    window.location.href = path+"/wxcms/accountMenuGroup/paginationEntityJsp";
                }else{
                    alert("删除本地菜单失败");
                    window.location.href = path+"/wxcms/accountMenuGroup/paginationEntityJsp";
                }
            }
        }
    }
    function doDelete(id){
        if(confirm("确定删除菜单?")){
            window.location.href='<%=path%>/wxcms/accountMenuGroup/delete?id='+id;
        }
    }
    function doPublish(){
        var gid = $('input:radio[name=radio_name]:checked').val();
        if(gid != null && gid != 'undefined'){
            if(confirm("确定生成微信账号菜单?")){
                window.location.href='<%=path%>/wxapi/publishMenu?gid='+gid;
            }
        }else{
            alert("请选择菜单组");
        }
    }

    function doCancel(){
        if(confirm("确定删除微信账号菜单?")){
            window.location.href='<%=path%>/wxapi/deleteMenu';
        }
    }

    //删除微信菜单
    function doCancelPublishMenu(){
        if(confirm("确定删除微信账号菜单?")){
            //同步访问
            var result = "";
            $.ajax({
                url:path + '/wxapi/deletePublicMenu',
                type:'GET',
                async: false,
                dataType:'text',
                data:null,
                success:function(msg){
                    result = msg;
                },
                error:function(msg){
                    alert(msg);
                }
            });

            if(result == "1"){
                alert("删除微信账号菜单成功");
                window.location.href = path+"/wxcms/accountMenuGroup/paginationEntityJsp";
            }else{
                alert(result);
            }

        }
    }



    //添加菜单
    function doPublishMenu(){
        var gid = $('input:radio[name=radio_name]:checked').val();
        if(gid != null && gid != 'undefined'){
            if(confirm("确定生成微信账号菜单?")){
                //确定生成
                doSaveMenu(gid);
            }
        }else{
            alert("请选择菜单组");
        }
    }
    //跳转到后台保存
    function doSaveMenu(gid){
        //同步访问
        var result = "";
        $.ajax({
            url:path + '/wxapi/doPublishMenu',
            type:'POST',
            async: false,
            dataType:'text',
            data:{"gid":gid},
            success:function(msg){
                result = msg;
            },
            error:function(msg){
                alert(msg);
            }
        });

        if(result == "1"){
            alert("微信账号菜单成功");
            window.location.href = path+"/wxcms/accountMenuGroup/paginationEntityJsp";
        }else{
            alert(result);
        }
    }
</script>

</html>