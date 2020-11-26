package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_5__AddProducts extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk) values " +
                        "(1, 'Rumsteak','2020-11-02','2020-11-07',1,1)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk) values " +
                        "(2, 'Mignonettes','2020-11-02','2020-11-06',2,2)");
    }
}