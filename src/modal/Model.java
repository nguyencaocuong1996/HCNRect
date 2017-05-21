package modal;

import java.sql.SQLException;

abstract class Model {
    protected ModalData insertData;
    protected ModalData updateData;
    abstract void insert() throws SQLException;
    abstract void update() throws SQLException;
    abstract void delete() throws SQLException;
    abstract String getTableName();
}
