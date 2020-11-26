package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_3__AddStatut extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO statut" +
                        "(id_stat, stat_name) values " +
                        "(1, 'Périmé')");
        statement.execute(
                "INSERT INTO statut" +
                        "(id_stat, stat_name) values " +
                        "(2, 'Rupture de stock')");

    }
}
