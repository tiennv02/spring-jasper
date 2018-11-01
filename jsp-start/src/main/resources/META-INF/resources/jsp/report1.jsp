<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 200px;
            background-color: #f1f1f1;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        /* Change the link color on hover */
        li a:hover {
            background-color: #555;
            color: white;
        }
    </style>
    <link href="jsp/jquery-ui.css" rel="stylesheet">
    <script src="jsp/external/jquery/jquery.js"></script>
    <script src="jsp/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#dtNgay" ).datepicker();
            $( "#dtNgay" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
        } );
    </script>
</head>
<body>

<h2>Báo cáo 1</h2>
<div>
    <div style="width: 200px;float: left">
        <ul>
            <li><a href="/report1">Báo cáo 1</a></li>
            <li><a href="/report2">Báo cáo 2</a></li>
            <li><a href="/report3">Báo cáo 3</a></li>
            <li><a href="/report4">Báo cáo 4</a></li>
            <li><a href="/report5">Báo cáo 5</a></li>
            <li><a href="/report6">Báo cáo 6</a></li>
        </ul>
    </div>
    <div style="margin-left:10px;float: left">
        <form method="post" action="report1/viewReport"  target="_blank">
            <table>
                <tr>
                    <td width="200px" style="text-align: right">Cân: </td>
                    <td width="200px">
                        <select id="cbbCa" name="cbbCa" style="width: 200px">
                            <option value="1" selected="true">Ca 1</option>
                            <option value="2">Ca 2</option>
                            <option value="3">Ca 3</option>
                        </select>
                    </td>
                    <td width="200px" style="text-align: right">Ngày tháng: </td>
                    <td width="200px">
                        <input type="text" id="dtNgay" name="dtNgay" data-role="date">
                    </td>
                </tr>
                <tr>
                    <td colspan="4" style="text-align: center;">
                        <input type="submit" value="Xem báo cáo" style="width: 100px; "/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>