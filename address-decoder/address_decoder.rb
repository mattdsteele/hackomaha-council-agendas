require 'yahoo-placemaker'
require 'json'
app_id = 'rwqKNO_V34G9..rg4xTlqwd14XxaevnHjzDkaARubilhGbIhR0kFbIp2H_b3YBpaWpM-'
Yahoo::Placemaker::APP_ID = app_id

def addresses(text)
  omaha_woe_id = '2465512'
  options = { 'focusWoeId' => omaha_woe_id }
  Yahoo::Placemaker::extract text, options
end

def texts
  text = JSON.parse `curl -q http://simomaha.com/citycouncil/agendas/2012-10-16`
  text['_source']['text']
end

class LocationResults
  @locations
end

class Location
  attr_accessor :text, :reference
end

texts.each do |t|
  addresses = addresses t
  valid_addresses = addresses.document.places.select {|i| i.centroid.latitude < 41.5084 && i.centroid.latitude > 41.0 }
  valid_addresses.each do |l|
    puts "in text:"
    puts t
    puts "#{l.name} : #{l.centroid.latitude},#{l.centroid.longitude}"
  end

  addresses.document.references.select do |i|

  end
  addresses.document.references.each do |i|
    puts i.text
  end

end

