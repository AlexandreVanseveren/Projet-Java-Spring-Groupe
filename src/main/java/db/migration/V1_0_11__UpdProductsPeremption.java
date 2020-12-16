package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_11__UpdProductsPeremption extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "UPDATE products SET peremption ='2020-12-19' where id_prod=1");
        statement.execute(
                "UPDATE products SET peremption ='2020-12-19' where id_prod=2");
        statement.execute(
                "UPDATE products SET peremption ='2020-12-19' where id_prod=3");
        statement.execute(
                "UPDATE products SET peremption ='2020-12-24' where id_prod=4");
        statement.execute(
                "UPDATE products SET peremption ='2020-12-23' where id_prod=5");
        statement.execute(
                "UPDATE products SET peremption ='2020-12-22' where id_prod=6");
        statement.execute("CREATE EVENT unrpromo ON SCHEDULE EVERY 5 SECOND DO update products set id_statfk=1, price =price*1.2 where peremption > NOW() and id_statfk = 4");
    }
}

