package com.stannah.queries;

public class PersonQueries extends AbstractQueries {

    public static final String PERSON = "Person";
    public static final String PARTY_ID = "partyId";
    public static final String PARTY_ID = "firstName";
    public static final String PARTY_ID = "lastName";

    PersonQueries() {}

    public String findById(final String partyId)
            throws GenericEntityException {
        return EntityQuery.use(delegator)
          .from(PERSON)
          .where(PARTY_ID, partyId)
          .queryFirst();
    }
}
