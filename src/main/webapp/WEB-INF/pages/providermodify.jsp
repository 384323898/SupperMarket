<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 供应商修改页面</span>
    </div>
    <div class="providerAdd">
        <form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/providermodifysave">
            <input type="hidden" name="id" value="${pro.id}"/>
            <input type="hidden" name="proCode" value="${pro.proCode}"/>

            <div>

                <label for="proName">供应商名称：</label>
                <input type="text" name="proName" id="proName" value="${pro.proName }">
                <font color="red"></font>
            </div>
            <div>
                <label for="proContact">供应商联系人：</label>
                <input type="text" name="proContact" id="proContact" value="${pro.proContact}">
                <font color="red"></font>
            </div>
            <div>
                <label for="proPhone">供应商电话：</label>
                <input type="text" name="proPhone" id="proPhone" value="${pro.proPhone}">
                <font color="red"></font>
            </div>
            <div>
                <label for="proAddress">供应商地址：</label>
                <input type="text" name="proAddress" id="proAddress" value="${pro.proAddress}">
                <font color="red"></font>
            </div>
            <div>
                <label for="proFax">供应商传真：</label>
                <input type="text" name="proFax" id="proFax" value="${pro.proFax}">
                <font color="red"></font>
            </div>
            <input type="hidden" name="createdBy" id="createdBy" value="${pro.createdBy}">
            <input type="hidden" name="creationDate" id="creationDate" value="${pro.creationDate}">

            <div>
                <label for="modifyBy">更改者编号：</label>
                <input  disabled="disabled" type="text" name="modifyBy" id="modifyBy" value="${sessionScope.user.id}">
                <font color="red"></font>
            </div>
            <div>
                <label for="proDesc">供应商描述：</label>
                <textarea  cols="40" rows="3" type="text" name="proDesc" id="proDesc" value="${pro.proDesc}">${pro.proDesc}</textarea>
                <font color="red"></font>
            </div>

<%--            <div>--%>
<%--                <label >用户性别：</label>--%>
<%--                <select name="gender" id="gender">--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${user.gender == 1 }">--%>
<%--                            <option value="1" selected="selected">男</option>--%>
<%--                            <option value="2">女</option>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <option value="1">男</option>--%>
<%--                            <option value="2" selected="selected">女</option>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </select>--%>
<%--            </div>--%>
            <!--
            <div>
                <label for="data">出生日期：</label>
<%--                <input type="text" id="birthday" name="birthday" value="${user.birthday }">--%>
                <font color="red"></font>
            </div>
            -->

<%--            <div>--%>
<%--                <label for="phone">用户电话：</label>--%>
<%--                <input type="text" name="phone" id="phone" value="${user.phone }">--%>
<%--                <font color="red"></font>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label for="address">用户地址：</label>--%>
<%--                <input type="text" name="address" id="address" value="${user.address }">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label >用户角色：</label>--%>
<%--                <!-- 列出所有的角色分类 -->--%>
<%--                &lt;%&ndash; <input type="hidden" value="${user.userRole }" id="rid" />--%>
<%--                <select name="userRole" id="userRole"></select> &ndash;%&gt;--%>

<%--                <select name="userRole" id="userRole">--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${user.userRole == 1}">--%>
<%--                            <option value="1" selected="selected">系统管理员</option>--%>
<%--                            <option value="2">经理</option>--%>
<%--                            <option value="3">普通用户</option>--%>
<%--                        </c:when>--%>
<%--                        <c:when test="${user.userRole == 2}">--%>
<%--                            <option value="1">系统管理员</option>--%>
<%--                            <option value="2" selected="selected">经理</option>--%>
<%--                            <option value="3">普通用户</option>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <option value="1">系统管理员</option>--%>
<%--                            <option value="2">经理</option>--%>
<%--                            <option value="3" selected="selected">普通用户</option>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </select>--%>
<%--                <font color="red"></font>--%>
<%--            </div>--%>
            <div class="providerAddBtn">
                <input type="submit" name="save" id="save" value="保存" />
                <input type="button" id="back" name="back" value="返回"/>
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/pages/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>