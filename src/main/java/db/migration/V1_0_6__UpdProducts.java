package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_6__UpdProducts extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "Alter Table products add price float (11)");
        statement.execute(
                "Alter Table products add quantities int (11)");
        statement.execute(
                "UPDATE products SET price =10, quantities =25 where id_prod=1");
        statement.execute(
                "UPDATE products SET price =15, quantities = 15 where id_prod=2");
    }
}
