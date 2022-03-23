$(function () {
    /**
     * 实现菜单导航图标切换
     */
    $(".panel-heading").click(function (e) {
        /*切换折叠指示图标*/
        $(this).find("span").toggleClass("glyphicon-chevron-down");
        $(this).find("span").toggleClass("glyphicon-chevron-up");
    });
    /**
     * 实现选中一个菜单的功能
     */
    $("ul li").click(function () {
        $("ul li").siblings("li").removeClass("active");  // 删除其兄弟元素的样式
        $(this).addClass("active");                    // 为点击元素添加类名
    });
    /**
     * 实现用户管理控制页面动态加载
     */
    $("#menupermissions").click(function () {
        $("#right").load("menupermissions")
    });
    /**
     * 实现菜单权限管理页面动态加载
     */
    $("#users-table").click(function () {
        $("#right").load("users-table")
    });
    /**
     * 实现角色管理页面动态加载
     */
    $("#role").click(function () {
        $("#right").load("role")
    });
});


window.onload = function () {
    var t = new Date().getHours();
    if (t >= 22 || t <= 6) {
        // $("#theme").attr("id","test2");//改变id
        //$("#theme").attr("class","theme-dark");//改变class
        // $("#theme").attr({"id":"test2","class":"demo2"});//改变id和class
        $("#theme").attr("class", "theme-dark");//关灯效果
    }
}

window.onload = function () {
    $("#right").load("menupermissions")
    $("#top").load("navigation")
}


