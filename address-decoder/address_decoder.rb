require 'yahoo-placemaker'

def addresses(text)
  omaha_woe_id = '2465512'
  options = { 'focusWoeId' => omaha_woe_id }
  app_id = 'rwqKNO_V34G9..rg4xTlqwd14XxaevnHjzDkaARubilhGbIhR0kFbIp2H_b3YBpaWpM-'
  eval "Yahoo::Placemaker::APP_ID = app_id"

  result = Yahoo::Placemaker::extract text, options
  result
end

text = "This agenda, which shall be kept continually current, shall be available for public inspection in the Office of the City Clerk, Omaha-Douglas Civic Center, 1819 Farnam St, LC 1, Omaha, NE, during normal business hours. All requests for sign language interpreters (signers) will require a minimum of 48 hours advance notice. Alternative formats require a minimum of 72 hours advance notice. Please contact Sandra L. Moses 444-5552 if arrangements need to be made."

results = addresses text
puts results.document.references.to_s
