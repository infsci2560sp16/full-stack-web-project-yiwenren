<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>setting</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./stylesheets/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            
            <form id="searchForm" >
            <input id="search" type="text" placeholder="search">
            <input id="searchButton" type="submit" title="search" value="search">
        </form>
            <h1>NEVERLAND</h1> 
        </div>
        <div id="headMenu">
         <ul>  
            
                <li><a href="index.html">Home</a></li>
                <li><a href="Post.html">Post</a></li>
                <li><a href="like.html">Like</a></li>
                <li class="extra"><a href="Following.html" style="width: 150px">Following</a></li>
                <li class="extra"><a href="Setting.html" >SETTING</a></li>
         </ul> 
        </div>
        
        <div class="profile">
            <a href="Setting.html"><img src="image/33.png" alt="profile photo" width="90" height="90"></a>
            <h2 style="margin: 0px">Emma</h2>
            <h2 style="margin: 0px; font-size: 15px;"><a href="register.html">Log Out</a></h2>
        </div>  
        
        
        <table id="setting">
            <tr><td>Name</td></tr>
            <tr><td id="setName"><input type="text" title="please enter your name" required size="30"></td></tr>
            <tr><td>Introduction</td></tr>
            <tr><td id="setIntr"><textarea rows="10" cols="50" title="please enter your introduction" placeholder="please enter your introduction here~" style="font-size: 18px"></textarea></td></tr>
            <tr>
                <td><input id="setCancel" type="button" value="cancel" onclick="javascript:window.location.href='http://localhost:8383/project1/index.html'">
                <input id="setSubmit" type="button" value="submit" onclick="set()"></td></tr>
        </table>
        
        <div id="footer">
            <p>Copyright &copy; Yiwen Ren. Allrights reserved.</p>
        </div>
    </body>
</html>
