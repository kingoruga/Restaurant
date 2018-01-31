
package DAO;

import model.FoodItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        FoodItem f = new FoodItem();
        f.setName(rs.getString(1));
        f.setDescription(rs.getString(2));
        f.setPrice(rs.getFloat(3));
        f.setType(rs.getString(4));
        f.setIsVeg(rs.getString(5).equals("0"));
        return f;
    }
}