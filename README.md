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
execute - shaded.jar file using java with command and arguments (if necessary)
Commands:
- `getKeywordCount(url, keyword)` - Search [keyword] in [url] and return 
number of matches
- `savePage(url)` - save webpage from [url] in the root folder
- `help` - show list of avaible commands
- `aboutMe` - show app info

Licensing
---------
Author: Viga Rudr

Used: Using Jsoup library. (https://jsoup.org) 

Contacts
--------
vigarudr.work@gmail.com
