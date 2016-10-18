# TripProject
This project  models a road trip as a linked list of stops, with each stop having a distance to travel, a location, and an activity. There are two itineraries (so that you can plan two trips, or make two versions of the same trip), and they should be completely independent (ie: modifying one should not cause the other to change). This means that a deep copy must be made each time the itinerary is copied from one itinerary to the other.