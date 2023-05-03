package com.example.resumebuilder.db;

import com.example.resumebuilder.data.Career;
import com.example.resumebuilder.data.ContactInfo;
import com.example.resumebuilder.data.Education;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmManager {
    private static RealmManager instance;
    RealmConfiguration realmConfiguration;
    Realm realm;

    public RealmManager(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
        realm = Realm.getInstance(realmConfiguration);
    }
    public static RealmManager getInstance(){
        if(instance == null)
            instance = new RealmManager(
                    new RealmConfiguration.Builder().
                    allowWritesOnUiThread(true).
                    allowQueriesOnUiThread(true).
                    name(Realm.DEFAULT_REALM_NAME).build());
        return instance;
    }
    public void insert(RealmObject object){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(object);
            }
        });
    }
    public void update(RealmObject object){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(object);
            }
        });
    }
    public RealmObject getRealmObject(Class<? extends RealmObject> table){
        return realm.where(table).findFirst();
    }
    public RealmResults<Education> getRealmCollectionEducation(){
        return realm.where(Education.class).findAll();
    }
    public RealmResults<ContactInfo> getRealmCollectionContactInfo(){
        return realm.where(ContactInfo.class).findAll();
    }
}
