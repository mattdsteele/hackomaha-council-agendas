Business Listing Extraction
===========================

Included Files:
* OWHYellowPageExtractor.bash
* BusinessExtractor.py

[Scraping Business Listings in Omaha](http://joshbranchaud.wordpress.com/2012/10/19/scraping-business-listings-in-omaha/)
: a blog post I wrote to explain how this all was implemented

OWHYellowPageExtractor.bash
---------------------------
This is a quick and dirty bash script to pull business listings HTML pages
from OWHYellowPages.com to the local disk. It will attempt to grab all 4216
pages, though the for loop can be modified for different ranges. To run this
script, simply run:

    ./OWHYellowPageExtractor.bash

Future Work:
* Allow argument-based ranges rather than the hardcoded range
* Add an `echo` to keep the user updated on progress
* Add a quiet/verbose option to toggle full `wget` info on and off

BusinessExtractor.py
--------------------
This is a set of python functions that parse HTML documents using
<a href="http://www.crummy.com/software/BeautifulSoup/">BeautifulSoup</a>
to get certain pieces of information, namely the business name, address, city,
and state. This can be used to either parse locally stored HTML documents or
to parse them directly from a specified URL. The results will be given in CSV
format written to a specified file.

Run BusinessExtractor on a specific range of local HTML files:

    python
    >>> import BusinessExtractor
    >>> BusinessExtractor.scrape_range('outfile.csv',0,100)

Run BusinessExtractor on a specific range of URLs:

    python
    >>> import BusinessExtractor
    >>> BusinessExtractor.scrape_url_range('outfile.csv',0,100)

Future Work:
* Allow the script to be run from commandline rather than from python REPL
* Add functions for extracting new pieces of data (phone numbers, descriptions, etc.)

