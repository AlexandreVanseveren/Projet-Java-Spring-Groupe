package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_9__CreateEvent extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute("INSERT INTO statut (id_stat,stat_name) values (4,'En promo')");
        statement.execute("CREATE EVENT perim ON SCHEDULE EVERY 30 SECOND DO update products set id_statfk=3 where peremption <= NOW() AND id_statfk <> 2");
        statement.execute("CREATE EVENT promo ON SCHEDULE EVERY 25 SECOND DO update products set price =price*0.8 ,id_statfk = 4 where datediff(peremption,NOW()) =2 and id_statfk= 1");
        statement.execute("CREATE EVENT rupture ON SCHEDULE EVERY 5 SECOND DO update products set id_statfk=2 where quantities = 0");
    }
}
