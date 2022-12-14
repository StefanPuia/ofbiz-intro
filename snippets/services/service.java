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
