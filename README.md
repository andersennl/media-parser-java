# Mediaparser written in Java
## Description
This is a hobby project which parses movies and series in a given directory structure, similar as e.g. Plex does it.
After completing the analysis, a HTML template is written, listing the resulsts. The resulsts file can then for instance be served via NGINX. [Here](https://github.com/andersennl/mediaserver-nginx-config) is a example config.

## Setup
Currently the directory structure is constant but you can change it [in this file](https://github.com/andersennl/media-parser-java/blob/master/src/com/company/Main.java).
The app currently supports one movie and one series directory.

## Development
I'm currently rewriting the project in Kotlin and Node. There is another version written in Python, which can be [found here](https://github.com/andersennl/media-parser-python).

## Contribution
Feel free to create a pr.
