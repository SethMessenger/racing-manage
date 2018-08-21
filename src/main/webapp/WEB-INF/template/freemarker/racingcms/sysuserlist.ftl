<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Racing+ 后台主题UI框架 - 主页</title>
    <meta name="keywords" content="Racing+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="Racing+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

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
    <script src="/res/news/js/plugins/sweetalert/sweetalert.min.js"></script>
    <link href="/res/news/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <!-- 注入腾讯分析服务 http://ta.qq.com/analysis/function -->
<#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>运营用户管理</h5>
                    <div class="ibox-tools">
                    </div>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>联系电话</th>
                            <th>账户余额</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as item>
                        <tr class="gradeX">
                            <td>${item_index + 1}</td>
                            <td>${item.account!}</td>
                            <td>${item.phone!}</td>
                            <td>${item.total!}</td>
                            <td class="text-navy">
                                <button class="btn btn-primary" href="form_basic.html#modal-form" data-toggle="modal" >充值卡券</button>
                                <button class="btn btn-primary" onclick="toUpdateUserAmount()">编辑</button>
                                <button class="btn btn-primary" onclick="toCardLogs('${item.id}')">卡券列表</button>
                            </td>

                        </tr>
                        </#list>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
    <div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 b-r">
                            <h3 class="m-t-none m-b">添加运营账户</h3>

                            <p>运营账户细则如右(⊙o⊙)</p>

                            <form id="addSysForm" role="form" action="#" method="post">
                                <div class="form-group">
                                    <label>账户：</label>
                                    <input type="number" placeholder="请输入用户名" class="form-control" name="account">
                                    <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请使用手机号码</span>
                                </div>
                                <div class="form-group">
                                    <label>密码：</label>
                                    <input type="password" placeholder="请输入密码" class="form-control" name="pwd">
                                </div>
                                <div class="form-group">
                                    <label>重复密码：</label>
                                    <input type="password" placeholder="请重复输入密码" class="form-control" name="confirm_password">
                                    <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>
                                </div>
                                <div class="form-group">
                                    <label>联系电话：</label>
                                    <input type="number" placeholder="请输入您的联系方式" class="form-control" name="phone">
                                </div>
                                <div class="form-group">
                                    <label>关联账户手机号：</label>
                                    <input type="number" placeholder="请输入关联账户手机号" class="form-control" name="rel_phone">
                                </div>
                                <div>
                                    <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="button" onclick="checkForm();"><strong>确认添加</strong>
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <h4>运营账户细则</h4>
                            <p>1、运营账户需要管理员进行添加</p>
                            <p>2、运营账户只有关联客户端用户后才生效</p>
                            <p>3、营运账户权限限于后台进行金币充值，充值数量不能超过关联客户端用户的金币数量</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    function toCardLogs(userUuid) {
        //window.location.href="/racingcms/ruser/listUserLogs?uuid="+userUuid;
        swal({
            title: "二级分销卡券功能待开放",
            text: "请联系管理员开发此功能！"
        });
    }
    function toUpdateUserAmount() {
        swal({
            title: "暂时不支持直接修改用户账户",
            text: "请联系管理员开发此功能！"
        });
    }
    function addSysUserCard(useruuid){
        swal({
            title: "二级分销卡券充值功能待开放",
            text: "请联系管理员开发此功能！"
        });
    }
    function checkForm(){
        $.ajax({
            url:"/racingcms/sysuser/add",
            data:$("#addSysForm").serialize(),
            type:"post",
            dataType : "json",
            success:function(data){//ajax返回的数据
                if("0" == data.errorCode){
                    alert("添加成功");
                    location.reload();
                }else {
                    alert("添加失败");
                }
            }
        });
    }
</script>

</html>