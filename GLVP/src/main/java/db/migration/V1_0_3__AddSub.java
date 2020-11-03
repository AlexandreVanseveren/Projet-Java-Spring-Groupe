package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_3__AddSub extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(1, 'Boeuf',1)");
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(2, 'Porc',1)");
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(3, 'Gibier',1)");
    }
}
