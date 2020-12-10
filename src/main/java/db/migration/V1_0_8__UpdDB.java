package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_8__UpdDB extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute("Update statut set stat_name = 'En stock' where id_stat =1");
        statement.execute(
                "INSERT INTO statut" +
                        "(id_stat, stat_name) values " +
                        "(3, 'Périmé')");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk,price,quantities) values " +
                        "(15, 'Steak Haché','2020-11-02','2020-11-07',1,3,5.32,10)");
    }
}