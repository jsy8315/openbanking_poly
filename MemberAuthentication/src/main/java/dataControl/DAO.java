package dataControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import jakarta.servlet.http.HttpSession;



public class DAO {
    private static DAO instance;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public DAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws Exception {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
        return dataSource.getConnection();
    }
    
    

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DAO getInstance() {
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    public List<DTO> getViewAll() {
        List<DTO> dtos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM customerr START WITH groups = 0 CONNECT BY PRIOR id = groups ORDER SIBLINGS BY step ASC");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String bankCode = rs.getString("bankCode");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String identityNum = rs.getString("identityNum");
                String phoneNum = rs.getString("phoneNum");
                String email = rs.getString("email");
                String postalCode = rs.getString("postalCode");
                String address = rs.getString("address");
                String detailAddress = rs.getString("detailaddress");
                String jibunAddress = rs.getString("jibunaddress");
                String extraAddress = rs.getString("extraaddress");
                DTO dto = new DTO(id, bankCode,name, password, identityNum,
                        phoneNum, email, postalCode, address, detailAddress, 
                        jibunAddress, extraAddress
                        );
                dtos.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return dtos;
    }
    public void increaseCount(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE customerr SET count = count + 1 WHERE id = ?");
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Count increased successfully.");
            } else {
                System.out.println("Failed to increase count.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

//    public DTO getPostById(int id) {
//        DTO dto = null;
//
//        try {
//            conn = getConnection();
//            stmt = conn.prepareStatement("SELECT * FROM customerr WHERE id = ?");
//            stmt.setInt(1, id);
//            rs = stmt.executeQuery();
//            if (rs.next()) {
//                String title = rs.getString("title");
//                String content = rs.getString("content");
//                String writer = rs.getString("writer");
//                Date writeDate = rs.getDate("write_date");
//                int count = rs.getInt("count");
//                int groups = rs.getInt("groups");
//                int step = rs.getInt("step");
//                int indent = rs.getInt("indent");
//
//                dto = new DTO(id, title, content, writer, writeDate, count, groups, step, indent);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeResources(conn, stmt, rs);
//        }
//
//        return dto;
//    }

    /*
     * public void createReply(DTO replyDto) { Connection conn = null; PreparedStatement stmt =
     * null; ResultSet rs = null;
     * 
     * try { conn = getConnection(); String insertQuery =
     * "INSERT INTO customerr (title, content, writer, groups, step, indent) " +
     * "VALUES (?, ?, ?, ?, ?, ?)"; stmt = conn.prepareStatement(insertQuery, new String[] { "ID"
     * });
     * 
     * stmt.setString(1, replyDto.getTitle()); stmt.setString(2, replyDto.getContent());
     * stmt.setString(3, replyDto.getWriter()); stmt.setInt(4, replyDto.getGroups()); stmt.setInt(5,
     * replyDto.getStep()); stmt.setInt(6, replyDto.getIndent()); stmt.executeUpdate(); rs =
     * stmt.getGeneratedKeys(); if (rs.next()) { int id = rs.getInt(1); replyDto.setId(id); }
     * 
     * System.out.println("----------------------------------------");
     * System.out.println("답변 작성 성공"); System.out.println(replyDto.getId() + replyDto.getGroups());
     * } catch (Exception e) { e.printStackTrace(); } finally { closeResources(conn, stmt, null); }
     * }
     */
    public boolean insertMember(DTO dto) {


        try {
            conn = getConnection();
            String insertQuery = "INSERT INTO customerr (id, bankCode, password, name, identityNum, phoneNum, email, postalCode, address, jibunAddress, detailAddress, extraAddress) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(insertQuery, new String[] { "ID" });

            stmt.setString(1, dto.getId());
            stmt.setString(2, dto.getBankCode());
            stmt.setString(3, dto.getPassword());
            stmt.setString(4, dto.getName());
            stmt.setString(5, dto.getIdentityNum());
            stmt.setString(6, dto.getPhoneNum());
            stmt.setString(7, dto.getEmail());
            stmt.setString(8, dto.getPostalCode());
            stmt.setString(9, dto.getAddress());
            stmt.setString(10, dto.getJibunAddress());
            stmt.setString(11, dto.getDetailAddress());
            stmt.setString(12, dto.getExtraAddress());

            rs = stmt.getGeneratedKeys();
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
            /*
             * if (rs.next()) { int id = rs.getInt(1);
             * 
             * dto.setId(id); }
             */
             /*
              * String updateQuery = "update customerr set groups = ? where id = ?"; stmt =
              * conn.prepareStatement(updateQuery); stmt.setInt(1, dto.getId()); stmt.setInt(2,
              * dto.getId()); stmt.executeUpdate();
              */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
        return false;
    }

    public boolean updatePost(DTO dto) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE customerr SET password = ?, name = ?, phoneNum = ?, email = ?, address = ? WHERE id = ?");
            stmt.setString(1, dto.getPassword());
            stmt.setString(2, dto.getName());
            stmt.setString(3, dto.getPhoneNum());
            stmt.setString(4, dto.getEmail());
            stmt.setString(5, dto.getAddress());
            stmt.setString(6, dto.getId());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }

        return false;
    }

    public void deletePost(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM customerr WHERE id = ?");
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Post deleted successfully.");
            } else {
                System.out.println("Failed to delete post. Post not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }
}