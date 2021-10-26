//
// Created by engsw on 21/10/2021.
//

#include <string>
#include "sqllite/sqlite3.h"
#include <jni.h>


extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_sqlitedbexample_NativeLibrary_createDb(JNIEnv *env, jobject thiz, jstring db_path) {

    sqlite3 *db;
    int rc;
    char *errMsg;

    const char *database = env->GetStringUTFChars(db_path, 0);
    rc = sqlite3_open(database, &db);

    if( rc!= SQLITE_OK) {
        sqlite3_open_v2(database, &db, SQLITE_OPEN_CREATE | SQLITE_OPEN_READWRITE, NULL);

    }
    const char *createQuery =
            "CREATE TABLE IF NOT EXISTS cities (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);";

    /* Execute SQL statement */
    rc = sqlite3_exec(db, createQuery, NULL, 0, &errMsg);


//    const char *insertQuery =
//    "INSERT INTO cities VALUES (NULL,'London');";
//    rc = sqlite3_exec(db, insertQuery, NULL, 0, &errMsg);

    if (rc != SQLITE_OK) {
        sqlite3_free(errMsg);
        return false;
    }
    sqlite3_close(db);
    return true;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_sqlitedbexample_NativeLibrary_insertData(JNIEnv *env, jobject thiz, jstring db_path) {

    sqlite3 *db;
    int rc;
    char *errMsg;

    const char *database = env->GetStringUTFChars(db_path, 0);
    rc = sqlite3_open(database, &db);

    if( rc!= SQLITE_OK) {
        sqlite3_open_v2(database, &db, SQLITE_OPEN_CREATE | SQLITE_OPEN_READWRITE, NULL);

    }
    const char *insertQuery =
    "INSERT INTO cities VALUES (NULL,'London');";
    rc = sqlite3_exec(db, insertQuery, NULL, 0, &errMsg);

    if (rc != SQLITE_OK) {
        sqlite3_free(errMsg);
        return false;
    }
    sqlite3_close(db);
    return true;
}