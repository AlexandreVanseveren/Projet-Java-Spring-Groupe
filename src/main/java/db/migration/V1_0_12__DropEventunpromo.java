package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;


import java.sql.Statement;

public class V1_0_12__DropEventunpromo extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute("DROP EVENT IF EXISTS unrpromo");
    }
}
