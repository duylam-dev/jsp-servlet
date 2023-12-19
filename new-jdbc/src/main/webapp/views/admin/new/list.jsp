<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>List News</title>
</head>
<body>
    <form class="main-content action="<c:url value='/admin-new'/>" id="formSubmit" method="get">
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Trang chủ</a>
                        </li>
                    </ul><!-- /.breadcrumb -->
                </div>
                <div class="page-content">
                    <div class="row" >
                        <div class="col-xs-12">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th>Tên bài viết</th>
                                                <th>Mô tả ngắn</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${model.listResult}">
                                                <tr>
                                                    <td>${item.title}</td>
                                                    <td>${item.shortDescription}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <ul class="pagination" id="pagination"></ul>
                                        <input type="hidden" id="page" value="" name="page"/>
                                        <input type="hidden" id="maxPageItem" value="" name="maxPageItem"/>
                                        <input type="hidden" id="sortName" value="" name="sortName"/>
                                        <input type="hidden" id="sortBy" value="" name="sortBy"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.main-content -->
    </form>
    <script type="text/javascript">
        var currentPages = ${model.page}
        var totalPages = ${model.totalPage}
        var limit = 2
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 2,
                startPage: currentPages,
                onPageClick: function (event, page) {
                    if(currentPages !== page){
                        $('#maxPageItem').val(limit);
                        $('#page').val(page);
                        $('#sortName').val('title');
                        $('#sortBy').val('desc');
                        $('#formSubmit').submit();
                    }
                }
            }).on('page', function (event, page) {
                console.info(page + ' (from event listening)');
            });
        });
    </script>
</body>
</html>
