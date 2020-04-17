<%
    config.require("label")
    config.require("formFieldName")
%>
<p>${config.label}</p>
<% conceptOptions.each { option -> %>
<div>
    <input type="checkbox" id="${option.conceptId}-field" name="${config.formFieldName}"
           value="${option.conceptId}"/>
    <label for="${option.conceptId}-field">${option.conceptName}</label>
</div>
<% } %>

