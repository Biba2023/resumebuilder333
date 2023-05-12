package com.example.resumebuilder.ui.projects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.Education;
import com.example.resumebuilder.data.Projects;
import com.example.resumebuilder.db.RealmManager;

public class ProjectsViewModel extends ViewModel {
    private final MutableLiveData<Projects> mProjectsLiveData;
    private final Projects mProjects;

    public ProjectsViewModel() {
        Projects projects = (Projects) RealmManager.getInstance().getRealmObject(Projects.class);
        if(projects == null)
            mProjects = new Projects();
        else
            mProjects = new Projects(projects);
        mProjectsLiveData = new MutableLiveData<>(mProjects);
    }

    public LiveData<Projects> getProjectsLiveData() {
        return mProjectsLiveData;
    }
    public void SaveProjects(Projects projects){

        mProjects.setProject(projects.getProject());
        mProjects.setDetails(projects.getDetails());
        mProjects.setStartDate(projects.getStartDate());
        mProjects.setEndDate(projects.getEndDate());
        mProjectsLiveData.setValue(mProjects);
        RealmManager.getInstance().update(mProjects);
    }
}
