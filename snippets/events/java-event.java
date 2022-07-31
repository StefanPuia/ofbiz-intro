package com.stannah.hr.events;

public class GetEmployee {
  public static String execute(
      final HttpServletRequest request,
      final HttpServletResponse response) {

    final Delegator delegator = (Delegator) request.getAttribute("delegator");
    final EmployeeQueries employeeQueries = QueryFactory.getInstance(EmployeeQueries.class, delegator);

    final String partyId = request.getParameter("partyId");

    request.setAttribute("employee", employeeQueries.findById(partyId));

    return "success";
  }
}

// Snippet from controller.xml
// <event type="java" path="com.stannah.hr.events.GetEmployee" invoke="execute"/>
// <response name="success" type="request" value="json"/>
