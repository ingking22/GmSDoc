<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="/img/icons/icon-48x48.png" />

    <link rel="canonical" href="https://demo-basic.adminkit.io/" />

    <title>문서반출 시스템 테스트</title>

    <link href="/css/app.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
    <div class="wrapper">

        <div class="main">
            <nav class="navbar navbar-expand navbar-light navbar-bg">
                <a class="sidebar-toggle js-sidebar-toggle">
          <i class="hamburger align-self-center"></i>
        </a>

                <div class="navbar-collapse collapse">
                    <ul class="navbar-nav navbar-align">
                        <li class="nav-item dropdown">
                            <a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
                                <div class="position-relative">
                                    <i class="align-middle" data-feather="bell"></i>
                                    <span class="indicator">4</span>
                                </div>
                            </a>
                            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="alertsDropdown">
                                <div class="dropdown-menu-header">
                                    4 New Notifications
                                </div>
                                <div class="list-group">
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <i class="text-danger" data-feather="alert-circle"></i>
                                            </div>
                                            <div class="col-10">
                                                <div class="text-dark">Update completed</div>
                                                <div class="text-muted small mt-1">Restart server 12 to complete the update.</div>
                                                <div class="text-muted small mt-1">30m ago</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <i class="text-warning" data-feather="bell"></i>
                                            </div>
                                            <div class="col-10">
                                                <div class="text-dark">Lorem ipsum</div>
                                                <div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate hendrerit et.</div>
                                                <div class="text-muted small mt-1">2h ago</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <i class="text-primary" data-feather="home"></i>
                                            </div>
                                            <div class="col-10">
                                                <div class="text-dark">Login from 192.186.1.8</div>
                                                <div class="text-muted small mt-1">5h ago</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <i class="text-success" data-feather="user-plus"></i>
                                            </div>
                                            <div class="col-10">
                                                <div class="text-dark">New connection</div>
                                                <div class="text-muted small mt-1">Christina accepted your request.</div>
                                                <div class="text-muted small mt-1">14h ago</div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="dropdown-menu-footer">
                                    <a href="#" class="text-muted">Show all notifications</a>
                                </div>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-icon dropdown-toggle" href="#" id="messagesDropdown" data-bs-toggle="dropdown">
                                <div class="position-relative">
                                    <i class="align-middle" data-feather="message-square"></i>
                                </div>
                            </a>
                            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="messagesDropdown">
                                <div class="dropdown-menu-header">
                                    <div class="position-relative">
                                        4 New Messages
                                    </div>
                                </div>
                                <div class="list-group">
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <img src="/img/avatars/avatar-5.jpg" class="avatar img-fluid rounded-circle" alt="Vanessa Tucker">
                                            </div>
                                            <div class="col-10 ps-2">
                                                <div class="text-dark">Vanessa Tucker</div>
                                                <div class="text-muted small mt-1">Nam pretium turpis et arcu. Duis arcu tortor.</div>
                                                <div class="text-muted small mt-1">15m ago</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <img src="/img/avatars/avatar-2.jpg" class="avatar img-fluid rounded-circle" alt="William Harris">
                                            </div>
                                            <div class="col-10 ps-2">
                                                <div class="text-dark">William Harris</div>
                                                <div class="text-muted small mt-1">Curabitur ligula sapien euismod vitae.</div>
                                                <div class="text-muted small mt-1">2h ago</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <img src="/img/avatars/avatar-4.jpg" class="avatar img-fluid rounded-circle" alt="Christina Mason">
                                            </div>
                                            <div class="col-10 ps-2">
                                                <div class="text-dark">Christina Mason</div>
                                                <div class="text-muted small mt-1">Pellentesque auctor neque nec urna.</div>
                                                <div class="text-muted small mt-1">4h ago</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="row g-0 align-items-center">
                                            <div class="col-2">
                                                <img src="/img/avatars/avatar-3.jpg" class="avatar img-fluid rounded-circle" alt="Sharon Lessman">
                                            </div>
                                            <div class="col-10 ps-2">
                                                <div class="text-dark">Sharon Lessman</div>
                                                <div class="text-muted small mt-1">Aenean tellus metus, bibendum sed, posuere ac, mattis non.</div>
                                                <div class="text-muted small mt-1">5h ago</div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="dropdown-menu-footer">
                                    <a href="#" class="text-muted">Show all messages</a>
                                </div>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                <i class="align-middle" data-feather="settings"></i>
              </a>

                            <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                <img src="/img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Charles Hall" /> <span class="text-dark">Charles Hall</span>
              </a>
                            <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="pages-profile.html"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
                                <a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="pie-chart"></i> Analytics</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="index.html"><i class="align-middle me-1" data-feather="settings"></i> Settings & Privacy</a>
                                <a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="help-circle"></i> Help Center</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Log out</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

<main class="content">
<form id="" method="post" action="">
 <div class="container-fluid p-0" style="width:50%;">


  <div class="card" style="flex-direction: inherit;">
   <div class="card-header">
     <h5 class="card-title mb-0">파일등록</h5>
   </div>
   <div class="card-body" style="width:80%;flex: inherit;">
        <div class="mb-3">
            <button type="button" class="btn btn-primary" style="margin-right:1%" id="htmlAttach">찾아보기</button>
            <button type="button" class="btn btn-primary" style="margin-right:1%" id="agentAttach">Agent를 이용한 파일 업로드</button>
            <button type="button" class="btn btn-primary" style="margin-right:1%" id="downloadTest">파일다운로드테스트</button>
            <button type="button" class="btn btn-primary" >파일 삭제</button>
        </div>
   </div>


  </div>

  <div class="card" style="flex-direction: inherit;">
  <div class="card-body" style="width:80%;flex: inherit;">

        <div class="mb-3">
                                    <table class="table mb-0" id="tableFileList">
                                            <thead>
                                                <tr>
                                                    <td>체크</td>
                                                    <td>파일명</td>
                                                    <td>파일크기</td>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>
        </div>
  </div>
  </div>
 </div>

 <div id="divFileList">
 </div>
</form>
</main>

        </div>
    </div>
<script src="/js/app.js"></script>
<script src='/js/jquery/jquery-3.7.0.min.js'></script>
<script src='/js/jquery-ui-1.13.2.custom/jquery-ui.min.js'></script>
<script src='/js/jquery-File-Upload-master/jquery.fileupload.js'></script>

<script type="text/javascript">

var fileIdx = 0;

$(document).ready(function() {

    initEvent();

});


function initEvent() {
    //찾아보기 버튼 클릭 시에
    $("#htmlAttach").on("click",function() {

        $("<input type=\"file\" id=\"fileUpload" + fileIdx + "\" name=\"files\""
                + "style=\"opacity:0;filter:alpha(opacity=0)\" />").appendTo("#divFileList");

        $("#fileUpload" + fileIdx.toString()).fileupload({
            url : "/File/FileUploadTest",
            add : function(e,data) {
               $("<tr>"
                    + "<td><input type=\"checkbox\" id=\"chk" + fileIdx + "\">" + "</td>"
                    + "<td id=\"tdFileUpload" + fileIdx.toString() + "\">" + data.files[0].name + "</td>"
                    + "<td id=\"tdFileProgress" + fileIdx.toString() + "\">" + data.files[0].size + "</td>"
               ).appendTo("#tableFileList").find("tbody");

               fileIdx++;
               //alert("submit");
               data.submit();

            } ,
            progress : function(e,data) {
                let progress = parseInt((data.loaded / data.total) * 100 ,10);
                console.log(progress);
                $("#tdFileProgress" + fileIdx.toString()).text(progress.toString() + "%");
            }

//             data:function(e,data) {
//                 console.log("Upload Finished");
//             }
        });


        $("#fileUpload" + fileIdx.toString()).click();

    });

    //Agent 이용 버튼 클릭 시에
    $("#agentAttach").on("click",function() {
        // 1. 서버에서 Generate 된 ID를 가져온다.
        let genID = "${tempGenID}";

        $.ajax({
            type:"post",
            url : "http://localhost:39394/command=uploadFile",
            contentType: "application/json; charset=utf-8",
            dataType : "json",
            data : {
                uploadURL: encodeURI("/File/FileUploadTest"),
                generateID : genID
            },
            success : function(data) {
                console.log(data);

                try {
                    //alert(data.result);
                    if(data.result == "SUCCESS") {
                        selectUploadTempFile();
                    }

                } catch(exception) {

                }

            } ,
            error : function(xhr) {
                console.log(xhr);
            } ,
            complete : function(data,textStatus) {
                console.log(data);
                console.log(textStatus);
            }
        });

    });

    // 다운로드 테스트 진행

    $("#downloadTest").on("click", function() {

        $.ajax({
            type:"post",
            url : "http://localhost:39394/command=downloadFile",
            contentType: "application/json; charset=utf-8",
            data : {
                downloadURL: encodeURI("/File/FileDownLoadTest")
            },
            success : function(data) {
                console.log(data);
            } ,
            error : function(xhr) {
                console.log(xhr);
            } ,
            complete : function(data,textStatus) {
                console.log(data);
                console.log(textStatus);
            }
        });

    });

    /*
    $("#downloadTest").on("click", function() {
        console.log("start");
        let startTime = new Date().getTime();


        $.ajax({
            url : "/File/FileDownLoadTest",
            type : "GET",
            cache : false,
            xhrFields : {
                responseType : "blob"
            }
        }).done(function(blob , status , xhr) {
               //check for filename
               let fileName = "";
               let disposition = xhr.getResponseHeader("Content-Disposition");

               if(disposition && disposition.indexOf("attachment") !== -1) {
                   let filenameRegex = /filename[^;=\n]*=((['"]).*?\2[^;\n]*)/;
                   let matches = filenameRegex.exec(disposition);

                   if(matches != null && matches[1]) {
                       fileName = decodeURI(matches[1].replace(/['"]/g,""));
                   }
               }

               //for IE
               if(window.navigator && window.navigator.msSaveOrOpenBlob) {
                    window.navigator.msSaveOrOpenBlob(blob , fileName);
               } else {
                   let URL = window.URL || window.webkitURL;
                   let downloadUrl = URL.createObjectURL(blob);

                   if(fileName) {
                       let a = document.createElement("a");

                       //for safari
                       if(a.download === undefined)
                           window.location.href = downloadUrl;
                       else {
                           a.href = downloadUrl;
                           a.download = fileName;
                           document.body.appendChild(a);
                           a.click();
                       }
                   } else
                       window.location.href = downloadUrl;
               }


               let endTime = new Date().getTime();
               console.log(endTime - startTime);
               console.log("end");
        });

    });
    */
}

function selectUploadTempFile() {

    //1. Ajax 호출 진행 [ 임시 파일 등록 목록 ]
    $.ajax({
        type:"post",
        url : "/DTC/RequestUploadFileTempList",
        contentType: "application/json; charset=utf-8",
        dataType : "json",
        data : JSON.stringify({"tempfileid" : "${tempGenID}"}),
        success : function(data) {

            $("#tableFileList").find("tbody").empty();

            for(let i = 0 ; i < data.length ; i++) {


                $("<tr>"
                        + "<td><input type=\"checkbox\" id=\"chk" + fileIdx + "\">" + "</td>"
                        + "<td id=\"tdFileUpload" + fileIdx.toString() + "\">" + data[i].filename + "</td>"
                        + "<td id=\"tdFileProgress" + fileIdx.toString() + "\">" + data[i].filesize + "</td>"
                   ).appendTo("#tableFileList").find("tbody");
            }
        } ,
        error : function(xhr) {
            console.log(xhr);
        } ,
        complete : function(data,textStatus) {
            console.log(data);
            console.log(textStatus);
        }
    });

}


</script>

</body>


</html>