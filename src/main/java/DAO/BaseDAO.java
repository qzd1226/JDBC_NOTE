package DAO;

import utils.JDBCUtils;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {
    public BaseDAO() {
    }

    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);

            for(int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            int var7 = ps.executeUpdate();
            return var7;
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            JDBCUtils.closeResource((Connection)null, ps);
        }

        return 0;
    }

    public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);

            for(int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();

                for(int i = 0; i < columnCount; ++i) {
                    Object columValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }

                Object var15 = t;
                return (T)var15;
            }
        } catch (Exception var18) {
            var18.printStackTrace();
        } finally {
            JDBCUtils.closeResource((Connection)null, ps, rs);
        }

        return null;
    }

    public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);

            for(int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList list = new ArrayList();

            while(rs.next()) {
                T t = clazz.newInstance();

                for(int i = 0; i < columnCount; ++i) {
                    Object columValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }

                list.add(t);
            }

            ArrayList var16 = list;
            return var16;
        } catch (Exception var19) {
            var19.printStackTrace();
        } finally {
            JDBCUtils.closeResource((Connection)null, ps, rs);
        }

        return null;
    }

    public <E> E getValue(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);

            for(int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                Object var8 = rs.getObject(1);
                return (E)var8;
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        } finally {
            JDBCUtils.closeResource((Connection)null, ps, rs);
        }

        return null;
    }
}
