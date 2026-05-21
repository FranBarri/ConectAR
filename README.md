# 🇦🇷 ConectAR - Network Logistics Planner

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Algorithms](https://img.shields.io/badge/Graph_Theory-Kruskal's_Algorithm-blue?style=flat-square)
![API](https://img.shields.io/badge/API-Geonames-green?style=flat-square)

ConectAR is an algorithmic logistics application designed to calculate the most cost-effective network connections across remote regions in Argentina. By treating locations as vertices and geographic distances as weighted edges, the system calculates a Minimum Spanning Tree (MST) to optimize infrastructure deployment.

## ⚙️ Core Architecture & Features

* **Algorithmic Routing (Kruskal's Algorithm):** Implemented a greedy algorithm to evaluate connected weighted graphs and dynamically generate the lowest-cost infrastructure network without creating cycles.
* **External API Integration:** Integrated the **Geonames API** to dynamically fetch, filter, and register real-world coordinates and provincial data for accurate geographic scaling.
* **Geospatial Computation:** Utilizes the **Haversine formula** to calculate precise spherical distances between coordinates, factoring in the Earth's curvature to generate dynamic connection costs. 
* **Data Persistence:** Implemented the **Gson library** to serialize and deserialize map network states into `.json` files for cross-session storage.
* **Interactive Mapping:** Built a custom UI utilizing `JMapViewer` to visually render nodes, edges, and real-time infrastructure costs.

## 📌 Technical Context
Developed as a deep-dive into graph theory, data structures, and practical API integration.
