package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;

public class V3__bulk_update_books extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        try (var selectStatement = context.getConnection().createStatement()) {
            try (ResultSet rows = selectStatement.executeQuery("SELECT id FROM books ORDER BY id")) {
                while (rows.next()) {
                    var id = rows.getInt(1);
                    String nameToChange = "홍길동" + id;
                    try (var updateStatement = context.getConnection().createStatement()) {
                        updateStatement.execute("UPDATE books SET author='" + nameToChange + "' WHERE id=" + id);
                    }
                }
            }
        }
    }
}
