package com.appstoremarketresearch.tutorial.android.mvc.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.appstoremarketresearch.tutorial.android.mvc.R;
import com.appstoremarketresearch.tutorial.android.mvc.model.SignedInUser;

/**
 * Fragment for displaying inventory information.
 */
public class MissionStatementFragment extends Fragment
{
    /**
     * initializeMissionStatement
     */
    private View initializeMissionStatement(
        View topLevelView,
        SignedInUser user)
    {        
        // cast the activity so MissionStatementFragment depends
        // on the MissionStatementAccessor interface but not 
        // the MissionStatementActivity
        MissionStatementAccessor accessor = (MissionStatementAccessor)getActivity();
        
        // get mission statement from activity
        String missionStatement = accessor.getMissionStatement(user.getUserRole());
        
        // get EditText or TextView
        int id = R.id.mission_statement_text;
        View missionStatementView = topLevelView.findViewById(id);

        if (missionStatementView instanceof EditText)
        {
            EditText editText = (EditText)missionStatementView;
            editText.setText(missionStatement);
        }
        else if (missionStatementView instanceof TextView)
        {
            TextView textView = (TextView)missionStatementView;
            textView.setText(missionStatement);
        }
        
        return missionStatementView;
    }
    
    /**
     * initializeSaveButton
     */
    private void initializeSaveButton(
        View topLevelView,
        final SignedInUser user,
        final View missionStatementView)
    {
        int id = R.id.button_save_mission_statement;
        View view = topLevelView.findViewById(id);
        
        if (view instanceof Button) // may be null
        {
            Button button = (Button)view;
            final MissionStatementAccessor accessor = (MissionStatementAccessor)getActivity();
            
            button.setOnClickListener(new OnClickListener() 
            {
                @Override
                public void onClick(View view) 
                {
                    if (missionStatementView instanceof EditText)
                    {
                        EditText editText = (EditText)missionStatementView;
                        String missionStatement = editText.getText().toString();
                        accessor.saveMissionStatement(user.getUserRole(), missionStatement);
                    }
                }
            });
        }
    }
    
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        Activity activity = getActivity();
        Intent intent = activity.getIntent();

        String key = SignedInUser.class.getSimpleName();
        SignedInUser user = (SignedInUser)intent.getSerializableExtra(key);

        android.util.Log.w(this.getClass().getSimpleName(), user.getUserRole().name());

        int layoutId = 0;

        switch(user.getUserRole())
        {
            case EDITOR:
            case TEST_EDITOR:
                layoutId = R.layout.fragment_mission_statement_editor;
                break;

            case READER:
            case TEST_READER:
                layoutId = R.layout.fragment_mission_statement_reader;
                break;
        }

        View topLevelView = inflater.inflate(layoutId, container, false);

        View missionStatementView = initializeMissionStatement(topLevelView, user);
        initializeSaveButton(topLevelView, user, missionStatementView);

        return topLevelView;
    }
}
