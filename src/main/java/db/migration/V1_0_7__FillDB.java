package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_7__FillDB extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO categories" +
                        "(id_cat, cat_name) values " +
                        "(3, 'Produits laitiers')");
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(4, 'Volaille',1)");
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(5, 'Cheval',1)");
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(6, 'Agneau',1)");
        statement.execute(
                "INSERT INTO subcat" +
                        "(id_sub, sub_name, id_catfk) values " +
                        "(7, 'Chien',1)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(3, 'Hot-dog','2020-11-30','2020-12-08',7,1,25,1200)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk , price, quantities) values " +
                        "(4, 'Côte d agneau','2020-11-30','2020-12-07',6,1,15,20)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(5, 'Gigolette d agneau','2020-12-03','2020-12-12',6,1,14,36)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(6, 'Roti de porc','2020-12-04','2020-12-11',2,1,4,1)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(7, 'Steak de cheval','2020-12-02','2020-12-07',5,1,18,25)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(8, 'Carbonnades de cheval','2020-12-02','2020-12-09',5,1,8,6)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(9, 'Ailes de poulet','2020-12-01','2020-12-06',4,1,2.25,10)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(10, 'Poulet fermier','2020-12-02','2020-12-10',4,1,10,15)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(11, 'Steak de Cerf','2020-12-02','2020-12-10',3,1,20,12)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(12, 'Coeur de boeuf','2020-12-03','2020-12-10',1,1,60,2)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(13, 'Foie de porc','2020-12-02','2020-12-11',2,1,14,2)");
        statement.execute(
                "INSERT INTO products" +
                        "(id_prod, prod_name, rayon, peremption, id_subfk, id_statfk, price, quantities) values " +
                        "(14, 'Coppa de sanglier','2020-12-02','2020-12-19',3,1,25,15)");
    }
}
