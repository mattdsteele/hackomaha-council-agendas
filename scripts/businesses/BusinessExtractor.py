# BusinessExtractor
# the purpose of this module is to go through the 4000+ html pages from
# www.owhyellowpages.com that contain business listings so as to extract
# the business name, address, and possibly other relevant information.
# Two approaches can be taken:
# - access the file on disk and parse relevant content
# - access the file online and parser the relevant content

from bs4 import BeautifulSoup
import urllib2

# f = open('yellowpages/business1.html', 'r')
# html = f.read()
# soup = BeautifulSoup(html, "html5lib")
# tags = soup.find("div", { "class" : "fn org" })
# print tags

htmlfile = "yellowpages/business" # need to add number and .html to end
firstfile = "yellowpages/business0.html"

# get_file_soup
# this function takes a file name and generates the soup object for
# it using the BeautifulSoup library.
def get_file_soup(filename):
	f = open(filename, 'r')
	html = f.read()
	soup = BeautifulSoup(html, "html5lib")
	f.close()
	return soup

# get_url_soup: String -> Soup
# given the URL for a website, this function will open it up, read in
# the HTML and then create a Soup object for the contents. That Soup
# object is returned.
def get_url_soup(url):
	f = urllib2.urlopen(url)
	html = f.read()
	soup = BeautifulSoup(html, "html5lib")
	f.close()
	return soup

# get_address_for_business
# this function takes a particular vcard business from the overall
# html soup and finds the street-address and returns that unicode object
def get_address_for_business(vcard):
	address = vcard.find('span', { 'class' : 'street-address' })
	if(address != None):
		innerstuff = address.contents
		if len(innerstuff) > 0:
			inner_item = innerstuff[0]
			return inner_item
		else:
			return ""
	else:
		return ""

# get_citystate_for_business
# this function takes a particular vcard business from the overall
# html soup and finds the citystate info and returns that unicode object
def get_citystate_for_business(vcard):
	citystate = vcard.find('span', { 'class' : 'city-state' })
	if(citystate != None):
		innerstuff = citystate.contents
		if len(innerstuff) > 0:
			inner_item = innerstuff[0]
			return inner_item
		else:
			return ""
	else:
		return ""

# get_name_for_business
# this function takes a particular vcard business from the overall
# html soup and finds the name of the business and returns that unicode object
def get_name_for_business(vcard):
	name = vcard.find('span', { 'class' : 'fn org' }).find('a')
	if(name != None):
		innerstuff = name.contents
		if len(innerstuff) > 0:
			inner_item = innerstuff[0]
			return inner_item
		else:
			return ""
	else:
		return ""

# print_each_vcard
# this function will go through the 10 vcards for a given soup of the html
# page and spit out the information in CSV format to the console
def print_each_vcard(soup):
	vcards = soup.findAll('div', { 'class' : 'vcard' })
	for vcard in vcards:
		items = []
		items.append(get_name_for_business(vcard))
		items.append(get_address_for_business(vcard))
		items.append(get_citystate_for_business(vcard))
		print ','.join('"{0}"'.format(w) for w in items)

def list_each_vcard(soup):
	vcards = soup.findAll('div', { 'class' : 'vcard' })
	businesses = []
	for vcard in vcards:
		items = []
		items.append(get_name_for_business(vcard))
		items.append(get_address_for_business(vcard))
		items.append(get_citystate_for_business(vcard))
		businesses.append(','.join('"{0}"'.format(w) for w in items))
	return businesses

# scrape_range: String int int -> void
# given the name of an output file, an int for the beginning of the range,
# and an int for the end of the range, this function will go through each
# set of business vcards and get the CSV business data. Each set of this
# data will be written to the out file.
def scrape_range(outfile, begin, end):
	csvfile = open(outfile, 'a')
	for a in range(begin, end+1):
		soup = get_file_soup(htmlfile + str(a) + ".html")
		for business in list_each_vcard(soup):
			csvfile.write(business + "\n")
	csvfile.close()

# scrape_url_range: String int int -> void
# given the name of an output file, an int for the beginning of the range,
# and an int for the end of the range, this function will open up the URLs
# in that range and then scrape out the business attributes from the vcards
# that we are interested in. The scraped data will be written to the out file.
def scrape_url_range(outfile, begin, end):
	csvfile = open(outfile, 'a')
	for a in range(begin, end+1):
		soup = get_url_soup("http://www.owhyellowpages.com/search/business?page=" + str(begin))
		for business in list_each_vcard(soup):
			csvfile.write(business + "\n")
	csvfile.close()
