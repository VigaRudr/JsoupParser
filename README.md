What is it?
-----------
Jsoup Parser is a parser designed to analyze a webpage and manipulate it.

The Latest Version
------------------
Can be found in master branch of this project.

Current version: 1.1-SNAPSHOT

Documentation
-------------
\doc\AppComposition

Packaging
---------
Packages a project using Maven

Create one jar file with dependencies inside using maven-shade-plugin in \target

Using Java 18

Using
--------
!App will create ./database folder

execute - shaded.jar file using java with command and arguments (if necessary)

to run any command write: java -jav .\JsoupParser-1.1-SNAPSHOT-shaded.jar command arguments

Commands (also can use help):
- `getKeywordCount(url, keyword)` - Search [keyword] in [url] and return 
number of matches
- `savePage(url, path)` - save webpage from [url] in the [path] folder 
(if folder not specified, saves in ./savedPages folder)
- `help` - show list of avaible commands
- `aboutMe` - show app info

Licensing
---------
Author: Viga Rudr

Used:
- Jsoup library. (https://jsoup.org) 

- SQLite JBDC Driver (https://www.sqlite.org/java/raw/doc/overview.html?name=0a704f4b7294a3d63e6ea2b612daa3b997c4b5f1)

Contacts
--------
vigarudr.work@gmail.com
