var serverUrl = 'http://localhost:2020';
var searchUserList = [];
var editUserename = "";
var deleteUsername = "";
var searchUsername = "";
var searchNickname = "";
var currentPage;
var pageSize = 10;

//删除用户
function deleteUser(_this) {
    deleteUsername = _this.getAttribute("username")
}

//确定删除用户
function confirmDeleteUser() {
    $.ajax({
            url:serverUrl+ "/system/systemUserService/delete.do?deleteUsername="+deleteUsername,
            type : "Get",
            dataType:'json',
            contentType: "application/json;charset=utf-8",
            success:function(result) {
                console.log(result);
                if(result.flat == true){
                    alert("删除用户成功！")
                }
                searchUserListMethod(searchUsername,searchNickname);
            }
        }
    );
}

//点击编辑，触发的函数，展示被编辑用户的基本信息
function editUserInfo(_this) {
    var username = _this.getAttribute("username")
    var i = _this.getAttribute("indexOfResult")
    editUserename = username;

    var editInfoUsername = document.getElementById("editInfoUsername");
    var editInfoNickname = document.getElementById("editInfoNickname");
    var editInfoPhone = document.getElementById("editInfoPhone");
    var editInfoEmail = document.getElementById("editInfoEmail");
    var editInfoGroupId = document.getElementById("editInfoGroupId");
    var editInfoPosition = document.getElementById("editInfoPosition");
    var editInfoRole = document.getElementById("editInfoRole");
    var active = document.getElementsByName("active");
    var sex = document.getElementsByName("sex");

    editInfoUsername.value = searchUserList[i].username;
    editInfoNickname.value = searchUserList[i].nickname;
    editInfoPhone.value = searchUserList[i].phone;
    editInfoEmail.value = searchUserList[i].email;
    editInfoGroupId.value = searchUserList[i].groupId;
    editInfoPosition.value = searchUserList[i].position;
    editInfoRole.value = searchUserList[i].role;

    var male = document.getElementById("male");
    var female = document.getElementById("female");
    if(searchUserList[i].sex=='男'){
        male.setAttribute("checked","checked");
        female.removeAttribute("checked");
    }else{
        female.setAttribute("checked","checked");
        male.removeAttribute("checked");
    }

    var active = document.getElementById("active");
    var inactive = document.getElementById("inactive");
    if(searchUserList[i].active=='Y'){
        active.setAttribute("checked","checked");
        inactive.removeAttribute("checked");
    }else{
        inactive.setAttribute("checked","checked");
        active.removeAttribute("checked");
    }
}

//编辑完用户信息，点击保存触发的函数
// 1.先检查
// 2.检查通过则发送请求给服务器
function  editInfoSave() {
    var editInfoUsername = document.getElementById("editInfoUsername");
    var editInfoNickname = document.getElementById("editInfoNickname");
    var editInfoPhone = document.getElementById("editInfoPhone");
    var editInfoEmail = document.getElementById("editInfoEmail");
    var editInfoGroupId = document.getElementById("editInfoGroupId");
    var editInfoPosition = document.getElementById("editInfoPosition");
    var editInfoRole = document.getElementById("editInfoRole");
    var editInfoActive = document.getElementsByName("active");
    var editInfoSex = document.getElementsByName("sex");

    var username = editInfoUsername.value;
    var nickname = editInfoNickname.value;
    var phone = editInfoPhone.value;
    var email = editInfoEmail.value;
    var groupId = editInfoGroupId.value;
    var position = editInfoPosition.value;
    var role = editInfoRole.value;
    var active,sex;

    for(var i=0;i<editInfoActive.length;i++){
        if(editInfoActive[i].checked){
            if(editInfoActive[i].value=='active'){
                active='Y';
            }else{
                active='N';
            }
        }
    }
    for(var i=0;i<editInfoSex.length;i++){
        if(editInfoSex[i].checked){
            if(editInfoSex[i].value=='male'){
                sex='男';
            }else{
                sex='女';
            }
        }
    }

    if(strIsNull(username) || strIsNull(nickname)|| strIsNull(phone)|| strIsNull(email)||
        strIsNull(groupId)|| strIsNull(position)|| strIsNull(role)|| strIsNull(active)|| strIsNull(sex)){
        alert("信息没填完整！");
    }else{
        var data = {
            'username':username,
            'nickname':nickname,
            'phone':phone,
            'email':email,
            'groupId':groupId,
            'position':position,
            'role':role,
            'active':active,
            'sex':sex
        };
        $.ajax({
                url:serverUrl+ "/system/systemUserService/update.do/"+editUserename,
                data:JSON.stringify(data),
                type : "POST",
                dataType:'json',
                contentType: "application/json;charset=utf-8",
                success:function(res) {
                    console.log(res);
                    if(res.flag==true){
                        alert("更新用户资料成功！")
                    }else{
                        alert("更新失败，可能是账号名重复了！")
                    }
                    searchUserListMethod(searchUsername,searchNickname);
                }
            }
        );
    }
}

//根据账号关键字、姓名关键字模糊搜索用户列表
function searchUserListMethod(username,nickname) {
    var data = {
        'username':username,
        'nickname':nickname
    }
    $.ajax({
            url:serverUrl+ "/system/systemUserService/find.do",
            data:JSON.stringify(data),
            type : "POST",
            dataType:'json',
            contentType: "application/json;charset=utf-8",
            success:function(result) {
                searchUserList = result.data;
                var html = "";
                for(var i = 0;i<searchUserList.length;i++){
                    var lihtml =
                        '<tr>\n' +
                        '                        <td><a data-toggle="modal" data-target="#showUserModal" href="#" onclick="showUserInfo(this)" indexOfResult='+i+'>'+searchUserList[i].username+'</a></td>\n' +
                        '                        <td>'+searchUserList[i].nickname+'</td>\n' +
                        '                        <td>'+searchUserList[i].sex+'</td>\n' +
                        '                        <td>'+searchUserList[i].groupId+'</td>\n' +
                        '                        <td>'+searchUserList[i].position+'</td>\n' +
                        '                        <td>'+searchUserList[i].phone+'</td>\n' +
                        '                        <td>'+searchUserList[i].email+'</td>\n' +
                        '                        <td>'+searchUserList[i].role+'</td>\n' +
                        '                        <td>'+searchUserList[i].active+'</td>\n' +
                        '                        <td><a data-toggle="modal" data-target="#editUserInfoModal" indexOfResult='+i+' username='+searchUserList[i].username+' onclick="editUserInfo(this)" href="#" id="editInfo">编辑</a><a  data-toggle="modal" data-target="#deleteUserModal" username='+searchUserList[i].username+' onclick="deleteUser(this)" style="color:#CD5555;margin-left: 5px;" href="#"  id="deleteUser">删除</a></td>\n' +
                        '                    </tr>'
                    html += lihtml;
                }

                var userListTable =  document.getElementById("userListTable");
                userListTable.innerHTML = html;
                console.log(result);
                console.log(searchUserList);
            }
        }
    );
}

//展示用户个人信息
function showUserInfo(_this) {
    var i = _this.getAttribute("indexOfResult");

    var userImg = document.getElementById("userImg");
    var imgUsername = document.getElementById("imgUsername");
    var showUsername = document.getElementById("showUsername");
    var showNickname = document.getElementById("showNickname");
    var showPhone = document.getElementById("showPhone");
    var showEmail = document.getElementById("showEmail");
    var showGroupId = document.getElementById("showGroupId");
    var showPosition = document.getElementById("showPosition");
    var showRole = document.getElementById("showRole");
    var showLogDate = document.getElementById("showLogDate");
    var showActive = document.getElementsByName("showActive");
    var showSex = document.getElementsByName("showSex");

    userImg.setAttribute("src",searchUserList[i].img);
    imgUsername.innerHtml = searchUserList[i].username;

    //showUsername.innerHtml = searchUserList[i].username;
    showUsername.innerHtml ="张卫平";
    showNickname.innerHtml = searchUserList[i].nickname;
    showPhone.innerHtml = searchUserList[i].phone;
    showEmail.innerHtml = searchUserList[i].email;
    showGroupId.innerHtml = searchUserList[i].groupId;
    showPosition.innerHtml = searchUserList[i].position;
    showRole.innerHtml = searchUserList[i].role;
    showLogDate.innerHtml = searchUserList[i].logDate;

}

//判读字符串是否为空
function strIsNull(str){
    if (str != null && str != "" && str != undefined) {
        return false;
    }
    return true;
}

$(function () {
    var oList = document.querySelectorAll('.list h2'),
        oHide = document.querySelectorAll('.hide'),
        lastIndex = 0;
    for(var i=0;i<oList.length;i++){
        oList[i].index = i;//自定义属性
        oList[i].isClick = false;
        oList[i].initHeight = oHide[i].clientHeight;
        oHide[i].style.height = '0';
        oList[i].onclick = function () {
            if(this.isClick){
                oHide[this.index].style.display = 'none';
                oList[this.index].isClick = false;
            }
            else{
                oHide[lastIndex].style.display = 'none';
                oHide[this.index].style.display = 'inline';
                oHide[this.index].style.width = '100%';

                oList[lastIndex].isClick = false;
                oList[this.index].isClick = true;
                lastIndex = this.index;
            }
        }
    }


    var searchButton = document.getElementById("searchUser");
    //搜索用户
    searchButton.onclick = function (ev) {
        var username = document.getElementById("username").value;
        var nickname = document.getElementById("nickname").value;
        searchUsername = username;
        searchNickname = nickname;

        searchUserListByPageMethod(1)
    }

});

//增加用户
function  addUserAndSave() {
    var addUsername = document.getElementById("addUsername");
    var addNickname = document.getElementById("addNickname");
    var addPhone = document.getElementById("addPhone");
    var addEmail = document.getElementById("addEmail");
    var addGroupId = document.getElementById("addGroupId");
    var addPosition = document.getElementById("addPosition");
    var addRole = document.getElementById("addRole");
    var addPassword = document.getElementById("addPassword");
    var addActive = document.getElementsByName("addActive");
    var addSex = document.getElementsByName("addSex");

    var username = addUsername.value;
    var nickname = addNickname.value;
    var phone = addPhone.value;
    var email = addEmail.value;
    var groupId = addGroupId.value;
    var position = addPosition.value;
    var role = addRole.value;
    var password = addPassword.value;
    var active,sex;

    for(var i=0;i<addActive.length;i++){
        if(addActive[i].checked){
            if(addActive[i].value=='active'){
                active='Y';
            }else{
                active='N';
            }
        }
    }
    for(var i=0;i<addSex.length;i++){
        if(addSex[i].checked){
            if(addSex[i].value=='male'){
                sex='男';
            }else{
                sex='女';
            }
        }
    }

    if(strIsNull(username) || strIsNull(nickname)|| strIsNull(phone)|| strIsNull(email)||strIsNull(password)||
        strIsNull(groupId)|| strIsNull(position)|| strIsNull(role)|| strIsNull(active)|| strIsNull(sex)){
        alert("信息没填完整！");
    }else{
        $('#addUserModal').modal("hide");
        var data = {
            'username':username,
            'nickname':nickname,
            'phone':phone,
            'email':email,
            'groupId':groupId,
            'position':position,
            'role':role,
            'active':active,
            'sex':sex,
            'password':password,
        };

        $.ajax({
                url:serverUrl+ "/system/systemUserService/add.do",
                data:JSON.stringify(data),
                type : "POST",
                dataType:'json',
                contentType: "application/json;charset=utf-8",
                success:function(result) {
                    console.log(result);
                    if(result.flag == true){
                        alert("添加用户成功")
                    }
                }
            }
        );
    }
}


//分页查询
function searchUserListByPageMethod(currentPage) {
    var username = document.getElementById("username").value;
    var nickname = document.getElementById("nickname").value;

    var data = {
        'username':username,
        'nickname':nickname
    }
    $.ajax({
            url:serverUrl+ "/system/systemUserService/search.do/"+currentPage+"/"+pageSize,
            data:JSON.stringify(data),
            type : "POST",
            dataType:'json',
            contentType: "application/json;charset=utf-8",
            success:function(result) {
                var mypage = result.data;
                searchUserList = result.data.list;
                var html = "";
                for(var i = 0;i<searchUserList.length;i++){
                    var lihtml =
                        '<tr>\n' +
                        '                        <td><a data-toggle="modal" data-target="#showUserModal" href="#" onclick="showUserInfo(this)" indexOfResult='+i+'>'+searchUserList[i].username+'</a></td>\n' +
                        '                        <td>'+searchUserList[i].nickname+'</td>\n' +
                        '                        <td>'+searchUserList[i].sex+'</td>\n' +
                        '                        <td>'+searchUserList[i].groupId+'</td>\n' +
                        '                        <td>'+searchUserList[i].position+'</td>\n' +
                        '                        <td>'+searchUserList[i].phone+'</td>\n' +
                        '                        <td>'+searchUserList[i].email+'</td>\n' +
                        '                        <td>'+searchUserList[i].role+'</td>\n' +
                        '                        <td>'+searchUserList[i].active+'</td>\n' +
                        '                        <td><a data-toggle="modal" data-target="#editUserInfoModal" indexOfResult='+i+' username='+searchUserList[i].username+' onclick="editUserInfo(this)" href="#" id="editInfo">编辑</a><a  data-toggle="modal" data-target="#deleteUserModal" username='+searchUserList[i].username+' onclick="deleteUser(this)" style="color:#CD5555;margin-left: 5px;" href="#"  id="deleteUser">删除</a></td>\n' +
                        '                    </tr>'
                    html += lihtml;
                }

                var userListTable =  document.getElementById("userListTable");
                userListTable.innerHTML = html;


                //设置分页的html

                //上一下：前两页的上一下为1，其他直接currentPage - 1
                var prepage = currentPage - 1 <= 1 ? 1 : currentPage - 1;
                //下一页：如果currentPage + 1不超过总页数，直接currentPage + 1；否则直接totalPage
                var pagenext = currentPage + 1 >= mypage.totalPage ?
                    mypage.totalPage : currentPage + 1;


                var first = '<li class="page-item"><a class="page-link" href="javascript:;" onclick="searchUserListByPageMethod(1)">首页</a></li>';
                var last = '<li class="page-item"><a class="page-link" href="javascript:;" onclick="searchUserListByPageMethod('+ mypage.totalPage +')">末页</a></li>';
                var pre = ' <li class="page-item"><a class="page-link"  href="javascript:;" onclick="searchUserListByPageMethod(' + prepage + ')">上一页</a></li>';
                var next = '<li class="page-item"><a class="page-link"  href="javascript:;" onclick="searchUserListByPageMethod(' + pagenext + ')">下一页</a></li>';

                var begin = 1;
                var end = mypage.totalPage;

                var temp = "";
                for (var i = begin; i <= end; i++) {
                    if (currentPage == i) {
                        temp += ' <li class="page-item active"><a class="page-link active" href="#" onclick="searchUserListByPageMethod('+i+')">'+i+'</a></li>';
                    } else {
                        temp += ' <li class="page-item"><a class="page-link" href="#" onclick="searchUserListByPageMethod('+i+')">'+i+'</a></li>';
                    }
                }
                var pagecount = first + pre + temp + next + last;

                var pagination = document.getElementById("pagination");
                pagination.innerHTML = pagecount;

                console.log(result);
                console.log(searchUserList);
            }
        }
    );
}







