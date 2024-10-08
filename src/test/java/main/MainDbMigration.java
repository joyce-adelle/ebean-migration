package main;

import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

public class MainDbMigration {

    public static void main(String[] args) throws Exception {

        // optionally specify the version and name
        System.setProperty("ddl.migration.version", "1.0.5");
        System.setProperty("ddl.migration.name", "modify_sheet_music_add_languages");

        // generate a migration using drops from a prior version
        //System.setProperty("ddl.migration.pendingDropsFor", "1.1");

        DbMigration dbMigration = DbMigration.create();
        dbMigration.setPlatform(Platform.POSTGRES);
//        dbMigration.setStrictMode(false);
        // generate the migration ddl and xml
        dbMigration.generateMigration();
    }

}
