hackomaha-council-agendas
=========================

City Council Agendas

Installation
------------

Git clone this. Run install/install.sh to set everything up.


Hot Search Terms
----------------
* Zoning / Zone / Rezone
* Liquor / "Special Designated License"
* Planning
* Public Hearing
* Annex / Subdivision
* OPW
* Mayor
* CSO
* Contract / Purchase Order / Interlocal / Processional Service Agreement

Sub-Projects
============

agendastojson/bin/agendastojson
--------------

Grabs all pdf's on the agenda page and stores them to "data/ in the current
working directory.
Converts all the pdf's to text.
Posts the pdf's to the elasticsearch server.
Deletes all of its work.

elasticsearch
-------------

The elasticsearch engine can be accessed at:
http://simomaha.com:9200/citycouncil/agendas/{dashed-date}

example:
http://simomaha.com:9200/citycouncil/agendas/2012-10-16

