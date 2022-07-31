// file: /hr/webapp/hr/WEB-INF/actions/EmployeeEvents.groovy

String getEmployeeData() {

  final def employeeQueries = QueryFactory.getInstance(EmployeeQueries.class, delegator)

  final String partyId = parameters.partyId

  request.setAttribute("employee", employeeQueries.findById(partyId))

  return "success"
}

// Snippet from controller.xml
// <event type="groovy" path="component://hr/webapp/hr/WEB-INF/actions/EmployeeEvents.groovy"
//    invoke="getEmployeeData"/>
// <response name="success" type="request" value="json"/>
