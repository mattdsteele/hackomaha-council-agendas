hackomaha-council-agendas
=========================

City Council Agendas

Installation
------------

Git clone this. Run install/install.sh to set everything up.


Sub-Projects
============

agendastojson/bin/agendastojson
--------------

Grabs all pdf's on the agenda page and stores them to "data/ in the current
working directory.
Converts all the pdf's to text.
Posts the pdf's to the elasticsearch server.
Deletes all of its work.
