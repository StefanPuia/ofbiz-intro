package com.stannah.hr.service;

public class UpdateEmployee {
  public Map<String, Object> execute(
    final DispatchContext dctx,
    final Map<String, Object> context) {

    final EmployeeQueries employeeQueries = QueryFactory.getInstance(EmployeeQueries.class, dctx.getDelegator());
    final String partyId = (String) context.get("partyId");
    final String firstName = (String) context.get("firstName");
    final String lastName = (String) context.get("lastName");

    final GenericValue employee = employeeQueries.findById(partyId);

    employee.put(EmployeeQueries.FIRST_NAME, firstName);
    employee.put(EmployeeQueries.LAST_NAME, lastName);
    employee.store();

    return ServiceUtil.returnSuccess();
  }
}
