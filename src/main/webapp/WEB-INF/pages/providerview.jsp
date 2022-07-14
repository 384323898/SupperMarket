<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span> 供应商管理页面 >> 供应商信息查看页面</span>
    </div>
    <div class="providerView">
        <p><strong>编号：</strong><span>${pro.id}</span></p>
        <p><strong>供应商编号：</strong><span>${pro.proCode}</span></p>
        <p><strong>供应商名称：</strong><span>${pro.proName}</span></p>
        <p><strong>供应商描述：</strong><span>${pro.proDesc}</span></p>
        <p><strong>供应商联系人：</strong><span>${pro.proContact}</span></p>
        <p><strong>地址：</strong><span>${pro.proAddress}</span></p>
        <p><strong>传真：</strong><span>${pro.proFax}</span></p>
        <p><strong>创建者编号：</strong><span>${pro.createdBy}</span></p>
        <p><strong>创建时间：</strong><span><fmt:formatDate value="${pro.creationDate}" pattern="yyyy-MM-dd"/></span></p>

        <p><strong>更新时间：</strong><span>


            <c:if test="${pro.modifyDate!=null}">
                <fmt:formatDate value="${pro.modifyDate}" pattern="yyyy-MM-dd"/></c:if>
            <c:if test="${pro.modifyDate==null}">无</c:if>


        </span></p>
        <p><strong>更新者编号：</strong><span>
            <c:if test="${pro.modifyBy==null}">无</c:if>
            <c:if test="${pro.modifyBy!=null}">${pro.modifyBy}</c:if>

        </span></p>
        <div class="providerAddBtn">
            <input type="button" id="back" name="back" value="返回" >
        </div>
    </div>
</div>
</section>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/providerview.js"></script>