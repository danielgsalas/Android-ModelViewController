package com.appstoremarketresearch.tutorial.android.mvc.controller;

import android.app.Activity;
import android.os.Bundle;

import com.appstoremarketresearch.tutorial.android.mvc.R;
import com.appstoremarketresearch.tutorial.android.mvc.model.MissionStatementDAO;
import com.appstoremarketresearch.tutorial.android.mvc.model.MissionStatementDAOFactory;
import com.appstoremarketresearch.tutorial.android.mvc.model.UserRole;
import com.appstoremarketresearch.tutorial.android.mvc.view.MissionStatementAccessor;

public class MissionStatementActivity 
    extends Activity
    implements MissionStatementAccessor
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_statement);
    }
    
    @Override
    public String getMissionStatement(UserRole role)
    {
        MissionStatementDAO dao = MissionStatementDAOFactory.getMissionStatementDAO(
            this, role);
        
        return dao.getMissionStatement();
    }
    
    @Override
    public void saveMissionStatement(
        UserRole role,
        String missionStatement)
    {
        MissionStatementDAO dao = MissionStatementDAOFactory.getMissionStatementDAO(
            this, role);
        
        dao.saveMissionStatement(missionStatement);
    }
}
