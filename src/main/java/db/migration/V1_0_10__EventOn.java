package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_10__EventOn extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {
    Statement statement = context.getConnection().createStatement();
        statement.execute("SET GLOBAL event_scheduler = ON");
        statement.execute("CREATE EVENT unrupture ON SCHEDULE EVERY 5 SECOND DO update products set id_statfk=1 where quantities <> 0 and id_statfk = 2");
}
}




