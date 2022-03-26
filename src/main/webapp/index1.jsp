<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/25
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax请求使用json格式的数据</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    function loadDataAjax(){
        $.ajax({
            url: "two",
            dataType: "json",
            success: function (resp) {
                $("#province").empty();
                $.each(resp, function (i, n) {
                    $("#province").append("<option value='" + n.id + "'>" + n.name + "</option>")
                })
            }
        })
    }
    $(function () {
        loadDataAjax();

        $("#province").change(function () {
            var $city = $("#province>option:selected");
            var value =$city.val();
            $.post("dopost",
                {
                    "provinId": value
                }
                ,

                function(resp) {
                $("#city").empty()
                    $.each(resp,function (i, n) {
                        $("#city").append(" <option size='100%'>" + n.name + "</option>")
                    })

                }
                ,
                "json")
        })
    })
</script>

<body>
<p>省市级联查询,使用ajax</p>
<div>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                省份：
            </td>
            <td>
                <select id="province">
                    <option value="0">请选择.....</option>
                </select>
                <input type="button" value="load数据" id="btnLoad" />
            </td>

        </tr>
        <tr>
            <td>城市：</td>
            <td>
                <select id="city">
                    <option value="0">请选择.....</option>
                </select>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
