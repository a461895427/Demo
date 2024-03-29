$(function () {
    //根据窗口调整表格高度
    $(window).resize(function () {
        $('#usertab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
    $('#usertab').bootstrapTable({
        url: "/queryUser",//数据源
        dataField: "rows",//服务端返回数据键值 就是说记录放的键值是rows，分页时使用总记录数的键值为total
        height: tableHeight(),//高度调整
        checkboxHeader:true, // 如果设置 false，将在列头隐藏全选复选框，反之则显示，设置为ture时，必须设置singleSelect=false 才有效
        clickToSelect:true, // 如果设置 true，则在点击行时，自动选中 rediobox 、 checkbox。
        singleSelect:false,  //如果设置为true - 禁止多选，否则不禁止多选
        search: false,//是否搜索,页面搜索
        pagination: true,//是否分页
        pageSize: 20,//单页记录数
        pageList: [5, 10, 20, 50],//分页步进值
        sidePagination: "server",//服务端分页
        contentType: "application/x-www-form-urlencoded",//请求数据内容格式 默认是 application/json 自己根据格式自行服务端处理
        dataType: "json",//期待返回数据类型
        method: "get",//请求方式
        searchAlign: "left",//查询框对齐方式
        queryParamsType: "limit",//查询参数组织方式
        queryParams: function (params) {
            //往后台传查询条件
            return params;
        },
        searchOnEnterKey: false,//回车搜索
        showRefresh: true,//刷新按钮
        showColumns: false,//列选择按钮
        buttonsAlign: "left",//按钮对齐方式
        toolbar: "#toolbar",//指定工具栏
        toolbarAlign: "right",//工具栏对齐方式
        columns: [
            {
                field: 'checkbox',
                align: 'center',   // 设置数据对齐方式可选项： 'left', 'right', 'center'
                halign: 'center',  // 设置表头标题对齐方式可选项： 'left', 'right', 'center'
                checkbox: true,    // 显示为复选框
            },
            {
                title: "用户ID",//标题
                field: "user_Id",//键名
                sortable: true,//是否可排序
                order: "desc"//默认排序方式
            },
            {
                title: "用户名",//标题
                field: "username",//键名
                sortable: true,//是否可排序
            },
            {
                title: "邮箱",
                field: "email",
                sortable: true,
            },
            {
                title: "手机号",
                field: "mobile",
            },
            {
                title: "创建时间",
                field: "create_time",
            },
            {
                title: "修改时间",
                field: "modify_time",
            }
        ],
    });

})

//新增用户
function addRecord() {
    var userId = document.getElementById("userId").value;
    var userName = document.getElementById("userName").value;
    var email = document.getElementById("email").value;
    var phoneNumber = document.getElementById("phoneNumber").value;
    //必须拥有数据的做提示
    if (userId == "") {
        alert("账号ID不能为空");
        return false;
    }
    if (userName == "") {
        alert("账号名称不能为空");
        return false;
    }
    $(function () {
        $.ajax({
            url: '/addUser', //请求地址
            type: 'post', //请求方式
            dataType: 'json', //返回的数据格式
            data: {
                'userId': userId,
                'userName': userName,
                'email': email,
                'phoneNumber': phoneNumber
            }
        }).done(function (dat) {
            // 请求成功以后要执行的回调函数
            alert(dat)
            //清空新增框里的数据,隐藏新增框,并且刷新表格
            document.getElementById('userId').value='';
            document.getElementById('userName').value='';
            document.getElementById('email').value='';
            document.getElementById('phoneNumber').value='';
            $('#addModal').modal('hide');
            $('#usertab').bootstrapTable('refresh');
        }).fail(function (e) {
            // 请求失败以后要执行的回调函数
            alert(e)
        })
    })
}

function tableHeight() {
    return $(window).height() - 150;
}

/**
 * 列的格式化函数 在数据从服务端返回装载前进行处理
 * @param  {[type]} value [description]
 * @param  {[type]} row   [description]
 * @param  {[type]} index [description]
 * @return {[type]}       [description]
 */
function infoFormatter(value, row, index) {
    return "id:" + row.id + " name:" + row.name + " age:" + row.age;
}