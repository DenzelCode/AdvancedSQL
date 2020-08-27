# AdvancedSQL
The best Java query builder/SQL connector.

## What's AdvancedSQL?
AdvancedSQL is a SQL query builder and/or connector that helps you to generate/modify information on the database without even have to write any line of SQL code, which sometimes is kindof boring and tiring. AdvancedSQL is the best exit for that developers who wants to continue coding without having to write out-of-syntax code (SQL queries) on Java code.

## Download
Download the last JAR version: https://github.com/DenzelCode/AdvancedSQL/releases/latest

## Dependency for maven:
```
<dependency>
    <groupId>com.code</groupId>
    <artifactId>advancedsql</artifactId>
    <version>2.0.0</version>
    <systemPath>${project.basedir}/lib/com.code.advancedsql.jar</systemPath>
</dependency>
```

## Examples:
**Connect to the Database:**
There is no need to create the database manually, AdvancedSQL does it for you.
```java
import com.code.advancedsql.*;

try {
    MySQL mySQL = new MySQL("127.0.0.1", 3306, "root", "password", "database");

    if (mySQL.isConnected()) {
        System.out.println("Connected!");
    }
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Create table:**
```java
import com.code.advancedsql.*;
import com.code.advancedsql.table.ITable;

try {
    MySQL mySQL = connect();

    // Table
    ITable table = mySQL.table("users");

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
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Alter table:**
```java
import com.code.advancedsql.*;
import com.code.advancedsql.query.action.Add;
import com.code.advancedsql.query.action.Modify;

try {
    MySQL mySQL = connect();

    // Alter columns
    Alter alter = mySQL.table("users").alter();

    // Add columns
    Add add = alter.add();
    add.string("token").nullable();
    add.string("connection_id").nullable();

    // Drop columns
    com.code.advancedsql.query.action.Drop drop = alter.drop();
    drop.column("test");

    // Modify columns
    Modify modify = alter.modify();
    modify.integer("connection_id").nullable();

    // Execute query
    Boolean result = alter.execute();

    // Print query string and result.
    System.out.println(alter);
    System.out.println(result);
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Insert:**
```java
import com.code.advancedsql.*;

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
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Update:**
```java
import com.code.advancedsql.*;

try {
    MySQL mySQL = connect();

    // Update
    Update query = mySQL.table("users").update(new HashMap<>(){{
        put("token", "Advanced");
    }}).where("first_name = ?", "Denzel");
    int execute = query.execute();

    // Print query string and result.
    System.out.println(query);
    System.out.println(execute)p
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Select:**
```java
import com.code.advancedsql.*;

try {
    MySQL mySQL = connect();

    // Select
    Select query = mySQL.table("users").select();
    Map<String, Object> fetch = query.fetch();

    // Print query string and result.
    System.out.println(query);
    System.out.println(fetch);
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Select with join:**
```java
import com.code.advancedsql.*;
import com.code.advancedsql.query.action.Add;
import com.code.advancedsql.query.action.Modify;
import com.code.advancedsql.table.ITable;

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

    // Insert value
    table.insert(new HashMap<>(){{
        put("user_id", 1);
        put("address", "20 Cooper Square");
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
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Delete:**
```java
import com.code.advancedsql.*;

try {
    MySQL mySQL = connect();

    // Delete
    Delete query = mySQL.table("users").delete().where("first_name = ?", "Denzel");
    int execute = query.execute();

    // Print query and result.
    System.out.println(query);
    System.out.println(execute);
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Truncate:**
```java
import com.code.advancedsql.*;

try {
    MySQL mySQL = connect();

    // Truncate table
    Truncate query = mySQL.table("users").truncate();
    Boolean execute = query.execute();

    // Print query and result.
    System.out.println(query);
    System.out.println(execute);
} catch (SQLException e) {
    e.printStackTrace();
}
```

**Drop:**
```java
import com.code.advancedsql.*;

try {
    MySQL mySQL = connect();

    // Drop table
    Drop query = mySQL.table("users").drop();
    Boolean execute = query.execute();

    // Print query and result.
    System.out.println(query);
    System.out.println(execute);
} catch (SQLException e) {
    e.printStackTrace();
}
```

## Licensing information
This project is licensed under LGPL-3.0. Please see the [LICENSE](/LICENSE) file for details.

## Donations
* [PayPal](https://paypal.me/DenzelGiraldo)
