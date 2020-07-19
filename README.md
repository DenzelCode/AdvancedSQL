# AdvancedSQL
The best Java query builder/SQL connector.

## What's AdvancedSQL?
AdvancedSQL is a SQL query builder and/or connector that helps you to generate/modify information on the database without even have to write any line of SQL code, which sometimes is kindof boring and tiring. AdvancedSQL is the best exit for that developers who wants to continue coding without having to write out-of-syntax code (SQL queries) on Java code.

## Documentation:
Connect to the Database:
There is no need to create the database manually, AdvancedSQL does it for you.
```java
import advancedsql.*;

try {
    MySQL mySQL = new MySQL("127.0.0.1", 3306, "root", "password", "database");

    if (mySQL.isConnected()) {
        System.out.println("Connected!");
    }
} catch (SQLException e) {
    e.printStackTrace();
}
```

## Licensing information
This project is licensed under LGPL-3.0. Please see the [LICENSE](/LICENSE) file for details.

## Donations
* [PayPal](https://paypal.me/DenzelGiraldo)
