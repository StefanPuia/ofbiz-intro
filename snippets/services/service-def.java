package com.stannah.hr.service;

public class UpdateEmployee {
  public Map<String, Object> execute(
        final DispatchContext dctx,
        final Map<String, Object> context) {

    final PersonQueries personQueries = QueryFactory
        .getInstance(PersonQueries.class, dctx.getDelegator());
    final String partyId = (String) context.get("partyId");
    final String firstName = (String) context.get("firstName");
    final String lastName = (String) context.get("lastName");

    try {
      final GenericValue person = personQueries.findById(partyId);

      person.put(PersonQueries.FIRST_NAME, firstName);
      person.put(PersonQueries.LAST_NAME, lastName);
      person.store();
    } catch (GenericEntityException e) {
      return ServiceUtil.returnError(e.getMessage());
    }

    final Map<String, Object> returnMap = ServiceUtil.returnSuccess();
    returnMap.put("partyId", partyId);
    return returnMap;
  }
}

// Code snippet from services.xml
// <service name="updateEmployee" engine="java" auth="true"
//     location="com.stannah.hr.service.UpdateEmployee" invoke="execute">
//   <description>Updates an employee's first and last names</description>
//   <attribute name="partyId" type="String" mode="INOUT"/>
//   <attribute name="firstName" type="String" mode="IN" optional="true"/>
//   <attribute name="lastName" type="String" mode="IN" optional="true"/>
// </service>
