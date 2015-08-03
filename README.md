# hackomaha-council-agendas
***

**City Council Agendas**

# Installation
***

- Git clone this
- Run install/install.sh to install the project dependencies.
- You will also need to have an [elasticsearch](http://www.elasticsearch.org) database installed and running at `http://{host}:9200/citycouncil`


# Hot Search Terms
***
- Zoning / Zone / Rezone
- Liquor / "Special Designated License"
- Planning
- Public Hearing
- Annex / Subdivision
- OPW
- Mayor
- CSO
- Contract / Purchase Order / Interlocal / Processional Service Agreement

# Future Work
***
- Import ALL past agendas into ElasticSearch database
- Push forward with NLP implementation (break this down into more concrete goals)
- Figure out how to extract addresses from the document text (Yahoo! Placemaker for geocoding)
- Improve current front-end by displaying specific agenda items and highlighting search terms
- Mockup/Prototype other front-ends (e.g. two panel display that utilizes NLP information)
- Tie NLP processing of agenda items to nightly script.
- Collect data (e.g. what search terms are being used)

# Sub-Projects
***

## scraper/bin/agenda-scraper
***
- Runs every night at midnight.
- Downloads every agenda on the main page and adds them to our datastore if they are not already in there.

## elasticsearch
***

[elasticsearch](http://www.elasticsearch.org) is an "open source, distributed, RESTful search engine." It is used as the search database for the agendas and their extracted metadata.  Individual agendas are identified by their date.

To access a specific agenda by its identifier, use the URL format:
`http://simomaha.com:9200/citycouncil/agendas/{dashed-date}`

example:
[http://simomaha.com:9200/citycouncil/agendas/2012-10-16](http://simomaha.com:9200/citycouncil/agendas/2012-10-16)

# References/Resources
***
- [Apache OpenNLP](http://opennlp.apache.org/)
- [elasticsearch](http://www.elasticsearch.org)
- [Omaha City Council Agendas](http://www.cityofomaha.org/cityclerk/city-council/agendas)

# Related Work
***
- [Beehive Agenda Management](http://www.beehiveindustries.com/solutions/agenda-management/)
- [Open/Nebraska TIF Project](https://github.com/opennebraska/pri-tif) downloads all the Journals (minutes) of the Omaha City Council, which is a very similar effort to this Agendas project.

