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

`savePage(String url)`
- Save html-code of page in default folder
- String url - link of webpage

`help()`
- Show list of available commands

`boutMe()`
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
