#!/bin/bash

# Download all of the Omaha World Herald Yellow Page businesses
#
# The general form of the URL to wget is:
#  http://www.owhyellowpages.com/search/business?page=0
# To request each subsequent page, the number for page needs to be
# incremented. The files should then be renamed. The naming scheme
# from wget will follow this format:
#  business?page=#
# where the number (#) is the page number from 0 to 4215.

url="http://www.owhyellowpages.com/search/business?page="
file="./business?page="
final_dir="./yellowpages/"
final_file="business"

if [ ! -d "$final_dir" ]; then
    mkdir $final_dir
fi

for a in {0..4215}
do

    wget ${url}$a
    mv ${file}$a ${final_dir}${final_file}$a.html

done
