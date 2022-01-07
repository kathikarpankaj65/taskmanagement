package com.example.taskmanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CreateFragment extends Fragment implements View.OnClickListener, Observer<Result> {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CreateFragmentViewModel createFragmentViewModel=new CreateFragmentViewModel();
        LiveData<Result> createFragmentMutableLiveData = createFragmentViewModel.getCreateFragmentViewModel();
        createFragmentMutableLiveData.observe(getActivity(), this);
        FloatingActionButton floatingActionButton =view.findViewById(R.id.floating_action_button_fragment_create);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(), CreateActivity.class);
        startActivity(intent);
    }

    @Override
    public void onChanged(Result result) {
        if (result instanceof Loading) {
            progressBar = getActivity().findViewById(R.id.progressbar_create);
            progressBar.setVisibility(View.VISIBLE);
        }
        if (result instanceof Success){
            progressBar.setVisibility(View.GONE);
            recyclerView = getActivity().findViewById(R.id.create_fragment_recycle_view);
            Success<ArrayList<AdapterListViewHomePage>> success=(Success) result;
            ArrayList<AdapterListViewHomePage> arrayList = success.getT();
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
            recyclerView.setAdapter(new CreateListAdapter(getActivity(), arrayList));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        else if (result instanceof Error) {
            progressBar.setVisibility(View.GONE);
            Error error = (Error) result;
            Toast.makeText(getActivity(), error.getException().getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}