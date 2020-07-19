/**
 *
 * AdvancedSQL
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *
 * @copyright Copyright (c) 2020 AdvancedSQL
 * @author Denzel Code
 * @link https://github.com/DenzelCode/AdvancedSQL
 *
 */
package advancedsql;

import advancedsql.query.*;
import advancedsql.query.action.Add;
import advancedsql.query.action.Modify;
import advancedsql.table.ITable;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MySQLTest {
    public MySQL connect() throws SQLException {
        return new MySQL("127.0.0.1", 3306, "root", "", "unittesting");
    }

    @Test public void testConnection() {
        try {
            MySQL mySQL = connect();

            assertTrue(mySQL.isConnected());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testCreateTable() {
        try {
            MySQL mySQL = connect();

            // Table
            ITable table = mySQL.table("users");

            if (mySQL.table("test").exists()) {
                System.out.println("Table test already exists, deleting.");

                table.drop().execute();
            }

            // Create table
            Create create = table.create();

            // Table columns
            create.id();
            create.string("first_name");
            create.string("last_name");
            create.string("test");

            Boolean result = create.execute();

            // Print query string and result.
            System.out.println(create);
            System.out.println(result);

            assertFalse(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testAfterTable() {
        try {
            MySQL mySQL = connect();

            // Alter columns
            Alter alter = mySQL.table("users").alter();

            // Add columns
            Add add = alter.add();
            add.string("token").nullable();
            add.string("connection_id").nullable();

            // Drop columns
            advancedsql.query.action.Drop drop = alter.drop();
            drop.column("test");

            // Modify columns
            Modify modify = alter.modify();
            modify.integer("connection_id").nullable();

            // Execute query
            Boolean result = alter.execute();

            // Print query string and result.
            System.out.println(alter);
            System.out.println(result);

            assertFalse(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testInsert() {
        try {
            MySQL mySQL = connect();

            // Insert
            Insert query = mySQL.table("users").insert(new HashMap<>(){{
                put("first_name", "Denzel");
                put("last_name", "Code");
            }});
            int execute = query.execute();

            // Print query string and result.
            System.out.println(query);
            System.out.println(execute);

            assertEquals(1, execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testUpdate() {
        try {
            MySQL mySQL = connect();

            // Update
            Update query = mySQL.table("users").update(new HashMap<>(){{
                put("token", "Advanced");
            }}).where("first_name = ?", "Denzel");
            int execute = query.execute();

            // Print query string and result.
            System.out.println(query);
            System.out.println(execute);

            assertEquals(1, execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testSelect() {
        try {
            MySQL mySQL = connect();

            // Select
            Select query = mySQL.table("users").select();
            Map<String, Object> fetch = query.fetch();

            // Print query string and result.
            System.out.println(query);
            System.out.println(fetch);

            assertEquals(fetch.get("first_name"), "Denzel");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testCreateSelectJoin() {
        try {
            MySQL mySQL = connect();

            // Create information table
            ITable table = mySQL.table("information");

            // Delete table if exists.
            if (mySQL.table("information").exists()) table.drop().execute();

            // Create table
            Create create = table.create();

            // Table columns
            create.id();
            create.integer("user_id").nullable();
            create.string("address").nullable();
            Boolean execute = create.execute();

            // Print query and result.
            System.out.println(create);
            System.out.println(execute);

            String address = "20 Cooper Square";

            // Insert value
            table.insert(new HashMap<>(){{
                put("user_id", 1);
                put("address", address);
            }}).execute();

            table = mySQL.table("users");

            Select query = table.select(new String[]{"information.address", "users.first_name"})
                    .innerJoin("information")
                    .on("users.id = information.user_id")
                    .where("first_name = ?", "Denzel");

            Map<String, Object> user = query.fetch();

            // Print query and result.
            System.out.println(query);
            System.out.println(user);

            assertEquals(address, user.get("address"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testDelete() {
        try {
            MySQL mySQL = connect();

            // Delete
            Delete query = mySQL.table("users").delete().where("first_name = ?", "Denzel");
            int execute = query.execute();

            // Print query and result.
            System.out.println(query);
            System.out.println(execute);

            assertEquals(1, execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testTruncate() {
        try {
            MySQL mySQL = connect();

            // Truncate table
            Truncate query = mySQL.table("users").truncate();
            Boolean execute = query.execute();

            // Print query and result.
            System.out.println(query);
            System.out.println(execute);

            assertFalse(execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testDrop() {
        try {
            MySQL mySQL = connect();

            // Drop table
            Drop query = mySQL.table("users").drop();
            Boolean execute = query.execute();

            // Print query and result.
            System.out.println(query);
            System.out.println(execute);

            assertFalse(execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
