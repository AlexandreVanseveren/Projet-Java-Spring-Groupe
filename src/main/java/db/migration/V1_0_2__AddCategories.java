package db.migration;

import be.ifosup.glvp.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_2__AddCategories extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO categories" +
                        "(id_cat, cat_name) values " +
                        "(1, 'Viandes')");
        statement.execute(
                "INSERT INTO categories" +
                        "(id_cat, cat_name) values " +
                        "(2, 'Légumes')");

    }
}
