/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.HashMap;

/**
 *
 * @author WINDNCC
 */
abstract class Model {
    protected HashMap insertData;
    protected HashMap updateData;
    abstract void insert();
    abstract void update();
    abstract void delete();
    abstract String getTableName();
}
