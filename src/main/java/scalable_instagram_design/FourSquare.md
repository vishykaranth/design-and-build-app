Design Scalable System like Foursquare
1- What is Foursquare?

As you know, if you decide to design scalable system, you should first the point that is the definition of the system. This means that you should be sure that what this system is. So firstly, we should explain the goal of the system. This is basically the system that presents locations to users based on nearby their locations. You can find nearby locations such as restaurants, hospitals, cafes and etc… In addition, you can search any location based on your demand. If you do this when you use this system, it should suggest best options that are closest to your location.

2- Identifying requirements



 

As we said before, the most important goal is presenting the most suitable places to you based on your searching query and location. There are three requirements that we need to define at first.

  Functional Requirements
  a-Users can register the system.
  b-Users can login or log out the system.
  c-Users can search a place such as a restaurant, theatre or etc..
  d-Users can comment a place.
  e-Users can like or dislike a place.
  f-Users can review a place.
  g-Users can add a place.
  h-Users can add pictures to added places.
  j-Users can update or delete a place if they added a place themselves.

  Nonfunctional Requirements
  a-Users should have a real-time experience.
  b-As we know, the system should be under read-heavy. Minimum latency is one of the most important parts of the system.
  c-The system should be highly available.
  d-The System should be reliable. This is important because nobody wants to lose their comments or places that they added.
  e-Consistency can take a hit. This means that if users don’t see the hottest review or places for a while, this should be ok.

  Extended Requirements

  a-The system should monitor.
  b-The system should suggest best options as soon as possible. The way to save the data and the search and recommendation algorithms are very important.

3- Capacity Estimation

Let’s assume there are totally 100 Million places in our system and 10.000 queries come to the system each day. We should keep in our mind that this system continues to grow each year and we can assume that the growth rate of the system equals to 10%. We have talked about the total capacity of the system for ten years. If you realized that system capacity is huge, we need to scale the system effectively. Notice that when we mention about the capacity, we should be careful about the optimum availability. Using 80% of each server is the most optimal use. To illustrate this, if the system capacity is 80 TB, we need to 100 TB for total capacity to reach optimum usability.

4- Database Design

As you know, we have two options which are SQL and NoSQL to select best database method. NoSQL is the best way to scale system easily. On the other hand, if we think the relations and constraints of SQL, scaling SQL databases is very difficult.

  Place
  PlaceID
  AddedUserID
  Name
  Longitude
  Latitude
  Category
  Description
  AddedDate
  Point
  LikeCount
  DislikeCount


 

  small_apps.User
  UserID
  UserName
  RegisterionDate
  LastLogin Date

  UserComment
  UserID
  PlaceID
  Like
  Dislike
  Comment
  CommentDate

** Notice that we can create UserID and PlaceID through Key Generation Service. KGS ensures that each key is unique in the system. The second important point is that 8 byte is enough to keep placeID and userID. Additionally, we can keep longitude and latitude with 8 bytes.

5- API Estimation
We can choose one of those two methods, REST or SOAP. There are four main API for designing the system.

  a-) AddPlace(api_dev_key, name, description, longitude, latitude, category): This API returns the HTTP response showing operation is a success or not.

  b-) DeletePlace(api_dev_key, placeID): This API returns the HTTP response showing operation is a success or not.

  c-) UpdatePlace(api_dev_key, placeID, name = null, description = null, longitude = null, latitude = null, category = null)

  d-) GetPlace(api_dev_key, search_query, maximum_return_count, radius,  userlongitude, userlatitude, categoryfilter = null, sortby, page_token): return JSON including the list of most suitable places with their name, like count, dislike count, explanation, location, thumbnail and etc…

6- System Design

You know how important indexing is in large scalable systems. There are no many updating operations in our system. If we select the indexed pieces carefully, this system responds faster. Indexing is not recommended for operations with too many updates. Our search query should focus the user’s and places’ locations so the way to store data is so important.  There are three ways to store data which are SQL, Grid, Dynamic sizable grid.


 

  SQL:

SQL is the simple solution. If you decide to use SQL, you need to index based on placeID, longitude, and latitude. This method is not effective because there is two source to get the data which are longitude and latitude. All these two sources are indexed sources. This is a phase that reduces the response time because both of them return a response and these coming responses combine for getting an optimum result.
select * from Places where placeLongitude between userLongitude – Radius and userLongitude + Radius and placeLatitude between userLatitude – Radius and userLatitude + Radius order by (selected ranking method) desc.

  Grid:

We can use a grid to solve performance problems. We can divide the whole world into smaller grids. This ensures that we can only deal with the few amount of grids. Thanks to this method, we just only focus on the user location grid and its neighbour grids. A map is the best choice to use a grid. Key is the gridID. Value is the whole places in this grid.
Select * from Places where Latitude between userLatitude – Radius and userLatitude + Radius and GridID in (GridID1, GridID2, …)
There is a problem with using a grid. As you know, all grids may not have same places so we can use a dynamic sizable grid.
We can keep all index in memory. This provides system become closer to real-time experience.

  Dynamic Sizable Grid:

A quadtree is a tree data structure in which each internal node has exactly four children. A quadtree is a good option to use a dynamic sizable grid. The way to walk about the child nodes of each grid can be provided by using doubly linked list. If we assume we want that each grid cannot have over the 200 places, when the limit is exceeded and division begins.

7- Data Partitioning

We can partition the system based on regionID or locationID. If we use regionID, the system may be non-uniform distributed. To illustrate this,  It can be very difficult to fit popular regions or regions having more places. We can handle this problem by using consistent hashing. The second option to partition data is sharding based on locationID. If we use locationID for sharding, the system becomes more uniformly distributed.

8- Replication and Load Balancer

As we mentioned above, the replication process is a valuable process to provide high availability, high reliability, and real-time experience. It is recommended to have 3 or more replicas for each server and service. This ensures that system automatically becomes more reliable and available. We can keep same data onto three different resources and thanks to this process if one server dies, the system automatically continues to work replicas. One more advantage of replication is the system may continue to run at an update to the system.


 

In replication process, there is a master-slave relationship between the server and its replicas. A Master is for writing and reading operations; a slave is for reading operations.

Load balancing refers to distributing requests across a group of services and servers. When we have talked about the replication and sharding, an incoming request must be directed and this is done by a load balancer. We can use Round-Robin method to redirect incoming requests but there may be a problem in this case. Round-Robin stops sending requests to dead servers but Round-Robin cannot stop sending requests to a server exposed to heavy traffic. We can prepare intelligent Round-Robin algorithm to take away this problem. Additionally, we can use consistent hashing to redirect incoming requests. Consistent hashing ensures that system becomes more uniformly distributed.

The possible problem for sharding with a load balancer is how we rebuilt the system when this system dies. The possible approach is brute-force. This method is slow because we need to rebuilt whole the system from the beginning. We can eliminate this problem by reverse indexing. We can have another Index server that will hold all information about reverse indexing. Reverse index maps all places. We need to build a map and key is the serverID (QuadTree server) and value is all places.

9- Caching Mechanism

There are many caching methods that we can use but LRU is the good choice for this system. Additionally, 80%-20% rule is valid for caching mechanism. This explains that we need to memory capacity to 20% of daily data. Moreover, as we explained before, keeping indexes in memory provides the system becomes more performance.

10- Ranking Mechanism
We can have various ranking mechanisms which are most popular, most relevant, newest and etc… As you know, we can have many servers and we need to get data from these servers. Because of this reason, we need to aggregate function to combine all these data to obtain the most desirable solution.