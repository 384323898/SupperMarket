<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 供应商添加页面</span>
    </div>
    <div class="providerAdd">
        <form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/provideraddsave">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="proCode">供应商编号：</label>
                <input type="text" name="proCode" id="proCode" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="proName">供应商名称：</label>
                <input type="text" name="proName" id="proName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="proContact">供应商联系人：</label>
                <input type="text" name="proContact" id="proContact" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="proPhone">供应商电话：</label>
                <input type="text" name="proPhone" id="proPhone" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="proAddress">供应商地址：</label>
                <input type="text" name="proAddress" id="proAddress" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="proFax">供应商传真：</label>
                <input type="text" name="proFax" id="proFax" value="">
                <font color="red"></font>
            </div>
            <input type="hidden" name="createdBy" id="createdBy" value="${sessionScope.user.id}">
            <div>
                <label for="proDesc">供应商描述：</label>
                <textarea  cols="40" rows="3" type="text" name="proDesc" id="proDesc"></textarea>
                <font color="red"></font>
            </div>


            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存" >
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/provideradd.js"></script>