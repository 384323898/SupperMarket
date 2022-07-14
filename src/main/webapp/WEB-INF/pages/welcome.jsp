<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div class="right">
    <img class="wColck" src="${pageContext.request.contextPath }/statics/images/clock.jpg" alt=""/>
    <div class="wFont">
        <h1>姓名：陈博文<br/>
            学号：201751201163<br/>
            班级：计科三班</h1>
        <h2>${sessionScope.user.userName}</h2>
        <p>欢迎来到超市订单管理系统!</p>
    </div>
</div>
</section>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>