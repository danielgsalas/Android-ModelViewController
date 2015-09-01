package com.appstoremarketresearch.tutorial.android.mvc.view;

import com.appstoremarketresearch.tutorial.android.mvc.model.UserRole;

public interface MissionStatementAccessor
{
    String getMissionStatement(UserRole role);
    
    void saveMissionStatement(UserRole role, String missionStatement);
}
