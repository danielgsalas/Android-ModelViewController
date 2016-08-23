package com.appstoremarketresearch.tutorial.android.mvc.model;

import android.content.Context;

public class MissionStatementDAOFactory
{
    public static MissionStatementDAO getMissionStatementDAO(
        Context context,
        UserRole role)
    {
        // return the interface, not a reference to a 
        // concrete class, to decouple the DAO user from
        // the implementation
        MissionStatementDAO dao = null;
        
        switch (role)
        {
        case EDITOR:
        case READER:
            dao = new MissionStatementWebServiceClient(context);
            break;
            
        case TEST_EDITOR:
        case TEST_READER:
            dao = new MissionStatementTestClient(context);
            break;
        }
        
        return dao;
    }
}
