/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.Category;
import com.farminventory.entity.Product;
import com.farminventory.entity.Transaction;
import com.farminventory.entity.Vendor;
import com.farminventory.util.Config;
import com.farminventory.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class ProductDAOImpl implements ProductDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Product> list = null;
    List<Transaction> Translist = null;
    List<Transaction> Translist2 = null;
    List<Transaction> trackList = null;
    Product product = null;
    PreparedStatement preparedStmt = null;
    UserDAO userDAO = new UserDAOImpl();

    private Transaction transaction;
    private Category category;

    @Override
    public List<Product> get() {
        try {
            list = new ArrayList<>();
            String sql = "select * from product ";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                product = new Product();
                product.setProduct_id(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("name"));
                product.setCost_price(resultSet.getDouble("cost_price"));
                product.setSelling_price(resultSet.getDouble("selling_price"));
                product.setLogger_id(resultSet.getInt("logger_id"));
                product.setCategory(resultSet.getString("category"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setPicURL(resultSet.getString("pic_url"));
                product.setVendorName(resultSet.getString("vendor_name"));

                product.setLogger(userDAO.get(resultSet.getInt("logger_id")));

                list.add(product);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    @Override
    public List<Product> getRestock() {
        Config conf = getConfig();
        int min = conf.getRestockLevel();
        try {
            list = new ArrayList<>();
            String sql = "select * from product where quantity <= " + min;
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                product = new Product();
                product.setProduct_id(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("name"));
                product.setCost_price(resultSet.getDouble("cost_price"));
                product.setSelling_price(resultSet.getDouble("selling_price"));
                product.setLogger_id(resultSet.getInt("logger_id"));
                product.setCategory(resultSet.getString("category"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setPicURL(resultSet.getString("pic_url"));
                product.setVendorName(resultSet.getString("vendor_name"));

                product.setLogger(userDAO.get(resultSet.getInt("logger_id")));

                list.add(product);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    @Override
    public boolean saveProduct(Product product) {
        boolean flag = false;
        try {

            String sql = "insert into product( name, cost_price, selling_price, logger_id, vendor_name, category, quantity, pic_url) "
                    + "values(?,?,?,?,?,?,?,?)";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, product.getName());
            preparedStmt.setDouble(2, product.getCost_price());
            preparedStmt.setDouble(3, product.getSelling_price());
            preparedStmt.setInt(4, product.getLogger_id());
            preparedStmt.setString(5, product.getVendorName());
            preparedStmt.setString(6, product.getCategory());
            preparedStmt.setInt(7, product.getQuantity());
            preparedStmt.setString(8, product.getPicURL());
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Product get(int id) {

        try {
            product = new Product();
            String sql = "SELECT * FROM product WHERE product_id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                product.setCategory(resultSet.getString("category"));
                product.setCost_price(resultSet.getDouble("cost_price"));
                product.setSelling_price(resultSet.getDouble("selling_price"));
                product.setName(resultSet.getString("name"));
                product.setProduct_id(resultSet.getInt("product_id"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setVendorName(resultSet.getString("vendor_name"));
                product.setPicURL(resultSet.getString("pic_url"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //////System.out.println(user.toString());
        return product;
    }
   

    @Override
    public Product get(String name) {

        try {
            product = new Product();
            String sql = "SELECT * FROM product WHERE name ='" + name + "'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                product.setCategory(resultSet.getString("category"));
                product.setProduct_id(resultSet.getInt("product_id"));
                product.setCost_price(resultSet.getDouble("cost_price"));
                product.setSelling_price(resultSet.getDouble("selling_price"));
                product.setName(resultSet.getString("name"));
                product.setPicURL(resultSet.getString("pic_url"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setVendorName(resultSet.getString("vendor_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //////System.out.println(user.toString());
        return product;
    }

    @Override
    public boolean update(Product product) {
        boolean flag = false;

        try {
            String sql = "update product set name='" + product.getName() + "', cost_price=" + product.getCost_price() + ", selling_price=" + product.getSelling_price() + ", logger_id=" + product.getLogger_id() + ", category='" + product.getCategory() + "', quantity =" + product.getQuantity() + ", vendor_name= '" + product.getVendorName() + "', pic_url= '" +product.getPicURL()+ "' where product_id='" + product.getProduct_id() + "'";
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM product WHERE product_id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categoryList = new ArrayList();
        try {

            String sql = "select * from category order by category";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                category = new Category();
                String categoryName = resultSet.getString("category");
                category.setName(categoryName);
                category.setId(resultSet.getInt("id"));
                category.setCreatedBy(resultSet.getString("loggedBy"));

                categoryList.add(category);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoryList;
    }

    @Override
    public Config getConfig() {
        Config conf = new Config();
        try {

            String sql = "select * from global_config where id = 1";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                //Category category = new Category();
                conf.setLastModifiedBy(resultSet.getString("modified_by"));
                conf.setPOS(resultSet.getDouble("POS"));
                conf.setVAT(resultSet.getDouble("VAT"));
                conf.setRestockLevel(resultSet.getInt("restock_level"));
                System.out.println("From the db " + resultSet.getInt("restock_level"));
                
                System.out.println("I am getting " + conf.toString());

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conf;
    }

    @Override
    public boolean updateConfig(Config config) {
        boolean flag = false;
        try {
            System.out.println("This Config = " + config.toString());
            String sqlPOS = "update global_config set POS= " + config.getPOS() + ",VAT =" + config.getVAT() + ", modified_by = '" + config.getLastModifiedBy()+ "', restock_level="+ config.getRestockLevel() + " where id =1";

            connection = DBConnectionUtil.openConnection();

            preparedStmt = connection.prepareStatement(sqlPOS);

            preparedStmt.executeUpdate();

            flag = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;

    }

    @Override
    public boolean logTransaction(Transaction transaction) {
        boolean flag = false;
        try {

            String sql = "insert into transaction( product_id, logger, client, units_sold, total_price, subcharge, vat, pos_charge, delivery_charge) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            try {
                connection = DBConnectionUtil.openConnection();
                preparedStmt = connection.prepareStatement(sql);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            int product_ID = transaction.getProduct().getProduct_id();
            preparedStmt.setInt(1, product_ID);
            preparedStmt.setString(2, transaction.getLogger().getFullName());
            preparedStmt.setString(3, transaction.getBuyer());
            preparedStmt.setInt(4, transaction.getQuantity());
            preparedStmt.setDouble(5, transaction.getTotalCharge());
            preparedStmt.setDouble(6, transaction.getSubcharge());
            preparedStmt.setDouble(7, transaction.getVAT());
            preparedStmt.setDouble(8, transaction.getPOS_charge());
            preparedStmt.setDouble(9, transaction.getDelivery().getCharge());

            preparedStmt.execute();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void updateTable(Transaction transaction) {
        int initial_quantity = transaction.getProduct().getQuantity();
        int product_id = transaction.getProduct().getProduct_id();
        int new_quantity = initial_quantity - transaction.getQuantity();

        try {
            String sqlPOS = "update product set quantity = " + new_quantity + " where product_id='" + product_id + "'";

            connection = DBConnectionUtil.openConnection();

            preparedStmt = connection.prepareStatement(sqlPOS);

            preparedStmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Transaction> getTrans() {
        ProductDAO productDAO = new ProductDAOImpl();
        try {
            Translist = new ArrayList<>();
            String sql = "select * from transaction ";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                transaction = new Transaction();
                transaction.setBuyer(resultSet.getString("client"));
                transaction.setQuantity(resultSet.getInt("units_sold"));
                transaction.setTime(resultSet.getTimestamp("time").toString().substring(0, 10));
                transaction.setLoggername(resultSet.getString("logger"));
                Product p = productDAO.get(resultSet.getInt("product_id"));
                transaction.setProductName(p.getName());
                transaction.setRef_number(resultSet.getInt("ref_number"));
                transaction.setTotalCharge(resultSet.getDouble("total_price"));
                Translist.add(transaction);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return Translist;
    }
    @Override
    public List<Transaction> getUserTransactions(String name) {
        ProductDAO productDAO = new ProductDAOImpl();
        try {
            //System.out.println("Let us get this guy from the database" + name);
            Translist = new ArrayList<>();
            String sql = "select * from transaction where logger = '" +name +"'";
            connection = DBConnectionUtil.openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                transaction = new Transaction();
                transaction.setBuyer(resultSet.getString("client"));
                transaction.setQuantity(resultSet.getInt("units_sold"));
                transaction.setTime(resultSet.getTimestamp("time").toString().substring(0, 10));
                transaction.setLoggername(resultSet.getString("logger"));
                Product p = productDAO.get(resultSet.getInt("product_id"));
                transaction.setProductName(p.getName());
                transaction.setRef_number(resultSet.getInt("ref_number"));
                transaction.setTotalCharge(resultSet.getDouble("total_price"));
               //System.out.println("See the transaction " + transaction.toString());
                Translist.add(transaction);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        ////System.out.println(Translist.get(0));
        return Translist;
    }

    @Override
    public List<Transaction> countTrans() {
        try {
            Translist = new ArrayList<>();
            String sql = "select product_id, count(*) from transaction group by product_id";
            connection = DBConnectionUtil.openConnection();

            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql);
            ProductDAO productDAO = new ProductDAOImpl();
            while (resultSet2.next()) {
                transaction = new Transaction();

                Product p = productDAO.get(resultSet2.getInt("product_id"));

                transaction.setProduct(p);
                transaction.setProductName(p.getName());
                //  transaction.setRef_number(resultSet2.getInt("ref_number"));
                transaction.setCount(resultSet2.getInt("count(*)"));

                Translist.add(transaction);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return Translist;
    }

    @Override
    public List<Transaction> trackSales() {
        try {
            Translist = new ArrayList<>();
            String sql3 = "select substring(time,1,7) as time, sum(total_price)as total_price from transaction group by substring(time, 1,7)";
            connection = DBConnectionUtil.openConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                transaction = new Transaction();
                transaction.setTime(rs.getString("time"));
                transaction.setTotalCharge2(Double.parseDouble((rs.getString("total_price"))));

                Translist.add(transaction);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Translist;
    }

    @Override
    public int countProducts() {
                int count = 0;
        try {
            
            String sql = "SELECT COUNT(*) as stock FROM product ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               count = resultSet.getInt("stock"); 
               }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
   return count;
    }

    @Override
    public boolean saveCategory(Category category) {
     boolean flag = false;
        try {

            String sql = "insert into category( category, loggedBy) "
                    + "values(?,?)";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, category.getName());
            preparedStmt.setString(2, category.getCreatedBy());
           
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;   
    }

  
    @Override
    public boolean update(Category cat) {
    boolean flag = false;
        System.out.println("Category to update " + cat.toString());
        try {
            String sql = "update category set category='" + cat.getName()+ "', loggedBy='" + cat.getCreatedBy()+ "' where id=" + cat.getId() ;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag; 
    }

    @Override
    public Category getCategory(int id) {
        try {
            category = new Category();
            String sql = "SELECT * FROM category WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

              category.setId(resultSet.getInt("id"));
              category.setName(resultSet.getString("category"));
              category.setCreatedBy(resultSet.getString("loggedBy"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //////System.out.println(user.toString());
        return category;
    }

    @Override
    public boolean deleteCategory(int id) {
         boolean flag = false;
        try {
            String sql = "DELETE FROM category WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag; }

}




















