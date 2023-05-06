# ConectAR

<!DOCTYPE html>
<html>
<body>
	<h1>Telephone Connections Planner</h1>
	<p>This project presents an application for planning telephone connections between locations located in depopulated regions. To do this, we find the minimum spanning tree of a graph whose vertices are the locations and the edges are the connections between cities, this was possible thanks to the Kruskal's algorithm. In addition, it describes how the distance between connections is calculated and how the algorithm is implemented.</p>
	<h2>Geonames Library and Auto Window</h2>
	<p>This library allows the program to connect to the Geonames website's database, which has information on locations around the world. The Geonames class in the Sistema package contains the method for registering a location using this library, it receives the name entered by the user and filters the result so that they are only locations in Argentina, then the first location found is registered. For example, if San Miguel is typed in the Auto window, which is the one that interacts with the library, it will show that San Miguel de Tucumán was registered; if you want to register the party of San Miguel, you can be more specific by entering San Miguel, Buenos Aires.</p>
	<h2>Manual Registration Window</h2>
	<p>This window was created before the window that interacts with the library mentioned in the previous paragraph, it allows the user to enter customized locations. The name, province, and coordinates that the user desires can be entered, as long as it complies with the IREP.</p>
	<h2>Map Window</h2>
	<p>This window shows the locations entered by the user, which are marked on a JMapViewer, and when the "Calculate" button is pressed, the connections are displayed on the map with the total cost of them. When a new location is registered, it may not be visible, to fix this, you can use the "Refresh Map" button. There is also a button that allows you to delete locations from the map and another that allows you to save the entered locations so that they appear the next time the program is run.</p>
	<h2>Save Locations</h2>
	<p>This function is possible thanks to the Gson library, which allows interaction with .json files. The Gson package is responsible for loading and saving the file. As a point to note, the file is not interacted with through the methods for registering and deleting locations, the only times this is done are when the program starts and when the user presses the button to save their preferences.</p>
	<h2>Costs Window</h2>
	<p>This window allows the user to see the planning costs in more detail through a table that shows the individual connections. Each row contains a connection between their respective locations, and its cost is separated into cost per kilometer, increasing if the connection exceeds 300 km, and a fixed cost that is added if it is a connection between two different provinces.</p>
	<h2>Calculation of Distance and Cost between Edges</h2>
	<p>The distance between edges in a weighted graph refers to the weight of the edge, which indicates the cost or distance between two vertices connected by the edge. In the solution presented in this project, the Conexion class is used to represent an edge, which has an origin location, a destination location, and a cost. The calcularDistancia and calcularCosto methods of the Conexion class are responsible for calculating the distance between two edges and the cost of the connection. These two methods solve it as follows.</p>
	<ul>
		<li>calcularDistancia: calculates the distance in kilometers from both locations

ChatGPT
using the Haversine formula, which takes into account the curvature of the Earth. This formula takes the latitude and longitude of both locations and calculates the distance between them. The result is returned in kilometers.</li>
<li>calcularCosto: calculates the cost of the connection using the distance calculated by the calcularDistancia method. If the distance is less than or equal to 300 km, the cost per kilometer is $10. If the distance is greater than 300 km, the cost per kilometer is $20. If the origin and destination locations are in different provinces, an additional fixed cost of $500 is added to the total cost.</li>
</ul>
<h2>Kruskal's Algorithm</h2>
<p>Kruskal's algorithm is a greedy algorithm that finds a minimum spanning tree for a connected weighted graph. The minimum spanning tree is the subgraph of the original graph that contains all the vertices and the minimum possible weight or cost. In the case of this project, the vertices are the locations and the edges are the connections between them, whose weights are the costs calculated by the calcularCosto method of the Conexion class. Kruskal's algorithm starts by sorting the edges in ascending order of their weights, and then iteratively adds the edges with the lowest weight that do not form a cycle until all vertices are included. This algorithm is implemented in the Grafo class, which creates the minimum spanning tree and returns it as a set of Conexion objects.</p>
<h2>Conclusion</h2>
<p>This project presents an application that uses Kruskal's algorithm to find the minimum spanning tree of a graph of locations connected by telephone connections, whose costs are calculated using the distance and cost methods of the Conexion class. The application allows the user to register locations manually or through the Geonames library, visualize them on a map, and see the planning costs in detail. In addition, it allows the user to save their preferences for future use. The project provides an example of the use of various libraries and algorithms in the development of practical applications.</p>

</body>
</html>
