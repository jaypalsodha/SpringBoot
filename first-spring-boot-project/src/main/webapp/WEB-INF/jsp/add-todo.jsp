<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
  <h2>Horizontal form</h2>
  <form:form class="form-horizontal" method="post" commandName="todo">
  <form:hidden path="id"/>
  	<!--Description  -->
    <div class="form-group">
      <form:label class="control-label col-sm-2" path="desc">Description</form:label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="desc"  required="required" />
        <form:errors path="desc" cssClass="text-warning"/>
      </div>
    </div>
    <!--Target Date  -->
    <div class="form-group">
      <form:label class="control-label col-sm-2" path="targetDate">Target Date</form:label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="targetDate"  required="required" />
        <form:errors path="targetDate" cssClass="text-warning"/>
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success">Add</button>
        <button type="submit" class="btn btn-warning">Back</button>
      </div>
     
    </div>
  </form:form>
</div>
<%@ include file="common/footer.jspf" %>