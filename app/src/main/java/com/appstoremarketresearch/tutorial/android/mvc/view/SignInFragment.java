package com.appstoremarketresearch.tutorial.android.mvc.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appstoremarketresearch.tutorial.android.mvc.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SignInFragment extends Fragment
{
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }
}
