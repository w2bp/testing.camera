package com.wang.base.testing.camera.data.local;

import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmModel;

@Singleton
public class RealmHelper {

    public static <T extends RealmModel> void deleteAllFrom(Class<T> targetClass, Realm realm) {
        realm.where(targetClass)
                .findAll()
                .deleteAllFromRealm();
    }

    public static void clearDB() {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(realm1 -> {
                realm1.deleteAll();
            });
        }
    }
}
