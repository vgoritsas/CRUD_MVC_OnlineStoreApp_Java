package onlinestoreapp.model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import onlinestoreapp.database.DBC;

// The model class extends DB
public class Model extends DBC {

    /**
     * δηλώνο id , productName , productSku, productPrice , productSize & και τα
     * sql queries
     *
     */
    private int id;
    private String productName;
    private String productSku;
    private double productPrice;
    private double productSize;

    private ResultSet result;

    private PreparedStatement ps;
    private String SQL_ADD; // save sql query for add
    private String SQL_EDIT; // save sql query for edit
    private String SQL_DELETE; // save sql query for delete
    private String SQL_CHECK_ID; // save sql query for check_id
    private String SQL_DISPLAY_DATA; // save sql query for display data
    private String SQL_CHECK_SKU; //save sql query for check sku

    /*
    Constructor
    */
    public Model() {
        /* initialize the variables  */
        super();

        this.id = 0;
        this.productName = null;
        this.productSku = null;
        //this.productPrice = null;
        //this.productSize = null;
        this.result = null;
        this.SQL_ADD = null;
        this.SQL_CHECK_ID = null;
        this.SQL_CHECK_SKU = null;
        this.SQL_DISPLAY_DATA = null;
        this.SQL_CHECK_ID = null;
        this.SQL_DELETE = null;

    }

    // set id with input integer
    public void setID(int id) {
        this.id = id;
    }

    // return id
    public int getID() {
        return this.id;
    }

    // set Productname with input string
    public void setProductName(String pname) {
        this.productName = pname;
    }

    // return productname
    public String getProductName() {
        return this.productName;
    }

    // set productsku with string input
    public void setProductSku(String sku) {
        this.productSku = sku;
    }

    // return product sku
    public String getProductSku() {
        return this.productSku;
    }

    // set productprize with double input 
    public void setProductPrice(double pprice) {
        this.productPrice = pprice;
    }

    // return productprice
    public double getProductPrice() {
        return this.productPrice;
    }

    // set productsize with double input
    public void setProductSize(double psize) {
        this.productSize = psize;
    }

    // return productsize
    public double getProductSize() {
        return this.productSize;
    }

    /**
     * INSERT DATA IN DATABASE.
     *
     * @return
     * @throws SQLException
     */
    public int add() throws SQLException {
        SQL_ADD = "INSERT INTO `onlinestore` ( `Name`, `Sku`, `Price`, `Size`) VALUES (?,?,?,?);";
        ps = (PreparedStatement) super.doConnect().prepareStatement(SQL_ADD);
        ps.setString(1, getProductName());
        ps.setString(2, getProductSku());
        ps.setDouble(3, getProductPrice());
        ps.setDouble(4, getProductSize());
        int insertData = ps.executeUpdate();
        ps.close();
        return insertData;
    }

    /**
     * EDIT DATA
     *
     * @return
     * @throws SQLException
     */
    public int edit() throws SQLException {
        SQL_EDIT = "UPDATE `onlinestore` SET `Name` = ? , `Sku` = ? , `Price` = ? , `Size` = ? WHERE `onlinestore`.`Id` = ?;";
        /**
         * the super.doConnection () get from the superclass ie the DBC the
         * method "doConnect" return makes the connection to the database
         */
        ps = (PreparedStatement) super.doConnect().prepareStatement(SQL_EDIT);
        /**
         * The Gets gets the variables that will set in vies. e.g. *
         * setProductName (pname.getText ()); τύπο π.χ String , int κτλπ
         */
        ps.setString(1, getProductName());
        ps.setString(2, getProductSku());
        ps.setDouble(3, getProductPrice());
        ps.setDouble(4, getProductSize());
        ps.setInt(5, getID());
        int updateData = ps.executeUpdate();
        ps.close();
        return updateData;
    }

    /**
     * DELETE DATA FROM DATABASE
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int delete() throws SQLException {
        SQL_DELETE = "DELETE FROM `onlinestore` WHERE `onlinestore`.`Id` =  ?";
        /**
         * the super.doConnection () get from the superclass ie the DBC the
         * method "doConnect" return makes the connection to the database
         */
        ps = (PreparedStatement) super.doConnect().prepareStatement(SQL_DELETE);
        ps.setInt(1, getID());
        int deleteData = ps.executeUpdate();
        ps.close();
        return deleteData;
    }


    /**
     * CHECK IF SKU IS EXIST
     *
     * @param sku
     * @return
     * @throws SQLException
     */
    public ResultSet checkSKU(String sku) throws SQLException {
        SQL_CHECK_SKU = "SELECT * FROM `onlinestore` WHERE `onlinestore`.`Sku` = ? ";
        /**
         * the super.doConnection () get from the superclass ie the DBC the
         * method "doConnect" return makes the connection to the database
         */
        ps = (PreparedStatement) super.doConnect().prepareStatement(SQL_CHECK_SKU);
        ps.setString(1, sku);
        result = ps.executeQuery();
        return result;
    }

    /**
     * DISPLAY DATA FROM DATABASE.
     *
     * @return
     * @throws SQLException
     */
    public ResultSet data() throws SQLException {
        SQL_DISPLAY_DATA = "SELECT * FROM onlinestore";
        /**
         * the super.doConnection () get from the superclass ie the DBC the
         * method "doConnect" return makes the connection to the database
         */
        ps = (PreparedStatement) super.doConnect().prepareStatement(SQL_DISPLAY_DATA);
        result = ps.executeQuery();
        return result;
    }

    /**
     * *
     * SEARCH BY PRICE
     *
     * @param from
     * @param to
     * @return
     * @throws SQLException
     */
    public ResultSet searchByPrice(double from, double to) throws SQLException {
        String a = "SELECT * FROM onlinestore where Price between '" + from + "'and'" + to + "'";
        /**
         * η super.doConnection() πέρνει από την super class δηλαδη την DBC την
         * method "doConnect" που κάνει return την σύνδεση με την βάση δεδομένων
         */
        ps = (PreparedStatement) super.doConnect().prepareStatement(a);
        result = ps.executeQuery();
        return result;

    }

    /**
     * SEARCH BY SIZE
     *
     * @param from
     * @param to
     * @return
     * @throws SQLException
     */
    public ResultSet searchBySize(double from, double to) throws SQLException {
        String size = "SELECT * FROM onlinestore where Size between '" + from + "'and'" + to + "'";
        /**
         * η super.doConnection() πέρνει από την super class δηλαδη την DBC την
         * method "doConnect" που κάνει return την σύνδεση με την βάση δεδομένων
         */
        ps = (PreparedStatement) super.doConnect().prepareStatement(size);
        result = ps.executeQuery();
        return result;
    }

}
