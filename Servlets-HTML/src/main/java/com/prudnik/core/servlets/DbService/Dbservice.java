package com.prudnik.core.servlets.DbService;

import java.util.List;

public class Dbservice {
    private static Dbservice dbservice = null;
    private List<String> users;

    private Dbservice() {

    }

    public static Dbservice getDbservice() {
        if (dbservice != null) {
            return dbservice;
        } else {
            synchronized (Dbservice.class) {
                if (dbservice == null) {
                    dbservice = new Dbservice();
                }
            }
            return dbservice;
        }
    }
}
