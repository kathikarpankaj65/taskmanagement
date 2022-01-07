package com.example.taskmanagement;

import java.util.ArrayList;

public abstract class Repository {

    abstract Result isUserAvailable (String username, String password) throws CredentialException;

    abstract Result getCreateList() throws Exception;

    abstract Result getNotificationList() throws Exception;

    abstract Result setCreateActivityData() throws Exception;

    abstract ArrayList<AdapterListViewHomePage> getArrayList();

    abstract ArrayList<AdapterNotificationHomePage> getNotificationArrayList();

}
