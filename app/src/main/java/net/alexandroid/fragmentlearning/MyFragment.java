package net.alexandroid.fragmentlearning;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {

    public static final String ARG_NAME = "ARG_NAME";
    private MyFragmentListener mMyFragmentListener;

    public static MyFragment newInstance(String name)  {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_NAME, name);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);

        String name = getArguments().getString(ARG_NAME, "Vasya");

        TextView textView = rootView.findViewById(R.id.textView);
        textView.setText(name);

        //((MyFragment.MyFragmentListener) getActivity()).doSomethingInActivity();
        mMyFragmentListener.doSomethingInActivity();

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMyFragmentListener = (MyFragmentListener) context;
    }

    interface MyFragmentListener {
        void doSomethingInActivity();

        void closeApplication();

        void showSecondActivity();

        void showMessageToUser();

    }
}
