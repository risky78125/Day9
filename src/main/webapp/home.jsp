<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Risky57
  Date: 2017/11/2
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script>

        function clearOption(selectEle) {
            var optionEle = selectEle.getElementsByTagName("option");
            var length = optionEle.length;
            for (var i = 0; i < length; i++) {
                selectEle.removeChild(optionEle[0]);
            }
        }

        function addSelectHeader(selectEle) {
            selectEle.innerHTML = "<option value = '-1'>--请选择--</option>";
        }


        <%--当选择部门的时候会执行--%>
        function onDeptSelected(value) {
            var data = new FormData();
            data.append("deptId", value);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    var json = eval("(" + this.responseText + ")")
                    var postEle = document.getElementById("post");
                    clearOption(postEle);
                    addSelectHeader(postEle)

                    for (var i = 0; i < json.length; i++) {
                        // 创建一个option标签
                        var option = document.createElement("option");
                        // 设置value属性
                        option.setAttribute("value", json[i].id);
                        // 设置文本信息
                        var text = document.createTextNode(json[i].name);
                        // 把文本信息添加到option标签中
                        option.appendChild(text);
                        // 把option标签添加到servers的select中
                        postEle.appendChild(option);
                    }

                }
            });

            xhr.open("POST", "http://localhost:8080/getPosts");

            xhr.send(data);
        }

        function createTD(text) {
            var td = document.createElement("td");
            td.setAttribute("align", "center")
            var textNode = document.createTextNode(text);
            td.appendChild(textNode);
            return td;
        }

        function onClickQuery() {
            var deptId = document.getElementById("department").value;
            var postId = document.getElementById("post").value;
            var data = new FormData();
            data.append("deptId", deptId);
            data.append("postId", postId);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    var json = eval("(" + this.responseText + ")");
                    var tableEle = document.getElementById("staff");
                    var length = tableEle.rows.length
                    for(var i = 0; i < length - 1; i++){
                        tableEle.deleteRow(1);
                    }

                    for (var i = 0; i < json.length; i++) {
                        var tr = document.createElement("tr");

                        tr.appendChild(createTD(json[i].id));
                        tr.appendChild(createTD(json[i].name));
                        tr.appendChild(createTD(json[i].gender));
                        tr.appendChild(createTD(json[i].age));
                        tr.appendChild(createTD(json[i].dept.name));
                        tr.appendChild(createTD(json[i].post.name));

                        tableEle.appendChild(tr);
                    }

                }
            });

            xhr.open("POST", "http://localhost:8080/getStaffs");

            xhr.send(data);
        }

    </script>

</head>
<body>
<h1>欢迎进入本系统</h1>

部门:
<select id="department" onchange="onDeptSelected(value)">
    <option value="-1">--请选择--</option>
    <s:iterator value="departments" var="dept">
        <option value="${dept.id}">${dept.name}</option>
    </s:iterator>
</select>

职位:
<select id="post">
    <option value="-1">--请选择--</option>
</select>

<button onclick="onClickQuery()">查询</button>
<hr/>

<table id="staff" align="center" border="1" cellpadding="2" width="800">
    <tr>
        <th align="center">ID</th>
        <th align="center">姓名</th>
        <th align="center">性别</th>
        <th align="center">年龄</th>
        <th align="center">部门</th>
        <th align="center">职务</th>
    </tr>
    <tbody>

    </tbody>
</table>

</body>
</html>
