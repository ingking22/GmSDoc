/**
 * Ajax 호출 처리 부분
 */

$.ajaxSetup({

});


function ajaxReqAsync(url , parameter , callback ) {

    if(parameter == null || parameter == "")
        parameter = {};

    $.ajax({
       type:"POST",
       url : url ,
       async : true,
       data : JSON.stringify(parameter) ,
       contentType: "application/json; charset=utf-8",
       dataType : "json",
       success : function(data) {
            console.log(getFuncName() + " success data=" + data);

            callback(data);
       } ,
       error : function(xhr) {
            console.log(getFuncName() + " error xhr=" +  xhr);

       } ,
       complete : function(data,textStatus) {
            console.log(getFuncName() + " complete data=" + data);
            console.log(getFuncName() + " complete data=" + textStatus);
       }
    });

}


function ajaxReqSync(url , parameter , callback ) {

    $.ajax({
       type:"POST",
       url : url ,
       async : false,
       data : JSON.stringify(parameter) ,
       contentType: "application/json; charset=utf-8",
       dataType : "json",
       success : function(data) {
            console.log(getFuncName() + " success data=" + data);

            if(callback == undefined || callback == null || callback == "")
                return data;
            else
                callback(data);

       } ,
       error : function(xhr) {
            console.log(getFuncName() + " error xhr=" +  xhr);

       } ,
       complete : function(data,textStatus) {
            console.log(getFuncName() + " complete data=" + data);
            console.log(getFuncName() + " complete data=" + textStatus);
       }
    });

}


function getFuncName() {
    return getFuncName.caller.name;
}



