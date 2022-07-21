The composition of the application
----------------------------------
Main(String[] argv) 
-------------------
The function provides console interaction with app.

class Handler
------------
Command invoker

Contains hash table to interact with WebsiteControl commands

interface Command
-----------------
Just implements the command interface

class ControlWebsite
--------------------
A receiver class for interacting with a web page using the available commands.

Contains a Website object

Provides interaction with that object

Methods:

`getKeywordCount(String url, String keyword)`
- Get keyword number from webpage url
- String url - webpage link
- String keyword - searched keyword
- send path to database column

`savePage(String url, String path)`
- Save html-code of page in [path]
- String url - link of webpage

`help()`
- Show list of available commands

`AboutMe()`
- Print app information

## Inner classes:

 `Website`
- Website description
- Stores url, title and html code of webpage.
- Interacts with the url using Jsoup


## class GetKeywordCount(String url, String keyword)
## class savePage(String url)
## class help
## class aboutMe
External classes of ControlWebsite function via command

class DatabaseControl
---------------------
Class for interacting with databese using JDBC Driver
and SQLite DBMS

- Database path: /database/JsoupParser.db
- table name is [JsoupParserTable]
- Values are:
   ```
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    URL VARCHAR(100),
    Keyword VARCHAR(50),
    SavePath VARCHAR(50));
    ```

Contains a Database object

Methods:

`send(String url, String keyword)`
- send [url] and searching [keyword] in database

`updatePath(String path, String url)`
- update empty data of saved file [path] in database

`delete(String condition)`
- for future use 
- delete row from database if [condition]

`clear()`
- for future use
- clear database

## Inner classes:

 `Database`
- Database description
- Stores tableName, path.
- Opens a database connection using JDBC
- Creates statement for interact with database
- Creates JsoupParserTable if not exists
